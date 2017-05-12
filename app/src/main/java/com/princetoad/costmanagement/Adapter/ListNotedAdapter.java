package com.princetoad.costmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.ManageDTO;
import com.princetoad.costmanagement.Common.Domain.NotedDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Utils.StringUtil;
import com.princetoad.costmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

public class ListNotedAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<NotedDTO> listNoted;
    private HashMap<NotedDTO, List<ManageDTO>> listNotedDetail;

    public ListNotedAdapter(Context context, List<NotedDTO> listNoted, HashMap<NotedDTO, List<ManageDTO>> listNotedDetail) {
        this.context = context;
        this.listNoted = listNoted;
        this.listNotedDetail = listNotedDetail;
    }

    @Override
    public int getGroupCount() {
        return listNoted.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listNotedDetail.get(listNoted.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listNoted.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listNotedDetail.get(listNoted.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        NotedDTO noted = (NotedDTO) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.custom_list_group_note, null);
        }
        TextView txt_date_noted = (TextView) convertView
                .findViewById(R.id.txt_date_noted);
        TextView group_earn = (TextView) convertView
                .findViewById(R.id.group_earn);
        TextView group_pay = (TextView) convertView
                .findViewById(R.id.group_pay);

        txt_date_noted.setText(noted.getDate());
        if (noted.getEarn_money() != 0)
            group_earn.setText("Thu: " + StringUtil.formatLocaleVN(noted.getEarn_money()) + " đ");
        else
            group_earn.setVisibility(View.GONE);
        if (noted.getPay_money() != 0)
            group_pay.setText("Chi: " + StringUtil.formatLocaleVN(noted.getPay_money()) + " đ");
        else
            group_pay.setVisibility(View.GONE);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ManageDTO manageDTO = (ManageDTO) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.custom_list_item_note, null);
        }

        TextView txt_item_note_name = (TextView) convertView
                .findViewById(R.id.txt_item_note_name);
        TextView txt_item_note_money = (TextView) convertView
                .findViewById(R.id.txt_item_note_money);
        TextView txt_item_list_des = (TextView) convertView
                .findViewById(R.id.txt_item_list_des);
        TextView item_list_account = (TextView) convertView
                .findViewById(R.id.item_list_account);

        if (manageDTO.getType() == Constant.TYPE.EARN){
            if (manageDTO.getTypeExpenseDTO() != null)
                txt_item_note_name.setText("Thu: " + manageDTO.getTypeExpenseDTO().getName());
            else if (manageDTO.getExpenseDTO() != null)
                txt_item_note_name.setText("Thu: " + manageDTO.getExpenseDTO().getName());
        } else if (manageDTO.getType() == Constant.TYPE.PAY){
            txt_item_note_name.setText("Chi: " + manageDTO.getTypeExpenseDTO().getName());
        }
        txt_item_note_money.setText(StringUtil.formatLocaleVN(manageDTO.getMoney()) + " đ");
        if (manageDTO.getDescription() == null)
            txt_item_list_des.setVisibility(View.VISIBLE);
        else
            txt_item_list_des.setText(manageDTO.getDescription());
        item_list_account.setText(manageDTO.getAccountDTO().getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

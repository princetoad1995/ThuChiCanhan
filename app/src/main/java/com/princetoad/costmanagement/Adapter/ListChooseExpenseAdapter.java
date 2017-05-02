package com.princetoad.costmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

public class ListChooseExpenseAdapter  extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<TypeExpenseDTO> listTypeExpense;
    private HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpense;

    public ListChooseExpenseAdapter(Context context, ArrayList<TypeExpenseDTO> listTypeExpense, HashMap<TypeExpenseDTO, ArrayList<ExpenseDTO>> listExpense) {
        this.context = context;
        this.listTypeExpense = listTypeExpense;
        this.listExpense = listExpense;
    }

    @Override
    public int getGroupCount() {
        return listTypeExpense.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listExpense.get(listTypeExpense.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTypeExpense.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listExpense.get(listTypeExpense.get(groupPosition)).get(childPosition);
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
        TypeExpenseDTO typeExpenseDTO = (TypeExpenseDTO) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.custom_list_group, null);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        ImageView img_check_header = (ImageView) convertView.findViewById(R.id.img_check_header);
        lblListHeader.setText(typeExpenseDTO.getName());
        if (typeExpenseDTO.getCheck() == 1){
            img_check_header.setVisibility(View.VISIBLE);
        } else
            img_check_header.setVisibility(View.INVISIBLE);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpenseDTO expenseDTO = (ExpenseDTO) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.custom_list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
        ImageView img_check_child = (ImageView) convertView.findViewById(R.id.img_check_child);

        txtListChild.setText(expenseDTO.getName());
        if (expenseDTO.getCheck() == 1){
            img_check_child.setVisibility(View.VISIBLE);
        } else
            img_check_child.setVisibility(View.INVISIBLE);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

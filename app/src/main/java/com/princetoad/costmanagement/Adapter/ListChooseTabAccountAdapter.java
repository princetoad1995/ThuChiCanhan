package com.princetoad.costmanagement.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Utils.StringUtil;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.ViewImpl.EditAccountActivity;

import java.util.ArrayList;

/**
 * Created by PRINCE D. TOAD on 4/20/2017.
 */

public class ListChooseTabAccountAdapter extends ArrayAdapter<AccountDTO>{
    private Context context;
    private ArrayList<AccountDTO> arr;

    public ListChooseTabAccountAdapter(@NonNull Context context, ArrayList<AccountDTO> arr) {
        super(context, R.layout.custom_list_choose_account, arr);
        this.context = context;
        this.arr = arr;
    }

    private static class ViewHolder {
        private ImageView img_choose_account, img_check, img_edit;
        private TextView name_account;
        private TextView number_account;
        private RelativeLayout item_list_account;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder viewHolder;
        if (item == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.custom_list_choose_account,null);
            viewHolder = new ListChooseTabAccountAdapter.ViewHolder();
            viewHolder.name_account = (TextView) item.findViewById(R.id.name_account);
            viewHolder.number_account = (TextView) item.findViewById(R.id.number_account);
            viewHolder.img_choose_account = (ImageView) item.findViewById(R.id.img_choose_account);
            viewHolder.img_check = (ImageView) item.findViewById(R.id.img_check);
            viewHolder.item_list_account = (RelativeLayout) item.findViewById(R.id.item_list_account);
            viewHolder.img_edit = (ImageView) item.findViewById(R.id.img_edit);
            item.setTag(viewHolder);
        } else {
            viewHolder = (ListChooseTabAccountAdapter.ViewHolder) convertView.getTag();
        }

        final AccountDTO accountDTO = arr.get(position);

        viewHolder.name_account.setText(accountDTO.getName());
        viewHolder.number_account.setText(StringUtil.formatLocaleVN(accountDTO.getMoney()));
        viewHolder.img_check.setVisibility(View.GONE);
        viewHolder.img_edit.setVisibility(View.VISIBLE);
        viewHolder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditAccountActivity.class);
                i.putExtra("account", accountDTO);
                ((Activity) context).startActivityForResult(i, Constant.INTENT.REQUEST_CODE_EDIT_ACCOUNT);
            }
        });
        if (position == 0){
            viewHolder.img_choose_account.setImageResource(R.drawable.ic_wallet_choose_account);
        } else if (position == 1){
            viewHolder.img_choose_account.setImageResource(R.drawable.ic_atm_choose_account);
        } else {
            viewHolder.img_choose_account.setImageResource(R.drawable.ic_wallet_choose_account);
        }
        return item;
    }
}

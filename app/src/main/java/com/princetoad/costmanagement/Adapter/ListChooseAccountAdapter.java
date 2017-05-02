package com.princetoad.costmanagement.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.R;

import java.util.ArrayList;

/**
 * Created by PRINCE D. TOAD on 4/20/2017.
 */

public class ListChooseAccountAdapter extends ArrayAdapter<AccountDTO>{
    private Context context;
    private ArrayList<AccountDTO> arr;

    public ListChooseAccountAdapter(@NonNull Context context, ArrayList<AccountDTO> arr) {
        super(context, R.layout.custom_list_choose_account, arr);
        this.context = context;
        this.arr = arr;
    }

    private static class ViewHolder {
        private ImageView img_choose_account, img_check;
        private TextView name_account;
        private TextView number_account;
        private RelativeLayout item_list_account;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder viewHolder;
        if (item == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.custom_list_choose_account,null);
            viewHolder = new ListChooseAccountAdapter.ViewHolder();
            viewHolder.name_account = (TextView) item.findViewById(R.id.name_account);
            viewHolder.number_account = (TextView) item.findViewById(R.id.number_account);
            viewHolder.img_choose_account = (ImageView) item.findViewById(R.id.img_choose_account);
            viewHolder.img_check = (ImageView) item.findViewById(R.id.img_check);
            viewHolder.item_list_account = (RelativeLayout) item.findViewById(R.id.item_list_account);
            item.setTag(viewHolder);
        } else {
            viewHolder = (ListChooseAccountAdapter.ViewHolder) convertView.getTag();
        }

        AccountDTO accountDTO = arr.get(position);

        viewHolder.name_account.setText(accountDTO.getName());
        viewHolder.number_account.setText(accountDTO.getMoney()+"");
        if (accountDTO.getChecked() == 1)
            viewHolder.img_check.setVisibility(View.VISIBLE);
        else
            viewHolder.img_check.setVisibility(View.INVISIBLE);
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

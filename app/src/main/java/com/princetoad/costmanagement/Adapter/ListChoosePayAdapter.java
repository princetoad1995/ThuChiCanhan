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
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.R;

import java.util.ArrayList;

/**
 * Created by PRINCE D. TOAD on 4/20/2017.
 */

public class ListChoosePayAdapter extends ArrayAdapter<ExpenseDTO>{
    private Context context;
    private ArrayList<ExpenseDTO> arr;

    public ListChoosePayAdapter(@NonNull Context context, ArrayList<ExpenseDTO> arr) {
        super(context, R.layout.custom_list_item, arr);
        this.context = context;
        this.arr = arr;
    }

    private static class ViewHolder {
        private ImageView img_check;
        private TextView name_pay;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder viewHolder;
        if (item == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.custom_list_item,null);
            viewHolder = new ListChoosePayAdapter.ViewHolder();
            viewHolder.name_pay = (TextView) item.findViewById(R.id.lblListItem);
            viewHolder.img_check = (ImageView) item.findViewById(R.id.img_check);
            item.setTag(viewHolder);
        } else {
            viewHolder = (ListChoosePayAdapter.ViewHolder) convertView.getTag();
        }

        ExpenseDTO expenseDTO = arr.get(position);

        viewHolder.name_pay.setText(expenseDTO.getName());

        if (expenseDTO.getCheck() == 1)
            viewHolder.img_check.setVisibility(View.VISIBLE);
        else
            viewHolder.img_check.setVisibility(View.INVISIBLE);

        return item;
    }
}

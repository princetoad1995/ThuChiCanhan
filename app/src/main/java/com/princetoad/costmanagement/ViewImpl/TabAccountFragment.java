package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.princetoad.costmanagement.Adapter.ListChooseAccountAdapter;
import com.princetoad.costmanagement.Adapter.ListChooseTabAccountAdapter;
import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Utils.StringUtil;
import com.princetoad.costmanagement.Presenter.TabAccountPresenter;
import com.princetoad.costmanagement.PresenterImpl.TabAccountPresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.TabAccountView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabAccountFragment extends BaseFragment implements TabAccountView{
    private static Fragment instance;
    private List<AccountDTO> accountDTOs;
    private ListView listView;
    private ListChooseTabAccountAdapter adapter;
    private TabAccountPresenter controller;
    private TextView total_money;

    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabAccountFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        setToolbar("Tài khoản", v);
        listView = (ListView) v.findViewById(R.id.list_account);
        accountDTOs = new ArrayList<>();
        total_money = (TextView) v.findViewById(R.id.total_money);
        controller = new TabAccountPresenterImpl(TabAccountFragment.this);
    }

    @Override
    protected void control() {
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_account;
    }

    @Override
    public void toastMessage(String message) {

    }

    @Override
    public void setListAccount(List<AccountDTO> list) {
        this.accountDTOs = list;
        adapter = new ListChooseTabAccountAdapter(getContext(), (ArrayList<AccountDTO>) accountDTOs);
        listView.setAdapter(adapter);
    }

    @Override
    public void setTotalMoney(long total) {
        total_money.setText("Tổng tiền còn: " + StringUtil.formatLocaleVN(total) + " đ");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.INTENT.REQUEST_CODE_EDIT_ACCOUNT && resultCode == Constant.INTENT.RESULT_CODE_EDIT_ACCOUNT && data != null){
            controller.reloadAccount();
        }
    }
}

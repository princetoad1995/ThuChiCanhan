package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.AccountDTO;
import com.princetoad.costmanagement.Common.Domain.ExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.TypeExpenseDTO;
import com.princetoad.costmanagement.Common.Domain.UserDTO;
import com.princetoad.costmanagement.DAO.AccountDAO;
import com.princetoad.costmanagement.DAO.ExpenseDAO;
import com.princetoad.costmanagement.DAO.TypeExpenseDAO;
import com.princetoad.costmanagement.DAOImpl.AccountDAOImpl;
import com.princetoad.costmanagement.DAOImpl.ExpenseDAOImpl;
import com.princetoad.costmanagement.DAOImpl.TypeExpenseDAOImpl;
import com.princetoad.costmanagement.Presenter.MainPresenter;
import com.princetoad.costmanagement.Service.SharedPreferencesService;
import com.princetoad.costmanagement.ServiceImpl.SharedPreferencesServiceImpl;
import com.princetoad.costmanagement.View.MainView;

/**
 * Created by PRINCE D. TOAD on 4/18/2017.
 */

public class MainPresenterImpl implements MainPresenter {
    private SharedPreferencesService service;
    private MainView view;
    private AccountDAO accountDAO;
    private TypeExpenseDAO typeExpenseDAO;
    private ExpenseDAO expenseDAO;


    public MainPresenterImpl(MainView view) {
        this.view = view;
        this.service = SharedPreferencesServiceImpl.getInstance();
        this.accountDAO = new AccountDAOImpl();
        this.typeExpenseDAO = new TypeExpenseDAOImpl();
        this.expenseDAO = new ExpenseDAOImpl();

        createDB();
        UserDTO user = (UserDTO) service.getObject(Constant.SHARED_PREFERENCE.REMEMBER, UserDTO.class);
        Log.e("userID", user.getId()+"");
    }

    public void createDB() {
        if (service.isFirstTime()) {
            addAccount();
            addTypeExpense();
        }
    }

    public void addAccount() {
        UserDTO user = (UserDTO) service.getObject(Constant.SHARED_PREFERENCE.REMEMBER, UserDTO.class);
        AccountDTO account1 = new AccountDTO("Ví", 0, user);
        accountDAO.addAccount(account1);
        AccountDTO account2 = new AccountDTO("ATM", 0, user);
        accountDAO.addAccount(account2);
    }

    public void addTypeExpense() {
        TypeExpenseDTO typeExpense = new TypeExpenseDTO("Ăn uống");
        typeExpenseDAO.addTypeExpense(typeExpense);
        TypeExpenseDTO typeExpense2 = new TypeExpenseDTO("Dịch vụ sinh hoạt");
        typeExpenseDAO.addTypeExpense(typeExpense2);
        TypeExpenseDTO typeExpense3 = new TypeExpenseDTO("Đi lại");
        typeExpenseDAO.addTypeExpense(typeExpense3);
        TypeExpenseDTO typeExpense4 = new TypeExpenseDTO("Trang phục");
        typeExpenseDAO.addTypeExpense(typeExpense4);
        TypeExpenseDTO typeExpense5 = new TypeExpenseDTO("Hưởng thụ");
        typeExpenseDAO.addTypeExpense(typeExpense5);
        TypeExpenseDTO typeExpense6 = new TypeExpenseDTO("Con cái");
        typeExpenseDAO.addTypeExpense(typeExpense6);
        TypeExpenseDTO typeExpense7 = new TypeExpenseDTO("Hiếu hỉ");
        typeExpenseDAO.addTypeExpense(typeExpense7);
        TypeExpenseDTO typeExpense8 = new TypeExpenseDTO("Sức khỏe");
        typeExpenseDAO.addTypeExpense(typeExpense8);
        TypeExpenseDTO typeExpense9 = new TypeExpenseDTO("Nhà cửa");
        typeExpenseDAO.addTypeExpense(typeExpense9);
        TypeExpenseDTO typeExpense10 = new TypeExpenseDTO("Phát triển bản thân");
        typeExpenseDAO.addTypeExpense(typeExpense10);

        ExpenseDTO expenseDTO = new ExpenseDTO("Đi chợ/ siêu thị", typeExpense);
        expenseDAO.addExpense(expenseDTO);
        ExpenseDTO expenseDTO2 = new ExpenseDTO("Ăn tiệm", typeExpense);
        expenseDAO.addExpense(expenseDTO2);
        ExpenseDTO expenseDTO3 = new ExpenseDTO("Cafe", typeExpense);
        expenseDAO.addExpense(expenseDTO3);

        ExpenseDTO expenseDTO4 = new ExpenseDTO("Điện", typeExpense2);
        expenseDAO.addExpense(expenseDTO4);
        ExpenseDTO expenseDTO5 = new ExpenseDTO("Nước", typeExpense2);
        expenseDAO.addExpense(expenseDTO5);
        ExpenseDTO expenseDTO6 = new ExpenseDTO("Internet", typeExpense2);
        expenseDAO.addExpense(expenseDTO6);
        ExpenseDTO expenseDTO7 = new ExpenseDTO("Điện thoại di động", typeExpense2);
        expenseDAO.addExpense(expenseDTO7);
        ExpenseDTO expenseDTO8 = new ExpenseDTO("Gas", typeExpense2);
        expenseDAO.addExpense(expenseDTO8);
        ExpenseDTO expenseDTO9 = new ExpenseDTO("Truyền hình", typeExpense2);
        expenseDAO.addExpense(expenseDTO9);
        ExpenseDTO expenseDTO10 = new ExpenseDTO("Điện thoại cố định", typeExpense2);
        expenseDAO.addExpense(expenseDTO10);
        ExpenseDTO expenseDTO11 = new ExpenseDTO("Thuê người giúp việc", typeExpense2);
        expenseDAO.addExpense(expenseDTO11);

        ExpenseDTO expenseDTO12 = new ExpenseDTO("Xăng xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO12);
        ExpenseDTO expenseDTO13 = new ExpenseDTO("Bảo hiểm xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO13);
        ExpenseDTO expenseDTO14 = new ExpenseDTO("Sửa chữa, bảo dưỡng xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO14);
        ExpenseDTO expenseDTO15 = new ExpenseDTO("Gửi xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO15);
        ExpenseDTO expenseDTO16 = new ExpenseDTO("Rửa xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO16);
        ExpenseDTO expenseDTO17 = new ExpenseDTO("Taxi/thuê xe", typeExpense3);
        expenseDAO.addExpense(expenseDTO17);

        ExpenseDTO expenseDTO18 = new ExpenseDTO("Quần áo", typeExpense4);
        expenseDAO.addExpense(expenseDTO18);
        ExpenseDTO expenseDTO19 = new ExpenseDTO("Giày dép", typeExpense4);
        expenseDAO.addExpense(expenseDTO19);
        ExpenseDTO expenseDTO20 = new ExpenseDTO("Phụ kiện khác", typeExpense4);
        expenseDAO.addExpense(expenseDTO20);

        ExpenseDTO expenseDTO21 = new ExpenseDTO("Vui chơi giải trí", typeExpense5);
        expenseDAO.addExpense(expenseDTO21);
        ExpenseDTO expenseDTO22 = new ExpenseDTO("Du lịch", typeExpense5);
        expenseDAO.addExpense(expenseDTO22);
        ExpenseDTO expenseDTO23 = new ExpenseDTO("Làm đẹp", typeExpense5);
        expenseDAO.addExpense(expenseDTO23);
        ExpenseDTO expenseDTO24 = new ExpenseDTO("Phim ảnh ca nhạc", typeExpense5);
        expenseDAO.addExpense(expenseDTO24);
        ExpenseDTO expenseDTO25 = new ExpenseDTO("Mỹ phẩm", typeExpense5);
        expenseDAO.addExpense(expenseDTO25);

        ExpenseDTO expenseDTO26 = new ExpenseDTO("Học phí", typeExpense6);
        expenseDAO.addExpense(expenseDTO26);
        ExpenseDTO expenseDTO27 = new ExpenseDTO("Sách vở", typeExpense6);
        expenseDAO.addExpense(expenseDTO27);
        ExpenseDTO expenseDTO28 = new ExpenseDTO("Sữa", typeExpense6);
        expenseDAO.addExpense(expenseDTO28);
        ExpenseDTO expenseDTO29 = new ExpenseDTO("Đồ chơi", typeExpense6);
        expenseDAO.addExpense(expenseDTO29);
        ExpenseDTO expenseDTO30 = new ExpenseDTO("Tiền tiêu vặt", typeExpense6);
        expenseDAO.addExpense(expenseDTO30);

        ExpenseDTO expenseDTO31 = new ExpenseDTO("Cưới xin", typeExpense7);
        expenseDAO.addExpense(expenseDTO31);
        ExpenseDTO expenseDTO32 = new ExpenseDTO("Ma chay", typeExpense7);
        expenseDAO.addExpense(expenseDTO32);
        ExpenseDTO expenseDTO33 = new ExpenseDTO("Thăm hỏi", typeExpense7);
        expenseDAO.addExpense(expenseDTO33);
        ExpenseDTO expenseDTO34 = new ExpenseDTO("Biếu tặng", typeExpense7);
        expenseDAO.addExpense(expenseDTO34);

        ExpenseDTO expenseDTO35 = new ExpenseDTO("Khám chữa bệnh", typeExpense8);
        expenseDAO.addExpense(expenseDTO35);
        ExpenseDTO expenseDTO36 = new ExpenseDTO("Thuốc men", typeExpense8);
        expenseDAO.addExpense(expenseDTO36);
        ExpenseDTO expenseDTO37 = new ExpenseDTO("Thể thao", typeExpense8);
        expenseDAO.addExpense(expenseDTO37);

        ExpenseDTO expenseDTO38 = new ExpenseDTO("Mua sắm đồ đạc", typeExpense9);
        expenseDAO.addExpense(expenseDTO38);
        ExpenseDTO expenseDTO39 = new ExpenseDTO("Sửa chữa nhà cửa", typeExpense9);
        expenseDAO.addExpense(expenseDTO39);
        ExpenseDTO expenseDTO40 = new ExpenseDTO("Thuê nhà", typeExpense9);
        expenseDAO.addExpense(expenseDTO40);

        ExpenseDTO expenseDTO41 = new ExpenseDTO("Học hành", typeExpense10);
        expenseDAO.addExpense(expenseDTO41);
        ExpenseDTO expenseDTO42 = new ExpenseDTO("Giao lưu, quan hệ", typeExpense10);
        expenseDAO.addExpense(expenseDTO42);

    }
}

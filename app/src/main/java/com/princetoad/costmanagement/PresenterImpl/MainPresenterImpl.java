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
        AccountDTO account1 = new AccountDTO("Ví", 0, 0, user);
        accountDAO.addAccount(account1);
        AccountDTO account2 = new AccountDTO("ATM", 0, 0, user);
        accountDAO.addAccount(account2);
    }

    public void addTypeExpense() {
        TypeExpenseDTO typeExpense = new TypeExpenseDTO("Ăn uống", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense);
        TypeExpenseDTO typeExpense2 = new TypeExpenseDTO("Dịch vụ sinh hoạt", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense2);
        TypeExpenseDTO typeExpense3 = new TypeExpenseDTO("Đi lại", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense3);
        TypeExpenseDTO typeExpense4 = new TypeExpenseDTO("Trang phục", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense4);
        TypeExpenseDTO typeExpense5 = new TypeExpenseDTO("Hưởng thụ", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense5);
        TypeExpenseDTO typeExpense6 = new TypeExpenseDTO("Con cái", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense6);
        TypeExpenseDTO typeExpense7 = new TypeExpenseDTO("Hiếu hỉ", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense7);
        TypeExpenseDTO typeExpense8 = new TypeExpenseDTO("Sức khỏe", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense8);
        TypeExpenseDTO typeExpense9 = new TypeExpenseDTO("Nhà cửa", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense9);
        TypeExpenseDTO typeExpense10 = new TypeExpenseDTO("Phát triển bản thân", 0, Constant.TYPE.PAY);
        typeExpenseDAO.addTypeExpense(typeExpense10);

        TypeExpenseDTO typeExpense11 = new TypeExpenseDTO("Lương", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense11);
        TypeExpenseDTO typeExpense12 = new TypeExpenseDTO("Thưởng", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense12);
        TypeExpenseDTO typeExpense13 = new TypeExpenseDTO("Được cho/tặng", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense13);
        TypeExpenseDTO typeExpense14 = new TypeExpenseDTO("Tiền lãi", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense14);
        TypeExpenseDTO typeExpense15 = new TypeExpenseDTO("Lãi tiết kiệm", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense15);
        TypeExpenseDTO typeExpense16 = new TypeExpenseDTO("Khác", 0, Constant.TYPE.EARN);
        typeExpenseDAO.addTypeExpense(typeExpense16);

        ExpenseDTO expenseDTO = new ExpenseDTO("Đi chợ/ siêu thị", 0, typeExpense);
        expenseDAO.addExpense(expenseDTO);
        ExpenseDTO expenseDTO2 = new ExpenseDTO("Ăn tiệm", 0, typeExpense);
        expenseDAO.addExpense(expenseDTO2);
        ExpenseDTO expenseDTO3 = new ExpenseDTO("Cafe", 0, typeExpense);
        expenseDAO.addExpense(expenseDTO3);

        ExpenseDTO expenseDTO4 = new ExpenseDTO("Điện", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO4);
        ExpenseDTO expenseDTO5 = new ExpenseDTO("Nước", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO5);
        ExpenseDTO expenseDTO6 = new ExpenseDTO("Internet", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO6);
        ExpenseDTO expenseDTO7 = new ExpenseDTO("Điện thoại di động", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO7);
        ExpenseDTO expenseDTO8 = new ExpenseDTO("Gas", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO8);
        ExpenseDTO expenseDTO9 = new ExpenseDTO("Truyền hình", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO9);
        ExpenseDTO expenseDTO10 = new ExpenseDTO("Điện thoại cố định", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO10);
        ExpenseDTO expenseDTO11 = new ExpenseDTO("Thuê người giúp việc", 0, typeExpense2);
        expenseDAO.addExpense(expenseDTO11);

        ExpenseDTO expenseDTO12 = new ExpenseDTO("Xăng xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO12);
        ExpenseDTO expenseDTO13 = new ExpenseDTO("Bảo hiểm xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO13);
        ExpenseDTO expenseDTO14 = new ExpenseDTO("Sửa chữa, bảo dưỡng xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO14);
        ExpenseDTO expenseDTO15 = new ExpenseDTO("Gửi xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO15);
        ExpenseDTO expenseDTO16 = new ExpenseDTO("Rửa xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO16);
        ExpenseDTO expenseDTO17 = new ExpenseDTO("Taxi/thuê xe", 0, typeExpense3);
        expenseDAO.addExpense(expenseDTO17);

        ExpenseDTO expenseDTO18 = new ExpenseDTO("Quần áo", 0, typeExpense4);
        expenseDAO.addExpense(expenseDTO18);
        ExpenseDTO expenseDTO19 = new ExpenseDTO("Giày dép", 0, typeExpense4);
        expenseDAO.addExpense(expenseDTO19);
        ExpenseDTO expenseDTO20 = new ExpenseDTO("Phụ kiện khác", 0, typeExpense4);
        expenseDAO.addExpense(expenseDTO20);

        ExpenseDTO expenseDTO21 = new ExpenseDTO("Vui chơi giải trí", 0, typeExpense5);
        expenseDAO.addExpense(expenseDTO21);
        ExpenseDTO expenseDTO22 = new ExpenseDTO("Du lịch", 0, typeExpense5);
        expenseDAO.addExpense(expenseDTO22);
        ExpenseDTO expenseDTO23 = new ExpenseDTO("Làm đẹp", 0, typeExpense5);
        expenseDAO.addExpense(expenseDTO23);
        ExpenseDTO expenseDTO24 = new ExpenseDTO("Phim ảnh ca nhạc", 0, typeExpense5);
        expenseDAO.addExpense(expenseDTO24);
        ExpenseDTO expenseDTO25 = new ExpenseDTO("Mỹ phẩm", 0, typeExpense5);
        expenseDAO.addExpense(expenseDTO25);

        ExpenseDTO expenseDTO26 = new ExpenseDTO("Học phí", 0, typeExpense6);
        expenseDAO.addExpense(expenseDTO26);
        ExpenseDTO expenseDTO27 = new ExpenseDTO("Sách vở", 0, typeExpense6);
        expenseDAO.addExpense(expenseDTO27);
        ExpenseDTO expenseDTO28 = new ExpenseDTO("Sữa", 0, typeExpense6);
        expenseDAO.addExpense(expenseDTO28);
        ExpenseDTO expenseDTO29 = new ExpenseDTO("Đồ chơi", 0, typeExpense6);
        expenseDAO.addExpense(expenseDTO29);
        ExpenseDTO expenseDTO30 = new ExpenseDTO("Tiền tiêu vặt", 0, typeExpense6);
        expenseDAO.addExpense(expenseDTO30);

        ExpenseDTO expenseDTO31 = new ExpenseDTO("Cưới xin", 0, typeExpense7);
        expenseDAO.addExpense(expenseDTO31);
        ExpenseDTO expenseDTO32 = new ExpenseDTO("Ma chay", 0, typeExpense7);
        expenseDAO.addExpense(expenseDTO32);
        ExpenseDTO expenseDTO33 = new ExpenseDTO("Thăm hỏi", 0, typeExpense7);
        expenseDAO.addExpense(expenseDTO33);
        ExpenseDTO expenseDTO34 = new ExpenseDTO("Biếu tặng", 0, typeExpense7);
        expenseDAO.addExpense(expenseDTO34);

        ExpenseDTO expenseDTO35 = new ExpenseDTO("Khám chữa bệnh", 0, typeExpense8);
        expenseDAO.addExpense(expenseDTO35);
        ExpenseDTO expenseDTO36 = new ExpenseDTO("Thuốc men", 0, typeExpense8);
        expenseDAO.addExpense(expenseDTO36);
        ExpenseDTO expenseDTO37 = new ExpenseDTO("Thể thao", 0, typeExpense8);
        expenseDAO.addExpense(expenseDTO37);

        ExpenseDTO expenseDTO38 = new ExpenseDTO("Mua sắm đồ đạc", 0, typeExpense9);
        expenseDAO.addExpense(expenseDTO38);
        ExpenseDTO expenseDTO39 = new ExpenseDTO("Sửa chữa nhà cửa", 0, typeExpense9);
        expenseDAO.addExpense(expenseDTO39);
        ExpenseDTO expenseDTO40 = new ExpenseDTO("Thuê nhà", 0, typeExpense9);
        expenseDAO.addExpense(expenseDTO40);

        ExpenseDTO expenseDTO41 = new ExpenseDTO("Học hành", 0, typeExpense10);
        expenseDAO.addExpense(expenseDTO41);
        ExpenseDTO expenseDTO42 = new ExpenseDTO("Giao lưu, quan hệ", 0, typeExpense10);
        expenseDAO.addExpense(expenseDTO42);

    }
}

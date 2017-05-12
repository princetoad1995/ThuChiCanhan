package com.princetoad.costmanagement.PresenterImpl;

import android.util.Log;

import com.princetoad.costmanagement.Common.Constant;
import com.princetoad.costmanagement.Common.Domain.ManageDTO;
import com.princetoad.costmanagement.Common.Domain.NotedDTO;
import com.princetoad.costmanagement.DAO.ManageDAO;
import com.princetoad.costmanagement.DAOImpl.ManageDAOImpl;
import com.princetoad.costmanagement.Presenter.ListNotePresenter;
import com.princetoad.costmanagement.View.ListNoteView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/12/2017.
 */

public class ListNotePresenterImpl implements ListNotePresenter {
    private ListNoteView view;
    private ManageDAO dao;
    private NotedDTO notedDTO;

    public ListNotePresenterImpl(ListNoteView view) {
        this.view = view;
        this.dao = new ManageDAOImpl();

        String date;
        long earn = 0;
        long pay = 0;

        List<ManageDTO> list = dao.getAllList();
        if (list.size() == 0) {
            view.showMessage("Bạn chưa có bản ghi nào");
        } else {
            List<ManageDTO> listChild = new ArrayList<>();

            date = list.get(0).getDate().split("\\s")[1];
            list.get(0).getDate();
            if (list.get(0).getType() == Constant.TYPE.EARN)
                earn = list.get(0).getMoney();
            else if (list.get(0).getType() == Constant.TYPE.PAY)
                pay = list.get(0).getMoney();
            listChild.add(list.get(0));

            if (list.size() == 1){
                notedDTO = new NotedDTO();
                notedDTO.setDate(date);
                notedDTO.setEarn_money(earn);
                notedDTO.setPay_money(pay);

                view.setList(notedDTO, listChild);
            }

            for (int i = 1; i < list.size(); i++) {
                if (!list.get(i).getDate().split("\\s")[1].equals(date)) {
                    notedDTO = new NotedDTO();
                    notedDTO.setDate(date);
                    notedDTO.setEarn_money(earn);
                    notedDTO.setPay_money(pay);

                    view.setList(notedDTO, listChild);

                    listChild = new ArrayList<>();
                    date = list.get(i).getDate().split("\\s")[1];
                    if (list.get(i).getType() == Constant.TYPE.EARN) {
                        earn = list.get(i).getMoney();
                        pay = 0;
                    } else if (list.get(i).getType() == Constant.TYPE.PAY) {
                        pay = list.get(i).getMoney();
                        earn = 0;
                    }
                    listChild.add(list.get(i));

                    if (list.size()-1 == i){
                        notedDTO = new NotedDTO();
                        notedDTO.setDate(date);
                        notedDTO.setEarn_money(earn);
                        notedDTO.setPay_money(pay);

                        view.setList(notedDTO, listChild);
                    }

                } else {
                    if (list.get(i).getType() == Constant.TYPE.EARN) {
                        earn += list.get(i).getMoney();
                    } else if (list.get(i).getType() == Constant.TYPE.PAY) {
                        pay += list.get(i).getMoney();
                    }
                    listChild.add(list.get(i));

                    if (list.size()-1 == i){
                        notedDTO = new NotedDTO();
                        notedDTO.setDate(date);
                        notedDTO.setEarn_money(earn);
                        notedDTO.setPay_money(pay);

                        view.setList(notedDTO, listChild);
                    }
                }
            }
        }
    }
}

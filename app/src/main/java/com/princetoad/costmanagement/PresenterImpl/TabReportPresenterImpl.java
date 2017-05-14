package com.princetoad.costmanagement.PresenterImpl;

import com.princetoad.costmanagement.Presenter.TabReportPresenter;
import com.princetoad.costmanagement.View.TabReportView;

/**
 * Created by PRINCE D. TOAD on 5/14/2017.
 */

public class TabReportPresenterImpl implements TabReportPresenter{
    private TabReportView view;

    public TabReportPresenterImpl(TabReportView view) {
        this.view = view;
    }
}

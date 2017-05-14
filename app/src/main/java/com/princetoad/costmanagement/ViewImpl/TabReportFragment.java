package com.princetoad.costmanagement.ViewImpl;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.princetoad.costmanagement.R;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * Created by PRINCE D. TOAD on 4/11/2017.
 */

public class TabReportFragment extends BaseFragment {
    private static Fragment instance;
    private TextView date_today, earn_today, pay_today, date_weekend, earn_weekend, pay_weekend, date_month, earn_month
            , pay_month, date_year, earn_year, pay_year, date_total, earn_total, pay_total;
    private LinearLayout liner_today, liner_weekend, liner_month, liner_year, liner_total;
    public static Fragment getInstance() {
        if (instance == null)
            instance = new TabReportFragment();
        return instance;

    }

    @Override
    protected void init(View v) {
        setToolbar("Báo cáo", v);
        date_today = (TextView) v.findViewById(R.id.date_today);
        earn_today = (TextView) v.findViewById(R.id.earn_today);
        pay_today = (TextView) v.findViewById(R.id.pay_today);
        date_weekend = (TextView) v.findViewById(R.id.date_weekend);
        earn_weekend = (TextView) v.findViewById(R.id.earn_weekend);
        pay_weekend = (TextView) v.findViewById(R.id.pay_weekend);
        date_month = (TextView) v.findViewById(R.id.date_month);
        earn_month = (TextView) v.findViewById(R.id.earn_month);
        pay_month = (TextView) v.findViewById(R.id.pay_month);
        date_year = (TextView) v.findViewById(R.id.date_year);
        earn_year = (TextView) v.findViewById(R.id.earn_year);
        pay_year = (TextView) v.findViewById(R.id.pay_year);
        date_total = (TextView) v.findViewById(R.id.date_total);
        earn_total = (TextView) v.findViewById(R.id.earn_total);
        pay_total = (TextView) v.findViewById(R.id.pay_total);

        liner_today = (LinearLayout) v.findViewById(R.id.liner_today);
        liner_weekend = (LinearLayout) v.findViewById(R.id.liner_weekend);
        liner_month = (LinearLayout) v.findViewById(R.id.liner_month);
        liner_year = (LinearLayout) v.findViewById(R.id.liner_year);
        liner_total = (LinearLayout) v.findViewById(R.id.liner_total);
    }

    @Override
    protected void control() {

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_tab_report;
    }

    @Override
    public void toastMessage(String message) {

    }

    private void openChart(){

        // Pie Chart Section Names
        String[] code = new String[] {
                "Eclair & Older", "Froyo", "Gingerbread", "Honeycomb",
                "IceCream Sandwich", "Jelly Bean"
        };

        // Pie Chart Section Value
        double[] distribution = { 3.9, 12.9, 55.8, 1.9, 23.7, 1.8 } ;

        // Color of each Pie Chart Sections
        int[] colors = { Color.BLUE, Color.MAGENTA, Color.GREEN, Color.CYAN, Color.RED,
                Color.YELLOW };

        // Instantiating CategorySeries to plot Pie Chart
        CategorySeries distributionSeries = new CategorySeries(" Android version distribution as on October 1, 2012");
        for(int i=0 ;i < distribution.length;i++){
            // Adding a slice with its values and name to the Pie Chart
            distributionSeries.add(code[i], distribution[i]);
        }

        // Instantiating a renderer for the Pie Chart
        DefaultRenderer defaultRenderer  = new DefaultRenderer();
        for(int i = 0 ;i<distribution.length;i++){
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(colors[i]);
            seriesRenderer.setDisplayBoundingPoints(true);
            // Adding a renderer for a slice
            defaultRenderer.addSeriesRenderer(seriesRenderer);
        }

        defaultRenderer.setChartTitle("Android version distribution as on October 1, 2012 ");
        defaultRenderer.setChartTitleTextSize(20);
        defaultRenderer.setZoomButtonsVisible(true);

        // Creating an intent to plot bar chart using dataset and multipleRenderer
        Intent intent = ChartFactory.getPieChartIntent(getContext(), distributionSeries , defaultRenderer, "AChartEnginePieChartDemo");

        // Start Activity
        startActivity(intent);

    }
}

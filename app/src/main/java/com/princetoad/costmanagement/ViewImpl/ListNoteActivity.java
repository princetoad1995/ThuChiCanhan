package com.princetoad.costmanagement.ViewImpl;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.princetoad.costmanagement.Adapter.ListNotedAdapter;
import com.princetoad.costmanagement.Common.Domain.ManageDTO;
import com.princetoad.costmanagement.Common.Domain.NotedDTO;
import com.princetoad.costmanagement.Presenter.ListNotePresenter;
import com.princetoad.costmanagement.PresenterImpl.ListNotePresenterImpl;
import com.princetoad.costmanagement.R;
import com.princetoad.costmanagement.View.ListNoteView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListNoteActivity extends BaseActivity implements ListNoteView{
    private ExpandableListView list_noted;
    private ListNotedAdapter adapter;
    private List<NotedDTO> listGroup;
    private HashMap<NotedDTO, List<ManageDTO>> listChild;
    private ListNotePresenter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_note);

        init();
        setToolbar("Lịch sử thu - chi");
    }

    public void init(){
        listGroup = new ArrayList<>();
        listChild = new HashMap<>();
        list_noted = (ExpandableListView) findViewById(R.id.list_noted);

        controller = new ListNotePresenterImpl(ListNoteActivity.this);
    }

    @Override
    public void setList(NotedDTO noted, List<ManageDTO> listManage) {
        listGroup.add(noted);
        listChild.put(noted, listManage);
        adapter = new ListNotedAdapter(ListNoteActivity.this, listGroup, listChild);
        list_noted.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++)
            list_noted.expandGroup(i);
    }
}

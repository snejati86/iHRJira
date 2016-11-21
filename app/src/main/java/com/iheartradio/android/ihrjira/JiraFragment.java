package com.iheartradio.android.ihrjira;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by sinasix on 11/20/16.
 */

public class JiraFragment extends Fragment {

    @BindView(R.id.jira_ticket_list)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        // specify an adapter (see also next example)
        List<JiraTicket> list = new ArrayList();
        JiraTicket jiraTicket = new JiraTicket();
        jiraTicket.setTicketName("Mine");
        jiraTicket.setUrl("http://sdasdasd/asdasdasd/asdasd");

        TicketParser ticketParser = new TicketParser(getActivity());
        list = ticketParser.parseJsonTickets();
        //list.add(jiraTicket);
        JiraTicketAdapter adapter = new JiraTicketAdapter(list);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

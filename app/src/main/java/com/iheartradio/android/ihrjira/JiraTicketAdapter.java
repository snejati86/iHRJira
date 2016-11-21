package com.iheartradio.android.ihrjira;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for holding Jira Ticket objects.
 */

public class JiraTicketAdapter extends RecyclerView.Adapter<JiraTicketAdapter.ViewHolder> {

    List<JiraTicket> mList = null;

    public JiraTicketAdapter(List<JiraTicket> jiraTicketList){
        mList = jiraTicketList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jira_ticket, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ticketName.setText(mList.get(position).getTicketName());
        holder.ticketUrl.setText(mList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.jira_ticket_name)
        TextView ticketName;
        @BindView(R.id.jira_ticket_url)
        TextView ticketUrl;

        public ViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);
        }

    }
}

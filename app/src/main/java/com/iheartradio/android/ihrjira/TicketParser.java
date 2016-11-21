package com.iheartradio.android.ihrjira;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sinasix on 11/20/16.
 */

public class TicketParser {

    private final Context mContext;

    public TicketParser(Context context){
        mContext = context;
    }

    public List<JiraTicket> parseJsonTickets() {
        List<JiraTicket> jiraTickets = new ArrayList<>();
        String json = null;
        InputStream is = null;
        try {
            is = mContext.getAssets().open("tickets.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        finally {
            if ( is != null ){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray tickets = obj.getJSONArray("Ticket URLs");
            for ( int i = 0 ; i < tickets.length() ; ++i ){
                String ticketUrl = tickets.getString(i);
                JiraTicket jiraTicket = new JiraTicket();
                jiraTicket.setUrl(ticketUrl);
                jiraTicket.setTicketName(ticketUrl.substring(ticketUrl.lastIndexOf("/")+1));
                jiraTickets.add(jiraTicket);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jiraTickets;
    }
}

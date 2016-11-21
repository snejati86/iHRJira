package com.iheartradio.android.ihrjira;

/**
 * Jira ticket model.
 */
public class JiraTicket {
    private String ticketName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

}

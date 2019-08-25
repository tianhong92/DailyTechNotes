package com.tianhong.demo.SQS;

public class ManniuMessage {
    private String table;
    private String action;
    private String other;

    public ManniuMessage(String table, String action, String other) {
        this.table = table;
        this.action = action;
        this.other = other;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

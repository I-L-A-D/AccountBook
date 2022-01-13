package com.ioad.accountbook.DAO;

public class Content {

    private String type;
    private String amount;
    private int typeImg;
    private String kind;

    public Content(String type, String amount, String kind) {
        this.type = type;
        this.amount = amount;
        this.kind = kind;
    }

    public String getType() {
        if (this.type.equals("income")) {
            this.type = "수입";
        } else if (this.type.equals("expend")) {
            this.type = "지출";
        }
        return this.type;
    }

    public void setType(String detail) {
        this.type = detail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getTypeImg() {
        return this.typeImg;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}

package com.ioad.accountbook.DAO;

import com.ioad.accountbook.R;

public class InsertDataRes {
    public int[] incomeImgData = { R.drawable.monthpay, R.drawable.wallet, R.drawable.plus};
    public String[] incomeNameData = {"월급","용돈", "기타"};
    public int[] exportImgData = { R.drawable.saving, R.drawable.meal, R.drawable.beauty,
    R.drawable.bus, R.drawable.cart, R.drawable.clothes, R.drawable.coffee, R.drawable.health, R.drawable.music};
    public String[] exportNameData = {"저축","식비", "미용", "교통", "생필품", "의류", "커피", "의료/건강", "문화생활"};

    public InsertDataRes() {
    }

    public int[] getIncomeImgData() {
        return incomeImgData;
    }

    public void setIncomeImgData(int[] data) {
        this.incomeImgData = data;
    }

    public String[] getIncomeNameData() {
        return incomeNameData;
    }

    public void setIncomeNameData(String[] incomeNameData) {
        this.incomeNameData = incomeNameData;
    }

    public int[] getExportImgData() {
        return exportImgData;
    }

    public void setExportImgData(int[] exportImgData) {
        this.exportImgData = exportImgData;
    }

    public String[] getExportNameData() {
        return exportNameData;
    }

    public void setExportNameData(String[] exportNameData) {
        this.exportNameData = exportNameData;
    }
}

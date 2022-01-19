package com.ioad.accountbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ioad.accountbook.DAO.Content;
import com.ioad.accountbook.DAO.InsertDataRes;
import com.ioad.accountbook.R;

import java.text.DecimalFormat;

public class UpdateDataActivity extends AppCompatActivity {

    TextView tv_detail_today, tv_detail_amount, tv_detail_kind, tv_detail_type;
    EditText et_detail_memo;
    ImageView iv_kind;

    InsertDataRes insertDataRes = new InsertDataRes();
    Content content = new Content();
    String kind, amount, type, selectDay;
    int[] data;
    String[] dataName;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        tv_detail_today = findViewById(R.id.tv_detail_today);
        tv_detail_amount = findViewById(R.id.tv_detail_amount);
        tv_detail_kind = findViewById(R.id.tv_detail_kind);
        tv_detail_type = findViewById(R.id.tv_detail_type);
        iv_kind = findViewById(R.id.iv_kind);

        Intent intent = getIntent();
        kind = intent.getStringExtra("KIND");
        type = intent.getStringExtra("TYPE");
        selectDay = intent.getStringExtra("SELECT_DAY");

        DecimalFormat myFormatter = new DecimalFormat("###,###");
        amount = myFormatter.format(Integer.parseInt(intent.getStringExtra("AMOUNT")));

        tv_detail_today.setText(selectDay);
        tv_detail_amount.setText(amount + " 원");
        tv_detail_kind.setText(kind);
        tv_detail_type.setText(type);

        if (type.equals("수입")) {
            data = insertDataRes.getIncomeImgData();
            dataName = insertDataRes.getIncomeNameData();
        } else {
            data = insertDataRes.getExportImgData();
            dataName = insertDataRes.getExportNameData();
        }


        for (int i = 0; i < data.length; i++) {
            if (kind.equals(dataName[i])) {
                position = i;
            }
        }

        iv_kind.setImageResource(data[position]);
    }
}
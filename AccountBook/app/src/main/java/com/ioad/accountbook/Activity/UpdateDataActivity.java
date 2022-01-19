package com.ioad.accountbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.ioad.accountbook.R;

import java.text.DecimalFormat;

public class UpdateDataActivity extends AppCompatActivity {

    TextView tv_detail_today, tv_detail_amount, tv_detail_kind;
    EditText et_detail_memo;

    String kind, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        tv_detail_today = findViewById(R.id.tv_detail_today);
        tv_detail_amount = findViewById(R.id.tv_detail_amount);
        tv_detail_kind = findViewById(R.id.tv_detail_kind);

        Intent intent = getIntent();
        kind = intent.getStringExtra("KIND");

        DecimalFormat myFormatter = new DecimalFormat("###,###");
        amount = myFormatter.format(Integer.parseInt(intent.getStringExtra("AMOUNT")));

        tv_detail_amount.setText(amount + " 원");
        tv_detail_kind.setText(kind);

    }
}
package com.ioad.accountbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ioad.accountbook.Adapter.DetailAdapter;
import com.ioad.accountbook.DAO.InsertDataRes;
import com.ioad.accountbook.R;
import com.ioad.accountbook.SQL.AccountBookDB;
import com.ioad.accountbook.Util.Share;

public class NewDataActivity extends AppCompatActivity {

    TextView tv_new_data_date;
    EditText et_amount;
    Button btn_income, btn_expend, btn_save;
    RecyclerView rv_income, rv_expend;
    ImageButton btn_cancel;

    private InsertDataRes insertDataRes = new InsertDataRes();
    GridLayoutManager gridLayoutManagerIncome;
    GridLayoutManager gridLayoutManagerExpend;
    private DetailAdapter reAdapterIncome;
    private DetailAdapter reAdapterExport;

    InputMethodManager manager;

    AccountBookDB dataBase;

    private int[] incomeImgData;
    private int[] exportImgData;
    private String[] incomeNameData;
    private String[] exportNameData;

    String m_type = "";
    String date = "";
    String year = "";
    String month = "";
    String day = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data);

        dataBase = new AccountBookDB(getApplicationContext());

        et_amount = findViewById(R.id.et_amount);
        btn_income = findViewById(R.id.btn_income);
        btn_expend = findViewById(R.id.btn_expend);
        btn_save = findViewById(R.id.btn_save);
        tv_new_data_date = findViewById(R.id.tv_new_data_date);
        btn_cancel = findViewById(R.id.btn_cancel);

        rv_income = findViewById(R.id.rv_income);
        rv_expend = findViewById(R.id.rv_expend);

        gridLayoutManagerIncome = new GridLayoutManager(this, 4);
        gridLayoutManagerExpend = new GridLayoutManager(this, 4);
        rv_income.setLayoutManager(gridLayoutManagerIncome);
        rv_expend.setLayoutManager(gridLayoutManagerExpend);

        btn_income.setOnClickListener(buttonOnClickListener);
        btn_expend.setOnClickListener(buttonOnClickListener);
        btn_save.setOnClickListener(buttonOnClickListener);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        incomeImgData = insertDataRes.getIncomeImgData();
        incomeNameData = insertDataRes.getIncomeNameData();

        exportImgData = insertDataRes.getExportImgData();
        exportNameData = insertDataRes.getExportNameData();

        reAdapterIncome = new DetailAdapter(getApplicationContext(), incomeImgData, incomeNameData);
        reAdapterExport = new DetailAdapter(getApplicationContext(), exportImgData, exportNameData);

        rv_income.setAdapter(reAdapterIncome);
        rv_expend.setAdapter(reAdapterExport);

        manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        Intent intent = getIntent();
        date = intent.getStringExtra("DATE");

        tv_new_data_date.setText(date);

        getDetailDate(date);

    }

    View.OnClickListener buttonOnClickListener = new View.OnClickListener() {

        SQLiteDatabase DB;
        String query;

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_income:
                    if (et_amount.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        rv_income.setVisibility(View.VISIBLE);
                        rv_expend.setVisibility(View.INVISIBLE);
                        m_type = "income";
                        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                    break;
                case R.id.btn_expend:
                    if (et_amount.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        rv_income.setVisibility(View.INVISIBLE);
                        rv_expend.setVisibility(View.VISIBLE);

                        m_type = "expend";
                        manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                    break;
                case R.id.btn_save:
                    if (et_amount.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else if (Share.getString(NewDataActivity.this, "NAME") == null
                            || Share.getString(NewDataActivity.this, "NAME").length() == 0) {
                        Toast.makeText(getApplicationContext(), "내역을 클릭해주세요.", Toast.LENGTH_SHORT).show();
                    } else {
                        /**
                         * seq_num      :: PK
                         * m_type       :: 수입 & 지출
                         * m_year       :: 년도
                         * m_month      :: 월
                         * m_day        :: 일
                         * m_amount     :: 금액
                         * m_detail     :: 상세내역
                         * m_memo       :: 메모
                         * @param sqLiteDatabase
                         */
                        try {
                            DB = dataBase.getWritableDatabase();
                            query = "INSERT INTO moneybook(m_type, m_year, m_month, m_day, m_amount, m_detail) VALUES" +
                                    "('" + m_type + "', '" + year + "', '"  + month + "', '"  + day + "', '" + et_amount.getText().toString() + "', '" + Share.getString(NewDataActivity.this, "NAME") + "');";
                            DB.execSQL(query);

                            Log.e("TAG", query);
                            dataBase.close();
                            Toast.makeText(getApplicationContext(), "INSERT", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        finish();
                    }

                    break;
            }
        }
    };

    private void getDetailDate(String date) {
        year = date.substring(0, 4);
        month = date.substring(4, 6);
        day = date.substring(6, date.length());
    }
}
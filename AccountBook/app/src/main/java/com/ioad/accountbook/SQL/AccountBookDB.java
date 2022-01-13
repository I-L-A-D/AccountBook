package com.ioad.accountbook.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountBookDB extends SQLiteOpenHelper {

    public AccountBookDB(Context context) {
        super(context, "MoneyBook.db", null, 1);
    }

    /**
     * seq_num      :: PK
     * m_type       :: 수입 & 지출
     * m_date       :: 날짜
     * m_amount     :: 금액
     * m_detail     :: 상세내역
     * m_memo       :: 메모
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE moneybook(seq_num INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "m_type TEXT NOT NULL, " +
                "m_year TEXT NOT NULL, " +
                "m_month TEXT NOT NULL, " +
                "m_day TEXT NOT NULL, " +
                "m_amount TEXT NOT NULL, " +
                "m_detail TEXT NOT NULL, " +
                "m_memo TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
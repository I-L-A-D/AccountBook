package com.ioad.accountbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ioad.accountbook.DAO.Content;
import com.ioad.accountbook.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainListAdapter extends BaseAdapter {

    private Context mContext;
    private int layout;
    private ArrayList<Content> listData = null;
    private LayoutInflater inflater = null;
    private Content content;

    public MainListAdapter(Context context, int layout, ArrayList<Content> data) {
        this.mContext = context;
        this.layout = layout;
        this.listData = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i).getType();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(this.layout, viewGroup, false);
        }

        LinearLayout ll_main_list = view.findViewById(R.id.ll_main_list);
        TextView tv_list_amount = view.findViewById(R.id.tv_list_amount);
        TextView tv_list_kind = view.findViewById(R.id.tv_list_kind);

//        tv_list_type.setText(listData.get(i).getType());

        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String amount = myFormatter.format(Integer.parseInt(listData.get(i).getAmount()));

        tv_list_amount.setText(amount);
        tv_list_kind.setText(listData.get(i).getKind());



        return view;
    }

}

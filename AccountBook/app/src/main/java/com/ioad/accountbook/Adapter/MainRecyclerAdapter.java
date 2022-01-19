package com.ioad.accountbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ioad.accountbook.Activity.UpdateDataActivity;
import com.ioad.accountbook.DAO.Content;
import com.ioad.accountbook.R;
import com.ioad.accountbook.Util.Share;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    Context mContext;
    ArrayList<Content> data;
    String type;
    String selectDay;

    public MainRecyclerAdapter(Context mContext, ArrayList<Content> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_layout, parent,false);
        MainRecyclerAdapter.ViewHolder viewHolder = new MainRecyclerAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String amount = myFormatter.format(Integer.parseInt(data.get(position).getAmount()));

        holder.tv_list_amount.setText(amount);
        holder.tv_list_kind.setText(data.get(position).getKind());
        type = data.get(position).getType();
        selectDay = data.get(position).getSelectDay();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_list_amount = itemView.findViewById(R.id.tv_list_amount);
        TextView tv_list_kind = itemView.findViewById(R.id.tv_list_kind);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, UpdateDataActivity.class);
                    intent.putExtra("KIND", data.get(position).getKind());
                    intent.putExtra("AMOUNT", data.get(position).getAmount());
                    intent.putExtra("TYPE", type);
                    intent.putExtra("SELECT_DAY", selectDay);
                    mContext.startActivity(intent);
                }
            });

        }
    }
}

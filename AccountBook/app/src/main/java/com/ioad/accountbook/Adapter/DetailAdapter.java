package com.ioad.accountbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ioad.accountbook.DAO.Content;
import com.ioad.accountbook.R;
import com.ioad.accountbook.Util.Share;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    Context mContext;
    int[] imageData;
    String[] nameData;
    Content content;

    public DetailAdapter(Context context, int[] data, String[] name) {
        this.mContext = context;
        this.imageData = data;
        this.nameData = name;
    }

    @NonNull
    @Override
    public DetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ViewHolder holder, int position) {
        holder.itemImage.setImageResource(imageData[position]);
        holder.itemText.setText(nameData[position]);
    }

    @Override
    public int getItemCount() {
        return imageData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView itemImage;
        public TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.iv_content);
            itemText = itemView.findViewById(R.id.tv_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Toast.makeText(mContext, nameData[position] + "선택", Toast.LENGTH_SHORT).show();
                    Share.setString(mContext, "NAME", nameData[position]);
                }
            });

        }
    }//Class
}
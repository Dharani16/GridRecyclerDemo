package com.dharani.gridrecyclerdemo;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    private Context context;

    public DataAdapter(Context context,ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAndroid.setText(android.get(position).getAndroidVersionName());
        Picasso.with(context)
                .load(android.get(position).getAndroidImage())
                .resize(140,120)
                .into(holder.imgAndroid);
    }
    @Override
    public int getItemCount() {
        return android.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvAndroid;
        private ImageView imgAndroid;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAndroid = (TextView)itemView.findViewById(R.id.textView_ID);
            imgAndroid = (ImageView)itemView.findViewById(R.id.imageView_ID);
//            CardView myCard=(CardView)itemView.findViewById(R.id.my_card_view);
//            myCard.setOnDragListener(new View.OnDragListener() {
//                @Override
//                public boolean onDrag(View v, DragEvent event) {
//                    Toast.makeText(context,"You are dragged something!",Toast.LENGTH_LONG).show();
//                    return true;
//                }
//            });
        }
    }
}

package com.example.jecrcapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


import java.util.List;

public class CleanAdapter extends RecyclerView.Adapter<CleanAdapter.CleanImageViewHolder> {
    private Context mContext;
    private List<UploadClean> mUploads;

    public CleanAdapter(Context context,List<UploadClean> uploadCleans)
    {
        mContext = context;
        mUploads = uploadCleans;
    }

    @Override
    public CleanImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item,parent, false);
     return new CleanImageViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull CleanImageViewHolder holder, int position) {
       UploadClean uploadCurrent = mUploads.get(position);
       holder.tvArea.setText(uploadCurrent.getArea());
        holder.tvDescription.setText(uploadCurrent.getDescription());
        Glide.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.clean2)
                .centerCrop()
                .into(holder.ivClean);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class CleanImageViewHolder extends RecyclerView.ViewHolder{
        public TextView tvArea,tvDescription;
        public ImageView ivClean;
        public CleanImageViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArea = itemView.findViewById(R.id.tvCleanArea);
            tvDescription = itemView.findViewById(R.id.tvCleanDescription);
            ivClean = itemView.findViewById(R.id.ivClean);
        }
    }
}

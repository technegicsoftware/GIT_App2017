package com.git.priyavidhi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by vidhi on 2/21/2017.
 */
public class FolderImageAdapter extends RecyclerView.Adapter<FolderImageAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private Context context;


    public FolderImageAdapter(Context context,ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public FolderImageAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.folder_image, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FolderImageAdapter.ViewHolder viewHolder, int i) {


        Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(240, 120).into(viewHolder.img_android);
//        viewHolder.tv_android.setText(android.get(i).getAndroid_version_name());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //        private TextView tv_android;
        private ImageView img_android;
        public TextView tv_android;

        public ViewHolder(View view) {
            super(view);

//            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);

            img_android.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(context,ViewPage.class);
                    i.putExtra("pos",getAdapterPosition());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
//                    Toast.makeText(context.getApplicationContext(),"helloo",Toast.LENGTH_SHORT).show();

                }
            });
        }

    }


}

package org.uitestingespresso.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.uitestingespresso.R;
import org.uitestingespresso.model.FlickerResponse;

import java.util.ArrayList;


public class FlickerListAdapter extends RecyclerView.Adapter<FlickerListAdapter.ViewHolderView> implements View.OnClickListener{
    private LayoutInflater layoutInflater;
    private ArrayList<FlickerResponse.ItemsBean> itemsBean;
    private Context mcontext;

    public FlickerListAdapter(Context context, ArrayList<FlickerResponse.ItemsBean> photos) {
        layoutInflater = LayoutInflater.from(context);
        this.mcontext = context;
        this.itemsBean = photos;
    }

    @Override
    public FlickerListAdapter.ViewHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.image_row_list, parent, false);
        return new ViewHolderView(view);
    }

    @Override
    public void onBindViewHolder(FlickerListAdapter.ViewHolderView holder, int position) {
        holder.title.setText(itemsBean.get(position).getTitle());
        Picasso.with(mcontext).load(itemsBean.get(position).getMedia().getM()).into(holder.flikerImage);
        holder.relativeLayout.setOnClickListener(this);
        holder.relativeLayout.setTag(position);

    }

    @Override
    public int getItemCount() {
        return itemsBean.size();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.container:
                Toast.makeText(mcontext, ""+v.getTag().toString(), Toast.LENGTH_SHORT).show();
                break;

        }
    }

    static class ViewHolderView extends RecyclerView.ViewHolder {
        TextView title;
        ImageView flikerImage;
        RelativeLayout relativeLayout;

        ViewHolderView(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.iameName);
            flikerImage = (ImageView) itemView.findViewById(R.id.flickerImage);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.container);
        }
    }
}

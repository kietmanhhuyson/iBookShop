package com.ibookshop.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ibookshop.R;
import com.ibookshop.data.BookHome;
import com.ibookshop.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RVCartAdapter extends RecyclerView.Adapter<RVCartAdapter.ViewHolder> {

    private ArrayList<BookHome> localDataSet;
    private Context context;
    private boolean isRemove = false;
    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean isChecked, int position, String gia, int dem);
    }
    private OnCheckedChangeListener listener;
    private boolean isCartPageCheckBoxChecked = false;

    public void setCartPageCheckBoxChecked(boolean checked) {
        isCartPageCheckBoxChecked = checked;
        notifyDataSetChanged();
    }

    public void updateListPrice(boolean isRemove) {
        this.isRemove = isRemove;
        if(isRemove) {
            notifyDataSetChanged();
        }
    }
    public void setIsRemove(boolean isRemove) {
        this.isRemove = isRemove;
    }


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtenSach,txtacGia,Gia;
        public ImageView imgHinh;
        public CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            txtenSach = itemView.findViewById(R.id.TenSach);
            txtacGia = itemView.findViewById(R.id.TenTacGia);
            imgHinh = itemView.findViewById(R.id.imgSach);
            Gia = itemView.findViewById(R.id.giaSach);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
        public ImageView getimgHinh() {
            return imgHinh;
        }
        public TextView gettxtacGia() {
            return txtacGia;
        }
        public TextView getGia() {
            return Gia;
        }
        public TextView gettxtenSach() {
            return txtenSach;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public RVCartAdapter(Context context, ArrayList<BookHome> dataSet, OnCheckedChangeListener listener) {
        localDataSet = dataSet;
        this.context = context;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_cart, viewGroup, false);
        return new ViewHolder(view);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Picasso.get().load(localDataSet.get(position).getUrlImage()).into(viewHolder.imgHinh);
        viewHolder.txtacGia.setText(localDataSet.get(position).getTenTacGia());
        viewHolder.Gia.setText(localDataSet.get(position).getGia());
        viewHolder.txtenSach.setText(localDataSet.get(position).getTenSach());

        if(!isRemove) {
            viewHolder.checkBox.setChecked(isCartPageCheckBoxChecked);
        }
        else {
            this.isRemove=false;
        }

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null && localDataSet.size()>0) {
                    if (isChecked) {

                        Utils.dem++;
                        listener.onCheckedChanged(isChecked, position, localDataSet.get(position).getGia(),Utils.dem);

                    }
                    else {

                        Utils.dem--;
                        listener.onCheckedChanged(isChecked, position, "-"+localDataSet.get(position).getGia(),Utils.dem);

                    }

                }
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(localDataSet!=null) {
            return localDataSet.size();
        }
        return 0;
    }
}

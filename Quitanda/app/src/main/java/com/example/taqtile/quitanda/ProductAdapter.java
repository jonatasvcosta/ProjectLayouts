package com.example.taqtile.quitanda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by taqtile on 1/13/16.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Product> mProducts;

    public ProductAdapter(ArrayList<Product> products){
        mProducts = products;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView name;
        ImageView img;
        public ViewHolder(View itemView){
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.itemChecked);
            name = (TextView) itemView.findViewById(R.id.itemName);
            img = (ImageView) itemView.findViewById(R.id.itemImg);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View productView = inflater.inflate(R.layout.item_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Product p = mProducts.get(i);
        viewHolder.checkBox.setChecked(p.getClicked());
        viewHolder.name.setText(p.getName());
        viewHolder.img.setImageResource(p.getImgId());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}

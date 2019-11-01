package com.google.codelabs.mdc.java.shrine;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

import java.util.List;

/**
 * Adapter used to show a simple grid of products.
 */
public class ProductCardRecyclerViewAdapter
        extends RecyclerView.Adapter<ProductCardViewHolder> {

    private List<ProductEntry> productList;

    ProductCardRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                    int viewType) {
        return ProductCardViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder,
                                 int position) {
        if (productList != null && position < productList.size()) {
            holder.bind(productList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

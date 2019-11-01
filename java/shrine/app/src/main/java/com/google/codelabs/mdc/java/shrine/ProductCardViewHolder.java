package com.google.codelabs.mdc.java.shrine;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.google.codelabs.mdc.java.shrine.databinding.ShrProductCardBinding;
import com.google.codelabs.mdc.java.shrine.network.ImageRequester;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;

import org.jetbrains.annotations.NotNull;

public class ProductCardViewHolder
        extends RecyclerView.ViewHolder {
    private NetworkImageView productImage;
    private TextView productTitle;
    private TextView productPrice;
    private ImageRequester imageRequester;

    private ProductCardViewHolder(@NotNull ShrProductCardBinding binding) {
        super(binding.getRoot());

        productImage = binding.productImage;
        productTitle = binding.productTitle;
        productPrice = binding.productPrice;

        imageRequester = ImageRequester.getInstance();
    }

    public void bind(@NotNull ProductEntry product) {
        productTitle.setText(product.title);
        productPrice.setText(product.price);
        imageRequester.setImageFromUrl(productImage, product.url);
    }

    @NotNull
    public static ProductCardViewHolder create(ViewGroup parent) {
        ShrProductCardBinding binding = ShrProductCardBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductCardViewHolder(binding);
    }
}

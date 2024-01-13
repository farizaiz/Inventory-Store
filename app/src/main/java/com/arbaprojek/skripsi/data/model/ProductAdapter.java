package com.arbaprojek.skripsi.data.model;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.arbaprojek.skripsi.R;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        Product currentProduct = getItem(position);

        Log.v("TAG", getContext() + "");

        View listItemView = null;

        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);


//        Product currentProduct = getItem(position);

        ImageView productImageImageView = listItemView.findViewById(R.id.product_image_image_view);

        if(currentProduct.imageURIString != null) {
            productImageImageView.setImageURI(Uri.parse(currentProduct.imageURIString));
        }
        else{
            productImageImageView.setImageResource(R.drawable.image_not_found);
        }
        TextView productNameTextView = listItemView.findViewById(R.id.product_name_text_view);
        productNameTextView.setText(currentProduct.productName);

        TextView quantityTextView = listItemView.findViewById(R.id.quantity_text_view);
        quantityTextView.setText(currentProduct.quantity + "");

        TextView pricePerUnitTextView = listItemView.findViewById(R.id.price_text_view);
        double price = currentProduct.pricePerUnit;

        String formattedPrice = "Rp. " + NumberFormat.getNumberInstance(new Locale("id", "ID")).format(price);

        pricePerUnitTextView.setText(formattedPrice);


        return listItemView;

    }
}

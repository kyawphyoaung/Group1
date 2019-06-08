package com.sakebakery.opus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class ProductDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Product> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final Product selectedProduct = catalog.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);
        TextView productFlavorTextView = (TextView) findViewById(R.id.TextViewProductFlavour);
        productFlavorTextView.setText(selectedProduct.flavor);
        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice);
        productPriceTextView.setText(""+selectedProduct.price);
        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
        productDetailsTextView.setText(selectedProduct.description);
        TextView productIcingTextView = (TextView) findViewById(R.id.a);
        productIcingTextView.setText(selectedProduct.icing);
        TextView productsideTextView = (TextView) findViewById(R.id.b);
        productsideTextView.setText(selectedProduct.icing);
        TextView productfillingTextView = (TextView) findViewById(R.id.c);
        productfillingTextView.setText(selectedProduct.filling);

        Button addToCartButton = (Button) findViewById(R.id.buttonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                cart.add(selectedProduct);
                finish();
            }
        });


        // Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedProduct)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item already added to Cart");

        }

        Button BackButton = (Button) findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, CatalogActivity.class);
                startActivity(intent);
            }
        });
    }

}



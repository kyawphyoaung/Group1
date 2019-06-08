package com.sakebakery.opus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class homedetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homedetail);

        Button bshop = (Button) findViewById(R.id.btn_shop);
        bshop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(homedetail.this, CatalogActivity.class);
                startActivity(intent);
            }
        });

        Button bnew = (Button) findViewById(R.id.btn_new);
        bnew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(homedetail.this, Create.class);
                startActivity(intent);
            }
        });

        Button bcart = (Button) findViewById(R.id.btn_cart);
        bcart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(homedetail.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        Button bhome = (Button) findViewById(R.id.btn_homebla);
        bcart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(homedetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

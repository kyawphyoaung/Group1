package com.sakebakery.opus;

import android.content.Context;
import android.os.Bundle;
import java.util.List;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;


public class ShoppingCartActivity extends Activity {

    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;
    private PopupWindow pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        mCartList = ShoppingCartHelper.getCart();


        final TextView subtotal=findViewById(R.id.tv_subtotal);
        final TextView total=findViewById(R.id.tv_total);

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Product selectedProduct = mCartList.get(position);
                int a=0;

                if(selectedProduct.selected == true)
                    selectedProduct.selected = false;
                else
                    selectedProduct.selected = true;
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).selected) {
                        a += mCartList.get(i).price;
                    }
                }
                subtotal.setText(""+a+" MMK");
                int amount=a+500;
                total.setText(""+amount+" MMK");

                mProductAdapter.notifyDataSetInvalidated();

            }
        });

        Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
        removeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
                subtotal.setText(""+0);
                total.setText(""+0);
            }
        });

        Button checkout = (Button) findViewById(R.id.bt_checkout);
        removeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Loop through and remove all the products that are selected
                // Loop backwards so that the remove works correctly
                for(int i=mCartList.size()-1; i>=0; i--) {

                    if(mCartList.get(i).selected) {
                        mCartList.remove(i);
                    }
                }
                mProductAdapter.notifyDataSetChanged();
                subtotal.setText(""+0);
                total.setText(""+0);
            }
        });



//        private void showPopup() {
//            try {
//// We need to get the instance of the LayoutInflater
//                LayoutInflater inflater = (LayoutInflater) ShoppingCartActivity.this
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View layout = inflater.inflate(R.layout.popup,
//                        (ViewGroup) findViewById(R.id.popup_1));
//                pw = new PopupWindow(layout, 300, 370, true);
//                pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
//                Close = (Button) layout.findViewById(R.id.close_popup);
//                Close.setOnClickListener(cancel_button);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        private OnClickListener cancel_button = new OnClickListener() {
//            public void onClick(View v) {
//                pw.dismiss();
//            }
//        };
//
//





    }

}



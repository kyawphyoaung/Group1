package com.sakebakery.opus;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter  extends BaseAdapter {

    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;

    public ProductAdapter(List<Product> list, LayoutInflater inflater, boolean showCheckbox) {
        mProductList = list;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item,
                    null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem);

            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem1);
//
           item.flavor=(TextView) convertView.findViewById(R.id.TextViewItem2);
           item.price=(TextView) convertView.findViewById(R.id.TextViewItem3);
//           item.filling=(TextView) convertView.findViewById(R.id.c);
//           item.side=(TextView) convertView.findViewById(R.id.b);
//            item.icing=(TextView) convertView.findViewById(R.id.a);

            item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product curProduct = mProductList.get(position);

        item.productImageView.setImageDrawable(curProduct.productImage);
        item.productTitle.setText(curProduct.title);
      item.flavor.setText(curProduct.flavor);
       item.price.setText(""+curProduct.price+" MMK");
//        item.filling.setText(curProduct.filling);
//        item.icing.setText(curProduct.icing);
//        item.side.setText(curProduct.side);

        if(!mShowCheckbox) {
            item.productCheckbox.setVisibility(View.GONE);
        } else {
            if(curProduct.selected == true)
                item.productCheckbox.setChecked(true);
            else
                item.productCheckbox.setChecked(false);
        }


        return convertView;
    }


    private class ViewItem {
        TextView flavor;
//        TextView icing;
//        TextView side;
//        TextView filling;
        TextView price;
        ImageView productImageView;
        TextView productTitle;
        CheckBox productCheckbox;
    }

}

package com.sakebakery.opus;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Create extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener{
    ImageView btnsfla, btncfla;
    ImageView imgDestination;
    String clipData="";


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_flavour);

            btnsfla = findViewById(R.id.SFlavor);
            btncfla = findViewById(R.id.CFlavor);
            imgDestination = findViewById(R.id.cakeDestination);

            btnsfla.setOnTouchListener(this);
            btncfla.setOnTouchListener(this);
            imgDestination.setOnDragListener(this);

        Button mClickButton1 = (Button)findViewById(R.id.btnfa);
        //mClickButton1.setOnClickListener((OnClickListener) this);
        Log.i("hello",clipData);

        mClickButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(clipData.equals("strawberry")) {
                   Log.i("hello1",clipData);
                   Intent intent = new Intent(getApplicationContext(), Icing.class);
                   intent.putExtra("message","strawberry");
                   startActivity(intent);
               }
                else if(clipData.equals("chocolate")) {

                    Intent intent = new Intent(getApplicationContext(), Icing.class);
                    intent.putExtra("message","chocolate");
                    startActivity(intent);
                }
            }
        });


        }


        @Override
        public boolean onTouch(View v, MotionEvent event) {


            View.DragShadowBuilder mShadow = new View.DragShadowBuilder(v);
            ClipData.Item item = new ClipData.Item(v.getTag().toString());
            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);



            switch (v.getId()) {
                case R.id.SFlavor:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, mShadow, null, 0);
                    } else {
                        v.startDrag(data, mShadow, null, 0);
                    }

                    break;
                case R.id.CFlavor:

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, mShadow, null, 0);
                    } else {
                        v.startDrag(data, mShadow, null, 0);
                    }
                    break;
                case R.id.btnstraw:

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, mShadow, null, 0);
                    } else {
                        v.startDrag(data, mShadow, null, 0);
                    }
                    break;

            }

            return false;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:



                    ((ImageView) v).setColorFilter(Color.WHITE);


                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_ENTERED:

                    clipData = event.getClipDescription().getLabel().toString();
                    switch (clipData) {
                        case "strawberry":
                            imgDestination.setImageResource(R.drawable.plane);
//                        ((ImageView) v).setColorFilter(ContextCompat.getColor(DragandDrop.this, R.color.colorPrimary), android.graphics.PorterDuff.Mode.MULTIPLY);
                            break;
                        case "chocolate":
                            imgDestination.setImageResource(R.drawable.cakechoco);
//                        ((ImageView) v).setColorFilter(ContextCompat.getColor(DragandDrop.this, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
//                            break;
//                        case "strawberry":
//                            imgDestination.setImageResource(R.drawable.scake);
                    }

                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    ((ImageView) v).clearColorFilter();
                    ((ImageView) v).setColorFilter(Color.YELLOW);

                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DROP:


                    clipData = event.getClipDescription().getLabel().toString();
                    Toast.makeText(getApplicationContext(),clipData, Toast.LENGTH_SHORT).show();

                    v.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_ENDED:


                    ((ImageView) v).clearColorFilter();
                    if (event.getResult()) {
                        Toast.makeText(Create.this, "Awesome!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Create.this, "Aw Snap! Try dropping it again", Toast.LENGTH_SHORT).show();
                    }
                    return true;

                default:
                    return false;
            }

        }


}


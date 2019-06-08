package com.sakebakery.opus;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Icing extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {
    String str = "";
    String clipData2="";
    ImageView btns, btnbb,btng,btnbutter,btnchoco,btnwhip;
    ImageView imgDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icing);

        btns = findViewById(R.id.Sicing);
        btnbb = findViewById(R.id.Berryicing);
        btng = findViewById(R.id.Grapeicing);
        btnbutter = findViewById(R.id.Buttericing);
        btnchoco = findViewById(R.id.Chocoicing);
        btnwhip = findViewById(R.id.Whipicing);

        imgDestination = findViewById(R.id.icingDestination);

        btns.setOnTouchListener(this);
        btnbb.setOnTouchListener(this);
        btng.setOnTouchListener(this);
        btnbutter.setOnTouchListener(this);
        btnchoco.setOnTouchListener(this);
        btnwhip.setOnTouchListener(this);

        imgDestination.setOnDragListener(this);
        Intent intent1 = getIntent();
        str = intent1.getStringExtra("message");
        Log.i("str",str);
        if(str.equals("strawberry"))
        {
            imgDestination.setImageResource(R.drawable.plane);
        }
        else
        {
            imgDestination.setImageResource(R.drawable.planec);
        }


        Button mClickButton2 = (Button)findViewById(R.id.btnicing);

        Log.i("test",clipData2);
        mClickButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clipData2.equals("s")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","strawberry");
                    startActivity(intent);
                } else if (clipData2.equals("bb")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","blueberry");
                    startActivity(intent);
                } else if (clipData2.equals("g")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","grape");
                    startActivity(intent);
                } else if (clipData2.equals("butter")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","butter");
                    startActivity(intent);
                } else if (clipData2.equals("c")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","chocolate");
                    startActivity(intent);
                } else if (clipData2.equals("w")) {
                    Intent intent = new Intent(getApplicationContext(), Topping.class);
                    intent.putExtra("message1","whip");
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
            case R.id.Sicing:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    v.startDrag(data, mShadow, null, 0);
                }

                break;
            case R.id.Berryicing:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    v.startDrag(data, mShadow, null, 0);
                }
                break;
            case R.id.Grapeicing:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    v.startDrag(data, mShadow, null, 0);
                }
                break;
            case R.id.Buttericing:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    v.startDrag(data, mShadow, null, 0);
                }
                break;
            case R.id.Chocoicing:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    v.startDrag(data, mShadow, null, 0);
                }
                break;
            case R.id.Whipicing:

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
                clipData2 = event.getClipDescription().getLabel().toString();
                if (str.equals("strawberry")) {
                    if (clipData2.equals("s")) {
                        imgDestination.setImageResource(R.drawable.strawberrycream);
                    } else if (clipData2.equals("bb")) {
                        imgDestination.setImageResource(R.drawable.strawberrybb);
                    } else if (clipData2.equals("g")) {
                        imgDestination.setImageResource(R.drawable.strawberrygrape);
                    } else if (clipData2.equals("butter")) {
                        imgDestination.setImageResource(R.drawable.strawberrybutter);
                    } else if (clipData2.equals("c")) {
                        imgDestination.setImageResource(R.drawable.strawberrybut);
                    } else if (clipData2.equals("w")) {
                        imgDestination.setImageResource(R.drawable.whitecream);
                    }
                    v.invalidate();
                    return true;

                }
                else {

                    if (clipData2.equals("s")) {
                        imgDestination.setImageResource(R.drawable.plane);
                    } else if (clipData2.equals("bb")) {
                        imgDestination.setImageResource(R.drawable.planec);
                    } else if (clipData2.equals("g")) {
                        imgDestination.setImageResource(R.drawable.planec);
                    } else if (clipData2.equals("butter")) {
                        imgDestination.setImageResource(R.drawable.planec);
                    } else if (clipData2.equals("c")) {
                        imgDestination.setImageResource(R.drawable.planec);
                    } else if (clipData2.equals("w")) {
                        imgDestination.setImageResource(R.drawable.planec);
                    }
                    v.invalidate();
                    return true;
                }

//                switch (clipData) {
//                    case "strawberry":
//                        imgDestination.setImageResource(R.drawable.plane);
////                        ((ImageView) v).setColorFilter(ContextCompat.getColor(DragandDrop.this, R.color.colorPrimary), android.graphics.PorterDuff.Mode.MULTIPLY);
//                        break;
//                    case "chocolate":
//                        imgDestination.setImageResource(R.drawable.planec);
////                        ((ImageView) v).setColorFilter(ContextCompat.getColor(DragandDrop.this, R.color.colorAccent), android.graphics.PorterDuff.Mode.MULTIPLY);
////                            break;
////                        case "strawberry":
////                            imgDestination.setImageResource(R.drawable.scake);
//                }
//
//                v.invalidate();
//                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                ((ImageView) v).clearColorFilter();
                ((ImageView) v).setColorFilter(Color.YELLOW);

                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:


                clipData2 = event.getClipDescription().getLabel().toString();
                Toast.makeText(getApplicationContext(), clipData2, Toast.LENGTH_SHORT).show();

                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_ENDED:


                ((ImageView) v).clearColorFilter();
                if (event.getResult()) {
                    Toast.makeText(Icing.this, "Awesome!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Icing.this, "Aw Snap! Try dropping it again", Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return false;
        }
    }
}

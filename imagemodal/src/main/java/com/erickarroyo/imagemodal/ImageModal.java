package com.erickarroyo.imagemodal;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageModal {
    Context context;

    public Dialog builder;

    public ImageModal(Context context) {
        this.context = context;
    }

    public void showModal(String url) {
        final Dialog builder = new Dialog(context);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        builder.setContentView(R.layout.dialog_layout);


        ImageButton imageButton = (ImageButton) builder.findViewById(R.id.close_modal_btn);
        ImageView imageView = (ImageView) builder.findViewById(R.id.image_view);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();

            }
        });

        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Log.d("MODAL_CLOSED", "modal_closed");
            }
        });

        Picasso.get().load(url).into(imageView);


        builder.show();


    }

    public void showModal(String url, DialogInterface.OnDismissListener listener) {
        builder = new Dialog(context);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        builder.setContentView(R.layout.dialog_layout);


        ImageButton imageButton = (ImageButton) builder.findViewById(R.id.close_modal_btn);
        ImageView imageView = (ImageView) builder.findViewById(R.id.image_view);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();
            }
        });

        builder.setOnDismissListener(listener);

        Picasso.get().load(url).into(imageView);







        /*



        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });





        ImageButton imageButton = new ImageButton(this);
        imageButton.setImageResource(R.mipmap.ic_close_modal);
        imageButton.setBackgroundColor(Color.parseColor("#00000000"));

        builder.addContentView(imageButton, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        ImageView imageView = new ImageView(this);


        //Uri imgUri = Uri.parse("android.resource://com.erickarroyo.testmodal/" + R.drawable.ic_novedades_test);
        //imageView.setImageURI(null);
        //imageView.setImageURI(imgUri);


        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));



        Picasso.get().load(url).into(imageView);



*/

        builder.show();


    }
}

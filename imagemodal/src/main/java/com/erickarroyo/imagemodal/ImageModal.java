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

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ImageModal {
    Context context;

    public Dialog builder;
    public ImageButton imageButton;
    public ImageView imageView;

    public ImageModal(Context context) {
        this.context = context;
    }

    public void showModal(String url) {
        setup(url, null);
    }


    public void showModal(String url, DialogInterface.OnDismissListener listener) {
        setup(url, listener);
    }

    private void setup(String url, DialogInterface.OnDismissListener listener) {
        builder = new Dialog(context);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        builder.setContentView(R.layout.dialog_layout);
        imageButton = (ImageButton) builder.findViewById(R.id.close_modal_btn);
        imageView = (ImageView) builder.findViewById(R.id.image_view);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();

            }
        });
        if (listener != null) {
            builder.setOnDismissListener(listener);
        }

        Picasso
                .get()
                .load(url)
                .into(imageView);

        builder.show();
        /*
        Picasso
                .get()
                .load(url)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        builder.show();
                    }

                    @Override
                    public void onError(Exception e) {
                        builder.show();
                    }
                });
        */

    }
}
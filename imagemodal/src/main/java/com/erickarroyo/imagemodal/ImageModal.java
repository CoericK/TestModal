package com.erickarroyo.imagemodal;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.budiyev.android.circularprogressbar.CircularProgressBar;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class ImageModal {
    Context context;

    public Dialog builder;
    public ImageButton imageButton;
    public ImageView imageView;
    public CircularProgressBar circularProgressBar;

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


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(builder.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;






        builder.setContentView(R.layout.dialog_layout);
        imageButton = (ImageButton) builder.findViewById(R.id.close_modal_btn);
        imageView = (ImageView) builder.findViewById(R.id.image_view);
        circularProgressBar = (CircularProgressBar) builder.findViewById(R.id.progress_bar);

        imageButton.setBackground(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
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
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        circularProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        circularProgressBar.setVisibility(View.GONE);
                    }
                });

        //builder.show();
        builder.show();
        builder.getWindow().setAttributes(lp);



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
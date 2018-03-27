package com.erickarroyo.testmodal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.erickarroyo.imagemodal.ImageModal;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /*
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();

        */
        final Context self = this;

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ImageModal imageModal = new ImageModal(self);
                imageModal.showModal("https://orig00.deviantart.net/8a2e/f/2015/109/c/c/vertical_banner_of_the_new_ussr_by_glide08-d8q9zjn.png");
                /*
                imageModal.showModal("https://orig00.deviantart.net/8a2e/f/2015/109/c/c/vertical_banner_of_the_new_ussr_by_glide08-d8q9zjn.png", new Runnable() {
                    @Override
                    public void run() {
                        Log.d("WITHIN_RUNABLE", "MESSAGE CALLBACK");
                    }
                });
                */


            }
        });
    }


}

package com.udacity.nanodegree.android.myappportfolio;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSpotifyApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.spotify_app_name) + " app!");
    }

    public void launchScoresApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.scores_app_name) + " app!");
    }

    public void launchLibraryApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.library_app_name) + " app!");
    }

    public void launchBuildItBiggerApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.build_it_bigger_app_name) + " app!");
    }

    public void launchXYZReaderApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.xyz_reader_app_name) + " app!");
    }

    public void launchCapstoneApp (View view) {
        this.showToast("This button will launch my " + this.getResources().getString(R.string.capstone_app_name) + " app!");
    }

    private void showToast (String message) {

        Context context = this.getApplicationContext();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

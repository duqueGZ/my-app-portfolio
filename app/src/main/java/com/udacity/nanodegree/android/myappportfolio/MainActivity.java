package com.udacity.nanodegree.android.myappportfolio;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNanodegreeApp(View view) {
        String appPackageName;
        switch (view.getId()) {
            case R.id.buttonPopularMovies:
                appPackageName = "com.udacity.nanodegree.android.popularmovies";
                break;
            case R.id.buttonScores:
            case R.id.buttonLibrary:
            case R.id.buttonBuildItBigger:
            case R.id.buttonXYZ:
            case R.id.buttonCapstone:
            default:
                appPackageName = null;
                break;
        }
        if (appPackageName != null ) {
            // Actually launch the selected app
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(new ComponentName(appPackageName,
                    appPackageName + ".MainActivity"));
            launchNewApp(intent);
        } else {
            // Temporarily, show a Toast with the app name
            if (view instanceof Button) {
                showToast("This button will launch my " + ((Button)view).getText().toString() +
                        " app!");
            }
        }
    }

    private void launchNewApp (Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOG_TAG, "Required activity (" + intent.getComponent().getClassName() +
                            ") could not be found");
            showToast(getString(R.string.app_not_found));
        }
    }
    private void showToast (String message) {

        Context context = this.getApplicationContext();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

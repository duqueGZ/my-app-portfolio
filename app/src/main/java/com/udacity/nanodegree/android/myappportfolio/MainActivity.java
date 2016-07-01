package com.udacity.nanodegree.android.myappportfolio;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Vector;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNanodegreeApp(View view) {
        String appPackageName;
        String appMainActivityClassName;
        Vector<String> appFlavors = new Vector<String>();
        switch (view.getId()) {
            case R.id.buttonPopularMovies:
                appPackageName = "com.udacity.nanodegree.android.popularmovies";
                appMainActivityClassName = appPackageName + ".MainActivity";
                break;
            case R.id.buttonFootballScores:
                appPackageName = "barqsoft.footballscores";
                appMainActivityClassName = appPackageName + ".MainActivity";
                break;
            case R.id.buttonAlexandria:
                appPackageName = "it.jaschke.alexandria";
                appMainActivityClassName = appPackageName + ".MainActivity";
                break;
            case R.id.buttonBuildItBigger:
                appPackageName = "com.udacity.gradle.builditbigger";
                appMainActivityClassName = appPackageName + ".MainActivity";
                appFlavors.addAll(Arrays.asList("paid", "free"));
                break;
            case R.id.buttonXYZ:
                appPackageName = "com.example.xyzreader";
                appMainActivityClassName = appPackageName + ".ui.ArticleListActivity";
                break;
            case R.id.buttonCapstone:
                appPackageName = "com.nanodegree.android.watchthemall";
                appMainActivityClassName = appPackageName + ".MainActivity";
                break;
            default:
                appPackageName = null;
                appMainActivityClassName = null;
                break;
        }
        if (appPackageName != null ) {
            // Actually launch the selected app
            launchNewApp(appPackageName, appMainActivityClassName, appFlavors);
        } else {
            // Temporarily, show a Toast with the app name
            if (view instanceof Button) {
                showToast("This button will launch my " + ((Button)view).getText().toString() +
                        " app!");
            }
        }
    }

    private void launchNewApp (String appPackageName, String appMainActivityClassName,
                               Vector<String> appFlavors) {
        String baseAppPackageName = appPackageName;
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            if (!appFlavors.isEmpty()) {
                String flavor = appFlavors.remove(0);
                appPackageName = appPackageName + "." + flavor;
            }
            intent.setComponent(new ComponentName(appPackageName, appMainActivityClassName));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(LOG_TAG, "Required activity (" + intent.getComponent().getPackageName() + " - "
                    + intent.getComponent().getClassName() + ") could not be found");
            if (!appFlavors.isEmpty()) {
                launchNewApp(baseAppPackageName, appMainActivityClassName, appFlavors);
            } else {
                showToast(getString(R.string.app_not_found));
            }
        }
    }
    private void showToast (String message) {

        Context context = this.getApplicationContext();
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

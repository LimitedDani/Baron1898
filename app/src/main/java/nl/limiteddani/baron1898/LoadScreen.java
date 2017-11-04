package nl.limiteddani.baron1898;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by daniq on 3-11-2016.
 */

public class LoadScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.loadscreen);
        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/Baron.otf");
        ImageView max = (ImageView) findViewById(R.id.max);
        ImageView dani = (ImageView) findViewById(R.id.dani);
        TextView baron = (TextView) findViewById(R.id.baronsimtext);
        baron.setTypeface(font);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;

        Bitmap danibm = BitmapFactory.decodeResource(getResources(), R.drawable.danimedia, options);
        Bitmap maxbm = BitmapFactory.decodeResource(getResources(), R.drawable.maxmedia, options);

        max.setImageBitmap(maxbm);
        dani.setImageBitmap(danibm);
        hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        RelativeLayout startscreen = (RelativeLayout) findViewById(R.id.startscreen);
        startscreen.setBackgroundColor(getResources().getColor(R.color.white));
        startscreen.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}

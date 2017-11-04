package nl.limiteddani.baron1898;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by daniq on 30-10-2016.
 */

public class Show2 {
    public static ImageView show2;
    public static ImageView pops;
    public static MainActivity r = MainActivity.r;
    public static boolean startshow2 = false;
    public static boolean showfull2 = false;
    public static boolean doornaarwagon = false;
    public static boolean volumesound = true;
    public static ImageView volume;
    public static void Startup(Context c) {
        show2 = (ImageView) r.findViewById(R.id.show2bezoekers);
        pops = (ImageView) r.findViewById(R.id.popshow2);
        volume = (ImageView) r.findViewById(R.id.show2geluid);
        pops.setImageBitmap(null);
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap show2p = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2, options);
        show2.setImageBitmap(show2p);
        MainActivity.r.button11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(showfull2 && startshow2) {
                    startshow2 = false;
                    Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenoff, options);
                    MainActivity.r.button11.setImageBitmap(show1s);
                    StartShow2();
                }
            }
        });
        volume.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(volumesound) {
                    BaronSound.mp_2.setVolume(0.0f,0.0f);
                    volumesound = false;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_off_white_24dp, options);
                    volume.setImageBitmap(s);
                } else {
                    BaronSound.mp_2.setVolume(1.0f,1.0f);
                    volumesound = true;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_up_white_24dp, options);
                    volume.setImageBitmap(s);
                }
            }
        });
    }
    public static void StartShow2() {
        BaronSound bs = new BaronSound();
        bs.startShow2(r);
        if(!volumesound) {
            bs.mp_2.setVolume(0.0f, 0.0f);
        } else {
            bs.mp_2.setVolume(1.0f, 1.0f);
        }
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.r.button1.setColorFilter(null);
                doornaarwagon = true;
            }
        }, 60000);
    }
    public static void fill() {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        final Handler handler1 = new Handler();
        startshow2 = true;
        showfull2 = true;
        Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenon, options);
        MainActivity.r.button11.setImageBitmap(show1s);
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2_bezoekers1, options);
                pops.setImageBitmap(pop);
                final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2_bezoekers2, options);
                        pops.setImageBitmap(pop);
                        final Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2_bezoekers3, options);
                                pops.setImageBitmap(pop);
                                final Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2_bezoekers4, options);
                                        pops.setImageBitmap(pop);
                                        final Handler handler1 = new Handler();
                                        handler1.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show2_bezoekers5, options);
                                                pops.setImageBitmap(pop);
                                                Show1.fillshow1 = true;
                                                Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.redon, options);
                                                MainActivity.r.button8.setImageBitmap(show1s);
                                                Show1.showdeur1uitgang.startAnimation(Show1.show2deurdicht);
                                                Show1.showdeur2uitgang.startAnimation(Show1.show1deurdicht);
                                                Show1.showdeur3uitgang.startAnimation(Show1.show1deurdicht);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);
                            }
                        }, 1000);
                    }
                }, 1000);
            }
        }, 5000);
    }
}

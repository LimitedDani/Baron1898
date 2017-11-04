package nl.limiteddani.baron1898;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by daniq on 30-10-2016.
 */

public class ShowWagon {
    public static ImageView karshow;
    public static ImageView lampen;
    public static ImageView black;
    public static ImageView volume;
    public static MainActivity r = MainActivity.r;
    public static boolean PreRideStarted = false;
    public static boolean volumesound = true;
    public static void Startup(Context c) {
        karshow = (ImageView) r.findViewById(R.id.karshow);
        lampen = (ImageView) r.findViewById(R.id.lampen);
        black = (ImageView) r.findViewById(R.id.black);
        volume = (ImageView) r.findViewById(R.id.geluidshowwagon);

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap k = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.showkar1, options);
        karshow.setImageBitmap(k);
        Bitmap lamp = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.lampen, options);
        lampen.setImageBitmap(lamp);
        Bitmap b = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.kar1showblack, options);
        black.setImageBitmap(b);
        Dimmen(0,0);

        volume.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(volumesound) {
                    BaronSound.mp_3.setVolume(0.0f,0.0f);
                    volumesound = false;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_off_white_24dp, options);
                    volume.setImageBitmap(s);
                } else {
                    BaronSound.mp_3.setVolume(1.0f,1.0f);
                    volumesound = true;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_up_white_24dp, options);
                    volume.setImageBitmap(s);
                }
            }
        });
    }
    public static void StartPreride() {
        BaronSound bs = new BaronSound();
        bs.startpreride(r);
        Oplichten(2000, 0);
        Dimmen(2000, 2000);
        Oplichten(2000, 4000);
        Dimmen(2000, 6000);
        Oplichten(2000, 8000);
        Dimmen(2000, 10000);
        Oplichten(2000, 12000);
        Dimmen(2000, 14000);
        Oplichten(2000, 16000);
        Dimmen(2000, 18000);
        Oplichten(2000, 20000);
        Dimmen(2000, 22000);
        Oplichten(2000, 24000);
        Dimmen(2000, 26000);
        Oplichten(2000, 28000);
        Dimmen(2000, 30000);
        Oplichten(2000, 32000);
        Dimmen(2000, 34000);
        Oplichten(2000, 36000);
        RedLight(39000);
        Rijden(39000);
        Dimmen(2000, 45000);
    }
    public static void Dimmen(final int time, final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int colorFrom = 255;
                int colorTo = 0;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(time); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Integer value = (Integer) animator.getAnimatedValue();
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.lampen, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        lampen.setImageDrawable(drawable);
                    }
                });
                colorAnimation.start();
            }
        }, timena);
    }
    public static void Oplichten(final int time, final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int colorFrom = 0;
                int colorTo = 255;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(time); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Integer value = (Integer) animator.getAnimatedValue();
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.lampen, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        lampen.setImageDrawable(drawable);
                    }
                });
                colorAnimation.start();
            }
        }, timena);
    }
    public static void Rijden(final int time) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(ControlPanel.wagon == 0) {
                    MainActivity.r.wagon2.startAnimation(MainActivity.r.wagonAfdaling);
                } else {
                    MainActivity.r.wagon.startAnimation(MainActivity.r.wagonAfdaling);
                }
                PreRideStarted = false;
            }
        }, time);
    }
    public static void RedLight(final int time) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.roodlicht, options);
                BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                lampen.setImageDrawable(drawable);
            }
        }, time);
    }
}

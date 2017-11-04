package nl.limiteddani.baron1898;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static android.R.attr.bitmap;
import static android.R.attr.opacity;

/**
 * Created by daniq on 30-10-2016.
 */

public class Show1 {
    public static ImageView show1;
    public static ImageView pops = null;
    public static ImageView showdeur1begin;
    public static ImageView showdeur2begin;
    public static ImageView showdeur1uitgang;
    public static ImageView showdeur2uitgang;
    public static ImageView showdeur3uitgang;
    public static ImageView light;
    public static ImageView jukeboxspot;
    public static ImageView volume;
    public static RelativeLayout showlight;

    public static boolean show1full = false;
    public static boolean volumesound = true;
    public static boolean fillshow1 = true;
    public static boolean startshow1 = false;
    public static boolean doornaarshow2 = false;


    public static MainActivity r = MainActivity.r;
    public static Animation show1deuropen, show1deurdicht;
    public static Animation show2deuropen, show2deurdicht;
    public static void Startup(Context c) {
        show1deuropen = AnimationUtils.loadAnimation(c, R.anim.show1deuropen);
        show1deurdicht = AnimationUtils.loadAnimation(c, R.anim.show1deurdicht);
        show2deuropen = AnimationUtils.loadAnimation(c, R.anim.show2deuropen);
        show2deurdicht = AnimationUtils.loadAnimation(c, R.anim.show2deurdicht);
        show1 = (ImageView) r.findViewById(R.id.show1bezoekers);
        pops = (ImageView) r.findViewById(R.id.popshow1);
        showdeur1begin = (ImageView) r.findViewById(R.id.showdeur1);
        showdeur2begin = (ImageView) r.findViewById(R.id.showdeur2);
        showdeur1uitgang = (ImageView) r.findViewById(R.id.showdeuruit1);
        showdeur2uitgang = (ImageView) r.findViewById(R.id.showdeuruit2);
        showdeur3uitgang = (ImageView) r.findViewById(R.id.showdeuruit3);
        light = (ImageView) r.findViewById(R.id.lightshow1);
        jukeboxspot = (ImageView) r.findViewById(R.id.jukeboxspot);
        showlight = (RelativeLayout) r.findViewById(R.id.showlight);
        volume = (ImageView) r.findViewById(R.id.show1geluid);


        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap li = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
        light.setImageBitmap(li);
        Bitmap show1p = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1, options);
        show1.setImageBitmap(show1p);
        Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.redon, options);
        MainActivity.r.button8.setImageBitmap(show1s);
        Bitmap jk = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_jukebox_spot, options);
        jukeboxspot.setImageBitmap(jk);
        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_up_white_24dp, options);
        volume.setImageBitmap(s);

        Bitmap s1 = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_deur1, options);
        showdeur1begin.setImageBitmap(s1);
        showdeur3uitgang.setImageBitmap(s1);
        showdeur2uitgang.setImageBitmap(s1);
        Bitmap s2 = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_deur2, options);
        showdeur2begin.setImageBitmap(s2);
        showdeur1uitgang.setImageBitmap(s2);

        MainActivity.r.button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(fillshow1) {
                    fillshow1 = false;
                    Fill();
                    reset();
                    Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.redoff, options);
                    MainActivity.r.button8.setImageBitmap(show1s);
                }
            }
        });
        volume.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(volumesound) {
                    BaronSound.mp_1.setVolume(0.0f,0.0f);
                    volumesound = false;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_off_white_24dp, options);
                    volume.setImageBitmap(s);
                } else {
                    BaronSound.mp_1.setVolume(1.0f,1.0f);
                    volumesound = true;
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.ic_volume_up_white_24dp, options);
                    volume.setImageBitmap(s);
                }
            }
        });
        MainActivity.r.button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(startshow1) {
                    StartShow1();
                    showdeur2begin.startAnimation(show2deurdicht);
                    showdeur1begin.startAnimation(show1deurdicht);
                    startshow1 = false;
                }
            }
        });
        MainActivity.r.button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(doornaarshow2 && !Show2.showfull2) {
                    fillshow1 = true;
                    Uitgangdeuropen();
                    Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.redoff, options);
                    MainActivity.r.button9.setImageBitmap(show1s);
                    Show2.fill();
                }
            }
        });
        reset();
    }
    public static void Fill() {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        showdeur2begin.startAnimation(show2deuropen);
        showdeur1begin.startAnimation(show1deuropen);
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers1, options);
                pops.setImageBitmap(pop);
                final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers2, options);
                        pops.setImageBitmap(pop);
                        final Handler handler1 = new Handler();
                        handler1.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers3, options);
                                pops.setImageBitmap(pop);
                                final Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers4, options);
                                        pops.setImageBitmap(pop);
                                        final Handler handler1 = new Handler();
                                        handler1.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers5, options);
                                                pops.setImageBitmap(pop);
                                                final Handler handler1 = new Handler();
                                                handler1.postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers6, options);
                                                        pops.setImageBitmap(pop);
                                                        final Handler handler1 = new Handler();
                                                        handler1.postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers7, options);
                                                                pops.setImageBitmap(pop);
                                                                final Handler handler1 = new Handler();
                                                                handler1.postDelayed(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers8, options);
                                                                        pops.setImageBitmap(pop);
                                                                        final Handler handler1 = new Handler();
                                                                        handler1.postDelayed(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                Bitmap pop = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_bezoekers9, options);
                                                                                pops.setImageBitmap(pop);
                                                                                show1full = true;
                                                                                startshow1 = true;
                                                                                final BitmapFactory.Options options = new BitmapFactory.Options();
                                                                                options.inScaled = false;
                                                                                Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenon, options);
                                                                                MainActivity.r.button10.setImageBitmap(show1s);
                                                                            }
                                                                        }, 1000);
                                                                    }
                                                                }, 1000);
                                                            }
                                                        }, 1000);
                                                    }
                                                }, 1000);
                                            }
                                        }, 1000);
                                    }
                                }, 1000);
                            }
                        }, 1000);
                    }
                }, 1000);
            }
        }, 1000);
    }
    public static void reset() {
        LampenUit(0);
        jukeboxspot.setImageDrawable(null);
        Show1.showlight.setBackgroundColor(MainActivity.r.getResources().getColor(R.color.darkoverlay1));
    }
    public static void StartShow1() {
        int colorFrom = MainActivity.r.getResources().getColor(R.color.darkoverlay1);
        int colorTo = MainActivity.r.getResources().getColor(R.color.darkoverlay6);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(2000); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                showlight.setBackgroundColor((int) animator.getAnimatedValue());
            }
        });
        colorAnimation.start();
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenoff, options);
        MainActivity.r.button10.setImageBitmap(show1s);
        final BaronSound bs = new BaronSound();
        bs.startShow1(MainActivity.r);
        bs.mp_1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {

            }
        });
        if(!volumesound) {
            bs.mp_1.setVolume(0.0f, 0.0f);
        } else {
            bs.mp_1.setVolume(1.0f, 1.0f);
        }
        //00:00:18
        OplichtenVanuituit(3000, 10);
        //00:00:25
        LampenKnipperen(7000, 200);
        //00:00:31
        LampenKnipperen(13000, 200);
        //00:00:36
        LampenKnipperen(18000, 200);
        //00:00:43
        LampenKnipperen(25000, 200);
        //00:00:49
        LampenKnipperen(31000, 200);
        //00:00:54
        LampenKnipperen(36000, 200);
        //00:01:01
        LampenKnipperen(43000, 200);
        //00:01:06
        LampenKnipperen(48000, 200);
        //00:01:12
        LampenKnipperen(54000, 200);
        //00:01:18
        LampenKnipperen(60000, 200);
        //00:01:21 lichten dimmen
        Dimmen(3000, 63000);
        //00:01:24 lichten zijn erg gedimt
        Oplichten(4000, 66000);
        //00:01:28 lichten zijn weer normaal
        Dimmen(2000, 70000);
        //00:01:30 lichten zijn erg gedimt
        Oplichten(3000, 72000);
        //00:01:33 lichten zijn weer normaal
        Dimmen(3000, 75000);
        //00:01:36 lichten zijn erg gedimt
        Oplichten(3000, 78000);
        //00:01:39 lichten zijn weer normaal

        //00:01:42 lichten zijn erg gedimt

        //00:01:44 lichten gaan heel snel knipperen
        Dimmen(400, 79000);
        Dimmen(400, 79501);
        Dimmen(400, 80002);
        Dimmen(400, 80503);
        Dimmen(400, 81004);
        Dimmen(400, 81505);
        Dimmen(400, 82006);
        Dimmen(400, 82507);
        Dimmen(400, 83008);
        Dimmen(400, 83509);
        Dimmen(400, 84010);
        Dimmen(400, 84511);
        Dimmen(400, 85012);
        Dimmen(400, 85513);
        LampenUit(86013);
        //00:01:47 stop met knipperen en lichten zijn uit
        //00:01:49 jukebox gaat oplichten
        JukeBoxLichten(89013);
        //00:02:00 mensen kunnen door naar show2
        DoorNaarShow2(99013);
    }
    public static void LampenKnipperen(final int aanna, final int uitna) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                light.setImageBitmap(null);
                final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Bitmap show1s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
                        light.setImageBitmap(show1s);
                    }
                }, uitna);
            }
        }, aanna);
    }
    public static void Dimmen(final int time, final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int colorFrom = 255;
                int colorTo = 70;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(time); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Integer value = (Integer) animator.getAnimatedValue();
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        light.setImageDrawable(drawable);
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
                int colorFrom = 70;
                int colorTo = 255;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(time); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Integer value = (Integer) animator.getAnimatedValue();
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        light.setImageDrawable(drawable);
                    }
                });
                colorAnimation.start();
            }
        }, timena);
    }
    public static void LampenUit(final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                light.setImageBitmap(null);
            }
        }, timena);
    }
    public static void DoorNaarShow2(final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap re = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.redon, options);
                MainActivity.r.button9.setImageBitmap(re);
                doornaarshow2 = true;
            }
        }, timena);
    }
    public static void LampenAan(final int timena) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                final BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = false;
                Bitmap li = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
                light.setImageBitmap(li);
            }
        }, timena);
    }
    public static void OplichtenVanuituit(final int time, final int timena) {
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
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1witlicht, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        light.setImageDrawable(drawable);
                    }
                });
                colorAnimation.start();
            }
        }, timena);
    }
    public static void JukeBoxLichten(final int time) {
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                int colorFrom = 0;
                int colorTo = 255;
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(1000); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        final BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = false;
                        Integer value = (Integer) animator.getAnimatedValue();
                        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.show1_jukebox_spot, options);
                        BitmapDrawable drawable = new BitmapDrawable(r.getResources(), l);
                        drawable.setAlpha(value);
                        jukeboxspot.setImageDrawable(drawable);
                    }
                });
                colorAnimation.start();
            }
        }, time);
    }
    public static void Uitgangdeuropen() {
        if(doornaarshow2) {
            showdeur1uitgang.startAnimation(show2deuropen);
            showdeur2uitgang.startAnimation(show1deuropen);
            showdeur3uitgang.startAnimation(show1deuropen);
            doornaarshow2 = false;
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pops.setImageBitmap(null);
                }
            }, 2000);
        }
    }
}

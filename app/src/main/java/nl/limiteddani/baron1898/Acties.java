package nl.limiteddani.baron1898;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;

/**
 * Created by daniq on 28-10-2016.
 */

public class Acties {
    public void PoortjesOpenen() {
        final Animation rotation = AnimationUtils.loadAnimation(MainActivity.r, R.anim.rotateopen);
        MainActivity.r.poortje1.startAnimation(rotation);
        MainActivity.r.poortje2.startAnimation(rotation);
        MainActivity.r.poortje3.startAnimation(rotation);
        rotation.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                if((!ControlPanel.trainfull) && (!ControlPanel.pwaitingb) && (Show2.doornaarwagon)) {
                    MainActivity.r.pop1.startAnimation(MainActivity.r.popshow);
                    MainActivity.r.pop1.setVisibility(View.VISIBLE);
                    MainActivity.r.pop2.startAnimation(MainActivity.r.popshow);
                    MainActivity.r.pop2.setVisibility(View.VISIBLE);
                    MainActivity.r.pop3.startAnimation(MainActivity.r.popshow);
                    MainActivity.r.pop3.setVisibility(View.VISIBLE);
                    MainActivity.r.popshow.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation arg0) {
                        }

                        @Override
                        public void onAnimationRepeat(Animation arg0) {
                        }

                        @Override
                        public void onAnimationEnd(Animation arg0) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inScaled = false;
                            if(!ControlPanel.beugels) {
                                MainActivity.r.pop1.setVisibility(View.GONE);
                                MainActivity.r.pop2.setVisibility(View.GONE);
                                MainActivity.r.pop3.setVisibility(View.GONE);
                                Bitmap veen = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2v, options);
                                MainActivity.r.wagon.setImageBitmap(veen);
                                ControlPanel.trainfull = true;
                                CheckStarten();
                            } else {
                                ControlPanel.pwaitingb = true;
                                CheckStarten();
                            }
                            ControlPanel.actiongoing = false;
                            CheckStarten();
                        }
                    });
                } else {
                    ControlPanel.actiongoing = false;
                    CheckStarten();
                }
            }
        });
    }
    public void PoortjesDicht() {
        Animation rotation = AnimationUtils.loadAnimation(MainActivity.r, R.anim.rotateclose);
        MainActivity.r.poortje1.startAnimation(rotation);
        MainActivity.r.poortje2.startAnimation(rotation);
        MainActivity.r.poortje3.startAnimation(rotation);
        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.actiongoing = false;
                MainActivity.r.button1.setColorFilter(ContextCompat.getColor(MainActivity.r,R.color.whitetrans));
                CheckStarten();
            }
        });
    }
    public static void SchuivenUit() {
        MainActivity.r.PlayLuiken();
        MainActivity.r.lschuif1.startAnimation(MainActivity.r.llinks);
        MainActivity.r.lschuif2.startAnimation(MainActivity.r.llinks);
        MainActivity.r.lschuif3.startAnimation(MainActivity.r.llinks);
        MainActivity.r.rschuif1.startAnimation(MainActivity.r.rrechts);
        MainActivity.r.rschuif2.startAnimation(MainActivity.r.rrechts);
        MainActivity.r.rschuif3.startAnimation(MainActivity.r.rrechts);
        MainActivity.r.grotepoortlinks.startAnimation(MainActivity.r.grotepoortlinksopen);
        MainActivity.r.grotepoortrechts.startAnimation(MainActivity.r.grotepoortrechtsopen);
        MainActivity.r.rrechts.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.actiongoing = false;
                CheckStarten();
            }
        });
    }
    public static void SchuivenIn() {
        MainActivity.r.PlayLuiken();
        MainActivity.r.lschuif1.startAnimation(MainActivity.r.lrechts);
        MainActivity.r.lschuif2.startAnimation(MainActivity.r.lrechts);
        MainActivity.r.lschuif3.startAnimation(MainActivity.r.lrechts);
        MainActivity.r.rschuif1.startAnimation(MainActivity.r.rlinks);
        MainActivity.r.rschuif2.startAnimation(MainActivity.r.rlinks);
        MainActivity.r.rschuif3.startAnimation(MainActivity.r.rlinks);
        MainActivity.r.grotepoortlinks.startAnimation(MainActivity.r.grotepoortlinksdicht);
        MainActivity.r.grotepoortrechts.startAnimation(MainActivity.r.grotepoortrechtsdicht);
        MainActivity.r.rlinks.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.actiongoing = false;
                CheckStarten();
            }
        });
    }
    public static void UitgangOpen() {
        MainActivity.r.uitgang1.startAnimation(MainActivity.r.uitgangopen);
        MainActivity.r.uitgang2.startAnimation(MainActivity.r.uitgangopen);
        MainActivity.r.uitgang3.startAnimation(MainActivity.r.uitgangopen);
        MainActivity.r.uitgangopen.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.actiongoing = false;
                CheckStarten();
            }
        });
    }
    public static void UitgangDicht() {
        MainActivity.r.uitgang1.startAnimation(MainActivity.r.uitgangdicht);
        MainActivity.r.uitgang2.startAnimation(MainActivity.r.uitgangdicht);
        MainActivity.r.uitgang3.startAnimation(MainActivity.r.uitgangdicht);
        MainActivity.r.uitgangdicht.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.actiongoing = false;
                CheckStarten();
            }
        });
    }
    public static void CheckStarten() {
        if((ControlPanel.trainonstation) && (!ControlPanel.poortjesopen) && (ControlPanel.trainfull) && (ControlPanel.beugels) && (!ControlPanel.vloer) && (!ControlPanel.poortjesopen) && (!ControlPanel.actiongoing)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenon, options);
            MainActivity.r.button5.setImageBitmap(r);
            Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.groen, options);
            MainActivity.r.stoplicht5.setImageBitmap(s);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenoff, options);
            MainActivity.r.button5.setImageBitmap(r);
            Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
            MainActivity.r.stoplicht5.setImageBitmap(s);
        }
    }
}

package nl.limiteddani.baron1898;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.health.PackageHealthStats;
import android.view.View;
import android.view.animation.Animation;

import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;

/**
 * Created by daniq on 28-10-2016.
 */

public class ControlPanel {
    public static boolean poortjesopen = false;
    public static boolean trainfull = false;
    public static boolean beugels = true;
    public static boolean vloer = false;
    public static boolean trainonstation = false;
    public static boolean actiongoing = false;
    public static boolean pwaitingb = false;
    public static boolean uitgang = false;
    public static int wagon = 0;


    public static Acties acties = new Acties();
    public static void StartControlPanel() {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        MainActivity.r.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(trainonstation && (!actiongoing) && Show2.doornaarwagon) {
                    actiongoing = true;
                    if (poortjesopen) {
                        acties.PoortjesDicht();
                        poortjesopen = false;

                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchright, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.groen, options);
                        MainActivity.r.button1.setImageBitmap(s);
                        MainActivity.r.stoplicht1.setImageBitmap(st);
                        Show2.showfull2 = false;
                        Show2.doornaarwagon = false;
                    } else {
                        acties.PoortjesOpenen();
                        poortjesopen = true;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchleft, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
                        MainActivity.r.stoplicht1.setImageBitmap(st);
                        MainActivity.r.button1.setImageBitmap(s);
                        Show2.pops.setImageBitmap(null);
                    }
                }
            }
        });
        MainActivity.r.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(trainonstation && (!actiongoing)) {
                    if (beugels) {
                        if (trainfull) {
                            if(wagon == 0) {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2v, options);
                                MainActivity.r.wagon.setImageBitmap(st);
                            } else {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2v, options);
                                MainActivity.r.wagon2.setImageBitmap(st);
                            }
                        } else {
                            if(pwaitingb) {
                                MainActivity.r.pop1.setVisibility(View.GONE);
                                MainActivity.r.pop2.setVisibility(View.GONE);
                                MainActivity.r.pop3.setVisibility(View.GONE);
                                if(wagon == 0) {
                                    Bitmap veen = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2v, options);
                                    MainActivity.r.wagon.setImageBitmap(veen);
                                } else {
                                    Bitmap veen = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2v, options);
                                    MainActivity.r.wagon2.setImageBitmap(veen);
                                }
                                pwaitingb = false;
                                ControlPanel.trainfull = true;
                            } else {
                                if(wagon == 0) {
                                    Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2, options);
                                    MainActivity.r.wagon.setImageBitmap(st);
                                } else {
                                    Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein2, options);
                                    MainActivity.r.wagon2.setImageBitmap(st);
                                }
                            }
                        }
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchleft, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
                        MainActivity.r.stoplicht2.setImageBitmap(st);
                        MainActivity.r.button2.setImageBitmap(s);
                        beugels = false;
                    } else {
                        if (trainfull) {
                            if(wagon == 0) {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein1v, options);
                                MainActivity.r.wagon.setImageBitmap(st);
                            } else {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein1v, options);
                                MainActivity.r.wagon2.setImageBitmap(st);
                            }
                        } else {
                            if(wagon == 0) {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein_1, options);
                                MainActivity.r.wagon.setImageBitmap(st);
                            } else {
                                Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein_1, options);
                                MainActivity.r.wagon2.setImageBitmap(st);
                            }
                        }
                        beugels = true;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchright, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.groen, options);
                        MainActivity.r.button2.setImageBitmap(s);
                        MainActivity.r.stoplicht2.setImageBitmap(st);
                    }
                    Acties.CheckStarten();
                }
            }
        });
        MainActivity.r.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(trainonstation && (!actiongoing)) {
                    actiongoing = true;
                    if(vloer) {
                        acties.SchuivenUit();
                        vloer = false;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchright, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.groen, options);
                        MainActivity.r.button3.setImageBitmap(s);
                        MainActivity.r.stoplicht3.setImageBitmap(st);
                    } else {
                        acties.SchuivenIn();
                        vloer = true;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchleft, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
                        MainActivity.r.button3.setImageBitmap(s);
                        MainActivity.r.stoplicht3.setImageBitmap(st);
                    }
                }
            }
        });
        MainActivity.r.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(trainonstation) {
                    actiongoing = true;
                    if(uitgang) {
                        acties.UitgangDicht();
                        uitgang = false;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchright, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.groen, options);
                        MainActivity.r.button4.setImageBitmap(s);
                        MainActivity.r.stoplicht4.setImageBitmap(st);
                    } else {
                        acties.UitgangOpen();
                        uitgang = true;
                        Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.switchleft, options);
                        Bitmap st = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
                        MainActivity.r.button4.setImageBitmap(s);
                        MainActivity.r.stoplicht4.setImageBitmap(st);
                    }
                }
            }
        });
        MainActivity.r.button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if((trainonstation) && (!poortjesopen) && (trainfull) && (beugels) && (!vloer) && (!poortjesopen) && (!ShowWagon.PreRideStarted) && (!actiongoing)) {
                    MainActivity.r.PlayWegIn();
                    if(wagon == 0) {
                        MainActivity.r.wagon.startAnimation(MainActivity.r.wagonDoor);
                        wagon = 1;
                    } else {
                        MainActivity.r.wagon2.startAnimation(MainActivity.r.wagonDoor);
                        wagon = 0;
                    }
                    MainActivity.r.wagonDoor.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation arg0) {
                        }
                        @Override
                        public void onAnimationRepeat(Animation arg0) {
                        }
                        @Override
                        public void onAnimationEnd(Animation arg0) {
                            ShowWagon.StartPreride();
                            ShowWagon.PreRideStarted = true;
                        }
                    });
                    trainonstation = false;
                    trainfull = false;
                    final BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = false;
                    Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.greenoff, options);
                    MainActivity.r.button5.setImageBitmap(r);
                    Bitmap s = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.rood, options);
                    MainActivity.r.stoplicht5.setImageBitmap(s);
                    final Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(wagon == 0) {
                                MainActivity.r.wagon.setVisibility(View.VISIBLE);
                                Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein_1, options);
                                MainActivity.r.wagon.setImageBitmap(r);
                                MainActivity.r.wagon.startAnimation(MainActivity.r.wagonShow);
                                MainActivity.r.PlayWegIn();
                            } else {
                                MainActivity.r.wagon2.setVisibility(View.VISIBLE);
                                Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein_1, options);
                                MainActivity.r.wagon2.setImageBitmap(r);
                                MainActivity.r.wagon2.startAnimation(MainActivity.r.wagonShow);
                                MainActivity.r.PlayWegIn();
                            }
                        }
                    }, 10000);
                }
            }
        });
        MainActivity.r.button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.r.attractiepanel.startAnimation(MainActivity.r.leftmenuleft);
                MainActivity.r.attractiepanel.setVisibility(View.GONE);
                MainActivity.r.showpanel.startAnimation(MainActivity.r.rightmenuleft);
                MainActivity.r.showpanel.setVisibility(View.VISIBLE);
            }
        });
        MainActivity.r.button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.r.attractiepanel.startAnimation(MainActivity.r.leftmenuright);
                MainActivity.r.attractiepanel.setVisibility(View.VISIBLE);
                MainActivity.r.showpanel.startAnimation(MainActivity.r.rightmenuright);
                MainActivity.r.showpanel.setVisibility(View.GONE);
            }
        });
    }
}

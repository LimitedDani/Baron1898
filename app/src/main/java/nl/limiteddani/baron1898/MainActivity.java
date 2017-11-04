package nl.limiteddani.baron1898;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;
import com.google.example.games.basegameutils.BaseGameUtils;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    static boolean starton = false;
    public RelativeLayout rol;
    public RelativeLayout controlpanel;
    public LinearLayout showpanel;
    public LinearLayout attractiepanel;
    public TextView texthide;
    public TextView sluiten;
    public Typeface font;
    public Switch autohide;
    public boolean hideauto = false;
    public Animation animShow, animHide;
    public Animation wagonShow, wagonDoor, wagonAfdaling;
    public Animation llinks, lrechts, rrechts, rlinks, rbegin, lbegin, uitgangbegin, grotepoortlinksdicht, grotepoortrechtsdicht, uitgangopen, uitgangdicht, grotepoortlinksopen, grotepoortrechtsopen, leftmenuleft, leftmenuright, rightmenuleft, rightmenuright;
    public Animation popshow;
    public boolean iscphide = true;
    public ImageView openen;
    public ImageView wagon, wagon2;
    public ImageView pop1;
    public ImageView pop2;
    public ImageView pop3;
    public ImageView lschuif1;
    public ImageView lschuif2;
    public ImageView lschuif3;
    public ImageView rschuif1;
    public ImageView rschuif2;
    public ImageView rschuif3;

    public ImageView stoplicht1;
    public ImageView stoplicht2;
    public ImageView stoplicht3;
    public ImageView stoplicht4;
    public ImageView stoplicht5;

    public ImageView tekst1;
    public ImageView tekst2;
    public ImageView tekst3;
    public ImageView tekst4;
    public ImageView tekst5;
    public ImageView tekst6;
    public ImageView tekst7;
    public ImageView tekst8;
    public ImageView tekst9;
    public ImageView tekst10;
    public ImageView tekst11;
    public ImageView tekst12;

    public ImageView button1;
    public ImageView button2;
    public ImageView button3;
    public ImageView button4;
    public ImageView button5;
    public ImageView button6;
    public ImageView button7;
    public ImageView button8;
    public ImageView button9;
    public ImageView button10;
    public ImageView button11;
    public ImageView button12;

    public ImageView poortje1, uitgang1;
    public ImageView poortje2, uitgang2;
    public ImageView poortje3, uitgang3;

    public ImageView grotepoortlinks;
    public ImageView grotepoortrechts;

    boolean mp1 = false;
    boolean mp2 = false;
    boolean mp3 = false;
    boolean mp4 = false;
    boolean mp5 = false;
    boolean mp6 = false;
    public static Acties acties = new Acties();

    public static MainActivity r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }

        r = this;
        //texthide = (TextView) findViewById(R.id.texthide);
        rol = (RelativeLayout) findViewById(R.id.rol);
        controlpanel = (RelativeLayout) findViewById(R.id.controlpanel);
        showpanel = (LinearLayout) findViewById(R.id.besturingshow);
        attractiepanel = (LinearLayout) findViewById(R.id.besturingattractie);
        font = Typeface.createFromAsset(getAssets(),"fonts/Baron.otf");
        sluiten = (TextView) findViewById(R.id.sluiten);
        //autohide = (Switch) findViewById(R.id.autohideswitch);
        animShow = AnimationUtils.loadAnimation( this, R.anim.show);
        animHide = AnimationUtils.loadAnimation( this, R.anim.hide);
        wagonShow = AnimationUtils.loadAnimation( this, R.anim.inwagon);
        wagonDoor = AnimationUtils.loadAnimation( this, R.anim.wagondoor);
        wagonAfdaling = AnimationUtils.loadAnimation( this, R.anim.wagonafdaling);
        popshow = AnimationUtils.loadAnimation( this, R.anim.popshow);
        uitgangbegin = AnimationUtils.loadAnimation( this, R.anim.uitgangrotatebegin);
        stoplicht1 = (ImageView) findViewById(R.id.stoplichtdeuringang);
        stoplicht2 = (ImageView) findViewById(R.id.stoplichtbeugels);
        stoplicht3 = (ImageView) findViewById(R.id.stoplichtvloer);
        stoplicht4 = (ImageView) findViewById(R.id.stoplichtpoortjes);
        stoplicht5 = (ImageView) findViewById(R.id.stoplichtstarten);
        tekst1 = (ImageView) findViewById(R.id.textdeuren);
        tekst2 = (ImageView) findViewById(R.id.textbeugels);
        tekst3 = (ImageView) findViewById(R.id.textvloer);
        tekst4 = (ImageView) findViewById(R.id.textpoortjes);
        tekst5 = (ImageView) findViewById(R.id.textstarten);
        tekst6 = (ImageView) findViewById(R.id.textmeer);
        tekst7 = (ImageView) findViewById(R.id.textterug);
        tekst8 = (ImageView) findViewById(R.id.textvullenshow1);
        tekst9 = (ImageView) findViewById(R.id.textoverplaatsen12);
        tekst10 = (ImageView) findViewById(R.id.textstartshow1);
        tekst11 = (ImageView) findViewById(R.id.textstartshow2);
        tekst12 = (ImageView) findViewById(R.id.texthandleiding);
        button1 = (ImageView) findViewById(R.id.buttondeuringang);
        button2 = (ImageView) findViewById(R.id.buttonbeugels);
        button3 = (ImageView) findViewById(R.id.buttonvloer);
        button4 = (ImageView) findViewById(R.id.buttonpoortjes);
        button5 = (ImageView) findViewById(R.id.buttonstarten);
        button6 = (ImageView) findViewById(R.id.buttonmeer);
        button7 = (ImageView) findViewById(R.id.buttonterug);
        button8 = (ImageView) findViewById(R.id.buttonvulshow1);
        button9 = (ImageView) findViewById(R.id.buttonoverplaatsen12);
        button10 = (ImageView) findViewById(R.id.buttonstartshow1);
        button11 = (ImageView) findViewById(R.id.buttonstartshow2);
        button12 = (ImageView) findViewById(R.id.buttonhandleiding);
        poortje1 = (ImageView) findViewById(R.id.poortje1);
        poortje2 = (ImageView) findViewById(R.id.poortje2);
        poortje3 = (ImageView) findViewById(R.id.poortje3);
        uitgang1 = (ImageView) findViewById(R.id.uitgang1);
        uitgang2 = (ImageView) findViewById(R.id.uitgang2);
        uitgang3 = (ImageView) findViewById(R.id.uitgang3);
        grotepoortlinks = (ImageView) findViewById(R.id.grotepoortlinks);
        grotepoortrechts = (ImageView) findViewById(R.id.grotepoortrechts);


        openen = (ImageView) findViewById(R.id.opencontrol);
        wagon = (ImageView) findViewById(R.id.wagon);
        wagon2 = (ImageView) findViewById(R.id.wagon2);
        pop1 = (ImageView) findViewById(R.id.pops1);
        pop2 = (ImageView) findViewById(R.id.pops2);
        pop3 = (ImageView) findViewById(R.id.pops3);

        lschuif1 = (ImageView) findViewById(R.id.lplaat1);
        lschuif2 = (ImageView) findViewById(R.id.lplaat2);
        lschuif3 = (ImageView) findViewById(R.id.lplaat3);
        rschuif1 = (ImageView) findViewById(R.id.rplaat1);
        rschuif2 = (ImageView) findViewById(R.id.rplaat2);
        rschuif3 = (ImageView) findViewById(R.id.rplaat3);

        llinks = AnimationUtils.loadAnimation(this, R.anim.lrechtsnaarlinks);
        lrechts = AnimationUtils.loadAnimation(this, R.anim.llinksnaarrechts);
        rlinks = AnimationUtils.loadAnimation(this, R.anim.rrechtsnaarlinks);
        rrechts = AnimationUtils.loadAnimation(this, R.anim.rlinksnaarrechts);
        rbegin = AnimationUtils.loadAnimation(this, R.anim.rbegin);
        lbegin = AnimationUtils.loadAnimation(this, R.anim.lbegin);
        grotepoortlinksdicht = AnimationUtils.loadAnimation(this, R.anim.grotepoortlinksdicht);
        grotepoortrechtsdicht = AnimationUtils.loadAnimation(this, R.anim.grotepoortrechtsdicht);
        grotepoortlinksopen = AnimationUtils.loadAnimation(this, R.anim.grotepoortlinksopen);
        grotepoortrechtsopen = AnimationUtils.loadAnimation(this, R.anim.grotepoortrechtsopen);
        uitgangopen = AnimationUtils.loadAnimation(this, R.anim.uitgangopen);
        uitgangdicht = AnimationUtils.loadAnimation(this, R.anim.uitgangdicht);
        leftmenuleft = AnimationUtils.loadAnimation(this, R.anim.leftmenutoleft);
        leftmenuright = AnimationUtils.loadAnimation(this, R.anim.leftmenutoright);
        rightmenuleft = AnimationUtils.loadAnimation(this, R.anim.rightmenutoleft);
        rightmenuright = AnimationUtils.loadAnimation(this, R.anim.rightmenutoright);

        rschuif1.startAnimation(rbegin);
        rschuif2.startAnimation(rbegin);
        rschuif3.startAnimation(rbegin);
        lschuif1.startAnimation(lbegin);
        lschuif2.startAnimation(lbegin);
        lschuif3.startAnimation(lbegin);
        pop1.setVisibility(View.GONE);
        pop2.setVisibility(View.GONE);
        pop3.setVisibility(View.GONE);
        wagon.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        wagon.startAnimation(wagonShow);
        wagon.setVisibility(View.VISIBLE);
        wagon2.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        wagon2.startAnimation(wagonShow);
        wagon2.setVisibility(View.GONE);
        controlpanel.setVisibility(View.GONE);
        openen.setImageDrawable(getResources().getDrawable(R.drawable.open));
        //autohide.setChecked(hideauto);


        controlpanel.setBackgroundColor(getResources().getColor(R.color.blur));

        /*autohide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hideauto = isChecked;
            }
        });*/

        sluiten.setTypeface(font);
        sluiten.setTextColor(getResources().getColor(R.color.red));
        //texthide.setTypeface(font);
        hide();
        setControlpanelImages();
        ControlPanel.StartControlPanel();
        ShowWagon.Startup(this);
        Show1.Startup(this);
        Show2.Startup(this);
        BaronSound.StartBaronSound();
        MainActivity.r.wagonShow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                ControlPanel.trainonstation = true;
            }
        });
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-2811980712617298/4420175769");

        AdView mAdView = (AdView) findViewById(R.id.ad);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }
    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        rol.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
    public void onClick(View v) {
        if(iscphide) {
            controlpanel.startAnimation(animShow);
            controlpanel.setVisibility(View.VISIBLE);
            openen.startAnimation(animHide);
            openen.setVisibility(View.GONE);
            iscphide = false;
        } else {
            controlpanel.startAnimation(animHide);
            controlpanel.setVisibility(View.GONE);
            openen.startAnimation(animShow);
            openen.setVisibility(View.VISIBLE);
            iscphide = true;
        }
    }

    public void setControlpanelImages() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;

        Bitmap stoplichtg = BitmapFactory.decodeResource(getResources(), R.drawable.groen, options);
        Bitmap stoplichtr = BitmapFactory.decodeResource(getResources(), R.drawable.rood, options);

        stoplicht1.setImageBitmap(stoplichtg);
        stoplicht2.setImageBitmap(stoplichtg);
        stoplicht3.setImageBitmap(stoplichtg);
        stoplicht4.setImageBitmap(stoplichtg);
        stoplicht5.setImageBitmap(stoplichtr);

        Bitmap textdeuren = BitmapFactory.decodeResource(getResources(), R.drawable.deureningang, options);
        tekst1.setImageBitmap(textdeuren);
        Bitmap textbeugels = BitmapFactory.decodeResource(getResources(), R.drawable.beugels, options);
        tekst2.setImageBitmap(textbeugels);
        Bitmap textvloer = BitmapFactory.decodeResource(getResources(), R.drawable.vloer, options);
        tekst3.setImageBitmap(textvloer);
        Bitmap textpoortjes = BitmapFactory.decodeResource(getResources(), R.drawable.poortjes, options);
        tekst4.setImageBitmap(textpoortjes);
        Bitmap textstarten = BitmapFactory.decodeResource(getResources(), R.drawable.starten, options);
        tekst5.setImageBitmap(textstarten);
        Bitmap textmeer = BitmapFactory.decodeResource(getResources(), R.drawable.meer, options);
        tekst6.setImageBitmap(textmeer);
        Bitmap textback = BitmapFactory.decodeResource(getResources(), R.drawable.terug, options);
        tekst7.setImageBitmap(textback);
        Bitmap vulshow = BitmapFactory.decodeResource(getResources(), R.drawable.vullenshow1, options);
        tekst8.setImageBitmap(vulshow);
        Bitmap overplaatsentext = BitmapFactory.decodeResource(getResources(), R.drawable.overplaatsenshow1show2, options);
        tekst9.setImageBitmap(overplaatsentext);
        Bitmap startshow1 = BitmapFactory.decodeResource(getResources(), R.drawable.startenshow1, options);
        tekst10.setImageBitmap(startshow1);
        Bitmap startshow2 = BitmapFactory.decodeResource(getResources(), R.drawable.startenshow2, options);
        tekst11.setImageBitmap(startshow2);
        Bitmap handleiding = BitmapFactory.decodeResource(getResources(), R.drawable.handleidingtext, options);
        tekst12.setImageBitmap(handleiding);

        Bitmap knopdeuren = BitmapFactory.decodeResource(getResources(), R.drawable.switchright, options);
        button1.setImageBitmap(knopdeuren);
        Bitmap knopbeugels = BitmapFactory.decodeResource(getResources(), R.drawable.switchright, options);
        button2.setImageBitmap(knopbeugels);
        Bitmap knopvloer = BitmapFactory.decodeResource(getResources(), R.drawable.switchright, options);
        button3.setImageBitmap(knopvloer);
        Bitmap knoppoortjes = BitmapFactory.decodeResource(getResources(), R.drawable.switchright, options);
        button4.setImageBitmap(knoppoortjes);
        Bitmap green = BitmapFactory.decodeResource(getResources(), R.drawable.greenoff, options);
        button5.setImageBitmap(green);
        Bitmap red = BitmapFactory.decodeResource(getResources(), R.drawable.redoff, options);
        button6.setImageBitmap(red);
        button7.setImageBitmap(red);
        button8.setImageBitmap(red);
        button9.setImageBitmap(red);
        button10.setImageBitmap(green);
        button11.setImageBitmap(green);
        Bitmap orange = BitmapFactory.decodeResource(getResources(), R.drawable.orangeon, options);
        button12.setImageBitmap(orange);
        Bitmap veen = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.trein_1, options);
        wagon.setImageBitmap(veen);

        Bitmap l = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.platforml, options);
        lschuif1.setImageBitmap(l);
        lschuif2.setImageBitmap(l);
        lschuif3.setImageBitmap(l);
        Bitmap r = BitmapFactory.decodeResource(MainActivity.r.getResources(), R.drawable.platformr, options);
        rschuif1.setImageBitmap(r);
        rschuif2.setImageBitmap(r);
        rschuif3.setImageBitmap(r);

        button1.setColorFilter(ContextCompat.getColor(this,R.color.whitetrans));
        showpanel.setVisibility(View.GONE);
        BaronSound ps = new BaronSound();
    }
    public void PlayLuiken() {
        BaronSound bs = new BaronSound();
        bs.startluiken(this);
    }
    public void PlayWegIn() {
        BaronSound bs = new BaronSound();
        bs.startweg(this);
    }
    public void onResume() {
        super.onResume();
        hide();
        try{
            if(mp1) {
                BaronSound.mp_1.start();
            }
            if(mp2) {
                BaronSound.mp_2.start();
            }
            if(mp3) {
                BaronSound.mp_3.start();
            }
            if(mp4) {
                BaronSound.mp_4.start();
            }
            if(mp5) {
                BaronSound.mp_5.start();
            }
            if(mp6) {
                BaronSound.mp_6.start();
            }
        }catch(Exception we){
            we.printStackTrace();
        }
    }
    public void onPause() {
        super.onPause();
        try{
            if (BaronSound.mp_1.isPlaying()) {
                BaronSound.mp_1.pause();
                mp1 = true;
            } else {
                mp1 = false;
            }
            if (BaronSound.mp_2.isPlaying()) {
                BaronSound.mp_2.pause();
                mp2 = true;
            } else {
                mp2 = false;
            }
            if (BaronSound.mp_3.isPlaying()) {
                BaronSound.mp_3.pause();
                mp3 = true;
            } else {
                mp3 = false;
            }
            if (BaronSound.mp_4.isPlaying()) {
                BaronSound.mp_4.pause();
                mp4 = true;
            } else {
                mp4 = false;
            }
            if (BaronSound.mp_5.isPlaying()) {
                BaronSound.mp_5.pause();
                mp5 = true;
            } else {
                mp5 = false;
            }
            if (BaronSound.mp_6.isPlaying()) {
                BaronSound.mp_6.pause();
                mp6 = true;
            } else {
                mp6 = false;
            }
        }catch(Exception we){
            we.printStackTrace();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

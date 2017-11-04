package nl.limiteddani.baron1898;

import android.content.Context;
import android.media.MediaPlayer;
/**
 * Created by daniq on 31-10-2016.
 */

public class BaronSound {
    public static MediaPlayer mp_1, mp_2, mp_3, mp_4, mp_5, mp_6;
    public static void StartBaronSound() {
        mp_1 = new MediaPlayer();
        mp_2 = new MediaPlayer();
        mp_3 = new MediaPlayer();
        mp_4 = new MediaPlayer();
        mp_5 = new MediaPlayer();
        mp_6 = new MediaPlayer();
    }
    public void startShow1(Context c) {
        mp_1 = MediaPlayer.create(c, R.raw.voorshow1);
        mp_1.start();
    }
    public void startShow2(Context c) {
        mp_2 = MediaPlayer.create(c, R.raw.voorshow2);
        mp_2.start();
    }
    public void startpreride(Context c) {
        mp_3 = MediaPlayer.create(c, R.raw.preride);
        mp_3.start();
    }
    public void startluiken(Context c) {
        mp_4 = MediaPlayer.create(c, R.raw.baron1898luiken);
        mp_4.start();
    }
    public void startweg(Context c) {
        mp_5 = MediaPlayer.create(c, R.raw.baron1898wegin);
        mp_5.start();
    }
    public void startmuziek(Context c) {
        mp_6 = MediaPlayer.create(c, R.raw.baron1898muziek);
        mp_6.start();
    }
}

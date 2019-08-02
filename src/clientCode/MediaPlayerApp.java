package clientCode;

import adapter.MediaPlayer;

public class MediaPlayerApp {
    public static void main(String[] args) {
        MediaPlayer mp = new MediaPlayer();
        mp.play("mp3","hello");
        mp.play("mp4","hello");
        mp.play("vlc","hello");

        mp.play("flv","hello");

        mp.play("mp5","hello");
    }
}

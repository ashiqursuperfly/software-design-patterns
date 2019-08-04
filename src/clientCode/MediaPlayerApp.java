package clientCode;

import adapter.MediaFile;
import adapter.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerApp {

    public static void main(String[] args) {
        MediaPlayer mp = new MediaPlayer();

        List<MediaFile> playlist = new ArrayList<>();

        playlist.add(new MediaFile("hello","mp3",2.30f,3.21f));
        playlist.add(new MediaFile("hello","flv",2.30f,3.21f));
        playlist.add(new MediaFile("hello","mp4",2.30f,3.21f));
        playlist.add(new MediaFile("hello","vlc",2.30f,3.21f));
        playlist.add(new MediaFile("hello","mp5",2.30f,3.21f));

        mp.addPlayList(0,playlist);
        mp.playPlayList(0);
        mp.addToCurrentlyPlayingPlaylist("added","mp3",2.0f,1f);
        mp.displayPlayList(playlist);
        mp.addPlayList(5, new ArrayList<>(playlist));

    }
}

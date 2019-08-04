package adapter;

import java.util.ArrayList;
import java.util.List;

/** Previously Could play only mp3. Now it can play advanced media types like : vlc,mp4,flv **/

public class MediaPlayer implements IMediaPlayer {

    private AdvancedMediaAdapter advancedMediaAdapter;
    private List<List<MediaFile>> playLists;
    private List<MediaFile> currentlyPlaying;

    public MediaPlayer() {
        playLists = new ArrayList<>();
        advancedMediaAdapter = new AdvancedMediaAdapter();
    }
    public void addToCurrentlyPlayingPlaylist(String fileName,String fileType,float duration,float size){
        currentlyPlaying.add(new MediaFile(fileName,fileType,duration,size));
    }
    public void addPlayList(float elapsed,List<MediaFile> playlist){
        float duration=0;

        if(currentlyPlaying == null){
            playLists.add(playlist);
            System.out.println("Added New Playlist");
            displayPlayList(playlist);
            return;
        }

        for (MediaFile mediaFile : currentlyPlaying) {
            duration += mediaFile.getDuration();
        }
        if(duration < elapsed) {
            playLists.add(playlist);
            System.out.println("Added New Playlist");
            displayPlayList(playlist);
            return;
        }
        try {
            throw new Exception(getClass().getName()+":"+"Cannot add new playlist,A playlist is already playing! " +
                    "If you're looking to add new files to the currently playing playlist,\n Try the addToCurrentlyPlayingPlaylist Method");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
    public void displayPlayList(List<MediaFile> playList){
        for (MediaFile m:
             playList) {
            System.out.println("--"+m.toString());
        }
    }
    public void playPlayList(int id){
        if(id>=0 && id< playLists.size()) {
            currentlyPlaying = playLists.get(id);
            for (MediaFile m :
                    currentlyPlaying) {
                play(m);
            }
        }
        else{
            try {
                throw new Exception("Invalid Id for playlist");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    public void stopCurrentlyPlayingPlaylist(){
        currentlyPlaying = null;
    }


    @Override
    public void play(MediaFile mediaFile) {
        if(mediaFile.getFileType().equalsIgnoreCase("mp3")){
            System.out.println("Playing:"+mediaFile.toString());
        }
        else {
            advancedMediaAdapter.play(mediaFile);
        }

    }
}

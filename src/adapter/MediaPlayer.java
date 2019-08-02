package adapter;


/** Previously Could play only mp3. Now it can play advanced media types like : vlc,mp4,flv **/

public class MediaPlayer implements IMediaPlayer {

    private AdvancedMediaAdapter advancedMediaAdapter;


    public MediaPlayer() {
        advancedMediaAdapter = new AdvancedMediaAdapter();
    }

    @Override
    public void play(String fileType, String fileName) {
        if(fileType.equalsIgnoreCase("mp3")){
            System.out.println("Playing"+fileName+"."+fileType);
        }
        else {
            advancedMediaAdapter.play(fileType,fileName);
        }

    }
}

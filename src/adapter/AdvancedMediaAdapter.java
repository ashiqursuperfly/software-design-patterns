package adapter;

/** Adapts between the Existing Media Player Interface and New Advanced MediaPlayer's Interface **/
class AdvancedMediaAdapter implements IMediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public AdvancedMediaAdapter() {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String fileType, String fileName) {
        advancedMediaPlayer.playAdvancedMedia(fileType,fileName);
    }

}

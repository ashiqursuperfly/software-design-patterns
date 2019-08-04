package adapter;

/** Can Play Only Advanced Media Types like : vlc,mp4,flv **/

class AdvancedMediaPlayer implements IAdvancedMediaPlayer {
    private IAdvancedMediaPlayer advancedMediaPlayer;

    private void playFlv(MediaFile mediaFile) {
        advancedMediaPlayer = new FlvPlayer();
        advancedMediaPlayer.playAdvancedMedia(mediaFile);
    }

    private void playMp4(MediaFile mediaFile) {

        advancedMediaPlayer = new Mp4Player();
        advancedMediaPlayer.playAdvancedMedia(mediaFile);
    }

    private void playVlc(MediaFile mediaFile) {
        advancedMediaPlayer = new VlcPlayer();
        advancedMediaPlayer.playAdvancedMedia(mediaFile);
    }

    @Override
    public void playAdvancedMedia(MediaFile mediaFile) {
        String fileType = mediaFile.getFileType();
        switch (fileType){
            case "flv":
                playFlv(mediaFile);break;
            case "mp4":
                playMp4(mediaFile);break;
            case "vlc":
                playVlc(mediaFile);break;
            default:
                try {
                    throw new Exception(getClass().getName()+":Unsupported FileType:"+fileType);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                break;
        }
    }
}

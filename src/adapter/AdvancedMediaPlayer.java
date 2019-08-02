package adapter;

import adapter.advancedMediaPlayers.FlvPlayer;
import adapter.advancedMediaPlayers.IAdvancedMediaPlayer;
import adapter.advancedMediaPlayers.Mp4Player;
import adapter.advancedMediaPlayers.VlcPlayer;

/** Can Play Only Advanced Media Types like : vlc,mp4,flv **/

class AdvancedMediaPlayer implements IAdvancedMediaPlayer {
    private IAdvancedMediaPlayer advancedMediaPlayer;

    private void playFlv(String fileName) {
        advancedMediaPlayer = new FlvPlayer();
        advancedMediaPlayer.playAdvancedMedia("flv",fileName);
    }

    private void playMp4(String fileName) {

        advancedMediaPlayer = new Mp4Player();
        advancedMediaPlayer.playAdvancedMedia("mp4",fileName);
    }

    private void playVlc(String fileName) {
        advancedMediaPlayer = new VlcPlayer();
        advancedMediaPlayer.playAdvancedMedia("vlc",fileName);
    }

    @Override
    public void playAdvancedMedia(String fileType,String fileName) {
        switch (fileType.toLowerCase()){
            case "flv":
                playFlv(fileName);break;
            case "mp4":
                playMp4(fileName);break;
            case "vlc":
                playVlc(fileName);break;
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

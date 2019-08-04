package adapter;

public class VlcPlayer implements IAdvancedMediaPlayer {
    @Override
    public void playAdvancedMedia(MediaFile mediaFile) {
        if(mediaFile.getFileType().equals("vlc")){
            System.out.println("Playing:"+mediaFile.toString());
        }
        else{
            try {
                throw new Exception(getClass().getName()+":Unsupported FileType:"+mediaFile.getFileType());
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

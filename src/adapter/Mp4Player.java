package adapter;

public class Mp4Player implements IAdvancedMediaPlayer {
    @Override
    public void playAdvancedMedia(MediaFile mediaFile) {

        if(mediaFile.getFileType().equals("mp4")){
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

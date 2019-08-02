package adapter.advancedMediaPlayers;

public class VlcPlayer implements IAdvancedMediaPlayer {
    @Override
    public void playAdvancedMedia(String fileType,String fileName) {
        if(fileType.equalsIgnoreCase("vlc")){
            System.out.println("Playing:"+fileName+"."+fileType);
        }
        else{
            try {
                throw new Exception(getClass().getName()+":Unsupported FileType:"+fileType);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

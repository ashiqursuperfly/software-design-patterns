package adapter.advancedMediaPlayers;

public class FlvPlayer implements IAdvancedMediaPlayer {
    @Override
    public void playAdvancedMedia(String fileType,String fileName) {
        if(fileType.equalsIgnoreCase("flv")){
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

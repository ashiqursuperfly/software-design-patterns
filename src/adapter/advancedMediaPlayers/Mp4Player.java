package adapter.advancedMediaPlayers;

public class Mp4Player implements IAdvancedMediaPlayer {
    @Override
    public void playAdvancedMedia(String fileType,String fileName) {

        if(fileType.equalsIgnoreCase("mp4")){
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

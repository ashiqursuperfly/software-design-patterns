package adapter;

public class MediaFile {
    private String fileName,fileType;
    private float duration,size;

    public MediaFile(String fileName, String fileType, float duration, float size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.duration = duration;
        this.size = size;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public float getDuration() {
        return duration;
    }

    public float getSize() {
        return size;
    }

    @Override
    public String toString() {
        return fileName+"."+fileType+" duration:"+duration+" size:"+size;
    }
}

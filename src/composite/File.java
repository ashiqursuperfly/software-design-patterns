package composite;

public class File implements FileSystemComponent{

    private int height;

    public File(String name) {
        this.name = name;
        this.type = "File";
    }

    private String name,type;
    private FileSystemComponent parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDirectory() {
        return parent.getDirectory()+"\\"+name;
    }

    @Override
    public String details() {
        return toString();
    }

    @Override
    public String list() {
        return name;
    }

    @Override
    public FileSystemComponent getParent() {
        return parent;
    }

    @Override
    public void setParent(FileSystemComponent parent) {
        this.parent = parent;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return  "Name=" + name + '\n' +
                "Type=" + type + '\n' +
                "Directory=" + getDirectory() + '\n';
    }
}

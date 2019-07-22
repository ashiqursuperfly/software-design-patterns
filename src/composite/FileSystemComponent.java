package composite;

public interface FileSystemComponent {
    String getName() ;

    String getType();

    String getDirectory();

    String details();

    String list();

    FileSystemComponent getParent();

    void setParent(FileSystemComponent parent);

    int getHeight();

    void setHeight(int height);


}

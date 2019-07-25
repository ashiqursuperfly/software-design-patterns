package composite;

public interface FileSystemComponent {
    String getName() ;

    String getType();

    String getDirectory();

    String details();

    String list();

    CompositeFileSystemComponent getParent();

    void setParent(CompositeFileSystemComponent parent);

    int getHeight();

    void setHeight(int height);


}

package composite;

import java.util.List;

public interface CompositeFileSystemComponent extends FileSystemComponent {

    int getComponentCount();

    String list();

    //TODO: possibly pkg-private
    void add(FileSystemComponent child);

}

package composite;

import java.util.List;

public interface CompositeFileSystemComponent extends FileSystemComponent {

    int getComponentCount();

    String list();

    void add(FileSystemComponent child);

}

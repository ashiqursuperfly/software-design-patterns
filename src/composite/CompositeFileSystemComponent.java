package composite;

import java.util.List;

public interface CompositeFileSystemComponent extends FileSystemComponent {

    int getComponentCount();

    String list();

    boolean add(FileSystemComponent child);

    boolean delete(FileSystemComponent child);

    String movableList();

    FileSystemComponent get(int index);
}

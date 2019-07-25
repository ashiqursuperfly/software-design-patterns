package composite;

import java.util.List;

public interface CompositeFileSystemComponent extends FileSystemComponent {

    int getComponentCount();

    boolean add(FileSystemComponent child);

    boolean delete(FileSystemComponent child);

    FileSystemComponent get(int index);

    String movableList();

    String deletableList();

    String list();
}

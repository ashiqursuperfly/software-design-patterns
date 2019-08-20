package composite;

import java.util.Objects;

public class File implements FileSystemComponent {

    private int height;
    private String name, type;
    private CompositeFileSystemComponent parent;

    public File(String name) {
        this.name = name;
        this.type = "File";
    }

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
        return parent.getDirectory() + "\\" + name;
    }

    @Override
    public String details() {
        return toString();
    }

    @Override
    public String list(int level) {
        return name + "\n";
    }

    @Override
    public CompositeFileSystemComponent getParent() {
        return parent;
    }

    @Override
    public void setParent(CompositeFileSystemComponent parent) {
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
        return "Name=" + name + '\n' +
                "Type=" + type + '\n' +
                "Directory=" + getDirectory() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return name.equals(file.name) &&
                type.equals(file.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}

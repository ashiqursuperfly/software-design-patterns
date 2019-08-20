package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Folder implements CompositeFileSystemComponent {

    private int componentCount;
    private String name, type;
    private List<FileSystemComponent> components;
    private CompositeFileSystemComponent parent; // parent can either be a folder or a drive
    private int height;

    public Folder(String name) {
        this.components = new ArrayList<>();
        this.name = name;
        this.type = "Folder";
        this.height = 0;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        for (FileSystemComponent c :
                components) {
            c.setHeight(height + 1);
        }
    }

    @Override
    public boolean add(FileSystemComponent child) {

        if (child.getType().equalsIgnoreCase("Drive")) {
            try {
                throw new Exception("Cant Create A Drive under a folder");
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        } else {
            if (components.contains(child)) {
                try {
                    throw new Exception(type + " Already Contains " + child.getName() + " " + child.getType());
                } catch (Exception e) {
                    System.out.println(e.toString());
                    return false;
                }
            }
            boolean b = components.add(child);
            if (b) {
                child.setParent(this);

                componentCount++;
                child.setHeight(getHeight() + 1);
            }
            return b;

        }
    }

    @Override
    public boolean delete(FileSystemComponent child) {
        boolean b = components.remove(child);
        if (b) componentCount--;
        return b;

    }

    @Override
    public int getComponentCount() {
        return componentCount;
    }

    @Override
    public String list(int level) {
        if(componentCount == 0){
            return "Drive Empty, Nothing to list";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n');

        for (FileSystemComponent f :
                components) {
            for (int i = 0; i <= level ; i++) {
                sb.append('\t');
            }
            sb.append("----").append(f.list(level+1));
        }
        return sb.toString() + '\n';
    }

    @Override
    public String movableList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, componentsSize = components.size(); i < componentsSize; i++) {
            FileSystemComponent f = components.get(i);
            if (!f.getType().equalsIgnoreCase("File")) {
                sb.append(i).append(".").append(f.getName()).append('\n');
            }
        }
        return sb.toString();
    }

    @Override
    public String deletableList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = components.size(); i < len; i++) {
            sb.append(i).append(".").append(components.get(i).getName()).append('\n');
        }
        return sb.toString();
    }

    @Override
    public FileSystemComponent get(int index) {
        if (index < 0 || index > components.size()) {
            try {
                throw new Exception("Invalid ID picked for Folder/Drive");
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }
        return components.get(index);
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
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDirectory() {
        return this.parent.getDirectory() + "\\" + this.getName();
    }

    @Override
    public String details() {
        return toString();
    }

    @Override
    public String toString() {
        return "Name=" + name + '\n' +
                "Type=" + type + '\n' +
                "Directory=" + getDirectory() + '\n' +
                "ComponentCount=" + componentCount + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return name.equals(folder.name) &&
                type.equals(folder.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}

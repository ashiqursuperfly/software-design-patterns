package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drive implements CompositeFileSystemComponent {

    private int componentCount;
    private String name,type;
    private List<FileSystemComponent> components;
    private FileSystemComponent parent; // parent can either be a folder or a drive


    public Drive(String name) {
        this.name = name;
        this.type = "Drive";
        components = new ArrayList<>();
    }

    @Override
    public boolean add(FileSystemComponent child){

        if(child.getType().equalsIgnoreCase("Drive")){
            try {
                throw new Exception("Cant Create A Drive under a Drive");
            } catch (Exception e) {
                return false;
            }
        }
        else{
            if(components.contains(child)){
                try {
                    throw new Exception(type + " Already Contains "+child.getName()+" "+child.getType());
                } catch (Exception e) {
                    return false;
                }
            }
            boolean b = components.add(child);
            if(b) {
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
        if(b) componentCount--;
        return b;
    }

    @Override
    public int getComponentCount() {
        return componentCount;
    }

    @Override
    public String list() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\\").append('\n');

        for (FileSystemComponent f :
                components) {
            for (int i = 0; i < f.getHeight(); i++) {
                sb.append('\t');
            }
            sb.append("----").append(f.list());
        }

        return sb.toString()+'\n';
    }
    @Override
    public String movableList(){
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
    public FileSystemComponent get(int index) {
        if(index < 0 || index > components.size()){
            try {
                throw new Exception("Invalid ID picked for Folder/Drive");
            } catch (Exception e) {
                return null;
            }
        }
        return components.get(index);
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
        return 1;
    }

    @Override
    public void setHeight(int height) {
        try {
            throw new Exception("Height of Drives always set to 1");
        } catch (Exception ignored) {
        }

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
        return name+":\\";
    }

    @Override
    public String details() {
        return toString();
    }

    @Override
    public String toString() {
        return  "Name=" + name + '\n' +
                "Type=" + type + '\n' +
                "Directory="+getDirectory()+'\n'+
                "ComponentCount=" + componentCount ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drive drive = (Drive) o;
        return name.equals(drive.name) &&
                type.equals(drive.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}

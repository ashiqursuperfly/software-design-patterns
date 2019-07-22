package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements CompositeFileSystemComponent {

    private int componentCount;
    private String name,type;
    private List<FileSystemComponent> components;
    private FileSystemComponent parent; // parent can either be a folder or a drive
    private int height;

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public Folder(String name) {
        this.components = new ArrayList<>();
        this.name = name;
        this.type = "Folder";
        this.height = 0;
    }

    @Override
    public void add(FileSystemComponent child){

        if(child.getType().equalsIgnoreCase("Drive")){
            try {
                throw new Exception("Cant Create A Drive under a folder");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            child.setParent(this);
            components.add(child);
            componentCount++;
            child.setHeight(getHeight()+1);


        }
    }

    @Override
    public int getComponentCount() {
        return componentCount;
    }

    @Override
    public String list() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n');

        for (FileSystemComponent f:
             components) {
            for (int i = 0; i < f.getHeight(); i++) {
                sb.append('\t');
            }
            sb.append("----").append(f.list()).append('\n');
        }
        return sb.toString()+'\n';
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
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDirectory() {
        return this.parent.getDirectory()+"\\"+this.getName();
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
                "ComponentCount=" + componentCount+'\n' ;
    }
}

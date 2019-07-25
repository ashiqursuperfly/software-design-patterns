package composite;

import java.util.ArrayList;
import java.util.List;

public class Root implements CompositeFileSystemComponent{

    private static Root ourInstance = new Root();
    private List<FileSystemComponent> components;
    private int componentCount;

    public static Root getInstance() {
        return ourInstance;
    }

    private Root() {
        components = new ArrayList<>();
    }

    @Override
    public int getComponentCount() {
        return componentCount;
    }

    @Override
    public String getName() {
        return "Root";
    }

    @Override
    public String getType() {
        return "Root";
    }

    @Override
    public String getDirectory() {
        return "Root\\";
    }

    @Override
    public String details() {
        return toString();
    }

    private List<FileSystemComponent> getComponents(){
        return components;
    }

    @Override
    public String list() {

        StringBuilder sb = new StringBuilder();
        sb.append("Root").append('\n');

        for (FileSystemComponent fileSystemComponent:
             components) {
            sb.append('\t').append(fileSystemComponent.list());
        }
        return sb.toString();
    }

    @Override
    public CompositeFileSystemComponent getParent() {
        try {
            throw new Exception("Parent of Root Directory is always null");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setParent(CompositeFileSystemComponent parent) {
        try {
            throw new Exception("Cant Set Parent of root Directory");
        } catch (Exception ignored) {
        }
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight(int height) {
        try {
            throw new Exception("Height of Root Directory always 0");
        } catch (Exception ignored) {

        }
    }

    @Override
    public boolean add(FileSystemComponent child) {
        if(!child.getType().equalsIgnoreCase("Drive")){
            try {
                throw new Exception("You can only add a Drive in Root!");
            } catch (Exception e) {
                return false;
            }
        }
        boolean b = components.add(child);
        if(b)componentCount++;
        return b;
    }

    @Override
    public boolean delete(FileSystemComponent child) {
        boolean b = components.remove(child);
        if(b)componentCount--;
        return b;
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
    public String deletableList(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0,len = components.size(); i < len; i++) {
            sb.append(i).append(".").append(components.get(i).getName()).append('\n');
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
    public String toString() {
        return "Name=Root\n" +"Type=Root\n"+"Directory=Root\\"+'\n'+
                "ComponentCount=" + componentCount +'\n';
    }
}

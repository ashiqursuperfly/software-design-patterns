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
    public FileSystemComponent getParent() {
        try {
            throw new Exception("Parent of Root Directory is always null");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void setParent(FileSystemComponent parent) {
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
    public void add(FileSystemComponent child) {
        components.add(child);
        componentCount++;

    }
}

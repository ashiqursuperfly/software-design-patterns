package clientCode;

import composite.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Client Code for File System  **/

public class FileSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompositeFileSystemComponent current = Root.getInstance();
        current.add(new Drive("C"));
        current = (CompositeFileSystemComponent) current.get(0); // C
        current.add(new Folder("mp3"));
        current.add(new Folder("mp4"));
        current.add(new File("fly.flv"));
        current = (CompositeFileSystemComponent) current.get(0); // mp3
        current.add(new File("rainbow.mp3"));
        current.add(new File("groove.mp3"));
        current = current.getParent();//C
        current = (CompositeFileSystemComponent) current.get(1); //mp4
        current.add(new File("Sunshine.mp4"));
        current = current.getParent();
        while (true) {
            System.out.println("1.Add Drive/Folder/File\n2.List\n" +
                    "3.Move\n4.Remove\n5.Details of Current Directory");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                return;
            }

            switch (choice) {
                case 1:
                    createComponent(current);
                    break;
                case 2:
                    //System.out.println(Root.getInstance().list());
                    System.out.println(current.list(0));
                    break;
                case 3:
                    CompositeFileSystemComponent f = move(current);
                    current = f != null ? f : current;
                    break;
                case 4:
                    delete(current);
                    break;
                case 5:
                    System.out.println(current.details());
                    break;
                default:
                    try {
                        throw new Exception("Invalid Choice");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        break;
                    }
            }
        }

    }

    private static void delete(CompositeFileSystemComponent current) {
        Scanner sc = new Scanner(System.in);
        String deletableList = current.deletableList();
        if (!deletableList.trim().equals("")) {
            System.out.println("Choose Any Of the following:");
            System.out.println(deletableList);
            System.out.println("-1.Exit");
        } else {
            System.out.println("No Available Directory / Drives");
            return;
        }

        int idx;

        try {
            idx = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            return;
        }

        if (idx == -1) {
            System.out.println("Aborted");
            return;
        }
        FileSystemComponent toBeDeleted = current.get(idx);
        if (toBeDeleted != null) {
            if (current.delete(toBeDeleted)) {
                System.out.println("Deleted to->" + toBeDeleted.getDirectory());
            } else System.out.println("Could not Delete the specified Componenet");

        } else {
            System.out.println("Could not Delete the specified Componenet");
        }

    }

    private static CompositeFileSystemComponent move(CompositeFileSystemComponent current) {

        Scanner sc = new Scanner(System.in);

        String movableList = current.movableList();
        if (!movableList.trim().equals("")) {
            System.out.println("Choose Any Folder Of the following:");
            System.out.println(movableList);
        }
        if(current.getType().equalsIgnoreCase("Folder")){
            System.out.println("-1.Move Back");
            System.out.println("-2.Exit");
        }

        int idx;


        try {
            idx = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            return null;
        }
        if (idx == -2) {
            System.out.println("Aborted");
            return null;
        } else if (idx == -1) {
            if (!current.getType().equalsIgnoreCase("Root")) {
                System.out.println("Moved to->" + current.getParent().getDirectory());
                return current.getParent();
            }
            System.out.println("Cant Go back.Inside Root Directory");
            return Root.getInstance();
        }

        if (current.get(idx) != null) {
            CompositeFileSystemComponent newCurrent = (CompositeFileSystemComponent) current.get(idx);
            System.out.println("Moved to->" + newCurrent.getDirectory());
            return newCurrent;
        } else {
            System.out.println("Could not Move to the specified Folder/Drive");
        }

        return null;
    }

    private static void createComponent(CompositeFileSystemComponent current) {
        CompositeFileSystemComponent currentComponent;
        FileSystemComponent added;
        Scanner sc = new Scanner(System.in);


        if (current.getType().equalsIgnoreCase("Folder")
                || current.getType().equalsIgnoreCase("Drive")) {
            if (current.getType().equalsIgnoreCase("Folder"))
                currentComponent = (Folder) current;
            else currentComponent = (Drive) current;

            System.out.println("1.Add A Folder 2.Add A File 3.Cancel");
            int c;
            try {
                c = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                return;
            }
            if (c == 1 || c == 2) {
                Scanner sc2 = new Scanner(System.in);
                String name;
                if (c == 1) {
                    System.out.println("Enter Folder Name");
                    name = sc2.nextLine();
                    added = new Folder(name);

                } else {
                    System.out.println("Enter File Name");
                    name = sc2.nextLine();
                    added = new File(name);
                }

                if (currentComponent.add(added)) {
                    System.out.println("Created " + name + " Successfully");
                } else {
                    System.out.println("Creating " + name + " Failed");
                }
            } else if (c == 3) System.out.println("Aborted!");
            else {
                System.out.println("Invalid Choice!");
            }

        } else if (current.getType().equalsIgnoreCase("Root")) {
            System.out.println("1.Add a Drive 2.Cancel");

            int c;
            try {
                c = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                return;
            }

            if (c == 1) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Enter Drive Name");
                String name = sc2.nextLine();

                currentComponent = Root.getInstance();

                if (currentComponent.add(new Drive(name))) {
                    System.out.println("Drive " + name + " Created Successfully");
                } else {
                    System.out.println("Drive " + name + "creation Failed");
                }
            } else if (c == 2) System.out.println("Aborted");
            else {
                System.out.println("Invalid Choice!");
            }
        }

    }
}

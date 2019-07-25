package clientCode;

import composite.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompositeFileSystemComponent current = Root.getInstance();

        while (true){
            System.out.println("1.Add Drive/Folder/File 2.List\n" +
                    "3.Move 4.Remove 5.Details of Current Directory");

            int choice;
            try {
                choice = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input");
                return;
            }

            switch (choice){
                case 1:
                    createComponent(current);
                    break;
                case 2:
                    System.out.println(Root.getInstance().list());
                    break;
                case 3:
                    CompositeFileSystemComponent f = move(current);
                    current = f!=null?f:current;
                    break;
                case 4:
                    delete(current);
                    break;
                case 5:
                    System.out.println(current.details());
                    break;
            }
        }

//        Root r = Root.getInstance();
//        Drive d1 = new Drive("Study");
//        r.add(d1);
//        Folder f11 = new Folder("Compiler");
//        d1.add(f11);
//        File fi111 = new File("DragonBook.pdf");
//        f11.add(fi111);
//        File fi112 = new File("Ct1Slide.pptx");
//        f11.add(fi112);
//        File fi113 = new File("Ct1Grades.xlsx");
//        f11.add(fi113);
//
//        Folder f12 = new Folder("S.E.");
//        d1.add(f12);
//        File fi121 = new File("GangOFour.pdf");
//        f12.add(fi121);
//        File fi122 = new File("SoftwareTesting.pptx");
//        f12.add(fi122);
//
//        Drive d2 = new Drive("Work");
//        r.add(d2);
//        File fi2 = new File("JetbrainsLicense.md");
//        d2.add(fi2);
//        Folder f = new Folder("Intellij");
//        f.add(new File("IntelliJ.exe"));
//        d2.add(f);
//        Drive d3 = new Drive("Entertainment");
//        r.add(d3);
//
//        System.out.println(r.list());
//
//        System.out.println(fi113.details());
//        System.out.println(fi111.details());
//        System.out.println(fi112.details());
//        System.out.println(f12.details());
//        System.out.println(d1.details());



    }

    private static void delete(CompositeFileSystemComponent current) {
        Scanner sc = new Scanner(System.in);
        //TODO:
        String deletableList = current.deletableList();
        if(!deletableList.trim().equals("")) {
            System.out.println("Choose Any Of the following:");
            System.out.println(deletableList);
            System.out.println("-1.Exit");
        }
        else {
            System.out.println("No Available Directory / Drives");
            return;
        }

        int idx;

        try {
            idx = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
            return;
        }

        if(idx == -1){
            System.out.println("Aborted");
            return;
        }
        FileSystemComponent toBeDeleted = current.get(idx);
        if(toBeDeleted != null){
            if(current.delete(toBeDeleted)){
                System.out.println("Deleted to->"+toBeDeleted.getDirectory());
            }
            else System.out.println("Could not Delete the specified Componenet");

        }
        else{
            System.out.println("Could not Delete the specified Componenet");
        }

    }

    private static CompositeFileSystemComponent move(CompositeFileSystemComponent current) {

        Scanner sc = new Scanner(System.in);

        String movableList = current.movableList();
        if(!movableList.trim().equals("")) {
            System.out.println("Choose Any Folder Of the following:");
            System.out.println(movableList);
            System.out.println("-1.Move Back");
            System.out.println("-2.Exit");
        }
        else {

            System.out.println("-1.Move Back");
            System.out.println("-2.Exit");
        }

        int idx;


        try {
            idx = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
            return null;
        }
        if(idx == -2){
            System.out.println("Aborted");
            return null;
        }
        else if(idx == -1){
            if(!current.getType().equalsIgnoreCase("Root")){
                System.out.println("Moved to->"+current.getParent().getDirectory());
                return current.getParent();
            }
            System.out.println("Cant Go back.Inside Root Directory");
            return Root.getInstance();
        }

        if(current.get(idx) != null){
            CompositeFileSystemComponent newCurrent = (CompositeFileSystemComponent) current.get(idx);
            System.out.println("Moved to->"+newCurrent.getDirectory());
            return newCurrent;
        }
        else{
            System.out.println("Could not Move to the specified Folder/Drive");
        }

        return null;
    }

    private static void createComponent(CompositeFileSystemComponent current) {
        CompositeFileSystemComponent currentComponent;
        FileSystemComponent added;
        Scanner sc = new Scanner(System.in);


        if(current.getType().equalsIgnoreCase("Folder")
                || current.getType().equalsIgnoreCase("Drive")){
            if(current.getType().equalsIgnoreCase("Folder"))
                currentComponent = (Folder)current;
            else currentComponent = (Drive)current;

            System.out.println("1.Add A Folder 2.Add A File 3.None");
            int c;
            try {
                c = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input");
                return;
            }
            if(c == 1 || c == 2) {
                Scanner sc2 = new Scanner(System.in);
                String name;
                if(c==1) {
                    System.out.println("Enter Folder Name");
                    name = sc2.nextLine();
                    added = new Folder(name);

                }else{
                    System.out.println("Enter File Name");
                    name = sc2.nextLine();
                    added = new File(name);
                }

                if (currentComponent.add(added)) {
                    System.out.println("Created " + name + " Successfully");
                } else {
                    System.out.println("Creating " + name + " Failed");
                }
            }
            else if(c==3) System.out.println("Aborted!");
            else{
                System.out.println("Invalid Choice!");
            }

        }
        else if(current.getType().equalsIgnoreCase("Root")){
            System.out.println("1.Add a Drive 2.None");

            int c;
            try {
               c = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input");
                return;
            }

            if(c==1){
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Enter Drive Name");
                String name = sc2.nextLine();

                currentComponent = Root.getInstance();

                if(currentComponent.add(new Drive(name))){
                    System.out.println("Drive "+name+" Created Successfully");
                }
                else {
                    System.out.println("Drive " + name + "creation Failed");
                }
            }
            else if(c==2) System.out.println("Aborted");
            else{
                System.out.println("Invalid Choice!");
            }
        }

    }
}

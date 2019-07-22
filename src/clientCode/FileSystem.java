package clientCode;

import composite.*;

import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (true){
//            FileSystemComponent current = Root.getInstance();
//            System.out.println("1.Create A Drive(mkdir) 2.List Current Directory(ls)\n" +
//                    "3.Move to Another Directory in the current Directory(cd) 4.Remove");
//
//            int x = sc.nextInt();
//            switch ()
//        }

        Root r = Root.getInstance();
        Drive d1 = new Drive("Study");
        r.add(d1);
        Folder f11 = new Folder("Compiler");
        d1.add(f11);
        File fi111 = new File("DragonBook.pdf");
        f11.add(fi111);
        File fi112 = new File("Ct1Slide.pptx");
        f11.add(fi112);
        File fi113 = new File("Ct1Grades.xlsx");
        f11.add(fi113);

        Folder f12 = new Folder("S.E.");
        d1.add(f12);
        File fi121 = new File("GangOFour.pdf");
        f12.add(fi121);
        File fi122 = new File("SoftwareTesting.pptx");
        f12.add(fi122);

        FileSystemComponent d2 = new Drive("Work");
        r.add(d2);
        FileSystemComponent d3 = new Drive("Entertainment");
        r.add(d3);

        System.out.println(r.list());

        System.out.println(fi113.details());
        System.out.println(fi111.details());
        System.out.println(fi112.details());
        System.out.println(f12.details());
        System.out.println(d1.details());



    }
}

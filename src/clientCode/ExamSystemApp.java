package clientCode;

import mediator.ExamController;
import mediator.ExamScript;
import mediator.Examiner;
import mediator.Student;

import java.util.*;

public class ExamSystemApp {

    public static void main(String[] args) {

        String examId = "CSE-305";
        List<Student> students = new ArrayList<>();
        HashMap<Student, ExamScript> examScripts = new HashMap<>();
        List<ExamScript> examScriptsList = new ArrayList<>();

        char c ='A';
        for(int i=1;i <= 5;i++){
            Student s = new Student(""+ c++ ,"CSE");
            students.add(s);
            examScriptsList.add(new ExamScript(examId,s));
        }
        Examiner examiner = new Examiner("EX","CSE");

        for (ExamScript examScript : examScriptsList) {
            examScript.setExaminer(examiner);
            examScript.setMarks(Math.abs(new Random().nextInt() % 20));
            examScripts.put(examScript.getStudent(),examScript);
        }
        examiner.sendExamScripts(examId,examScripts);

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println(students.get(i).getId()+": Apply for Re-Examine?");
            System.out.println("1.YES 2.NO");
            String choice = sc.nextLine();

            if(choice.equals("1")){
                students.get(i).applyForReExamine(examId);
            }
            else if(!choice.equals("2")){
                System.out.println("Invalid Choice");
                i--;
            }


        }





    }
}

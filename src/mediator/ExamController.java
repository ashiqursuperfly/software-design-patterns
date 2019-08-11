package mediator;

import java.util.*;

public class ExamController {

    /**
     * scripts: examId,Map<studentId,examScript>
     **/
    //private static HashMap<String, HashMap<String, ExamScript>> scripts = new HashMap<>();
    private static HashMap<String, Exam> exams = new HashMap<>();

    public static void receiveExamScriptsFromExaminer(String examId, HashMap<Student, ExamScript> scripts) {
        Exam exam = new Exam(examId);
        exam.setScripts(scripts);
        exams.put(examId,exam);

        System.out.println("Exam Controller Received Scripts for Exam: "+examId);
        System.out.println("St.ID  Marks");
        for (Map.Entry<Student, ExamScript> entry : scripts.entrySet()) {
            Student key = entry.getKey();
            ExamScript value = entry.getValue();
            System.out.println(key.getId()+"--"+value.getMarks());
        }
        scrutinizeScripts(examId);
        publishExamResults(examId);
    }

    private static void scrutinizeScripts(String examId) {
        //Scrutinize Logic

        System.out.println("Results after Exam Controller Scrutiny for Exam: "+examId);
        Map<Student,ExamScript> scripts = exams.get(examId).getScripts();
        System.out.println("St.ID  Marks");
        for (ExamScript examScript : scripts.values()) {
            if(new Random().nextBoolean()){
                float marks = examScript.getMarks();
                float corrected = marks + 2;
                examScript.setMarks(corrected);
                System.out.println(examScript.getStudent().getId()+"--"+marks+"--"+examScript.getMarks());
            }
            else{
                System.out.println(examScript.getStudent().getId()+"--"+examScript.getMarks());
            }
        }

    }

    private static void publishExamResults(String examId) {

        System.out.println("Published Results for exam: "+examId);
        Map<Student,ExamScript> scripts = exams.get(examId).getScripts();

        System.out.println("St.ID  Marks");

        for (Map.Entry<Student, ExamScript> entry : scripts.entrySet()) {
            entry.getKey().receiveResults(examId,entry.getValue().getMarks());
        }
        System.out.println("** NOTE:Students can now Apply for Re-Examine");

    }

    public static void receiveReExamineApplication(Student student, String examId) {
        System.out.println("Re-Examine Application Received from:"+student.getId());
        sendScriptForReExamine(exams.get(examId).getScripts().get(student));
    }

    private static void sendScriptForReExamine(ExamScript examScript) {
        examScript.getExaminer().receiveReExamineRequest(examScript);
    }

    public static void receiveReExaminationResults(String examinerId,String examId,ExamScript examScript){
        exams.get(examId).getScripts().put(examScript.getStudent(),examScript);
        sendReExaminationResults(examScript);
    }

    private static void sendReExaminationResults(ExamScript e) {
        e.getStudent().receiveReExamineResults(e.getExamId(),e.getMarks());
    }

}

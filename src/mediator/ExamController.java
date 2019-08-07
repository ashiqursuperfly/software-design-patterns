package mediator;

import composite.CompositeFileSystemComponent;

import java.util.HashMap;
import java.util.List;

public class ExamController {

    /**
     * scripts: examId,Map<studentId,examScript>
     **/
    private static HashMap<String, HashMap<String, ExamScript>> scripts = new HashMap<>();
    private static HashMap<String, Exam> exams = new HashMap<>();

    public static void receiveExamScriptsFromExaminer(String examId, HashMap<String, ExamScript> scripts) {
        ExamController.scripts.put(examId, scripts);
        scrutinizeScripts(examId);
    }

    private static void scrutinizeScripts(String examId) {
        publishExamResults(examId);
    }

    private static void publishExamResults(String examId) {
        //Sout marks of each script
    }

    public static void receiveReExamineApplication(String studentId, String examId) {
        sendScriptForReExamine(exams.get(examId).getExaminerId(),examId, scripts.get(examId).get(studentId));
    }

    private static void sendScriptForReExamine(String examinerId,String examId, ExamScript examScript) {

    }

    public static void receiveReExaminationResults(String examinerId,String examId,ExamScript examScript){
        scripts.get(examId).put(examScript.getStudentId(),examScript);
        sendReExaminationResults(examScript.getStudentId(),examScript);
        publishExamResults(examId); //revised results
    }

    private static void sendReExaminationResults(String studentId,ExamScript e) {

    }

}

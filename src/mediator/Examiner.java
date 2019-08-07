package mediator;

import java.util.HashMap;

public class Examiner {
    private String name,dept,id;

    public Examiner(String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.id = name.substring(0,4) +"-"+dept;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDept() {
        return dept;
    }

    public void sendExamScripts(String examId,HashMap<String,ExamScript> scripts){
        ExamController.receiveExamScriptsFromExaminer(examId,scripts);
    }

    public void sendAfterReExamine(String examId,ExamScript e){
        ExamController.receiveReExaminationResults(id,examId,e);
    }
}

package mediator;

import java.util.HashMap;

public class Examiner {

    private static int count = 0;
    private String name,dept,id;

    public Examiner(String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.id =  dept+"-"+count++;
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

    public void sendExamScripts(String examId,HashMap<Student,ExamScript> scripts){
        ExamController.receiveExamScriptsFromExaminer(examId,scripts);
    }

    public void receiveReExamineRequest(ExamScript e){
        reExamine(e);
        sendAfterReExamine(e.getExamId(),e);
    }

    private void reExamine(ExamScript e) {
        e.setMarks(e.getMarks()+2);
    }

    public void sendAfterReExamine(String examId,ExamScript e){
        ExamController.receiveReExaminationResults(id,examId,e);
    }
}

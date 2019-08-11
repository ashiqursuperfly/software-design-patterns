package mediator;

import java.util.HashMap;

public class Exam {

    private String id,examinerId;
    private HashMap<Student,ExamScript> scripts;


    public Exam(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getExaminerId() {
        return examinerId;
    }

    public void setScripts(HashMap<Student, ExamScript> scripts) {
        this.scripts = scripts;
    }

    public HashMap<Student, ExamScript> getScripts() {
        return scripts;
    }
}

package mediator;

import java.util.HashMap;

public class Exam {

    private String id,examinerId;
    private HashMap<String,ExamScript> scripts;


    public Exam(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getExaminerId() {
        return examinerId;
    }
}

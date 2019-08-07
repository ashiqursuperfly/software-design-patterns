package mediator;

public class Student {

    private String name,dept,id;

    public Student(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getId() {
        return id;
    }

    public void applyForReExamine(String examId){
        ExamController.receiveReExamineApplication(id,examId);
    }
}

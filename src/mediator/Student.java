package mediator;

public class Student {

    private static int count = 0;
    private String name,dept,id;

    public Student(String name,String dept) {
        this.name = name;
        this.dept = dept;
        this.id =  dept+"-"+count++;
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

package mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {

    private static int count = 0;
    private String name,dept,id;
    private Map<String,Float> results;

    public Student(String name,String dept) {
        this.name = name;
        this.dept = dept;
        this.id =  dept+"-"+count++;
        results = new HashMap<>();
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
        System.out.println("Re-Examine Application sent from:"+id);
        ExamController.receiveReExamineApplication(this,examId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void receiveResults(String examId, float marks) {
        results.put(examId,marks);
        System.out.println("Iam student:"+id+" and i got "+marks+" in exam:"+examId);
    }
    public void receiveReExamineResults(String examId, float marks) {
        results.put(examId,marks);
        System.out.println("Iam student:"+id+" and i got "+marks+" in exam:"+examId+" After ReExamination");
    }
}

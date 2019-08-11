package mediator;

public class ExamScript {
    private String examId;
    private float marks;
    private Student student;
    private Examiner examiner;

    public ExamScript(String examId, Student student) {
        this.examId = examId;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public float getMarks() {
        return marks;
    }

    public String getExamId() {
        return examId;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void setExaminer(Examiner examiner) {
        this.examiner = examiner;
    }

    public Examiner getExaminer() {
        return examiner;
    }
}

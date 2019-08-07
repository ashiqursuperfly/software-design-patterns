package mediator;

public class ExamScript {
    private String studentId,examId;
    private float marks;

    public ExamScript(String studentId, String examId) {
        this.studentId = studentId;
        this.examId = examId;
    }

    public String getStudentId() {
        return studentId;
    }

    public float getMarks() {
        return marks;
    }

    public String getExamId() {
        return examId;
    }
}

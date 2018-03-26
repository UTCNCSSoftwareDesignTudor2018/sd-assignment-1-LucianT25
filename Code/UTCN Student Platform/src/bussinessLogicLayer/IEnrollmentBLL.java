package bussinessLogicLayer;

public interface IEnrollmentBLL {
    String enroll(int studentId, int courseId);

    String disenroll(int studentId, int courseId);

    String putGrade(int studentId, int courseId, double grade);

    String changeGrade(int studentId, int courseId, double grade);
}

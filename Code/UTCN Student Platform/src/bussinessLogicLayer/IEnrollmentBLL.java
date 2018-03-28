package bussinessLogicLayer;

import javax.swing.table.DefaultTableModel;

public interface IEnrollmentBLL {
    String enroll(int studentId, int courseId);

    String disenroll(int studentId, int courseId);

    boolean putGrade(int studentId, int courseId, double grade);

    DefaultTableModel getStudentData(int studentId);

    DefaultTableModel getCourseData(int courseId);
}

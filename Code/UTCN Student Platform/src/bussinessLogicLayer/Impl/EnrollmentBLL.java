package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IEnrollmentBLL;
import dataAccessLayer.EnrollmentDAO;

public class EnrollmentBLL implements IEnrollmentBLL {
    public String enroll(int studentId, int courseId) {
        if(EnrollmentDAO.enroll(studentId, courseId)) {
            return "Student successfully enrolled.";
        }
        return "Enrollment failed.";
    }

    public String disenroll(int studentId, int courseId) {
        return "";
    }

    public String putGrade(int studentId, int courseId, double grade) {
        return "";
    }

    public String changeGrade(int studentId, int courseId, double grade) {
        return "";
    }
}

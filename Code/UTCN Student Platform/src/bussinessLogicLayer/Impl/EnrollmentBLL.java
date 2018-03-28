package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IEnrollmentBLL;
import dataAccessLayer.EnrollmentDAO;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EnrollmentBLL implements IEnrollmentBLL {
    @Override
    public String enroll(int studentId, int courseId) {
        if(EnrollmentDAO.enroll(studentId, courseId)) {
            return "Student successfully enrolled.";
        }
        return "Enrollment failed.";
    }

    @Override
    public String disenroll(int studentId, int courseId) {
        return "";
    }

    @Override
    public boolean putGrade(int studentId, int courseId, double grade) {
        return EnrollmentDAO.putGrade(studentId, courseId, grade);
    }

    @Override
    public DefaultTableModel getStudentData(int studentId) {
        return EnrollmentDAO.getStudentData(studentId);
    }

    @Override
    public DefaultTableModel getCourseData(int courseId) {
        return EnrollmentDAO.getCourseData(courseId);
    }
}

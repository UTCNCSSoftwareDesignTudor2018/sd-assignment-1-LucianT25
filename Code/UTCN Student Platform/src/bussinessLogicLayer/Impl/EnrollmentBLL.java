package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IEnrollmentBLL;
import dataAccessLayer.EnrollmentDAO;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

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

    public DefaultTableModel getData(int studentId) {
        return EnrollmentDAO.getData(studentId);
        /*String[][] data = new String[dataRaw.size()][4];
        for(int i = 0; i < dataRaw.size(); i++) {
            data[i] = dataRaw.get(i);
        }

        return data*/
    }
}

package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IEnrollmentBLL;
import bussinessLogicLayer.IStudentBLL;
import dataAccessLayer.StudentDAO;
import repositoryLayer.Student;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class StudentBLL implements IStudentBLL {

    @Override
    public boolean updateInfo(String name, String address, String email, Long PNC, int year, int id) {
        if(StudentDAO.updateStudent(name, address, email, PNC, year, id) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Student getStudent(int studentId) {
        return StudentDAO.getStudent(studentId);
    }

    @Override
    public void createReport(int studentId, int year) {
        PrintWriter writer = null;
        Student student = StudentDAO.getStudent(studentId);
        IEnrollmentBLL enrollmentBLL = new EnrollmentBLL();
        DefaultTableModel studentData = enrollmentBLL.getStudentData(studentId);
        try {
            writer = new PrintWriter("./reports/report-" + studentId, "UTF-8");
            writer.println("ID: "+student.getId());
            writer.println("Name: "+student.getName());
            writer.println("Address: "+student.getAddress());
            writer.println("Email: "+student.getEmail());
            writer.println("Current year: "+student.getYear());
            writer.println();
            writer.println("Activity Report for Year "+year+":");

            for(Vector<Object> row: studentData.getDataVector()) {
                if (row.elementAt(1).equals(String.valueOf(year)))
                    writer.println(row.elementAt(0)+": "+row.elementAt(2));
            }

            writer.println(studentData.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}

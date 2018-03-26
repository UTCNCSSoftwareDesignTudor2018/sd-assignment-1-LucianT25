package bussinessLogicLayer.Impl;

import bussinessLogicLayer.IStudentBLL;
import dataAccessLayer.StudentDAO;
import repositoryLayer.Student;

public class StudentBLL implements IStudentBLL {

    @Override
    public boolean updateInfo(String name, String address, String email, Long PNC, int year, int id) {
        if(StudentDAO.updateStudent(name, address, email, PNC, year, id) > 0) {
            return true;
        }
        return false;
    }

    public Student getStudent(int studentId) {
        return StudentDAO.getStudent(studentId);
    }
}

package bussinessLogicLayer;

import dataAccessLayer.StudentDAO;
import repositoryLayer.Student;

public interface IStudentBLL {
    boolean updateInfo(String name, String address, String email, Long PNC, int year, int id);

    Student getStudent(int studentId);

}

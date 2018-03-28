package bussinessLogicLayer.Impl;

import bussinessLogicLayer.ITeacherBLL;
import dataAccessLayer.TeacherDAO;
import repositoryLayer.Teacher;

import java.io.IOException;
import java.io.PrintWriter;

public class TeacherBLL implements ITeacherBLL {
    @Override
    public Teacher getTeacher(int userId) {
        return TeacherDAO.getTeacher(userId);
    }


}

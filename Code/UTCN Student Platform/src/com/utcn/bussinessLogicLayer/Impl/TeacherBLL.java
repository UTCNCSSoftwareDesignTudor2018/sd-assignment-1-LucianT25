package com.utcn.bussinessLogicLayer.Impl;

import com.utcn.bussinessLogicLayer.ITeacherBLL;
import com.utcn.dataAccessLayer.TeacherDAO;
import com.utcn.repositoryLayer.Teacher;

public class TeacherBLL implements ITeacherBLL {
    @Override
    public Teacher getTeacher(int userId) {
        return TeacherDAO.getTeacher(userId);
    }


}

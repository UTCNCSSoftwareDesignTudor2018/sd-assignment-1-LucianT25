package com.utcn.bussinessLogicLayer;

import com.utcn.repositoryLayer.Student;

public interface IStudentBLL {
    boolean updateInfo(String name, String address, String email, Long PNC, int year, int id);

    Student getStudent(int studentId);

    void createReport(int studentId, int year);
}

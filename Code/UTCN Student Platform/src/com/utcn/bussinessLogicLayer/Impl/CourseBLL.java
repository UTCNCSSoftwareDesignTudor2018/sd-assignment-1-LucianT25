package com.utcn.bussinessLogicLayer.Impl;

import com.utcn.bussinessLogicLayer.ICourseBLL;
import com.utcn.dataAccessLayer.CourseDAO;
import com.utcn.repositoryLayer.Course;

public class CourseBLL implements ICourseBLL {

    @Override
    public boolean isEligible(int studentYear, int courseId) {
        Course course = CourseDAO.getCourse(courseId);

        if(course.getYear() == studentYear)
            return true;
        return false;
    }
}

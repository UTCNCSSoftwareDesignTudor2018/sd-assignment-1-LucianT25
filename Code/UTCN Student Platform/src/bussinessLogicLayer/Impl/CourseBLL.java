package bussinessLogicLayer.Impl;

import bussinessLogicLayer.ICourseBLL;
import dataAccessLayer.CourseDAO;
import repositoryLayer.Course;

public class CourseBLL implements ICourseBLL {

    @Override
    public boolean isEligible(int studentYear, int courseId) {
        Course course = CourseDAO.getCourse(courseId);

        if(course.getYear() == studentYear)
            return true;
        return false;
    }
}

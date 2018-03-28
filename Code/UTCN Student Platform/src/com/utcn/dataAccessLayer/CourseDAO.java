package com.utcn.dataAccessLayer;

import com.utcn.repositoryLayer.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDAO {

    public static Course getCourse(int courseId) {
        Connection c;
        PreparedStatement stmt;
        Course selectedCourse = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"Course\" WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            if ( rs.next() ) {
                String  name = rs.getString("name");
                int year = rs.getInt("year");
                int credits = rs.getInt("credits");

                selectedCourse = new Course(courseId, name, year, credits);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return selectedCourse;
    }
}

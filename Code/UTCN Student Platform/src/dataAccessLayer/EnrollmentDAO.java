package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EnrollmentDAO {

    public static boolean enroll(int studentId, int courseId) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO public.\"Enrollment\"(student_id, course_id) "
                    + "VALUES ("+studentId+", '"+courseId+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        System.out.println("insert successful");
        return true;
    }

    public static boolean putGrade(int studentId, int courseId, double grade) {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "UPDATE public.\"Enrollment\" SET grade = ? WHERE student_id = ? AND course_id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setDouble(1, grade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        System.out.println("insert successful");
        return true;
    }

    public static double getGrade() {
        return 0;
    }
}

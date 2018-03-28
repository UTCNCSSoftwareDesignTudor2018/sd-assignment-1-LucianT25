package dataAccessLayer;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class EnrollmentDAO {
    /*Select public."Course".name, public."Teacher".name as "teacher", grade, year, credits from
    public."Enrollment" join public."Course" on public."Course".id = public."Enrollment".course_id
    join public."Teacher" on public."Teacher".course_id = public."Course".id
    where student_id = '21013299';*/  //query with teacher names

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

    public static DefaultTableModel getStudentData(int studentId) {
        Connection c;
        PreparedStatement stmt;
        DefaultTableModel data = new DefaultTableModel();

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT public.\"Course\".name, public.\"Course\".credits, public.\"Course\".year, grade FROM \n" +
                    "public.\"Enrollment\" JOIN public.\"Course\" ON public.\"Course\".id = public.\"Enrollment\".course_id\n" +
                    "WHERE student_id = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            data.setColumnIdentifiers(new String[]{"Course", "Year", "Grade", "Credits"});
            while ( rs.next() ) {
                Vector<Object> dataRow = new Vector<>();
                dataRow.addElement(rs.getString("name"));
                dataRow.addElement(String.valueOf(rs.getInt("year")));
                dataRow.addElement(String.valueOf(rs.getDouble("grade")));
                dataRow.addElement(String.valueOf(rs.getInt("credits")));

                data.addRow(dataRow);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return data;
    }

    public static DefaultTableModel getCourseData(int courseId) {
        Connection c;
        PreparedStatement stmt;
        DefaultTableModel data = new DefaultTableModel();

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "Select public.\"Student\".id, public.\"Student\".name, public.\"Enrollment\".grade from public.\"Student\"" +
                    " join public.\"Enrollment\" on public.\"Student\".id = public.\"Enrollment\".student_id where course_id = ?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            data.setColumnIdentifiers(new String[]{"id", "student", "Grade"});
            while ( rs.next() ) {
                Vector<Object> dataRow = new Vector<>();
                dataRow.addElement(String.valueOf(rs.getInt("id")));
                dataRow.addElement(rs.getString("name"));
                dataRow.addElement(String.valueOf(rs.getDouble("grade")));

                data.addRow(dataRow);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return data;
    }
}

package dataAccessLayer;

import repositoryLayer.Student;
import repositoryLayer.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherDAO {

    public static void addTeacher(int id, String name, String address, String email) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO public.\"Teacher\"(ID,NAME,ADDRESS,EMAIL) "
                    + "VALUES ("+id+", '"+name+"', '"+address+"', '"+email+"' );";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("insert successful");
    }

    public static Teacher getTeacher(int id) {
        Connection c;
        PreparedStatement stmt;
        Teacher selectedTeacher = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"Teacher\" WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if ( rs.next() ) {
                String  name = rs.getString("name");
                String  address = rs.getString("address");
                String email = rs.getString("email");

                selectedTeacher = new Teacher(id, name, address, email);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return selectedTeacher;
    }

    public static void updateTeacher(int id, String field, String value) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "UPDATE public.\"Teacher\" SET "+field+" = ? WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, value);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("update successful");
    }

    public static void deleteTeacher(int id) {
        Connection c;
        PreparedStatement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "DELETE FROM public.\"Teacher\" WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("delete successful");
    }

}

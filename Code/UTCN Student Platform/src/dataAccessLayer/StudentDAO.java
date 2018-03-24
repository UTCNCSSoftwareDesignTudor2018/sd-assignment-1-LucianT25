package dataAccessLayer;

import repositoryLayer.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public static void addStudent(int id, String name, String address, String email) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO public.\"Student\"(ID,NAME,ADDRESS,EMAIL) "
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

    public static Student getStudent(int id) {
        Connection c = null;
        PreparedStatement stmt = null;
        Student selectedStudent = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"Student\" WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if ( rs.next() ) {
                String  name = rs.getString("name");
                String  address = rs.getString("address");
                String email = rs.getString("email");

                selectedStudent = new Student(id, name, address, email);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return selectedStudent;
    }

    public static void updateStudent(int id, String field, String value) {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "UPDATE public.\"Student\" SET "+field+" = ? WHERE id = ?";
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

    Connection c;
    PreparedStatement stmt;

    public static void deleteStudent(int id) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "DELETE FROM public.\"Student\" WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("delete successful");
    }

}

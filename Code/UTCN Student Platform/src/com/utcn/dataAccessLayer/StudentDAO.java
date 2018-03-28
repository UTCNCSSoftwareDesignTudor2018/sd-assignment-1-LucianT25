package com.utcn.dataAccessLayer;

import com.utcn.repositoryLayer.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public static void addStudent(int id, String name, String address, String email, Long pnc) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO public.\"Student\"(ID,NAME,ADDRESS,EMAIL, PNC) "
                    + "VALUES ("+id+", '"+name+"', '"+address+"', '"+email+"', '"+pnc+"' );";
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
        Connection c;
        PreparedStatement stmt;
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
                Long pnc = rs.getLong("pnc");
                int year = rs.getInt("year");

                selectedStudent = new Student(id, name, address, email, pnc, year);
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

    public static int updateStudent(String name, String address, String email, Long pnc, int year, int id) {
        Connection c = null;
        PreparedStatement stmt = null;
        int updateCount = 0;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "UPDATE public.\"Student\" SET name = ?, address = ?, email = ?, PNC = ?, year = ? WHERE id = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, email);
            stmt.setLong(4, pnc);
            stmt.setInt(5, year);
            stmt.setInt(6, id);

            updateCount = stmt.executeUpdate();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("update successful");
        return updateCount;
    }

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

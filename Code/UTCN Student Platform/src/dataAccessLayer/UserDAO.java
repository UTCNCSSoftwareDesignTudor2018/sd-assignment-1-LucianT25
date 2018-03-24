package dataAccessLayer;

import repositoryLayer.Teacher;
import repositoryLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    public static void addUser(String username, String password) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "INSERT INTO public.\"User\"(username, password) VALUES (?, ?);";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("insert successful");
    }

    public static User getUser(String username) {
        Connection c;
        PreparedStatement stmt;
        User selectedUser = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "SELECT * FROM public.\"User\" WHERE username = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if ( rs.next() ) {
                String password = rs.getString("password");
                selectedUser = new User(username, password);
            }

            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("select successful");
        return selectedUser;
    }

    public static void updateUser(String username, String field, String value) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "UPDATE public.\"User\" SET "+field+" = ? WHERE username = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, value);
            stmt.setString(2, username);
            stmt.executeUpdate();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("update successful");
    }

    public static void deleteUser(String username) {
        Connection c;
        PreparedStatement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = SQLConnectionFactory.getConnection();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "DELETE FROM public.\"User\" WHERE username = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, username);
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

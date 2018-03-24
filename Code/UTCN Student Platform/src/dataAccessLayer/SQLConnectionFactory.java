package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnectionFactory {
    public static Connection c;
    
    public Connection getConnection() {
        if(c == null) {
            c = createConnection();
        }
        return c;
    }

    public Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/UTCN Student Platform DB",
                            "postgres", "2284");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


        System.out.println("Created database connection.");
        return c;
    }
}

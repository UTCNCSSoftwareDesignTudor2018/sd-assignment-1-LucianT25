package com.utcn.dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnectionFactory {
    public static Connection c;
    private static String connectionString = "jdbc:postgresql://localhost:5432/UTCN Student Platform DB";
    private static String user = "postgres";
    private static String password = "2284";

    public static Connection getConnection() {
        if(c == null) {
            c = createConnection();
        }
        return c;
    }

    public static Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(connectionString, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Created database connection.");
        return c;
    }
}

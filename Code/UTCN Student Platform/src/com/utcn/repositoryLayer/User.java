package com.utcn.repositoryLayer;

public class User {
    public static final String STUDENT_TYPE = "Student";
    public static final String TEACHER_TYPE = "Teacher";

    private String username;
    private String password;
    private String type;
    private int id; //same as the teacher/student id

    public User() {
    }

    public User(String username, String password, String type, int id) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

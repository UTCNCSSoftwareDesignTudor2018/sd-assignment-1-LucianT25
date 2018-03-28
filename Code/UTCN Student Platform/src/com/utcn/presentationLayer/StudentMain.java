package com.utcn.presentationLayer;

import com.utcn.bussinessLogicLayer.IEnrollmentBLL;
import com.utcn.bussinessLogicLayer.IStudentBLL;
import com.utcn.bussinessLogicLayer.Impl.EnrollmentBLL;
import com.utcn.bussinessLogicLayer.Impl.StudentBLL;
import com.utcn.repositoryLayer.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMain {
    private JTable gradesTable;
    private JButton editProfileButton;
    private JScrollPane scrollPane;
    private JButton logoutButton;
    private JPanel mainPanel;
    private JButton enrollButton;
    private JLabel nameLabel;
    private JLabel yearLabel;

    public StudentMain(int studentId) {
        IEnrollmentBLL enrollmentBLL = new EnrollmentBLL();
        IStudentBLL studentBLL = new StudentBLL();
        Student currentStudent = studentBLL.getStudent(studentId);

        nameLabel.setText(currentStudent.getName());
        yearLabel.setText("Year "+String.valueOf(currentStudent.getYear()));

        DefaultTableModel data = enrollmentBLL.getStudentData(studentId);
        gradesTable.setModel(data);

        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentEditProfile editProfile = new StudentEditProfile(studentId);
                JFrame editFrame = new JFrame("Edit profile");
                editFrame.setContentPane(editProfile.getPanel());
                editFrame.pack();
                editFrame.setVisible(true);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.getNewFrame().dispose();
                Login.getFrame().setVisible(true);
            }
        });
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentEnroll enroll = new StudentEnroll(studentId);
                JFrame enrollFrame = new JFrame("Enroll");
                enrollFrame.setContentPane(enroll.getPanel());
                enrollFrame.pack();
                enrollFrame.setVisible(true);
            }
        });
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}

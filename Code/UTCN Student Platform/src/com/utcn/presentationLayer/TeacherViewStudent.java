package com.utcn.presentationLayer;

import com.utcn.bussinessLogicLayer.IEnrollmentBLL;
import com.utcn.bussinessLogicLayer.IStudentBLL;
import com.utcn.bussinessLogicLayer.Impl.EnrollmentBLL;
import com.utcn.bussinessLogicLayer.Impl.StudentBLL;
import com.utcn.repositoryLayer.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherViewStudent {
    private JTextField idField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField pncField;
    private JTextField yearField;
    private JButton updateButton;
    private JButton reportButton;
    private JTextField gradeField;
    private JPanel mainPanel;
    private JTextField reportYearField;

    private IStudentBLL studentBLL;
    private IEnrollmentBLL enrollmentBLL;

    public TeacherViewStudent(int studentId, int courseId) {
        studentBLL = new StudentBLL();
        enrollmentBLL = new EnrollmentBLL();
        Student currentStudent = studentBLL.getStudent(studentId);

        nameField.setText(currentStudent.getName());
        addressField.setText(currentStudent.getAddress());
        emailField.setText(currentStudent.getEmail());
        pncField.setText(String.valueOf(currentStudent.getPNC()));
        idField.setText(String.valueOf(studentId));
        yearField.setText(String.valueOf(currentStudent.getYear()));


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enrollmentBLL.putGrade(studentId, courseId, Integer.valueOf(gradeField.getText()));
                    if (studentBLL.updateInfo(nameField.getText(), addressField.getText(), emailField.getText(),
                            Long.valueOf(pncField.getText()), Integer.valueOf(yearField.getText()), studentId))
                        JOptionPane.showMessageDialog(new JFrame("Success!"), "Update successful!");
                    else
                        JOptionPane.showMessageDialog(new JFrame("Oops!"), "Error updating profile.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Oops!"), "Error updating profile.");
                    ex.printStackTrace();
                }
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(reportYearField.getText().length() == 1)
                    studentBLL.createReport(studentId, Integer.valueOf(reportYearField.getText()));
            }
        });
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }
}

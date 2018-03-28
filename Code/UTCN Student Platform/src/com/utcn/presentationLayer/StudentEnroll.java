package com.utcn.presentationLayer;

import com.utcn.bussinessLogicLayer.ICourseBLL;
import com.utcn.bussinessLogicLayer.IEnrollmentBLL;
import com.utcn.bussinessLogicLayer.IStudentBLL;
import com.utcn.bussinessLogicLayer.Impl.CourseBLL;
import com.utcn.bussinessLogicLayer.Impl.EnrollmentBLL;
import com.utcn.bussinessLogicLayer.Impl.StudentBLL;
import com.utcn.repositoryLayer.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentEnroll {
    private JButton button1;
    private JPanel panel1;
    private JTextField courseIDTextField;

    IStudentBLL studentBLL;
    ICourseBLL courseBLL;
    IEnrollmentBLL enrollmentBLL;

    public StudentEnroll(int studentId) {
        studentBLL = new StudentBLL();
        courseBLL = new CourseBLL();
        enrollmentBLL = new EnrollmentBLL();
        Student currentStudent = studentBLL.getStudent(studentId);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int courseId = Integer.valueOf(courseIDTextField.getText());
                if(courseBLL.isEligible(currentStudent.getYear(), courseId)) {
                    String message = enrollmentBLL.enroll(studentId, courseId);
                    JOptionPane.showMessageDialog(new JFrame("Success!"), message);
                } else
                    JOptionPane.showMessageDialog(new JFrame("Oops!"), "Not eligible for this course!");
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}

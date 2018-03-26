package presentationLayer;

import bussinessLogicLayer.ICourseBLL;
import bussinessLogicLayer.IEnrollmentBLL;
import bussinessLogicLayer.IStudentBLL;
import bussinessLogicLayer.Impl.CourseBLL;
import bussinessLogicLayer.Impl.EnrollmentBLL;
import bussinessLogicLayer.Impl.StudentBLL;
import repositoryLayer.Student;

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
                    enrollmentBLL.enroll(studentId, courseId);
                    JOptionPane.showMessageDialog(new JFrame("Success!"), "Enrolled successfully!");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Oops!"), "Not eligible for this course!");
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }
}

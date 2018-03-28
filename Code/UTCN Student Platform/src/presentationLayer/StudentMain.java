package presentationLayer;

import bussinessLogicLayer.IEnrollmentBLL;
import bussinessLogicLayer.IStudentBLL;
import bussinessLogicLayer.Impl.EnrollmentBLL;
import bussinessLogicLayer.Impl.StudentBLL;
import repositoryLayer.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMain {
    private JPanel panel1;
    private JTable gradesTable;
    private JButton editProfileButton;
    private JScrollPane scrollPane;
    private JButton logoutButton;
    private JPanel mainPanel;
    private JButton enrollButton;
    private int studentId;

    private IEnrollmentBLL enrollmentBLL;

    DefaultTableModel data;

    public StudentMain(int studentId) {
        enrollmentBLL = new EnrollmentBLL();


        this.studentId = studentId;
        data = enrollmentBLL.getStudentData(studentId);
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

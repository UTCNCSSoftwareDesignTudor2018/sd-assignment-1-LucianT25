package presentationLayer;

import bussinessLogicLayer.IEnrollmentBLL;
import bussinessLogicLayer.ITeacherBLL;
import bussinessLogicLayer.Impl.EnrollmentBLL;
import bussinessLogicLayer.Impl.TeacherBLL;
import repositoryLayer.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class TeacherMain {
    private JPanel panel1;
    private JButton logoutButton;
    private JTable studentsTable;

    IEnrollmentBLL enrollmentBLL;
    ITeacherBLL teacherBLL;
    DefaultTableModel data;

    public TeacherMain(int userId) {
        enrollmentBLL = new EnrollmentBLL();
        teacherBLL = new TeacherBLL();
        Teacher currentTeacher = teacherBLL.getTeacher(userId);
        int courseId = currentTeacher.getCourse();
        data = enrollmentBLL.getCourseData(courseId);
        studentsTable.setModel(data);

        studentsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = studentsTable.rowAtPoint(e.getPoint());
                int column = studentsTable.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                    Vector<Vector> dataVector = data.getDataVector();
                    int studentId = Integer.valueOf((String) dataVector.elementAt(row).elementAt(0));
                    TeacherViewStudent viewStudent = new TeacherViewStudent(studentId, courseId);
                    JFrame viewFrame = new JFrame("Edit profile");
                    viewFrame.setContentPane(viewStudent.getPanel());
                    viewFrame.pack();
                    viewFrame.setVisible(true);
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.getNewFrame().dispose();
                Login.getFrame().setVisible(true);
            }
        });
    }

    public JPanel getPanel() {
        return this.panel1;
    }
}

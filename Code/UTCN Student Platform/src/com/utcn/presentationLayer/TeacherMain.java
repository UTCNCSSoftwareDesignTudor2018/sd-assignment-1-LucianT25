package com.utcn.presentationLayer;

import com.utcn.bussinessLogicLayer.IEnrollmentBLL;
import com.utcn.bussinessLogicLayer.ITeacherBLL;
import com.utcn.bussinessLogicLayer.Impl.EnrollmentBLL;
import com.utcn.bussinessLogicLayer.Impl.TeacherBLL;
import com.utcn.repositoryLayer.Teacher;

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
    private JLabel courseLabel;
    private JLabel nameLabel;

    public TeacherMain(int userId) {
        IEnrollmentBLL enrollmentBLL = new EnrollmentBLL();
        ITeacherBLL teacherBLL = new TeacherBLL();
        Teacher currentTeacher = teacherBLL.getTeacher(userId);
        int courseId = currentTeacher.getCourse().getId();
        DefaultTableModel data = enrollmentBLL.getCourseData(courseId);
        studentsTable.setModel(data);
        nameLabel.setText(currentTeacher.getName());
        courseLabel.setText("Enrollments for "+currentTeacher.getCourse().getName());
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

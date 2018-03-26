package presentationLayer;

import bussinessLogicLayer.IStudentBLL;
import bussinessLogicLayer.Impl.StudentBLL;
import repositoryLayer.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentEditProfile {
    private JTextField nameField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField pncField;
    private JTextField idField;
    private JButton submitButton;
    private JPanel mainPanel;

    private static IStudentBLL studentBLL;

    StudentEditProfile(int studentId) {
        studentBLL = new StudentBLL();
        Student currentStudent = studentBLL.getStudent(studentId);

        nameField.setText(currentStudent.getName());
        addressField.setText(currentStudent.getAddress());
        emailField.setText(currentStudent.getEmail());
        pncField.setText(String.valueOf(currentStudent.getPNC()));
        idField.setText(String.valueOf(studentId));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (studentBLL.updateInfo(nameField.getText(), addressField.getText(), emailField.getText(),
                            Long.valueOf(pncField.getText()), currentStudent.getYear(), studentId))
                        JOptionPane.showMessageDialog(new JFrame("Success!"), "Update successful!");
                    else
                        JOptionPane.showMessageDialog(new JFrame("Oops!"), "Error updating profile.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Oops!"), "Error updating profile.");
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }
}

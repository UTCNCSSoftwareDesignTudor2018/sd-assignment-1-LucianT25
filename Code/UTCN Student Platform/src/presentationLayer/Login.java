package presentationLayer;

import bussinessLogicLayer.IUserBLL;
import bussinessLogicLayer.Impl.UserBLL;
import repositoryLayer.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel loginPanel;
    private JButton loginButton;
    private JTextField usernameField;
    private JTextField passwordField;
    private JLabel userLabel;
    private JLabel passLabel;
    private JButton registerButton;
    private static JFrame newFrame;
    private static JFrame frame;

    private IUserBLL userBLL = new UserBLL();
    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                User currentUser = userBLL.login(username, password);
                if(currentUser != null) {
                    if(User.STUDENT_TYPE.equals(currentUser.getType())) {
                        StudentMain studentMain = new StudentMain(currentUser.getId());
                        Login.frame.setVisible(false);
                        newFrame = new JFrame("Student View");
                        newFrame.setContentPane(studentMain.getPanel());
                        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        newFrame.pack();
                        newFrame.setVisible(true);
                    } else if(User.TEACHER_TYPE.equals(currentUser.getType())){
                        //open teacher
                    }
                } else {
                    //popup
                }
            }
        });
    }

    public void start() {
        frame = new JFrame("Login");
        frame.setContentPane(new Login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JFrame getNewFrame() {
        return newFrame;
    }

}

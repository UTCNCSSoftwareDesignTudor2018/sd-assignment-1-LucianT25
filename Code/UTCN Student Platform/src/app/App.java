package app;

import dataAccessLayer.SQLConnectionFactory;
import dataAccessLayer.StudentDAO;
import repositoryLayer.Student;

import java.sql.SQLException;

public class App {
    public static void main(String args[]) {
        try {
            //StudentDAO.addStudent(22233344, "test name", "test address", "test@email.com");
            Student me = StudentDAO.getStudent(21013299);

            Student test = StudentDAO.getStudent(22233344);

            System.out.println(me.toString());
            System.out.println(test.toString());

            //StudentDAO.updateStudent(22233344, "name", "updated");
            StudentDAO.deleteStudent(22233344);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                SQLConnectionFactory.getConnection().close();
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
        }


        /*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileExtractorGUI gui = new FileExtractorGUI();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(gui);
                frame.pack();
                frame.setVisible(true);
            }
        });*/
    }
}

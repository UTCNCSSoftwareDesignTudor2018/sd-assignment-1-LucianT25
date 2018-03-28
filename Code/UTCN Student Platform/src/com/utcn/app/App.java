package com.utcn.app;
import com.utcn.presentationLayer.Login;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login gui = new Login();
                gui.start();
            }
        });
    }
}

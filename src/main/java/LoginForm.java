import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel panelPrincipal;
    private JTextField textUser;
    private JPasswordField passwordField;
    private JButton send;

    public LoginForm(){
        sendForm();
        send.addActionListener(e -> {
            validateLogin();
        });
    }

    private void validateLogin(){
        //read values
        var user = this.textUser.getText();
        var password = new String(this.passwordField.getPassword());
        if("root".equals(user) && "1234".equals(password))
            showMessage("Successful login, welcome!");
        else if("1234".equals(password))
            showMessage("Invalid Password");
        else
            showMessage("Invalid user");
    }
    private void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    private void sendForm(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}

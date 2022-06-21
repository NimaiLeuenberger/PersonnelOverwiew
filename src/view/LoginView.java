package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginView extends JFrame {
    private JLabel function, pw, login;
    private JComboBox functionComboBox;
    private JPasswordField pwField;
    private JPanel componentPane, loginPane, loginBtnPane;
    private boolean isAdmin = false, isPerson = false;
    private JButton loginBtn;

    public LoginView(){
        super("Login Personnel Overview");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 200));

        init();

        this.pack();
        this.setVisible(true);
    }

    private void init(){
        function = new JLabel("Function: ");
        String[] functionList = {"Person","Admin"};
        functionComboBox = new JComboBox(functionList);

        pw = new JLabel("Password: ");
        pwField = new JPasswordField();

        login = new JLabel("Login: ", JLabel.LEFT);
        loginPane = new JPanel(new BorderLayout());
        loginPane.setBorder(new EmptyBorder(30,40,40,40));
        loginPane.add(login, BorderLayout.NORTH);

        componentPane = new JPanel(new GridLayout(2,2));
        componentPane.setBorder(new LineBorder(Color.black));
        componentPane.add(function);
        componentPane.add(functionComboBox);
        componentPane.add(pw);
        componentPane.add(pwField);

        loginBtn = new JButton("login");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Validate();
            }
        });
        loginBtnPane = new JPanel(new BorderLayout());
        loginBtnPane.add(loginBtn, BorderLayout.EAST);

        loginPane.add(componentPane, BorderLayout.CENTER);
        loginPane.add(loginBtnPane, BorderLayout.SOUTH);
        this.getContentPane().add(loginPane, BorderLayout.CENTER);
    }

    private void Validate(){
        String pw = String.valueOf(pwField.getPassword());
        if (functionComboBox.getSelectedIndex() == 0){
            if (pw.equals("person")){
                isPerson = true;
                new OverView(isPerson, isAdmin);
            }
        } else if (functionComboBox.getSelectedIndex() == 1){
            if (pw.equals("admin")){
                isAdmin = true;
                new OverView(isPerson, isAdmin);
            }
        }

        System.out.println("admin: " + isAdmin);
        System.out.println("person: " + isPerson);
    }

    public static void main(String[] args) {
        LoginView lv = new LoginView();
    }
}

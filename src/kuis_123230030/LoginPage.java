/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis_123230030;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener{
    JLabel labelUsername = new JLabel("Username:");
    JLabel labelPassword = new JLabel("Password");
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();
    
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
     
    LoginPage() {
        setVisible(true);
        setSize(480,360);
        setTitle("Halaman Login");
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labelUsername.setBounds(20,60,150,30);
        usernameTextField.setBounds(160,60,280,30);
        labelPassword.setBounds(20,110,150,30);
        passwordTextField.setBounds(160,110,280,30);
        
        loginButton.setBounds(20,170,420,40);
        resetButton.setBounds(20,230,420,40);
        
        add(labelUsername);
        add(usernameTextField);
        add(labelPassword);
        add(passwordTextField);
        add(loginButton);
        add(resetButton);
        
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == loginButton) {
                String username = usernameTextField.getText();
                String password  = new String(passwordTextField.getPassword());
                if(username.equals("Reza Rasendriya Adi Putra") && password.equals("123230030")) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil");
                    new HalamanUtama(username);
                    this.dispose();
                }else {
                    JOptionPane.showMessageDialog(this, "Username dan atau password tidak valid");
                }
                
            }else if(e.getSource() == resetButton){
                usernameTextField.setText("");
                passwordTextField.setText("");
            }
               
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
            
        }
    }
    
    
    
}

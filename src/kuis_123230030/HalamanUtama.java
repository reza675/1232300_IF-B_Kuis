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
public class HalamanUtama extends JFrame implements ActionListener {
    JLabel labelJudul = new JLabel();
    JLabel labelApel = new JLabel("Apel (Rp15.000/kg):");
    JLabel labelJeruk = new JLabel("Jeruk (Rp12.000/kg):");
    JLabel labelMangga = new JLabel("Mangga (Rp20.000/kg):");
    
    JTextField apelTextField = new JTextField("0");
    JTextField jerukTextField = new JTextField("0");
    JTextField manggaTextField = new JTextField("0");
    
    String username;
    JButton beliButton = new JButton("Beli");
    JButton logoutButton = new JButton("Logout");
    

    HalamanUtama(String username){
        this.username = username;
        setVisible(true);
        setSize(480,360);
        setTitle("Halaman Utama");
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        labelJudul.setText("Selamat Datang, "+username);
        labelJudul.setBounds(20,20,300,30);
        
        labelApel.setBounds(20,70,150,30);
        labelJeruk.setBounds(20,120,150,30);
        labelMangga.setBounds(20,170,150,30);
        
        apelTextField.setBounds(190,70,180,30);
        jerukTextField.setBounds(190,120,180,30);
        manggaTextField.setBounds(190,170,180,30);
        
        beliButton.setBounds(20,220,420,40);
        logoutButton.setBounds(20,280,420,40);
        
        
        add(labelJudul);
        add(labelApel);
        add(labelJeruk);
        add(labelMangga);
        add(apelTextField);
        add(jerukTextField);
        add(manggaTextField);
        add(beliButton);
        add(logoutButton);
        beliButton.addActionListener(this);
        logoutButton.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == beliButton) {
                int apelJum = Integer.parseInt(apelTextField.getText());
                int manggaJum = Integer.parseInt(manggaTextField.getText());
                int jerukJum = Integer.parseInt(jerukTextField.getText());
                
                if(apelJum <= 0 && manggaJum <= 0 && jerukJum <= 0){
                    throw new Exception();
                }
                new HalamanPembelian(username,apelJum,jerukJum,manggaJum);
                this.dispose();
              
            }else if(e.getSource() == logoutButton) {
                new LoginPage();
                this.dispose();
            }
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Harap masukan data dengan valid","error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}

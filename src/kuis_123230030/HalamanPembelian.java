/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis_123230030;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Lab Informatika
 */
public class HalamanPembelian extends JFrame implements ActionListener{
    String username;
    int hargaApel = 15000;
    int hargaJeruk = 12000;
    int hargaMangga = 20000;
    int apelJum;
    int jerukJum;
    int manggaJum;
    
    JLabel labelApel = new JLabel();
    JLabel labelJeruk = new JLabel("Jeruk: ");
    JLabel labelMangga = new JLabel("Mangga: ");
    JLabel labelSubTotal = new JLabel();
    JLabel labelPajak = new JLabel();
    JLabel labelTotalHarga = new JLabel();
    
    JButton kembaliButton = new JButton("Kembali");
    
    
    HalamanPembelian(String username,int apelJum,int jerukJum,int manggaJum){
        this.username = username;
        this.apelJum = apelJum;
        this.jerukJum = jerukJum;
        this.manggaJum = manggaJum;
        
        int totalHargaApel = apelJum * hargaApel;
        int totalHargaJeruk = jerukJum * hargaJeruk;
        int totalHargaMangga = manggaJum * hargaMangga;
        int pajak = ((totalHargaApel + totalHargaJeruk + totalHargaMangga)*10)/100;
        int subTotalHarga = totalHargaApel + totalHargaJeruk + totalHargaMangga;
        int TotalHarga = totalHargaApel + totalHargaJeruk + totalHargaMangga + pajak;
        
        
        
        setVisible(true);
        setSize(480,360);
        setTitle("Halaman Pembelian");
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setGroupingSeparator('.');
        DecimalFormat formatRupiah = new DecimalFormat("#,###",simbol);
        
        labelApel.setText("Apel: " + apelJum + "kg x Rp" + formatRupiah.format(hargaApel) + " = Rp" + formatRupiah.format(totalHargaApel));
        labelJeruk.setText("Jeruk: " + jerukJum + "kg x Rp" + formatRupiah.format(hargaJeruk) + " = Rp" + formatRupiah.format(totalHargaJeruk));
        labelMangga.setText("Mangga: " + manggaJum + "kg x Rp" + formatRupiah.format(hargaMangga) + " = Rp"+ formatRupiah.format(totalHargaMangga));
        labelApel.setBounds(20,20,300,30);
        labelJeruk.setBounds(20,60,300,30);
        labelMangga.setBounds(20,100,300,30);
        
        labelSubTotal.setText("Subtotal: Rp "+ formatRupiah.format(subTotalHarga));
        labelSubTotal.setBounds(20,150,300,30);
        labelPajak.setText("Pajak (10%): Rp"+formatRupiah.format(pajak));
        labelPajak.setBounds(20,190,300,30);
        labelTotalHarga.setText("Total Harga: Rp"+formatRupiah.format(TotalHarga));
        labelTotalHarga.setBounds(20,230,300,30);
        
        kembaliButton.setBounds(20,270,400,40);
        
        add(labelApel);
        add(labelJeruk);
        add(labelMangga);
        add(labelSubTotal);
        add(labelPajak);
        add(labelTotalHarga);
        add(kembaliButton);
        kembaliButton.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            if (e.getSource() == kembaliButton) {
                new HalamanUtama(username);
                this.dispose();                
            }
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
    
    
    
    
}

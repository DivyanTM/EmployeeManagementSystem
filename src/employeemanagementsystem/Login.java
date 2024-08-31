package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField usernameTf,passwordTf;
    Login(){
        setTitle("LOGIN");
        setLayout(null);
        JLabel usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(40,20,100,30);
        add(usernameLabel);
        
        usernameTf=new JTextField();
        usernameTf.setBounds(150,20,150,30);
        add(usernameTf);
        
        JLabel passwordLabel=new JLabel("Username");
        passwordLabel.setBounds(40,70,100,30);
        add(passwordLabel);
        
        passwordTf=new JTextField();
        passwordTf.setBounds(150,70,150,30);
        add(passwordTf);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        Image banner;
        ImageIcon scaledIcon;
        JLabel bannerImage ;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/second.jpg")); 

        banner = imageIcon.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(banner);

        bannerImage = new JLabel(scaledIcon);
        bannerImage.setBounds(350, 0, 200, 200);
        add(bannerImage);
        
        setSize(600,300);
        setLocation(450,200);
       
        setVisible(true);
    }
    
  
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e){
       try{
           String username=usernameTf.getText();
           String password=passwordTf.getText();
           
           Conn c=new Conn();
           String query="select * from login where username = '"+username+"' and password = '"+password+"'";
           ResultSet rs= c.statement.executeQuery(query);
           if(rs.next()){
               setVisible(false);
               new Home();
           }else{
               JOptionPane.showMessageDialog(null, "invalid username or password");
               setVisible(false);
           }
       }
       catch(Exception e1){
          e1.printStackTrace();
       }
    }
}
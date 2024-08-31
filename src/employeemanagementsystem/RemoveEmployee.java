package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cEmpId;
    JButton delete,back;

    RemoveEmployee(){
        setTitle("Remove employee");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel labelEmpId=new JLabel("Employee Id");
        labelEmpId.setBounds(50,50,100,30);
//        labelEmpId.setFont(new Font("serif",Font.BOLD,25));
        add(labelEmpId);

        cEmpId=new Choice();
        cEmpId.setBounds(200,50,100,30);
        add(cEmpId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,100,100,30);
//        labelname.setFont(new Font("serif",Font.BOLD,25));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,100,100,30);
//        lblname.setFont(new Font("serif",Font.BOLD,25));
        add(lblname);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
//        labelphone.setFont(new Font("serif",Font.BOLD,25));
        add(labelphone);
        
        JLabel lblphone=new JLabel();
//        lblphone.setBounds(200,150,100,30);
        lblphone.setFont(new Font("serif",Font.BOLD,15));
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
//        labelemail.setFont(new Font("serif",Font.BOLD,25));
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,200,200,30);
//        lblemail.setFont(new Font("serif",Font.BOLD,25));
        add(lblemail);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                lblphone.setText(rs.getString("phone"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                try{
            Conn c=new Conn();
            String query="select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.statement.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                lblphone.setText(rs.getString("phone"));
            }
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
            }
        });
        
        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        Image banner;
        ImageIcon scaledIcon;
        JLabel bannerImage ;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/delete.png"));
        
       
        banner = imageIcon.getImage().getScaledInstance(600,400, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(banner);

        bannerImage = new JLabel(scaledIcon);
        bannerImage.setBounds(350, 0, 600,400);
        add(bannerImage);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Emplyee deletd successfully");
                setVisible(false);
                new Home();
            }catch(Exception exception){
                
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
}

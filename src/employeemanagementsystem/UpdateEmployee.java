package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfeducation,fnametf,tfsalary,tfaddress,tfphone,tfmail,tfdesignation,tfadhar;
    JLabel lblempid,lbladhar;
    JButton back,add;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId=empId;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
             
        
        JLabel heading=new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        fnametf=new JTextField();
        fnametf.setBounds(600,150,150,30);
        add(fnametf);
        
        JLabel labeldob=new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labelAddress=new JLabel("Address");
        labelAddress.setBounds(50,250,150,30);
        labelAddress.setFont(new Font("serif",Font.PLAIN,20));
        add(labelAddress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200,300,150,30);
        add(tfmail);
        
        JLabel labeleducation=new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        
        String courses[]={"BBA","BCA","BA","B.Com.","BSC","B.Tech.","MBA","MCA","MA","MTech","MSC","PHD"};
        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labeladharnumber=new JLabel("Adhar Number");
        labeladharnumber.setBounds(400,350,150,30);
        labeladharnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladharnumber);
        
        lbladhar=new JLabel();
        lbladhar.setBounds(600,350,150,30);
        add(lbladhar);
        
        JLabel labelempid=new JLabel("Employee Id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        lblempid=new JLabel();
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        try{
            Conn conn=new Conn();
            String query="select * from employee where empId = '"+empId+"'";
            ResultSet rs=conn.statement.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                fnametf.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfdesignation.setText(rs.getString("designation"));
                tfmail.setText(rs.getString("email"));
                lbladhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empId"));
                tfeducation.setText(rs.getString("education"));
                
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
        add=new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String fname=fnametf.getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfmail.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
            String adhar=lbladhar.getText();
            String empId=lblempid.getText();
            
            
           try{
               Conn con=new Conn();
              String query = "UPDATE employee SET " +
               "fname = '" + fname + "', " +
               "salary = '" + salary + "', " +
               "address = '" + address + "', " +
               "phone = '" + phone + "', " +
               "email = '" + email + "', " +
               "education = '" + education + "', " +
               "designation = '" + designation + "', " +
               "aadhar = '" + adhar + "' " +
               "WHERE empId = '" + empId + "';";

               con.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Details updated sucessfully");
               setVisible(false);
               new Home();
           }catch(Exception e1){
               e1.printStackTrace();
           }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
}

package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame implements ActionListener{
    JButton add,remove,view,update;
    Home(){
        setLayout(null);
        Image banner;
        ImageIcon scaledIcon;
        JLabel bannerImage ;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/home.jpg"));
         

        banner = imageIcon.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(banner);

        bannerImage = new JLabel(scaledIcon);
        bannerImage.setBounds(0,0,1120,630);
        add(bannerImage);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        bannerImage.add(heading);
        
        add=new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        add.setBackground(new Color(100, 149, 237));
        bannerImage.add(add);
        
        view=new JButton("View Employee");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        view.setBackground(new Color(100, 149, 237));
        bannerImage.add(view);
        
        update=new JButton("Update Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        update.setBackground(new Color(100, 149, 237));
        bannerImage.add(update);
        
        remove=new JButton("Remove Employee");
        remove.setBounds(820,140,150,40);
        remove.setBackground(new Color(100, 149, 237));
        remove.addActionListener(this);
        bannerImage.add(remove);
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Home();
    }
    
    @Override
    public void actionPerformed(ActionEvent e1){
        if(e1.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(e1.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }else if(e1.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
}

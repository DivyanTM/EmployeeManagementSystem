package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash() {
        setTitle("Employee Management System");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", SwingConstants.CENTER); 
        heading.setBounds(0, 0, 1170, 100); // Full width of JFrame
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.WHITE);
        heading.setBackground(Color.BLACK); 
        heading.setOpaque(true);
        add(heading);

        // BANNER Image
        Image banner;
        ImageIcon scaledIcon;
        JLabel bannerImage ;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/banner.jpg"));
        
        int width = 1280; 
        int height = imageIcon.getIconHeight() * width / imageIcon.getIconWidth(); 

        banner = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(banner);

        bannerImage = new JLabel(scaledIcon);
        bannerImage.setBounds(0, 0, width, height);
        add(bannerImage);
        
        
        JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(430,520,320,60);
        clickhere.setBackground(Color.BLACK);
        clickhere.setFont(new Font("serif",Font.BOLD,15));
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        bannerImage.add(clickhere);
        
        setSize(1170, 700); 
        setLocation(200, 50);
        setVisible(true);
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}


package employeemanagementsystem;

import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;
    static final String DB_USERNAME="root";
    static final String DB_PASSWORD="13071977@edm";
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo",DB_USERNAME,DB_PASSWORD);
            statement=connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

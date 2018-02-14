import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mydb {
    public Connection con;
    public Connection getCon(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","6363");
    }
    catch (ClassNotFoundException | SQLException e) {
    }

return con;

    }
}
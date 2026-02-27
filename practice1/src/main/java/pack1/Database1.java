package pack1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Database1 {

    public static void main(String[] args) throws IOException, SQLException {
        Properties prop = new Properties();

        // 1. Get the stream (Ensure the filename matches: application.properties vs liquibase.properties)
        InputStream file = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("application.properties");

        if (file != null) {
            // 2. THIS IS THE MISSING STEP: Load the stream into the properties object
            prop.load(file);

            // 3. Now you can access the keys
            System.out.println(prop.getProperty("db.user"));
            String url = prop.getProperty("db.url");
            String user= prop.getProperty("db.user");
            String pass= prop.getProperty("db.password");

            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps =con.prepareStatement("select uname from table4 where urole='admin'");
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("uname"));
            }

        } else {
            System.out.println("Resource not found!");
        }
    }

}

package pack1;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestClass1 {

    public static Properties props;



    public static void m1() throws IOException, SQLException, LiquibaseException {
        props = new Properties();
        props.load(TestClass1.class.getClassLoader()
                .getResourceAsStream("application.properties"));

        try (
                Connection con = DriverManager.getConnection(
                        props.getProperty("db.url"),
                        props.getProperty("db.user"),
                        props.getProperty("db.password"))) {

            // 3. Initialize Liquibase
            String changelogPath = props.getProperty("liquibase.changelog");
            Liquibase liquibase = new Liquibase(
                    changelogPath,
                    new ClassLoaderResourceAccessor(),
                    new JdbcConnection(con)
            );
            liquibase.update(props.getProperty("liquibase.contexts"));
            System.out.println("Liquibase migrations completed successfully.");
        }
    }

    public void main (String[]args) throws SQLException, IOException, LiquibaseException {
        TestClass1.m1();
    }

}

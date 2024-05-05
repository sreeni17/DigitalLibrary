package sreeni.digitallibrary.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

  @Value("${mysql-host}")
  String host;
  @Value("${mysql-username}")
  String username;
  @Value("${mysql-password}")
  String password;

  @Bean("mysqlDbConnection")
  public Connection mySqlConnection() {
    System.out.println("im called from configuration");
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:mysql://"+host+"/library", username, password);
    } catch (SQLException e) {
      System.out.println("Exception here"+e.getMessage());
    }
    return connection;
  }
}

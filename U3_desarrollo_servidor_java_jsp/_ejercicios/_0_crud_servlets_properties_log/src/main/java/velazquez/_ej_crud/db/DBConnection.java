package velazquez._ej_crud.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

import static org.apache.logging.log4j.Level.*;

public class DBConnection {
  static final Logger logger = LoggerFactory.getLogger(DBConnection.class);
  private static Connection con = null;
  private static String host = null;
  private static String port = null;
  private static String db = null;
  private static String user = null;
  private static String password = null;

  //  private static String url =
  //      "jdbc:mariadb://localhost:3336/classicmodels?user=root&password=XXXXX";

  public static Connection getConnection() {
    if (host == null && port == null && user == null && password == null && db == null) {
      try {
        Properties prop = new Properties();
        InputStream is = null;

        is = DBConnection.class.getClassLoader().getResourceAsStream("bd.properties");
        prop.load(is);

        for (Enumeration e = prop.keys(); e.hasMoreElements(); ) {
          String key = (String) e.nextElement();
          switch (key) {
            case "server":
              host = prop.getProperty(key);
              break;
            case "port":
              port = prop.getProperty(key);
              break;
            case "db":
              db = prop.getProperty(key);
              break;
            case "user":
              user = prop.getProperty(key);
              break;
            case "password":
              password = prop.getProperty(key);
              break;
            default:
              logger.warn("Propiedad no válida en fichero bd.properties");
          }
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      try {
        Class.forName("org.mariadb.jdbc.Driver");
        String connectionString =
            "jdbc:mariadb://"
                + host
                + ":"
                + port
                + "/"
                + db
                + "?user="
                + user
                + "&password="
                + password;
        con = DriverManager.getConnection(connectionString);
        logger.error("Probando el error");
        logger.info("Conexión realizada correctamente");
      } catch (SQLException | ClassNotFoundException e) {
        logger.error("Conexión no realizada correctamente");
        logger.error(e.getMessage());
        logger.error(Arrays.toString(e.getStackTrace()));
      }
    }
    return con;
  }

  public static void close() {
    if (con != null) {
      try {
        con.close();
        con = null;
        logger.info("Conexión con la BD cerrada correctamente");
      } catch (SQLException e) {
        logger.error("Conexión no cerrada correctamente");
      }
    }
  }
}

package velazquez._entregable_filtros.bd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import velazquez._entregable_filtros.controller.AdminInicioServlet;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class ConexionBD {

  final static Logger logger = LoggerFactory.getLogger(ConexionBD.class);
  private static Connection connection = null;
  private static String host = null;
  private static String port = null;
  private static String usuario = null;
  private static String password = null;

  public ConexionBD() {}

  public static Connection getConnection() {

    // Obtenemos los datos de la conexión del fichero de propiedades
    // Solo lo hago la primera vez (Estoy dando por supuesto que no cambio
    // de servidor de BD)
    if (host == null && port == null && usuario == null && password == null) {
      try {
        Properties prop = new Properties();
        InputStream is = null;

        is = ConexionBD.class.getClassLoader().getResourceAsStream("bd.properties");
        prop.load(is);

        for (Enumeration<Object> e = prop.keys(); e.hasMoreElements(); ) {

          String key = (String) e.nextElement();

          switch (key) {
            case "server":
              host = prop.getProperty(key);
              break;
            case "port":
              port = prop.getProperty(key);
              break;
            case "user":
              usuario = prop.getProperty(key);
              break;
            case "password":
              password = prop.getProperty(key);
              break;
          }
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

    try {
      if (connection == null || connection.isClosed()) {
        try {
          Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
          logger.error("Error al cargar el driver JDBC", e);
        }

        String connectionString =
            "jdbc:mariadb://"
                + host
                + ":"
                + port
                + "/classicmodels?user="
                + usuario
                + "&password="
                + password
                + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        connection = DriverManager.getConnection(connectionString);
      }

    } catch (SQLException ex) {
      logger.error("Error al crear la conexión", ex);
    }

    return connection;
  }

  public static void close() {

    try {
      if (connection != null) connection.close();
    } catch (SQLException e) {
        logger.error("Error al cerrar la conexión", e);
    }
  }
}

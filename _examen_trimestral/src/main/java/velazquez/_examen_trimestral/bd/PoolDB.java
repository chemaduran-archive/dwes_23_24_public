package velazquez._examen_trimestral.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolDB {

  static final Logger logger = LoggerFactory.getLogger(PoolDB.class);
  public DataSource dataSource;

  public PoolDB() {
    initDataSource();
  }

  private void initDataSource() {

    Properties properties = new Properties();
    try {
      properties.load(
          Thread.currentThread().getContextClassLoader().getResourceAsStream("bd.properties"));
    } catch (IOException e) {
      logger.error("Error al cargar el fichero de propiedades", e);
    }

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(properties.getProperty("db.classForName"));
    basicDataSource.setUsername(properties.getProperty("db.username"));
    basicDataSource.setPassword(properties.getProperty("db.password"));
    String url =
        properties.getProperty("db.url")
            + "//"
            + properties.getProperty("db.host")
            + ":"
            + properties.getProperty("db.port")
            + "/"
            + properties.getProperty("db.dbname");

    basicDataSource.setUrl(url);
    basicDataSource.setMaxTotal(Integer.parseInt(properties.getProperty("db.pool.maxTotal")));
    basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("db.pool.maxIdle")));

    dataSource = basicDataSource;
  }

  public Connection getConnection() {
    Connection result = null;
    try {
      result = dataSource.getConnection();
    } catch (SQLException e) {
      logger.error("Error al obtener la conexión", e);
    }
    logger.info("Conexión obtenida: " + result != null ? "OK" : "KO");
    return result;
  }
}

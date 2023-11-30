package velazquez._0_pooldb.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
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
          Thread.currentThread()
              .getContextClassLoader()
              .getResourceAsStream("configuration.properties"));
      logger.info("Properties loaded");
    } catch (IOException e) {
      logger.error(e.getMessage());
      logger.error(Arrays.toString(e.getStackTrace()));
    }

    logger.info("Creating data source");
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

    logger.info("Creating url: " + url);

    basicDataSource.setUrl(url);
    basicDataSource.setMaxTotal(Integer.parseInt(properties.getProperty("db.pool.maxTotal")));
    basicDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("db.pool.maxIdle")));

    dataSource = basicDataSource;
    logger.info("Data source created");
  }

  public Connection getConnection() {
    logger.info("Getting connection");
    Connection connection = null;

    try {
      connection = dataSource.getConnection();
        logger.info("Connection obtained");
    } catch (SQLException e) {
		logger.error(e.getMessage());
		logger.error(Arrays.toString(e.getStackTrace()));
    }
    return connection;
  }
}

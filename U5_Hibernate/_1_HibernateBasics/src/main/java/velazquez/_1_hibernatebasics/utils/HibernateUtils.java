package velazquez._1_hibernatebasics.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

  // Atributo de clase donde guardaremos la factoría de sesiones que me
  // proporciona las sesiones para trabajar con la BDD
  private static final SessionFactory SESSION_FACTORY;

  // Bloque estático de una clase.Se ejecuta cuando la clase se inicializ.
  // Es algo así como un "constructor de clase".
  static {
    try {

      // Generación de configuración.
      SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    } catch (final Throwable ex) {

      // Error de inicialización.
      System.err.println("[ERROR] Configuración de Hibernate - " + ex);
      throw new ExceptionInInitializerError();
    }
  }

  // Método para obtener el session factory
  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }
}

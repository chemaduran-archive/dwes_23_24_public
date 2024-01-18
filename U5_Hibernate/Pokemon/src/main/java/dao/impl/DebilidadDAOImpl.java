package dao.impl;

import dao.DebilidadDAO;
import dao.generic.GenericDAOImpl;
import models.Debilidad;
import org.hibernate.Session;

public class DebilidadDAOImpl extends GenericDAOImpl<Debilidad> implements DebilidadDAO {
    public DebilidadDAOImpl(Session session) {
        super(session);
    }
}

package velazquez._1_hibernatebasics.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import velazquez._1_hibernatebasics.manytomany.dao.OrderDAO;
import velazquez._1_hibernatebasics.manytomany.dao.OrderDAOImpl;
import velazquez._1_hibernatebasics.manytomany.model.Order;

public class OrderServiceImpl implements OrderService {

	// El servicio encapsulará el uso del DAO
	// y añadirá la lógica de negocio
	private OrderDAO orderDao;

	public OrderServiceImpl(final Session session) {

			this.orderDao = new OrderDAOImpl(session);
		}

	@Override
	public void insertNewOrder(final Order order) {

		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (order != null && order.getId() == null) {
			// Inserción del pedido
			orderDao.insert(order);
		}

	}

	@Override
	public void updateOrder(final Order order) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (order != null && order.getId() != null) {

			// Actualizo el pedido
			orderDao.update(order);
		}

	}

	@Override
	public void deleteOrder(final Order order) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (order != null && order.getId() != null) {

			// Actualizo el pedido
			orderDao.delete(order);
		}

	}

	@Override
	public Order searchById(final Long orderId) {

		Order order = null;

		if (orderId != null) {

			order = orderDao.searchById(orderId);
		}

		return order;
	}

	@Override
	public List<Order> searchAll() {

		List<Order> orderList = new ArrayList<Order>();

		orderList = orderDao.searchAll();

		return orderList;
	}

}

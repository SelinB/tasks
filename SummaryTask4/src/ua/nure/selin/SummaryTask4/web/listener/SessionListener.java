package ua.nure.selin.SummaryTask4.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.db.dao.DAOFactory;
import ua.nure.selin.SummaryTask4.db.dao.OrderItemDAO;
import ua.nure.selin.SummaryTask4.db.entity.User;
import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.DBException;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	private static Logger LOG = Logger.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		LOG.error("LISTENER " + session);
		User user = (User) session.getAttribute("user");
		if (user != null && user.getCurrentOrderId() != 0) {
			if (session.getAttribute("orderItems") == null) {
				loadToSession(session, user);
			}
		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// No operations
	}

	private static void loadToSession(HttpSession session, User user) {
		DAOFactory.setDaoFactoryFCN(DBUtil.MYSQL_DAO_FACTORY_FCN);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			OrderItemDAO orderItemDAO = daoFactory.getOrderItemDAO();
			orderItemDAO.getAllOrderItemsByOrder(user.getCurrentOrderId());
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

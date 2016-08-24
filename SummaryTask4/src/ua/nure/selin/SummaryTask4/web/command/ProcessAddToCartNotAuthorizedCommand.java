package ua.nure.selin.SummaryTask4.web.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.db.dao.DAOFactory;
//import ua.nure.selin.SummaryTask4.db.dao.OrderDAO;
//import ua.nure.selin.SummaryTask4.db.dao.OrderItemDAO;
import ua.nure.selin.SummaryTask4.db.dao.ProductDAO;
import ua.nure.selin.SummaryTask4.db.entity.Order;
import ua.nure.selin.SummaryTask4.db.entity.OrderItem;
import ua.nure.selin.SummaryTask4.db.entity.Product;
import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * @author B.Selin
 *
 */
public class ProcessAddToCartNotAuthorizedCommand extends Command {

	private static final long serialVersionUID = 9043908635678962322L;

	/**
	 * Apache Log4j logger
	 */
	private static final Logger LOG = Logger.getLogger(ProcessAddToCartNotAuthorizedCommand.class);

	@SuppressWarnings("unchecked")
	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

		LOG.debug(Messages.SUCCESS_COMMAND_STARTED + getClass().getSimpleName());

		CommandResult result = new CommandResult(Path.COMMAND_VIEW_ADD_TO_CART);
		result.setTransitionRedirect();

		HttpSession session = request.getSession();

		DAOFactory.setDaoFactoryFCN(DBUtil.MYSQL_DAO_FACTORY_FCN);
		DAOFactory daoFactory = DAOFactory.getInstance();

		String productIdAsString = request.getParameter("productId");
		String categoryName = request.getParameter("currentCategory");
		LOG.info(Messages.TRACE_REQUES_PARAMETER + productIdAsString);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + categoryName);

		if (isParamEmpty(productIdAsString)) {
			LOG.debug("ERR id null");
			// ERR
		}

		int productId = Integer.valueOf(productIdAsString);

		ProductDAO productDAO = daoFactory.getProductDAO();
		Product product = productDAO.findProductById(productId);

		if (product == null) {
			LOG.debug("ERR product null");
			// ERR
		}

		if (product.getStock() < 1) {
			// CANT BUY
		}

		// OrderDAO orderDAO = daoFactory.getOrderDAO();
		// OrderItemDAO orderItemDAO = daoFactory.getOrderItemDAO();

		Order cart = new Order();

		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		if (session.getAttribute("orderItems") != null) {
			orderItems = (List<OrderItem>) session.getAttribute("orderItems");
		}

		OrderItem newOrderItem = new OrderItem();

		newOrderItem.setProductId(productId);
		newOrderItem.setProductsCount(1); // ADD PRODUCTS COUNT SOMEHOW!!!
		newOrderItem.setPrice(product.getPrice()); // * products count!!!

		orderItems.add(newOrderItem);

		int price = 0;
		for (OrderItem item : orderItems) {
			price += item.getPrice();
		}
		cart.setTotalPrice(price);

		session.setAttribute("cart", cart);
		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + cart);
		session.setAttribute("orderItems", orderItems);
		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + orderItems);

		return result;
	}

}

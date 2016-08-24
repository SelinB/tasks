package ua.nure.selin.SummaryTask4.web.command;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.constant.Path;
//import ua.nure.selin.SummaryTask4.db.dao.DAOFactory;
//import ua.nure.selin.SummaryTask4.db.dao.OrderDAO;
//import ua.nure.selin.SummaryTask4.db.dao.OrderItemDAO;
//import ua.nure.selin.SummaryTask4.db.dao.ProductDAO;
//import ua.nure.selin.SummaryTask4.db.dao.UserDAO;
//import ua.nure.selin.SummaryTask4.db.entity.Order;
//import ua.nure.selin.SummaryTask4.db.entity.OrderItem;
//import ua.nure.selin.SummaryTask4.db.entity.Product;
//import ua.nure.selin.SummaryTask4.db.entity.User;
//import ua.nure.selin.SummaryTask4.db.status.OrderStatus;
//import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Command that processes product addition to a cart.
 * 
 * @author B.Selin
 *
 */
public class ProcessAddToCartCommand extends Command {

	private static final long serialVersionUID = -1128310099366384175L;

	/**
	 * Apache Log4j logger
	 */
	private static final Logger LOG = Logger.getLogger(ProcessAddToCartCommand.class);

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

		LOG.debug(Messages.SUCCESS_COMMAND_STARTED + getClass().getSimpleName());

		CommandResult result = new CommandResult(Path.COMMAND_ADD_TO_CART_AUTHORIZED);
		result.setTransitionForward();
		
		HttpSession session = request.getSession();

		if(session.getAttribute("user") == null){
			result.setDestinationURL(Path.COMMAND_ADD_TO_CART_NOT_AUTHORIZED);
		} 
		
		return result;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		DAOFactory.setDaoFactoryFCN(DBUtil.MYSQL_DAO_FACTORY_FCN);
//		DAOFactory daoFactory = DAOFactory.getInstance();

//		String productIdAsString = request.getParameter("productId");
//		String categoryName = request.getParameter("currentCategory");
//		LOG.info(Messages.TRACE_REQUES_PARAMETER + productIdAsString);
//		LOG.info(Messages.TRACE_REQUES_PARAMETER + categoryName);
//
//		if (isParamEmpty(productIdAsString)) {
//			LOG.debug("ERR id null");
//			// ERR
//		}
//
//		int productId = Integer.valueOf(productIdAsString);
//
//		ProductDAO productDAO = daoFactory.getProductDAO();
//		Product product = productDAO.findProductById(productId);
//
//		if (product == null) {
//			LOG.debug("ERR product null");
//			// ERR
//		}
//
//		if (product.getStock() < 1) {
//			// CANT BUY
//		}
//
//		OrderDAO orderDAO = daoFactory.getOrderDAO();
//		OrderItemDAO orderItemDAO = daoFactory.getOrderItemDAO();

//		UserDAO userDAO = daoFactory.getUserDAO();

//		User user = (User) session.getAttribute("user");

//		Order cart = new Order();

//		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		/// !!!!!!!!!!!!!
//	//	if (session.getAttribute("orderItems") != null) {
//	//		orderItems = (List<OrderItem>) session.getAttribute("orderItems");
//	//	}
		/// !!!!!!!!!!!!!
//		if (user != null) {
//			if (user.getCurrentOrderId() != 0) { // NULL?
//				cart = orderDAO.getOrderById(user.getCurrentOrderId());
//				orderItems = orderItemDAO.getAllOrderItemsByOrder(cart.getId());
//			} else {
//				cart.setUserId(user.getId());
//				// new order, usr_id = getid, order_id - ?, price = 0, user
//				// curr_order_id - ?
//				orderDAO.addOrder(cart);
//				LOG.debug("ORDER JUST USER ID" + cart);
//				cart = orderDAO.getOrderByUserStatusAndId(user.getId(), OrderStatus.PROCESSING);
//				LOG.debug("ORDER OBRAINED" + cart);
//				user.setCurrentOrderId(cart.getId());
//				userDAO.updateUser(user);
//				// cart = orderDAO.select by user_id and status
//				// user.setCurrentOrderId(cart_id);
//			}
//		}

//		OrderItem newOrderItem = new OrderItem();
//
//		newOrderItem.setProductId(productId);
//		newOrderItem.setProductsCount(1); // ADD PRODUCTS COUNT SOMEHOW!!!
//		newOrderItem.setPrice(product.getPrice()); // * products count!!!
//
//		cart.setTotalPrice(cart.getTotalPrice() + newOrderItem.getPrice());

//		if (user != null) {
//			newOrderItem.setOrderId(user.getCurrentOrderId());
//			orderItemDAO.addOrderItem(newOrderItem);
//
//			orderDAO.updateOrder(cart);
//		}

//		orderItems.add(newOrderItem);

//		session.setAttribute("cart", cart);
//		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + cart);
//		session.setAttribute("orderItems", orderItems);
//		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + orderItems);

//		return result;
	}

}

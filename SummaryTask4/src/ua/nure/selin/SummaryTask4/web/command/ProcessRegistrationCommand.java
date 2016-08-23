package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.db.dao.DAOFactory;
import ua.nure.selin.SummaryTask4.db.dao.UserDAO;
import ua.nure.selin.SummaryTask4.db.entity.User;
import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Command that processing registration operation.
 * 
 * @author B.Selin
 *
 */
public class ProcessRegistrationCommand extends Command {

	private static final long serialVersionUID = -4342207205509274697L;

	/**
	 * Apache Log4j logger
	 */
	private static final Logger LOG = Logger.getLogger(ProcessRegistrationCommand.class);

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

		LOG.debug(Messages.SUCCESS_COMMAND_STARTED + getClass().getSimpleName());

		CommandResult result = new CommandResult(Path.REGISTRATION_PAGE);
		result.setTransitionForward();

		HttpSession session = request.getSession();
		LOG.trace(Messages.TRACE_CURRENT_SESSION + session);

		DAOFactory.setDaoFactoryFCN(DBUtil.MYSQL_DAO_FACTORY_FCN);
		DAOFactory daoFactory = DAOFactory.getInstance();

		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");

		LOG.info(Messages.TRACE_REQUES_PARAMETER + login);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + email);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + password);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + firstName);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + lastName);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + phone);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + address);
		LOG.info(Messages.TRACE_REQUES_PARAMETER + gender);

		if (isParamsEmpty(login, password) || isParamsEmpty(email, firstName) || isParamEmpty(lastName)) {
			request.setAttribute("message", Messages.WARNING_EMPTY_FIELDS);
			return result;
		}

		UserDAO userDAO = daoFactory.getUserDAO();
		User user = userDAO.findUserByLogin(login);
		LOG.trace(Messages.TRACE_FOUNDED_IN_DATA_BASE + user);
		if (user != null) {
			request.setAttribute("message", Messages.WARNING_USER_ALREADY_EXISTS);
			return result;
		}

		{
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPhone(phone);
			user.setAddress(address);
			user.setGender(gender);
		}
		LOG.debug("Curren user object" + user);

		userDAO.addUser(user);
		user = userDAO.findUserByLogin(login);

		session.setAttribute("user", user);
		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + user);

		result.setDestinationURL(Path.COMMAND_VIEW_REGISTRARION);
		result.setTransitionRedirect();
		return result;
	}

}

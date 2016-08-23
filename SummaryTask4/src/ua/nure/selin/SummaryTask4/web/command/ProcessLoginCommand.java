package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.db.dao.DAOFactory;
import ua.nure.selin.SummaryTask4.db.dao.UserDAO;
import ua.nure.selin.SummaryTask4.db.entity.Role;
import ua.nure.selin.SummaryTask4.db.entity.User;
import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Command that process login operation.
 * 
 * @author B.Selin
 *
 */
public class ProcessLoginCommand extends Command {

	private static final long serialVersionUID = 1145768516376082548L;

	/**
	 * Apache Log4j logger.
	 */
	private static final Logger LOG = Logger.getLogger(ProcessLoginCommand.class);

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

		LOG.debug(Messages.SUCCESS_COMMAND_STARTED + getClass().getSimpleName());

		CommandResult result = new CommandResult(Path.LOGIN_PAGE);
		result.setTransitionForward();

		HttpSession session = request.getSession();
		LOG.trace(Messages.TRACE_CURRENT_SESSION + session);

		DAOFactory.setDaoFactoryFCN(DBUtil.MYSQL_DAO_FACTORY_FCN);
		DAOFactory daoFactory = DAOFactory.getInstance();

		String login = request.getParameter("login");
		LOG.trace(Messages.TRACE_REQUES_PARAMETER + login);
		String password = request.getParameter("password");
		LOG.trace(Messages.TRACE_REQUES_PARAMETER + password);

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			request.setAttribute("message", Messages.WARNING_EMPTY_FIELDS);
			return result;
		}

		UserDAO userDAO = daoFactory.getUserDAO();
		User user = userDAO.findUserByLogin(login);
		LOG.trace(Messages.TRACE_FOUNDED_IN_DATA_BASE + user);

		if (user == null || !password.equals(password)) {
			request.setAttribute("message", Messages.WARNING_NO_SUCH_USER);
			return result;
		}

		Role role = Role.getRole(user);
		LOG.trace(Messages.TRACE_USER_ROLE + role);

		session.setAttribute("user", user);
		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + user);
		session.setAttribute("role", role);
		LOG.trace(Messages.TRACE_ATRIBUTE_ADDED_TO_SESSION + role);

		result.setDestinationURL(Path.COMMAND_VIEW_LOGIN);
		result.setTransitionRedirect();
		return result;
	}

}

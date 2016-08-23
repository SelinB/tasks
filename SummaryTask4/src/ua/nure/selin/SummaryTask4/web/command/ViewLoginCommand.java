package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * @author B.Selin
 *
 */
public class ViewLoginCommand extends Command {

	private static final long serialVersionUID = -6086867590194386112L;

	/**
	 * Apache Log4j logger
	 */
	private static final Logger LOG = Logger.getLogger(ViewLoginCommand.class);

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {

		CommandResult result = new CommandResult();

		HttpSession session = request.getSession(false);
		LOG.trace(Messages.TRACE_CURRENT_SESSION + session);

		if ((session != null) && (session.getAttribute("user") != null)) {
			result.setDestinationURL(Path.MAIN_PAGE);
		} else {
			result.setDestinationURL(Path.LOGIN_PAGE);
		}
		result.setTransitionForward();
		return result;
	}

}

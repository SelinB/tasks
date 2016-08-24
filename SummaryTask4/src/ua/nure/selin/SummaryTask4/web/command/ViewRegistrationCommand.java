package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Displays adding a user to a database operation. Part of PRG pattern - secures
 * from forms resubmit.
 * 
 * @author B.Selin
 *
 */
public class ViewRegistrationCommand extends Command {

	private static final long serialVersionUID = -5167717223725126570L;

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
		CommandResult result = new CommandResult(Path.REGISTRATION_SUCCESS);
		result.setTransitionForward();
		return result;
	}

}

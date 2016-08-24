package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Displays login operation. Part of PRG pattern - secures from forms resubmit.
 * 
 * @author B.Selin
 *
 */
public class ViewLoginCommand extends Command {

	private static final long serialVersionUID = -6086867590194386112L;

	/**
	 * Apache Log4j logger
	 */

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
		CommandResult result = new CommandResult();
		result.setDestinationURL(Path.MAIN_PAGE);
		result.setTransitionForward();
		return result;
	}

}

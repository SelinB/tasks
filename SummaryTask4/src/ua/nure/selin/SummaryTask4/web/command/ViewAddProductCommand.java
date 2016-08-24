package ua.nure.selin.SummaryTask4.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.selin.SummaryTask4.constant.Path;
import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Displays adding a product to a database operation. Part of PRG pattern -
 * secures from forms resubmit.
 * 
 * @author B.Selin
 *
 */
public class ViewAddProductCommand extends Command {

	private static final long serialVersionUID = -986896759938106514L;

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException {
		CommandResult result = new CommandResult(Path.SHOP_PAGE);
		result.setTransitionForward();
		return result;
	}

}

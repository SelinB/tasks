package ua.nure.selin.SummaryTask4.web.command;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.selin.SummaryTask4.exception.AppException;

/**
 * Main class of the Command pattern implementation.
 * 
 * @author B.Selin
 *
 */
public abstract class Command implements Serializable {

	private static final long serialVersionUID = 7204476818217250489L;

	/**
	 * Executes command functionality.
	 * 
	 * @param request
	 *            HttpServletRequest.
	 * @param response
	 *            HttpServletResponse
	 * @return String address to forward or redirect.
	 * @throws AppException
	 */
	public abstract CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AppException;

	/**
	 * Checks if a requested string empty or not.
	 * 
	 * @param param
	 *            String representation of a parameter.
	 * @return <b>true</b> if a parameter empty, <b>false</b> if not.
	 */
	protected static boolean isParamEmpty(String param) {
		if (param == null || param.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a requested strings empty or not.
	 * 
	 * @param param1,
	 *            param2 String representation of a parameters.
	 * @return <b>true</b> if at least one of parameters empty, <b>false</b> if
	 *         they both are not empty.
	 */
	protected static boolean isParamsEmpty(String param1, String param2) {
		if (isParamEmpty(param1) || isParamEmpty(param2)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}

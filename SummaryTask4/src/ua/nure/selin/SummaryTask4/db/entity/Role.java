package ua.nure.selin.SummaryTask4.db.entity;

/**
 * Role entity.
 * 
 * @author B.Selin
 *
 */
public enum Role {
	ADMIN, CLIENT;

	/**
	 * Returns user role by his roleId.
	 * 
	 * @param user
	 * @return role
	 */
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId - 1];
	}
}

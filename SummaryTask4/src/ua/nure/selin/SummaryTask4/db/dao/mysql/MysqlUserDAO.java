package ua.nure.selin.SummaryTask4.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.nure.selin.SummaryTask4.constant.DBCommands;
import ua.nure.selin.SummaryTask4.constant.Fields;
import ua.nure.selin.SummaryTask4.constant.Messages;
import ua.nure.selin.SummaryTask4.db.dao.UserDAO;
import ua.nure.selin.SummaryTask4.db.entity.User;
import ua.nure.selin.SummaryTask4.db.status.UserStatus;
import ua.nure.selin.SummaryTask4.db.util.DBUtil;
import ua.nure.selin.SummaryTask4.exception.DBException;

/**
 * @author B.Selin
 *
 */
public class MysqlUserDAO implements UserDAO {

	private static final Logger LOG = Logger.getLogger(MysqlUserDAO.class);

	public MysqlUserDAO() {
		LOG.trace(Messages.TRACE_DAO_OBJECT_CREATED + getClass().getSimpleName());
	}

	@Override
	public User findUserByLogin(String login) throws DBException {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = con.prepareStatement(DBCommands.SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = parseUser(rs);
			}
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollBack(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, e);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, e);
		} finally {
			DBUtil.close(con, pstmt, rs);
		}
		return user;
	}

	@Override
	public boolean addUser(User user) throws DBException {
		Connection con = DBUtil.getConnection();
		;
		PreparedStatement pstmt = null;
		int counter = 1;
		boolean result = false;
		try {
			pstmt = con.prepareStatement(DBCommands.SQL_ADD_USER);
			pstmt.setString(counter++, user.getLogin());
			pstmt.setString(counter++, user.getPassword());
			pstmt.setString(counter++, user.getEmail());
			pstmt.setString(counter++, user.getFirstName());
			pstmt.setString(counter++, user.getLastName());
			pstmt.setString(counter++, user.getPhone());
			pstmt.setString(counter++, user.getAddress());
			pstmt.setString(counter++, user.getGender());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		} catch (SQLException e) {
			LOG.error(Messages.ERR_CANNOT_CREATE_USER, e);
			throw new DBException(Messages.ERR_CANNOT_CREATE_USER, e);
		} finally {
			DBUtil.close(con);
			DBUtil.close(pstmt);
		}
		return result;

	}

	@Override
	public User parseUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(Fields.ENTITY_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		user.setEmail(rs.getString(Fields.USER_EMAIL));
		user.setFirstName(rs.getString(Fields.USER_FIRST_NAME));
		user.setLastName(rs.getString(Fields.USER_LAST_NAME));
		user.setPhone(rs.getString(Fields.USER_PHONE));
		user.setAddress(rs.getString(Fields.USER_ADDRESS));
		user.setGender(rs.getString(Fields.USER_GENDER));
		user.setStatus(UserStatus.valueOf(rs.getString(Fields.USER_STATUS)));
		user.setRoleId(rs.getInt(Fields.USER_ROLE_ID));
		user.setCurrentOrderId(rs.getInt(Fields.USER_CURRENT_ORDER_ID));
		return user;
	}

}

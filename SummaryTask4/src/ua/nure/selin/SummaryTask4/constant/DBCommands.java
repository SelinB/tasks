package ua.nure.selin.SummaryTask4.constant;

/**
 * Commands for DataBase operations.
 * 
 * @author B.Selin
 *
 */
public final class DBCommands {

	// Commands for operations with 'users' table
	public static final String SQL_ADD_USER = "INSERT INTO users (login, password, email, first_name, last_name, phone, address, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";

	// Commands for operations with 'roles' table
	public static final String SQL_FIND_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";

	// Commands for operations with 'products' table
	// public static final String SQL_FIND_ALL_PRODUCTS_BY_CATEGORY
	public static final String SQL_FIND_PRODUCT_BY_CATEGORY_ID = "SELECT * FROM product WHERE category_id = ?";
	public static final String SQL_ADD_PRODUCT = "INSERT INTO products (name, price, stock, manufactoring_date, size, color, img_src, description, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_FIND_ALL_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM products WHERE category_id = ?";
	public static final String SQL_FIND_ALL_PRODUCTS = "SELECT * FROM products";
	public static final String SQL_FIND_PRODUCT_BY_NAME = "SELECT * FROM products WHERE name = ?";
	public static final String SQL_FIND_PRODUCT_BY_ID = "SELECT * FROM products WHERE id = ?";

	// Commands for operations with 'categories' table
	public static final String SQL_ADD_CATEGORY = "INSERT INTO categories (name) VALUES ?";
	public static final String SQL_FIND_CATEGORY_BY_NAME = "SELECT * FROM categories WHERE name = ?";
	public static final String SQL_FIND_CATEGORY_BY_ID = "SELECT * FROM categories WHERE id = ?";
	public static final String SQL_FIND_ALL_CATEGORIES = "SELECT * FROM categories";

}

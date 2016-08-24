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
	public static final String SQL_UPDATE_USER = "UPDATE users SET login = ?, password = ?, email = ?, first_name = ?, last_name = ?, phone = ?, address = ?, gender = ?, status = ?, current_order_id = ? WHERE id = ?";

	// Commands for operations with 'roles' table
	public static final String SQL_FIND_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";

	// Commands for operations with 'products' table
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

	// Commands for operations with 'orders' table
	public static final String SQL_UPDATE_ORDER = "UPDATE orders SET status = ?, user_id = ?, total_price = ? WHERE id = ?";
	public static final String SQL_ADD_ORDER = "INSERT INTO orders (user_id) VALUES (?)";
	public static final String SQL_FIND_ORDER_BY_STATUS_AND_USER_ID = "SELECT * FROM orders WHERE user_id = ? AND status = ?";
	public static final String SQL_FIND_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ? ";

	// Commands for operations with 'order_items' table
	public static final String SQL_ADD_ORDER_ITEM = "INSERT INTO order_items (product_id, products_count, price, order_id) VALUES (?, ?, ?, ?)";
	public static final String SQL_FIND_ALL_ORDER_ITEMS_BY_ORDER_ID = "SELECT * FROM order_items WHERE order_id = ?";

}

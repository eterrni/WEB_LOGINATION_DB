package by.epamtc.home.dao;

import by.epamtc.home.dao.impl.SQLUserDAO;

public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();
	private final UserDAO sqlUserImpl = new SQLUserDAO();
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
	public UserDAO getUserDAO() {
		return sqlUserImpl;
	}
}

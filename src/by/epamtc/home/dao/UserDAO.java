package by.epamtc.home.dao;

import by.epamtc.home.dao.exception.DAOException;

public interface UserDAO {
	void signIn(String login, String password) throws DAOException;
	void registartion(String name, String surname, String login, String password) throws DAOException;
	public boolean userPresenceInSystem(String login, String password) throws DAOException;
}

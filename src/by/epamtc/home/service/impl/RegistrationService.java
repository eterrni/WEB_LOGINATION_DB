package by.epamtc.home.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.home.dao.DAOFactory;
import by.epamtc.home.dao.UserDAO;
import by.epamtc.home.dao.exception.DAOException;
import by.epamtc.home.entity.RegistrationUser;
import by.epamtc.home.service.Service;
import by.epamtc.home.service.ServiceFactory;
import by.epamtc.home.service.exception.ServiceException;

public class RegistrationService implements Service{
	private final DAOFactory instance = DAOFactory.getInstance();
	private final UserDAO sqlUserDAO = instance.getUserDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		try {
			if(sqlUserDAO.userPresenceInSystem(login,password)) {
				try {
					request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					throw new ServiceException(e);
				}
			} else {
				sqlUserDAO.registartion(name, surname, login, password);
				RegistrationUser regUser = new RegistrationUser(name, surname, login, password);
				
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}

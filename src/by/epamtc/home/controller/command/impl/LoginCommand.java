package by.epamtc.home.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.home.controller.command.Command;
import by.epamtc.home.service.Service;
import by.epamtc.home.service.ServiceFactory;
import by.epamtc.home.service.exception.ServiceException;

public class LoginCommand implements Command {

	private final ServiceFactory factory = ServiceFactory.getInstance();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = factory.getLoginService();
		try {
			service.execute(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

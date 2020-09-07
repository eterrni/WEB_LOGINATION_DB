package by.epamtc.home.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.home.service.exception.ServiceException;

public interface Service {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}

package by.epamtc.home.service;

import by.epamtc.home.service.impl.LoginService;
import by.epamtc.home.service.impl.RegistrationService;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();
	private final LoginService loginService = new LoginService();
	private final RegistrationService registartionService = new RegistrationService();
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public LoginService getLoginService() {
		return loginService;
	}
	
	public RegistrationService getRegistrationService() {
		return registartionService;
	}
}

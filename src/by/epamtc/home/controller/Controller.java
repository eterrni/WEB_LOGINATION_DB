package by.epamtc.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epamtc.home.controller.command.Command;
import by.epamtc.home.controller.command.CommandProvider;

public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_NAME = "command";
	private CommandProvider provider = CommandProvider.getInstance();
	
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String currentCommand;
		Command command;
		
		currentCommand = request.getParameter(COMMAND_NAME);
		command = provider.getCommand(currentCommand);	
		
		command.execute(request, response);
	}
}

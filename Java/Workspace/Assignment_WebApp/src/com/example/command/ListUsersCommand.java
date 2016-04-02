package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class ListUsersCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		UserService userService = new UserService();
		String forwardToJsp = "";		

		List<User> allUsers = new ArrayList<User>();
		
		allUsers = userService.getAllUsers();
		
		if(!allUsers.isEmpty()) {
			//store the session id for the client
			HttpSession session = request.getSession();
			String clientSessionId = session.getId();
			session.setAttribute("loggedSessionId", clientSessionId);

			session.setAttribute("users", allUsers);
			
			forwardToJsp = "/users.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
	
		return forwardToJsp;
	}

}

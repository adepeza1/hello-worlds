package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBOImpl;
import com.bo.SearchBo;
import com.exception.BusinessException;
import com.to.Team;

/**
 * Servlet implementation class TeamController
 */
@WebServlet("/addTeam")
public class TeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    private SearchBo searchBo;
    private SearchBo getSearchBO() {
    	if(searchBo==null) {
    		searchBo=new SearchBOImpl();
    	}
    	return searchBo;
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		Team team = (Team) session.getAttribute("team");
		PrintWriter out = response.getWriter();
		searchBo=getSearchBO();
		try {
			searchBo.addTeam(team);
			out.println("The team " + team+ "'s has been added");
			out.print("<a href = 'addTeam.jsp'>Click to add another team</a>");
			//response.sendRedirect("addTeam.jsp");
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
	}

}

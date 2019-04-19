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
import com.to.Player;

/**
 * Servlet implementation class AddPlayerController
 */
@WebServlet("/addPlayer")
public class AddPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerController() {
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
		PrintWriter out = response.getWriter();
		Player player = (Player) session.getAttribute("player");
		System.out.println(player);
		searchBo=getSearchBO();
		try {
			System.out.println("I got here");
			searchBo.addPlayer(player);
			out.println("Player with the name " + player.getName()+ "'s has been added to the roster");
			out.print("<a href = 'AddPlayer.jsp'>Click to add another player</a>");
			out.print("<a href = 'viewPlayers.jsp'>Click to view the complete roster</a>");
			
			//response.sendRedirect("AddPlayer.jsp");
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}

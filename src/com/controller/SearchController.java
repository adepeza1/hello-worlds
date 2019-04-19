package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBOImpl;
import com.bo.SearchBo;
import com.dao.SearchDAO;
import com.exception.BusinessException;
import com.to.Player;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		int  ch = Integer.parseInt(request.getParameter("criteria"));
		try {
			searchBo=getSearchBO();
			String headers[]= {"ID", "Name", "DOB","Gender","Contact","Email","Team name"};
		switch(ch) {
		
		case 1: 
			/*System.out.println("Enter Player ID");*/
			String id =request.getParameter("searchValue");
			
				Player player1 = searchBo.getPlayerById(id);
				if(player1 != null) {
					System.out.println("Player found with id "+id);
					System.out.println("Player details "+player1);
					List<Player> playerList=new ArrayList<>();
					playerList.add(player1);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");
				}
			
			
			break;
			
		case 2:
			
			String name =request.getParameter("searchValue");	
				List<Player> playerList1 = searchBo.getPlayersbyName(name);
				if(playerList1 != null && playerList1.size()>0) {
				
					for(Player p: playerList1) {
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("playerList", playerList1);
						response.sendRedirect("results.jsp");
					}
				}
			
			
			break;
		case 3:
			String email = request.getParameter("searchValue");
			
			
				Player player2 = searchBo.getPlayerByEmail(email);
				if(player2 != null) {
					List<Player> playerList=new ArrayList<>();
					playerList.add(player2);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");
				}
			
			
			
			break;
		case 4:
			System.out.println("Enter DOB");
			String date = request.getParameter("searchValue");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
				Date d = sdf.parse(date);
				List<Player> playerList2 = searchBo.getPlayersbyDob(d);
				if(playerList2 != null && playerList2.size()>0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList2);
					response.sendRedirect("results.jsp");
					
				}
			
			
			break;
		case 5:
			System.out.println("Enter conatct for player");
			String con = request.getParameter("searchValue");
			
			
				long contact = Long.parseLong(con);
				Player player3 = searchBo.getPlayerByContact(contact);
				if(player3 != null) {
					List<Player> playerList=new ArrayList<>();
					playerList.add(player3);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");
				}
			
			break;
		case 6:
			System.out.println("Enter Gender");
			String gender = request.getParameter("searchValue");

				List<Player> playerList3 = searchBo.getPlayersbyGender(gender);
				if(playerList3 != null && playerList3.size()>0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList3);
					response.sendRedirect("results.jsp");
					}
			break;

		case 7:
			/*System.out.println("Enter Team Name");*/
			String tm =request.getParameter("teamname");
		
				List<Player> playerList = searchBo.getPlayersbyTeamName(tm);
				if(playerList != null && playerList.size()>0) {
						HttpSession session = request.getSession();
						session.setAttribute("headers", headers);
						session.setAttribute("playerList", playerList);
						response.sendRedirect("results.jsp");
					
				}

			break;
	
			
		default:
			throw new BusinessException("Invlaid Search Criteris");
			
		}
	}catch(BusinessException | ParseException e) {
		System.out.println(e);
		request.setAttribute("errorMessage", e.getMessage());
		request.getRequestDispatcher("search.jsp").include(request, response);
	}
	}

}

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
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		String id= request.getParameter("id");
		long contact = Long.parseLong(request.getParameter("contact"));
		//Player player = (Player) session.getAttribute("player");
		searchBo=getSearchBO();
		try {
			searchBo.updatePlayerContact(id,contact);
			out.println("Player with the id " + id+ "'s contact has been updated");
			out.print("<a href = 'Update.jsp'>Click to update another contact</a>");
			//response.sendRedirect("Update.jsp");
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}

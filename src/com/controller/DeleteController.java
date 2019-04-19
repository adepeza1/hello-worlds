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

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		searchBo=getSearchBO();
		try {
			System.out.println(id);
			searchBo.deletePlayer(id);
			out.println("Player with the id " + id+ "'s contact has been deleted");
			out.print("<a href = 'delete.jsp'>Click to delete another contact</a>");
			//response.sendRedirect("Update.jsp");
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}

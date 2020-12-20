package edu.tesji.sistemas.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tesji.sistemas.library.persistence.dao.UserDAO;
import edu.tesji.sistemas.library.persistence.entities.UserEntity;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(name="/LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7690912214756326308L;
	private static final Logger log = Logger.getLogger(LoginController.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("##### iniciando... info ");
		log.debug("##### iniciando... degbug");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getParameter("usuarioTXT");
		String password = request.getParameter("passwordTXT");
		request.getSession().getId();
        System.out.println("Do Post");
        

        UserDAO dao = new UserDAO();
//        List<UserEntity> userList = dao.selectUsers();
//        System.out.println(userList.get(0).toString());
        
        dao.insertUser("hector", "MEX");
        // forward
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

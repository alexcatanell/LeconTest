package com.lecon.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecon.Bean.Servico;
import com.lecon.DAOImpl.ServicoDAOImpl;

/**
 * Servlet implementation class Servicos
 */
@WebServlet("/Servicos")
public class ServicosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicoDAOImpl servicoDAO = new ServicoDAOImpl();   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicosController() {
        super();
        org.apache.log4j.BasicConfigurator.configure();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		getServicos(request);
		sc.getRequestDispatcher("/services.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		int action = Integer.parseInt(request.getParameter("action"));

		switch (action) {
		case 1:
			String name = request.getParameter("name");
			String desc= request.getParameter("desc");
			float valor = Float.parseFloat(request.getParameter("valor"));
			saveServico(new Servico(name, desc, valor));
			break;

		case 2:
			deleteServico(Integer.parseInt(request.getParameter("id")));
			break;
			
		default:
			break;
		}
		
		getServicos(request);
		sc.getRequestDispatcher("/services.jsp").forward(request, response);
	}
	
	public void getServicos(HttpServletRequest request){
		request.setAttribute("listServicos", servicoDAO.findAllServicos());
	}
	
	public void saveServico(Servico servico){
		servicoDAO.saveServico(servico);
	}
	public void deleteServico(int id){
		servicoDAO.deleteServico(id);
	}

}

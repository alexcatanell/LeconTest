package com.lecon.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lecon.Bean.Servico;
import com.lecon.DAOImpl.ServicoDAOImpl;

/**
 * Servlet implementation class ConsultaClientes
 */
@WebServlet("/ConsultaClientes")
public class ConsultaClientesWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicoDAOImpl servicoDAO = new ServicoDAOImpl();   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaClientesWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Servico> list = servicoDAO.findAllServicos();  
		String json = new Gson().toJson(list);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}

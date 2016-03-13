package com.lecon.Controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecon.Bean.Cliente;
import com.lecon.DAOImpl.ClienteDAOImpl;

/**
 * Servlet implementation class Clients
 */
@WebServlet("/Clientes")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        org.apache.log4j.BasicConfigurator.configure();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		getClientes(request);
		sc.getRequestDispatcher("/clients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		int action = Integer.parseInt(request.getParameter("action"));
		int classe = 1;
		switch (action) {
		case 1:
			String name = request.getParameter("name");
			String cpf= request.getParameter("cpf");
			String email = request.getParameter("email");
			if(request.getParameter("classe")!=null){
				classe = Integer.parseInt(request.getParameter("classe"));
			}
			saveCliente(new Cliente(name, email, cpf, classe));
			break;

		case 2:
			deleteCliente(Integer.parseInt(request.getParameter("id")));
			break;
			
		case 3:
			getServicosClientes(request, Integer.parseInt(request.getParameter("id")));
			request.setAttribute("name", request.getParameter("name"));
			sc.getRequestDispatcher("/clientes_servicos.jsp").forward(request, response);
			break;
			
		default:
			break;
		}
		
		getClientes(request);
		sc.getRequestDispatcher("/clients.jsp").forward(request, response);
	}
	
	public void getClientes(HttpServletRequest request){
		request.setAttribute("listCliente", clienteDAO.findAllCliente());
	}
	
	public void getServicosClientes(HttpServletRequest request, int id){
		request.setAttribute("listServicoCliente", clienteDAO.findServicosCliente(id));
	}
	
	public void saveCliente(Cliente cliente){
		clienteDAO.saveCliente(cliente);
	}
	
	public void deleteCliente(int id){
		clienteDAO.deleteCliente(id);
	}

}

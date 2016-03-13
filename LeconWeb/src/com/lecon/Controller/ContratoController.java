package com.lecon.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lecon.Bean.Cliente;
import com.lecon.Bean.Contrato;
import com.lecon.Bean.Servico;
import com.lecon.DAOImpl.ClienteDAOImpl;
import com.lecon.DAOImpl.ContratoDAOImpl;
import com.lecon.DAOImpl.ServicoDAOImpl;

/**
 * Servlet implementation class Contratos
 */
@WebServlet("/Contratos")
public class ContratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();   
	private ServicoDAOImpl servicoDAO = new ServicoDAOImpl();   
	private ContratoDAOImpl contratoDAO = new ContratoDAOImpl();   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContratoController() {
        super();
        org.apache.log4j.BasicConfigurator.configure();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		getServicos(request);
		getClientes(request);
		getContratos(request);
		sc.getRequestDispatcher("/contracts.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		int action = Integer.parseInt(request.getParameter("action"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date parsedDateIni = null;
		Date parsedDateFim = null;
		
		switch (action) {
		case 1:
			int idServico = Integer.parseInt(request.getParameter("servico"));
			int idCliente = Integer.parseInt(request.getParameter("cliente"));
			Cliente cli = clienteDAO.findClienteById(idCliente);
			Servico serv = servicoDAO.findServicosById(idServico);

			try {
				parsedDateIni = formatter.parse(request.getParameter("dtIni"));
				parsedDateFim = formatter.parse(request.getParameter("dtFim"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			saveContrato(new Contrato(cli,serv,parsedDateIni,parsedDateFim));
			break;

		case 2:
			deleteContrato(Integer.parseInt(request.getParameter("id")));
			break;
			
		default:
			break;
		}
		
		getServicos(request);
		getClientes(request);
		getContratos(request);		
		sc.getRequestDispatcher("/contracts.jsp").forward(request, response);
	}
	
	public void saveContrato(Contrato contrato){
		contratoDAO.saveContrato(contrato);
	}	
	public void getContratos(HttpServletRequest request){
		request.setAttribute("listContratos", contratoDAO.findAllContratos());
	}
	public void getServicos(HttpServletRequest request){
		request.setAttribute("listServicos", servicoDAO.findAllServicos());
	}
	public void getClientes(HttpServletRequest request){
		request.setAttribute("listCliente", clienteDAO.findAllCliente());
	}
	public void deleteContrato(int id){
		contratoDAO.deleteContrato(id);
	}	

}

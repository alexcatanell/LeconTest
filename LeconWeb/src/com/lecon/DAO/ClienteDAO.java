package com.lecon.DAO;

import java.util.List;

import com.lecon.Bean.Cliente;
import com.lecon.Bean.Servico;


public interface ClienteDAO {
	public void saveCliente(Cliente cliente);
	public List<Cliente> findAllCliente();
	public void deleteCliente(int id);
	public List<Servico> findServicosCliente(int id);
}

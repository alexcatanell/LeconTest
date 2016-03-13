package com.lecon.DAO;

import java.util.List;

import com.lecon.Bean.Contrato;

public interface ContratoDAO {
	public void saveContrato(Contrato cliente);
	public List<Contrato> findAllContratos();
	public void deleteContrato(int id);

}

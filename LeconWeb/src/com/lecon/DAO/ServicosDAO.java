package com.lecon.DAO;

import java.util.List;

import com.lecon.Bean.Servico;

public interface ServicosDAO {
	public void saveServico(Servico cliente);
	public List<Servico> findAllServicos();
	public void deleteServico(int id);
	public Servico findServicosById(int id);

}

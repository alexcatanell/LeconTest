package com.lecon.Bean;

import java.util.Date;


public class Contrato {

	private int id;
	private Cliente cliente;
	private Servico servico;
	private Date dtInicio;
	private Date dtFim;

	public Contrato() {
		super();
	}

	public Contrato(Cliente cliente, Servico servico, Date dtInicio, Date dtFim) {
		super();
		this.cliente = cliente;
		this.servico = servico;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

}

package com.lecon.Bean;


public class Servico {

	private int id;
	private String name;
	private String desc;
	private float valor;
	private float valorDesconto;
	private int daysLeft;
	
	public Servico() {
		super();
	}
	
	public Servico(String name, String desc, float valor) {
		this.name = name;
		this.desc = desc;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}
	
}

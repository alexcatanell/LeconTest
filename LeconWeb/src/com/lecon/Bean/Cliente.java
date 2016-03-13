package com.lecon.Bean;

public class Cliente {

	private int id;
	private String name;
	private String email;
	private String cpf;
	private int classe;
	
	public Cliente() {
		super();
	}	
	
	public Cliente(String name, String email, String cpf, int classe) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.classe = classe;
	}
	
	public Cliente(int id, String name, String email, String cpf, int classe) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.classe = classe;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
}

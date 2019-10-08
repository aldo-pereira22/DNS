package br.edu.ifg.model;

import java.io.Serializable;

public class Mensagem implements java.io.Serializable{

	private static final long serialVersionUID = 10L;
	
	private String conteudo;
	private String remetente;
	
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

package com.bancocrud.springboot.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date data;
	private String mensagem;
	private String detalhes;
	
	
	public ErrorDetails(Date data, String mensagem, String detalhes) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
		
}

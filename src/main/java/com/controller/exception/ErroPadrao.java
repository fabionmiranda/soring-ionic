package com.controller.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ErroPadrao  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String mensagem;
	private Long instanteErro;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Long getInstanteErro() {
		return instanteErro;
	}
	public void setInstanteErro(Long instanteErro) {
		this.instanteErro = instanteErro;
	}
	public ErroPadrao(int i, String mensagem, Long instanteErro) {
		super();
		this.status = i;
		this.mensagem = mensagem;
		this.instanteErro = instanteErro;
	}
	
	 
	

}

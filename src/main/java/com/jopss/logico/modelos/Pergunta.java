package com.jopss.logico.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Pergunta implements Serializable{

	private static final long serialVersionUID = 5046223523494220037L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generatorName")
	@TableGenerator(name = "generatorName", allocationSize = 1)
	private Integer id;
	private String texto;
	
	@ManyToOne
	private Resposta resposta;
	
	public Integer getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

}

package com.jopss.logico.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Resposta implements Serializable{

	private static final long serialVersionUID = -3237888243584753897L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "generatorName")
	@TableGenerator(name = "generatorName", allocationSize = 1)
	private Integer id;
	private String texto;
	
	public Integer getId() {
		return id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}

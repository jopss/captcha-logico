/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file,
 * you can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.jopss.logico.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 * Entidade para as perguntas.
 * A pergunta possui uma resposta associada.
 * 
 * @author jopss
 */
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

/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file,
 * you can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.jopss.logico.modelos;

/**
 * Utilizado dentro da excecao para indicar o erro/validacao gerada.
 * 
 * @author jopss
 */
public enum Erro {

	ERRO_001(1,"Resposta do usuario nula. Verifique a selecao."),
	ERRO_002(2,"Sessao nao iniciada. Criei primeiro uma pergunta."),
	ERRO_003(3,"Sessao nula. Verifique os parametros desta classe. Uma 'HttpSession' valida eh obrigatoria."),
	ERRO_004(4,"Invalido! Resposta do usuario diferente da pergunta na sessao."),
	ERRO_005(5,"Erro generico. Verifique a mensagem da excecao.");
	
	private Integer codigo;
	private String mensagem;
	
	private Erro(Integer codigo, String mensagem){
		this.codigo=codigo;
		this.mensagem=mensagem;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	
}

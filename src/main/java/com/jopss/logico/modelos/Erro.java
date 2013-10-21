package com.jopss.logico.modelos;

/**
 * Utilizado dentro da excecao para indicar o erro/validacao gerada.
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

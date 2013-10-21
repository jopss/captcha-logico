package com.jopss.logico.negocio;

import java.util.List;

import com.jopss.logico.modelos.Resposta;

/**
 * Classe de dados contendo o texto da pergunta e as respostas a serem exibidos em tela.
 * Esta classe ira compor a requisicao de resposta da tela. Por seguranca nao tem como saber a resposta correta somente olhando para estes dados.
 */
public class PerguntaRespostas {
	
	private String textoPergunta;
	private List<Resposta> respostas;

	public String getTextoPergunta() {
		return textoPergunta;
	}
	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}

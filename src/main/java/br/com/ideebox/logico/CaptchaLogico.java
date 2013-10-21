package br.com.ideebox.logico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ideebox.logico.exception.CaptchaLogicoException;
import br.com.ideebox.logico.negocio.ProvedorPerguntas;
import br.com.ideebox.logico.negocio.util.GerenciadorBase;

/**
 * Classe inicializadora do Captcha de Perguntas Logicas.
 */
public class CaptchaLogico {

	private CaptchaLogico(){}
	
	/**
	 * Inicializa o provedor de perguntas aleatorias.
	 * 
	 * @param session HttpSession, necessario para guardar a resposta correta a ser validada. A resposta sera encriptada.
	 * @param request HttpServletRequest necessario para receber os dados a serem exibidos no componente de tela.
	 * @return ProvedorPerguntas provedor com os metodos de acesso, validacoes e regras.
	 * @throws CaptchaLogicoException
	 */
	public static ProvedorPerguntas carregar(HttpSession session, HttpServletRequest request) throws CaptchaLogicoException{
		return new ProvedorPerguntas(session, request, new GerenciadorBase());
	}

}

/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file,
 * you can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.jopss.logico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jopss.logico.exception.CaptchaLogicoException;
import com.jopss.logico.negocio.ProvedorPerguntas;
import com.jopss.logico.negocio.util.GerenciadorBase;

/**
 * Classe inicializadora do Captcha de Perguntas Logicas.
 * 
 * @author jopss
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

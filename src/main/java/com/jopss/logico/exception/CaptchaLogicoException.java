/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. 
 * If a copy of the MPL was not distributed with this file,
 * you can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.jopss.logico.exception;

import com.jopss.logico.modelos.Erro;

/**
 * Excecoes da aplicacao, seja de regras ou validacoes.
 * Contem um atributo Erro contendo uma mensagem tecnica e codigo fixo. 
 * Pode ser utilizado este codigo para especificar mensagens amigaveis ao usuario.
 * 
 * @author jopss
 */
public class CaptchaLogicoException extends RuntimeException{

	private static final long serialVersionUID = -5030427710188647692L;

	private Erro erro;
	
	public CaptchaLogicoException(Erro erro) {
		super(erro.getMensagem());
		this.erro=erro;
	}

	public CaptchaLogicoException(Erro erro, Throwable cause) {
		super(erro.getMensagem(), cause);
		this.erro=erro;
	}

	/**
	 * Retorna o codigo de erro/validacao da aplicacao. Este codigo eh fixo.
	 */
	public Integer getCodigoErro() {
		return erro.getCodigo();
	}
	
	/**
	 * Verifica se o erro gerado foi o erro de resposta incorreta do usuario.
	 */
	public boolean isRespostaUsuarioInvalida(){
		if( erro != null && erro.getCodigo().intValue() == 4 ){
			return true;
		}
		return false;
	}

}

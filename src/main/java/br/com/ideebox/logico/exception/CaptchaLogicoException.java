package br.com.ideebox.logico.exception;

import br.com.ideebox.logico.modelos.Erro;

/**
 * Excecoes da aplicacao, seja de regras ou validacoes.
 * Contem um atributo Erro contendo uma mensagem tecnica e codigo fixo. Pode ser utilizado este codigo para especificar mensagens amigaveis ao usuario.
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

package br.com.ideebox.logico.negocio;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ideebox.logico.exception.CaptchaLogicoException;
import br.com.ideebox.logico.modelos.Erro;
import br.com.ideebox.logico.modelos.Pergunta;
import br.com.ideebox.logico.modelos.Resposta;
import br.com.ideebox.logico.negocio.util.CriptoUtils;
import br.com.ideebox.logico.negocio.util.GerenciadorBase;

/**
 * Classe provedora de regras para perguntas e respostas.
 */
public class ProvedorPerguntas {

	private final String keySession = "cp_logico_resp_session";
	private final String keyRequest = "cp_pergunta_req";
	private GerenciadorBase gerenciadorBase;
	
	private HttpSession session;
	private HttpServletRequest request;
	
	public ProvedorPerguntas(HttpSession session, HttpServletRequest request, GerenciadorBase gerenciadorBase) {
		this.session=session;
		this.request=request;
		this.gerenciadorBase=gerenciadorBase;
	}

	/**
	 * Cria um novo conjunto de pergunta e 4 respostas. A pergunta e as respostas sao aleatorias, sendo somente 1 resposta correta. Invoque este metodo antes do retorno a sua pagina que contem o
	 * componente "<idee:captcha-logico..." para carrega-lo com a pergunta e respostas.
	 * 
	 * <br/><br/>
	 * Ainda, faz duas regras importantes:
	 * <ul>
	 * 	<li>Armazena a resposta correta na Sessao, encriptada com MD5. Ela eh necessaria para validacao postarior da resposta correta.</li>
	 *  <li>Armezena o conjunto de pergunta e respostas na Requisicao para ser possivel retornar os valores no componente de tela. Por este objeto nao eh possivel saber a resposta correta.</li>
	 * <ul>
	 * 
	 * @return PerguntaRespostas contendo os dados a serem exibidos em tela. Ele jah vai estar na request para os componentes em tela. Normalmente nao eh necessario usa-lo manualmente.
	 * @throws CaptchaLogicoException
	 */
	public PerguntaRespostas criarNovaPerguntaRespostas() throws CaptchaLogicoException{
		return this.criarNovaPerguntaRespostas(3);
	}
	
	/**
	 * Cria um novo vonjunto de pergunta e respostas. A quantidade de respostas eh definido pelo parametro do metodo.
	 * A pergunta e as respostas sao aleatorias, sendo somente 1 resposta correta. Invoque este metodo antes do retorno a sua pagina que contem o
	 * componente "<idee:captcha-logico..." para carrega-lo com a pergunta e respostas.
	 * 
	 * <br/><br/>
	 * Ainda, faz duas regras importantes:
	 * <ul>
	 * 	<li>Armazena a resposta correta na Sessao, encriptada com MD5. Ela eh necessaria para validacao postarior da resposta correta.</li>
	 *  <li>Armezena o conjunto de pergunta e respostas na Requisicao para ser possivel retornar os valores no componente de tela. Por este objeto nao eh possivel saber a resposta correta.</li>
	 * <ul>
	 * 
	 * @param quantidadeRespostasErradas Inteiro com a quantidade de respostas.
	 * @return PerguntaRespostas contendo os dados a serem exibidos em tela. Ele jah vai estar na request para os componentes em tela. Normalmente nao eh necessario usa-lo manualmente.
	 * @throws CaptchaLogicoException
	 */
	public PerguntaRespostas criarNovaPerguntaRespostas(int quantidadeRespostasErradas) throws CaptchaLogicoException{
		
		if(session == null){
			throw new CaptchaLogicoException(Erro.ERRO_003);
		}
		
		Pergunta pergunta = this.retornarPerguntaAleatoria();
		
		List<Resposta> respostas = this.retornarRespostasErradasAleatorias(pergunta.getResposta(), quantidadeRespostasErradas);
		respostas.add(pergunta.getResposta());
		
		Collections.shuffle(respostas); //embaralhamento
		
		PerguntaRespostas perguntaRespostas = new PerguntaRespostas();
		perguntaRespostas.setTextoPergunta(pergunta.getTexto());
		perguntaRespostas.setRespostas(respostas);
		
		this.session.setAttribute( this.keySession, CriptoUtils.md5Encrypt( pergunta.getResposta().getTexto() ) );
		this.request.setAttribute( this.keyRequest, perguntaRespostas );
		
		return perguntaRespostas;
	}
	
	/**
	 * Valida a resposta selecionada pelo usuario com a resposta correta armazenada na sessao. Invoque este metodo apos a submissao do formulario que contem a resposta String do captcha.
	 * Sera retornado excecao caso a resposta esteja incorreta. Caso esteja correta, segue o fluxo.
	 * 
	 * @param respostaUsuario Objeto String com a selecao do usuario.
	 * @throws CaptchaLogicoException contendo validacoes. Caso a resposta for errada, retorna excecao do tipo 'ERRO_004'.
	 */
	public void validarRespostaUsuario(String respostaUsuario) throws CaptchaLogicoException{
		
		if(respostaUsuario == null){
			throw new CaptchaLogicoException(Erro.ERRO_001);
		}
		
		Object obj = this.session.getAttribute( this.keySession );
		
		if(obj == null){
			throw new CaptchaLogicoException(Erro.ERRO_002);
		}
		
		this.session.removeAttribute( this.keySession );
		this.request.removeAttribute( this.keyRequest );
		
		String respostaMD5 = (String) obj;
		if(! respostaMD5.equals( CriptoUtils.md5Encrypt( respostaUsuario ) ) ){
			throw new CaptchaLogicoException(Erro.ERRO_004);
		}
		
	}
	
	/**
	 * Retorna uma pergunta aleatoria da base. A aleatoriedade eh verificada pelo ID: tenta buscar de 1 ate o maximo de IDs da base.
	 * <br/><br/>
	 * OBS: Funcao RAND() do HSQLDB. Pode nao funcionar com outras bases.
	 * 
	 * @return Pergunta
	 */
	private Pergunta retornarPerguntaAleatoria(){
		TypedQuery<Pergunta> query = gerenciadorBase.getConnect().createQuery("FROM Pergunta ORDER BY RAND()", Pergunta.class);
		query.setMaxResults(1);
		return query.getSingleResult();
	}
	
	/**
	 * Retorna a lista de respostas a compor os dados da tela. Eh necessario passar a resposta correta para retornar a quantidade passada de respostas, menos ela.
	 * <br/><br/>
	 * OBS: Funcao RAND() do HSQLDB. Pode nao funcionar com outras bases.
	 * 
	 * @param respostaCorreta objeto Resposta com a resposta correta da pergunta. O retorno ira ignorar este dado.
	 * @param quantidadeAleatoria Inteiro com a quantidade de repostas a serem retornadas.
	 * @return List<Resposta>
	 */
	private List<Resposta> retornarRespostasErradasAleatorias(Resposta respostaCorreta, int quantidadeAleatoria){
		TypedQuery<Resposta> query = gerenciadorBase.getConnect().createQuery("FROM Resposta WHERE id != :idNegado ORDER BY RAND()", Resposta.class);
		query.setParameter("idNegado", respostaCorreta.getId());
		query.setMaxResults(quantidadeAleatoria);
		return query.getResultList();
	}
	
}

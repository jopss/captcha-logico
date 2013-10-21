package br.com.ideebox.negocio.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import com.jopss.logico.negocio.PerguntaRespostas;
import com.jopss.logico.negocio.ProvedorPerguntas;
import com.jopss.logico.negocio.util.GerenciadorBase;

public class ProvedorPerguntasTeste {

	@Test
	public void retornarNovaPerguntaRespostas() throws Exception{
		
		ProvedorPerguntas provedor = new ProvedorPerguntas( this.getMockHttpSession(), this.getMockHttpRequest(), new GerenciadorBase());
		PerguntaRespostas perguntaRespostas =  provedor.criarNovaPerguntaRespostas(3);
		
		assertNotNull(perguntaRespostas);
		assertNotNull(perguntaRespostas.getTextoPergunta());
		assertEquals(4, perguntaRespostas.getRespostas().size());
		
	}
	
	private HttpSession getMockHttpSession(){
		return new MockHttpSession();
	}
	
	private HttpServletRequest getMockHttpRequest(){
		return new MockHttpServletRequest();
	}
	
}

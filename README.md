captcha-logico
==============

API para implementação de um Captcha com perguntas lógicas em português.

Uso
===

Para utilizar o Captcha Logico na sua aplicação, basta configurar a dependência maven no seu projeto, utilizar a classe "CaptchaLogico" para carregar e criar as perguntas e referenciar a tag html na página web.

Maven
-----

	<dependency>
		<groupId>com.jopss</groupId>
		<artifactId>captcha-logico</artifactId>
		<version>1.0</version>
	</dependency>

Controlador/Serviço
-------------------

No seu controlador ou serviço web deve carregar a listagem de perguntas:

	CaptchaLogico.carregar(session, request).criarNovaPerguntaRespostas();

E na requisição da página, verifique a resposta digitada com o valor guardado na sessão com:

	CaptchaLogico.carregar(session, request).validarRespostaUsuario(guiaForm.getRespostaCaptcha());
	
Tela JSP
--------

Em tela deve criar referenciar o diretorio de tags da API no cabeçalho na página:

	<%@ taglib prefix="jopss" tagdir="/WEB-INF/tags/cp-componentes"%>
	
E em sua pagina, posicionar a tag que ira exibir as perguntas:

	<jopss:captcha-logico nameRepostas="respostaCaptcha" />

	Os parâmetros possíveis são:
	
		nameRepostas: Atributo a ser inserido no 'name' de todos os radios de respostas. Normalmente ele deve referenciar algum atributo do 'backend bean' do formulario.
		classDivContent: Classe CSS para estilizacao do div content. Este div esta em volta de todos os componentes.
		classPergunta: Classe CSS para o paragrado (p) da pergunta. 
		classSpanRespostas: Classe CSS para o span das respostas. Dentro deste estarão os radios com as respostas.


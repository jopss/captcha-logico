<%@tag description="Componente para exibir a pergunta e respostas do Captcha Logico." pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="nameRadiosRespostas"  type="java.lang.String" 	required="true" 	rtexprvalue="true" 	description="Nome do atributo 'String' a ser inserido no 'name' de todos os radios. Normalmente ele deve referenciar algum atributo do 'backend bean' do formulario." %>
<%@ attribute name="classDivConteudo"					required="false" 	rtexprvalue="true" 	description="Nome da classe CSS para estilizacao do div content. Este div esta em volta de todos os componentes." %>
<%@ attribute name="classPergunta"					required="false" 	rtexprvalue="true" 	description="Nome da classe CSS para o paragrado (p) da pergunta." %>
<%@ attribute name="classSpanRespostas"					required="false" 	rtexprvalue="true" 	description="Nome da classe CSS para o span das respostas. Dentro deste estarao os radios com as respostas." %>

<c:set var="perguntaRespostas" value="${requestScope.idee_pergunta_req}"/>

<div id="divCaptchaLogico" class="${classDivConteudo}">

	<p class="${classPergunta}">
		${perguntaRespostas.textoPergunta}
	</p>

	<span class="${classSpanRespostas}">
		<c:forEach var="resposta" items="${perguntaRespostas.respostas}" varStatus="count">
			<input type="radio" id="resposta_${count.index}" name="${nameRadiosRespostas}" value="${resposta.texto}" /> ${resposta.texto}
			<br/>
		</c:forEach>
	</span>

</div>

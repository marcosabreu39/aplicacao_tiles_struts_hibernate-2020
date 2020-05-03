<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#request.mensagem == null}">
<div class="alert alert-primary" role="alert">
  Bem vindo à página inicial!
</div>
</s:if>
<s:elseif test="%{#request.mensagem == 'Autenticação realizada com sucesso!'}">
<div class="alert alert-success" role="alert">
	<s:property value="mensagem" />
</div>
</s:elseif>
<s:else>
<div class="alert alert-primary" role="alert">
  <s:property value="mensagem" />
</div>
</s:else>

<h1 class="h3 mb-3 font-weight-normal text-center" id="hd">Aplicação com Tiles, Struts e Hibernate</h1>

<div class="row d-flex justify-content-center">

<img src="frontend/imagens/java-ee-logo.png" class="img-fluid" alt="Responsive image">

</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#request.mensagem == null}">
<div class="alert alert-primary" role="alert">
	Bem vindo à página de alteração de usuário!
</div>
</s:if>
<s:elseif test="%{#request.mensagem == 'Este login já está sendo utilizado!'}">
<div class="alert alert-danger" role="alert">
	<s:property value="mensagem" />
</div>
</s:elseif>
 <s:else>
 <div class="alert alert-primary" role="alert">
	<s:property value="mensagem" />
</div>
 </s:else>

<h1 class="h3 mb-3 font-weight-normal text-center">Página de alteração de usuário</h1>

<div class="row d-flex justify-content-center">		
	<s:form action="Altera" validate="true">
		<s:hidden name="usuario.id" />
		<div class="form-group">
		<s:textfield label="Nome" name="usuario.nome" cssClass="form-control" />
		<s:actionmessage key="nome" />
		</div>
		<div class="form-group">
		<s:textfield label="Login" name="usuario.userName" cssClass="form-control" />
		<s:actionmessage key="userName" />
		</div>
		<div class="form-group">
		<s:textfield label="Senha" name="usuario.password" cssClass="form-control" />
		<s:actionmessage key="password" />
		</div>
		<s:submit value="Salvar" cssClass="btn btn-lg btn-primary btn-block" />
	</s:form>
</div>

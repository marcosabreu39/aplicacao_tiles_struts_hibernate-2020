<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#request.mensagem == null}">
<div class="alert alert-primary" role="alert">
  Bem vindo à página de cadastro!
</div>
</s:if>
<s:elseif test="%{#request.mensagem == 'Usuário já cadastrado!'}">
<div class="alert alert-danger" role="alert">
	<s:property value="mensagem" />
</div>
</s:elseif>
<s:else>
<div class="alert alert-primary" role="alert">
  <s:property value="mensagem" />
</div>
</s:else>

<h1 class="h3 mb-3 font-weight-normal text-center">Página de Cadastro de usuários</h1>

<div class="row d-flex justify-content-center">

	<s:form action="Adiciona" validate="true">		
			<div class="form-group">
			<s:textfield label="Nome" name="usuario.nome" cssClass="form-control" />
			</div>
			<div class="form-group">
			<s:textfield label="Login" name="usuario.userName" cssClass="form-control" />
			</div>
			<div class="form-group">
			<s:password label="Senha" name="usuario.password" cssClass="form-control" />
			</div>
			<s:submit value="Salvar" cssClass="btn btn-lg btn-primary btn-block" />		
	</s:form>
</div>
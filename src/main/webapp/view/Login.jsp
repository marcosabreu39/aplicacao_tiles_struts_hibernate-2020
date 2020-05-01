<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#request.mensagem == 'Usuário e/ou senha incorretos!'}">
<div class="alert alert-danger" role="alert">
	<s:property value="mensagem" />
</div>
</s:if>
<s:elseif test="%{#request.mensagem == null}">
<div class="alert alert-primary" role="alert">
	Bem vindo à página de Login!
</div>
</s:elseif>
<s:else>
<div class="alert alert-primary" role="alert">
	<s:property value="mensagem" />
</div>
</s:else>
<h1 class="h3 mb-3 font-weight-normal text-center">Página de login</h1>

<div class="row d-flex justify-content-center">
	<s:form action="Logon" cssClass="form-signin" validate="true">
		<div class="form-group">
		<s:textfield name="usuario.userName"  label="Login" cssClass="form-control" />
		<s:actionerror />		
		</div>
		<div class="form-group">
		<s:password name="usuario.password" label="Senha" cssClass="form-control" />
		<s:actionerror />		
		</div>		
		<s:submit value="Enviar" cssClass="btn btn-lg btn-primary btn-block" />
	</s:form>
</div>

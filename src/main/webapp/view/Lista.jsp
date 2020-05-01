<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="%{#session.usuario == null}">
<s:set var="css">btn btn-secondary btn-sm disabled</s:set>
</s:if>
<s:else>
<s:set var="css">btn btn-primary btn-sm</s:set>
</s:else>

<s:if test="%{#request.mensagem == null}">
<div class="alert alert-primary" role="alert">
	Bem vindo à página de usuários
</div>
</s:if>
 <s:else>
 <div class="alert alert-success" role="alert">
	<s:property value="mensagem" />
</div>
 </s:else>
 
<h1 class="h3 mb-3 font-weight-normal text-center">Página de Usuários</h1>

<div class="row d-flex justify-content-center">
	<c:if test="${not empty usuarios}">		
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Login</th>
				<th>Senha</th>
				<th>Alterar</th>
				<th>Remover</th>
			</tr>

			<s:iterator value="usuarios" status="status">
				<tr style="background-color:${status.even?'#EEEEEE':'#FFFFFF'}">
					<td><s:property value="id" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="password" /></td>
					<td><s:a action="UsuarioPreparaAlteracao" cssClass="%{#css}">alterar<s:param name="usuario.id" value="id" />
						</s:a></td>
					<td><s:a action="Remove" cssClass="%{#css}">remover<s:param name="usuario.id" value="id" />																	
						</s:a></td>
				</tr>
			</s:iterator>			
		</table>
	</c:if>
	
	<c:if test="${empty usuarios}">
		<h1 class="h3 mb-3 font-weight-normal text-center">Sem usuários cadastrados</h1>
	</c:if>
</div>	
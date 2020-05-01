<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:set var="pg" scope="request" value="${pagina}" />
<c:choose>
	<c:when test="${pg eq 'home'}">
		<c:set var="homeAtivo" scope="request" value=" active" />
	</c:when>
	<c:when test="${pg eq 'login'}">
		<c:set var="loginAtivo" scope="request" value=" active" />
	</c:when>
	<c:when test="${pg eq 'cadastro'}">
		<c:set var="cadastroAtivo" scope="request" value=" active" />
	</c:when>
	<c:when test="${pg eq 'usuario'}">
		<c:set var="usuarioAtivo" scope="request" value=" active" />
	</c:when>
</c:choose>

<nav class="navbar-expand-sm navbar navbar-dark bg-primary">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item ${homeAtivo}"><s:a href="Home.jsp" cssClass="nav-link">Home<span class="sr-only">(current)</span>
			</s:a></li>
		<s:if test="%{#session.usuario == null}">
			<li class="nav-item ${loginAtivo}"><s:a href="Login.jsp" cssClass="nav-link">Login</s:a></li>
		</s:if>
		<li class="nav-item ${cadastroAtivo}"><s:a href="Cadastro.jsp" cssClass="nav-link">Cadastro</s:a></li>
		<s:if test="%{#session.usuario != null}">
			<li class="nav-item"><s:a action="Logout" cssClass="nav-link">Logout</s:a>
			</li>
		</s:if>
		<s:if test="%{#session.usuario != null}">
			<li class="nav-item ${usuarioAtivo}"><s:a href="UsuarioLista.jsp" cssClass="nav-link">Usuários</s:a></li>
		</s:if>
	</ul>
	<s:if test="%{#session.usuario != null}">
		<span class="navbar-text nav-item active"> <s:property value="%{#session.usuario.userName}" />
		</span>
	</s:if>
</nav>
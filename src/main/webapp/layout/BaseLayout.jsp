<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet" type="text/css" href="frontend/bootstrap/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="frontend/css/style.css">

</head>

<body>
			
	<div class="container-fluid">
	
		<tiles:insertAttribute name="banner" />
		
		
		<tiles:insertAttribute name="navbar" />		


		<tiles:insertAttribute name="body" />


		<tiles:insertAttribute name="footer" />
		
	</div>

<script type="text/javascript" src="frontend/bootstrap/bootstrap.min.js"></script>

</body>
	
</html>
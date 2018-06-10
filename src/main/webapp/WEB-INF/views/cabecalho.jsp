<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<c:url value="/" var="contextPath" />
	  <meta charset="utf-8"/>
		  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
		<link rel="icon"
			href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
			type="image/ico" />
		<link href="https://plus.googlecom/108540024862647200608"
			rel="publisher"/>
		<title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e
			muito mais - Casa do Código</title>
		<link href="${contextPath}resources/css/cssbase-min.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
			rel='stylesheet'/>
		<link href="${contextPath}resources/css/fonts.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello-ie7.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello-embedded.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/fontello.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/style.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/layout-colors.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/responsive-style.css"
			rel="stylesheet" type="text/css" media="all" />
		<link href="${contextPath}resources/css/guia-do-programador-style.css" 
			rel="stylesheet" type="text/css"  media="all"  />
	    <link href="${contextPath}resources/css/produtos.css" 
	    	rel="stylesheet" type="text/css"  media="all"  />
		<link rel="canonical" href="http://www.casadocodigo.com.br/" />	
		<link href="${contextPath}resources/css/book-collection.css"
				rel="stylesheet" type="text/css" media="all" />
	
	<c:url value="/resources/css" var="cssPath"/>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">

<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

<%-- <script src="${cssPath}/js/bootstrap.min.js"></script> --%>			
	
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa do Código</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="${s:mvcUrl('PC#listar').build() }">Lista de Produtos</a></li>
				<li><a href="${s:mvcUrl('PC#form').build() }">Cadastro de Produtos</a></li>
			</security:authorize>
				<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>
				<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
				<li><a href="${s:mvcUrl('CCC#itens').build() }" rel="nofollow">Carrinho(${carrinhoCompras.quantidade })</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
</nav>

<nav id="nav justify-content-center">
	<div class="container">

		<header id="layout-header">
			<div class="clearfix container">
				<a href="/" id="logo"> </a>
				<div id="header-content">

						<ul>
							<li class="category"><a href="${s:mvcUrl('HC#index').build() }">Home</a></li>
							<li class="category"><a href="${s:mvcUrl('PC#form').build() }">Cadastro </a></li>
							<li class="category"><a href="/collections/livros-de-front-end">Front End</a></li>
							<li class="category"><a href="/collections/livros-de-games">Games</a></li>
							<li class="category"><a href="/collections/livros-de-java">Java</a></li>
							<li class="category"><a href="/collections/livros-de-mobile">Mobile</a></li>
							<li class="category"><a	href="/collections/livros-desenvolvimento-web">Web</a></li>
							<li class="category"><a href="/collections/outros">Outros</a></li>

						</ul>
					</nav>
				</div>
			</div>
		</header>
		

</nav>

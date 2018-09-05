<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>


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
				<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow"><fmt:message key="menu.sobre"/></a></li>
				<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
				<li><a href="${s:mvcUrl('CCC#itens').build() }" rel="nofollow">
					<fmt:message key="menu.carrinho">
						<fmt:param value="${carrinhoCompras.quantidade }"/>
					</fmt:message></a></li>
				<li><a href="?locale=pt" rel="nofollow">
					<fmt:message key="menu.pt"/>	
				</a></li>
				<li><a href="?locale=en_US" rel="nofollow">
					<fmt:message key="menu.en"/>	
				</a></li>
				
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
							<li class="category"><a href="${s:mvcUrl('HC#index').build() }">
								<fmt:message key="navegacao.categoria.home"/></a></li>
								<li class="category"><a href="/collections/livros-de-front-end">
								<fmt:message key="navegacao.categoria.agile"/></a></li>
							<li class="category"><a href="/collections/livros-de-front-end">
								<fmt:message key="navegacao.categoria.front_end"/></a></li>
							<li class="category"><a href="/collections/livros-de-games">
								<fmt:message key="navegacao.categoria.games"/></a></li>
							<li class="category"><a href="/collections/livros-de-java">
								<fmt:message key="navegacao.categoria.java"/></a></li>
							<li class="category"><a href="/collections/livros-de-mobile">
								<fmt:message key="navegacao.categoria.mobile"/></a></li>
							<li class="category"><a	href="/collections/livros-desenvolvimento-web">
								<fmt:message key="navegacao.categoria.web"/></a></li>
							<li class="category"><a href="/collections/outros">
								<fmt:message key="navegacao.categoria.others"/></a></li>

						</ul>
					</nav>
				</div>
			</div>
		</header>
		

</nav>

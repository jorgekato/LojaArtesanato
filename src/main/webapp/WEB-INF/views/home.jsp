<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!--Inserir o Template  -->
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Livros de Java, Android, iOS e muito mais">


	<div class="container">

		<section id="index-section" class="container middle">

			<h2 class="cdc-call">Últimos dias com os preços promocionais. Aproveite!</h2>
			<div>
				<ul class="container middle">
					<c:forEach items="${produtos }" var="produto">

						<li>
							<a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }" class="block clearfix">
								<h5 class="product-title">${produto.titulo }</h5> 
								<img width="143" height="202"
								src="https://cdn.shopify.com/s/files/1/0155/7645/products/java8-featured_large.png?v=1411490181"
					alt="Java 8 Prático" title="Java 8 Prático" /> <small
								class="buy-button">Compre</small>
						</a></li>


					</c:forEach>
				</ul>
			</div>

		</section>
		
	</div>

</tags:pageTemplate>


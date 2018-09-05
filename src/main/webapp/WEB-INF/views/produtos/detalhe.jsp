<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="">

	<section class="buy-options clearfix">
			<form:form servletRelativeAction="/carrinho/add" method="post" cssClass="container">
				<ul id="variants" class="clearfix">
					<input type="hidden" value="${produto.id }" name="produtoId" />
					<c:forEach items="${produto.precos }" var="preco">
						<li class="buy-option" itemprop="offers" itemscope><input
							type="radio" name="tipoPreco" class="variant-radio" id="tipo"
							value="${preco.tipo }" checked="checked" /> <label
							itemrop="category" itemscope class="variant-label">${preco.tipo }</label>
							<small class="compare-at-price">R$ 39,90</small>
							<p class="variant-price">${preco.valor }</p></li>
					</c:forEach>
				</ul>
				<input type="submit" class="submit-image icon-basket-alt"
					alt="Compre Agora" title="Compre Agora '${produto.titulo }'!" value="Comprar" />

			</form:form>

		</section>

		<div class="container">
			<section class="summary">
				<ul>
					<li><h3>
							E muito mais... <a href='/pages/sumario-java8'>veja o sumário</a>.
						</h3></li>
				</ul>
			</section>

			<section class="data product-detail">
				<h2 class="section-title">Dados do livro:</h2>
				<p>
					Número de páginas: <span itemprop="numberOfPages">${produto.paginas }</span>
				</p>
				<p></p>
				<p>
					Data de publicação: <span class="publishedAt"><fmt:formatDate
							pattern="dd/MM/yyyy" value="${produto.dataLancamento.time }" /></span>
				</p>
				<p>
					Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta
						uma errata</a>
				</p>
			</section>
		</div>

	</article>

</tags:pageTemplate>
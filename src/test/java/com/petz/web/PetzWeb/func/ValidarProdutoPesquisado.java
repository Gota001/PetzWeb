package com.petz.web.PetzWeb.func;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.petz.web.PetzWeb.apoio.Memoria;
import com.petz.web.PetzWeb.telas.TelaCarrinho;

public class ValidarProdutoPesquisado {
	
	final static Log log = LogFactory.getLog(ValidarProdutoPesquisado.class);

	public void validarProdutoPesquisa(Memoria memoria) throws Exception {

		TelaCarrinho carrinho = new TelaCarrinho(memoria.getCt());
		String titulo = carrinho.recuperarTituloProduto();
		String preco = carrinho.recuperarPrecoProduto();
		
		if(titulo.contains(memoria.getProduto()) && preco.contains(memoria.getPrecoNormal())) {
			log.info("Preço e produto validados com sucesso! Produto: "+memoria.getProduto()+ " Preço: "+memoria.getPrecoNormal());
			carrinho.clicarDeletarProduto();
			carrinho.clicarIconePetz();
		}else{
			String erro ="Erro ao validar preço e produto";
			log.error(erro);
			throw new Exception(erro);
		}

	}
}

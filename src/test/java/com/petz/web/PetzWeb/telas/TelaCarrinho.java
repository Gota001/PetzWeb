package com.petz.web.PetzWeb.telas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.petz.web.PetzWeb.apoio.CapturaTela;
import com.petz.web.PetzWeb.apoio.DataFormater;
import com.petz.web.PetzWeb.apoio.FrameSelenium;

public class TelaCarrinho extends FrameSelenium{
	
	public String ct;
	
	public TelaCarrinho(String ct){
		this.ct = ct;
	}
	
	CapturaTela print = new CapturaTela();
	final static Log log = LogFactory.getLog(TelaCarrinho.class);
	
	public String recuperarPrecoProduto() throws Exception{
		try {
			String xpath = "//td[@class='preco']";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			log.info("Preço atual carrinho: " + texto);
			print.tirarPrintTela(ct, "recuperarPrecoProdutoc-"+DataFormater.data());
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar preço do produto na tela carrinho";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public String recuperarTituloProduto() throws Exception{
		try {
			String xpath = "//td[@class='td-resumo']/a";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			log.info("Produto selecionado carrinho: " + texto);
			print.tirarPrintTela(ct, "recuperarTituloProdutoc-"+DataFormater.data());
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar titulo do produto na tela carrinho";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public void clicarIconePetz() throws Exception{
		try {
			String xpath = "//img[@class='logo img-responsive']";
			this.aguardarElementoFicarVisivel(xpath);
			this.clicarElementoJS(xpath);
			log.info("Clique no icone petz efetuado com sucesso na tela carrinho");
			print.tirarPrintTela(ct, "clicarIconePetz-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao clicar no icone petz na tela carrinho";
			log.error(erro);
			throw new Exception(erro);
		}
	}

	public void clicarDeletarProduto() throws Exception{
		try {
			String xpath = "//i[@class='delete-item-pedido fa fa-times']";
			this.aguardarElementoFicarVisivel(xpath);
			this.clicarElementoJS(xpath);
			log.info("Clique no botão deletar efetuado com sucesso na tela carrinho");
			print.tirarPrintTela(ct, "clicarDeletarProduto-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao clicar no botão deletar na tela carrinho";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
}

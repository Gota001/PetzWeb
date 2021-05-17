package com.petz.web.PetzWeb.telas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.petz.web.PetzWeb.apoio.CapturaTela;
import com.petz.web.PetzWeb.apoio.DataFormater;
import com.petz.web.PetzWeb.apoio.FrameSelenium;

public class TelaProduto extends FrameSelenium{
	
	public String ct;
	
	public TelaProduto(String ct){
		this.ct = ct;
	}
	
	CapturaTela print = new CapturaTela();
	final static Log log = LogFactory.getLog(TelaProduto.class);
	
	public String recuperarTituloProduto() throws Exception{
		try {
			String xpath = "//div[@class='col-md-7 prod-info']/h1";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			log.info("Produto selecionado: " + texto);
			print.tirarPrintTela(ct, "recuperarTituloProduto-"+DataFormater.data());
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar titulo do produto na tela produto";
			log.error(erro);
			throw new Exception(erro);
		}
	}

	public String recuperarFornecedorProduto() throws Exception{
		try {
			String xpath = "(//div[@class='col-md-6 reset-padding']//span)[1]";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			log.info("Fornecedor: " + texto);
			print.tirarPrintTela(ct, "recuperarFornecedorProduto-"+DataFormater.data());
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar fornecedor do produto na tela produto";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public String recuperarPrecoProduto() throws Exception{
		try {
			String xpath = "//div[@class='price-current']";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			log.info("Preço atual: " + texto);
			print.tirarPrintTela(ct, "recuperarPrecoProduto-"+DataFormater.data());
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar preço do produto na tela produto";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public String recuperarPrecoAssinanteProduto() throws Exception{
		try {
			String xpath = "//span[@class='price-subscriber']";
			this.aguardarElementoFicarVisivel(xpath);
			String texto = this.recuperarTexto(xpath);
			print.tirarPrintTela(ct, "recuperarPrecoAssinanteProduto-"+DataFormater.data());
			log.info("Preço para assinantes: " + texto);
			return texto;
		} catch (Exception e) {
			String erro = "Erro ao recuperar preço para assinantes do produto na tela produto";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public void clicarAdicionarAoCarrinho() throws Exception{
		try {
			String xpath = "//button[@id='adicionarAoCarrinho']";
			this.aguardarElementoFicarVisivel(xpath);
			this.clicarElementoJS(xpath);
			log.info("Clique no botão adicionar ao carrinho efetuado com sucesso na tela de produto");
			print.tirarPrintTela(ct, "clicarAdicionarAoCarrinho-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao clicar no botão adicionar ao carrinho na tela tela de produto";
			log.error(erro);
			throw new Exception(erro);
		}
	}
}

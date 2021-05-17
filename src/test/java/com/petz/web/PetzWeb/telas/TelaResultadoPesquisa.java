package com.petz.web.PetzWeb.telas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.petz.web.PetzWeb.apoio.CapturaTela;
import com.petz.web.PetzWeb.apoio.DataFormater;
import com.petz.web.PetzWeb.apoio.FrameSelenium;

public class TelaResultadoPesquisa extends FrameSelenium{
	
	public String ct;
	
	public TelaResultadoPesquisa(String ct){
		this.ct = ct;
	}
	
	CapturaTela print = new CapturaTela();
	final static Log log = LogFactory.getLog(TelaResultadoPesquisa.class);
	
	public void clicarTerceiroProduto() throws Exception{
		try {
			String xpath = "(//img[@class='product-img img-responsive'])[3]";
			this.aguardarElementoFicarVisivel(xpath);
			this.clicarElementoJS(xpath);
			log.info("Clique no terceito produto efetuado com sucesso na tela de resultado da pesquisa");
			print.tirarPrintTela(ct, "clicarTerceiroProduto-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao clicar no terceito produto na tela de resultado da pesquisa";
			log.error(erro);
			throw new Exception(erro);
		}
	}

}

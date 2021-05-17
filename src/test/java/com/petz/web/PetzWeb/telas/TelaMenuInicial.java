package com.petz.web.PetzWeb.telas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.petz.web.PetzWeb.apoio.CapturaTela;
import com.petz.web.PetzWeb.apoio.DataFormater;
import com.petz.web.PetzWeb.apoio.FrameSelenium;


public class TelaMenuInicial extends FrameSelenium {
	
	public String ct;
	
	public TelaMenuInicial(String ct){
		this.ct = ct;
	}
	
	final static Log log = LogFactory.getLog(TelaMenuInicial.class);
	CapturaTela print = new CapturaTela();
	
	public void digitarBarraPesquisa(String texto) throws Exception{
		try {
			String xpath = "//input[@class='inputPesquisa']";
			this.aguardarElementoFicarVisivel(xpath);
			this.digitaTexto(xpath, texto);
			log.info(texto + " inserido com sucesso na barra de pesquisa do menu inicial");
			print.tirarPrintTela(ct, "digitarBarraPesquisa-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao inserir texto na barra de pesquisa no menu inicial";
			log.error(erro);
			throw new Exception(erro);
		}
	}
	
	public void clicarLupa() throws Exception{
		try {
			String xpath = "//button[@class='button-search']";
			this.aguardarElementoFicarVisivel(xpath);
			this.clicarElementoJS(xpath);
			log.info("Clique na lupa efetuado com sucesso no menu inicial");
			print.tirarPrintTela(ct, "clicarLupa-"+DataFormater.data());
		} catch (Exception e) {
			String erro = "Erro ao clicar na lupa no menu inicial";
			log.error(erro);
			throw new Exception(erro);
		}
		
	}

}

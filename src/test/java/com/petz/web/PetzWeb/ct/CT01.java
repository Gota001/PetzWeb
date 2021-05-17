package com.petz.web.PetzWeb.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.petz.web.PetzWeb.aplicacao.Aplicacao;
import com.petz.web.PetzWeb.apoio.DataFormater;
import com.petz.web.PetzWeb.apoio.Memoria;
import com.petz.web.PetzWeb.func.PesquisarProduto;
import com.petz.web.PetzWeb.func.ValidarProdutoPesquisado;



public class CT01 {

	final static Log log = LogFactory.getLog(CT01.class);

	@Test
	public void ct01() throws Exception{
		
		String ct = "CT01-"+DataFormater.data();
		System.setProperty("log4jFileName", ct);
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT01 - Pesquisar produto no site Petz");
		Aplicacao aplicacao = new Aplicacao();
		
		try{
			
			aplicacao.iniciarAplicacaoPetz();
			
			PesquisarProduto produto = new PesquisarProduto(ct);
			Memoria memoria = produto.pesquisaDeProduto();
			
			ValidarProdutoPesquisado validacao = new ValidarProdutoPesquisado();
			validacao.validarProdutoPesquisa(memoria);
			aplicacao.fecharAplicacao();
			
		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			aplicacao.fecharAplicacao();
			throw e;
		}
	}
}

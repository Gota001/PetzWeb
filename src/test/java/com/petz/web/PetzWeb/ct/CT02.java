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

public class CT02 {

	final static Log log = LogFactory.getLog(CT02.class);

	@Test
	public void ct02() throws Exception {

		String ct = "CT02-" + DataFormater.data();
		System.setProperty("log4jFileName", ct);
		PropertyConfigurator.configure("log4j.properties");

		log.info("Inicio caso de Teste - CT02 - Pesquisar 10 produtos no site Petz");
		Aplicacao aplicacao = new Aplicacao();

		try {
			aplicacao.iniciarAplicacaoPetz();
			for (int i = 0; i < 10; i++) {
				PesquisarProduto produto = new PesquisarProduto(ct,i);
				Memoria memoria = produto.pesquisaDeProdutoEmLote();

				ValidarProdutoPesquisado validacao = new ValidarProdutoPesquisado();
				validacao.validarProdutoPesquisa(memoria);
			}
			aplicacao.fecharAplicacao();
		} catch (Exception e) {
			log.info("Erro ao executar caso de teste");
			aplicacao.fecharAplicacao();
			throw e;
		}
	}
}

package com.petz.web.PetzWeb.func;

import com.petz.web.PetzWeb.apoio.Memoria;
import com.petz.web.PetzWeb.telas.TelaMenuInicial;
import com.petz.web.PetzWeb.telas.TelaProduto;
import com.petz.web.PetzWeb.telas.TelaResultadoPesquisa;

public class PesquisarProduto {

	private String ct;
	private int produto;
	
	public PesquisarProduto(String ct){
		this.ct = ct;
	}
	
	public PesquisarProduto(String ct,int produto){
		this.ct = ct;
		this.produto = produto;
	}
	
	public Memoria pesquisaDeProduto() throws Exception{
		
		Memoria memoria = new Memoria();
		MassaDados massa = new MassaDados(ct);
		memoria.setCt(ct);
		
		TelaMenuInicial menu = new TelaMenuInicial(ct);
		menu.digitarBarraPesquisa(massa.getProduto());
		menu.clicarLupa();
		
		TelaResultadoPesquisa pesquisa = new TelaResultadoPesquisa(ct);
		pesquisa.clicarTerceiroProduto();
		
		TelaProduto produto = new TelaProduto(ct);
		memoria.setProduto(produto.recuperarTituloProduto());
		memoria.setFornecedor(produto.recuperarFornecedorProduto());
		memoria.setPrecoNormal(produto.recuperarPrecoProduto());
		memoria.setPrecoAssinantel(produto.recuperarPrecoAssinanteProduto());
		produto.clicarAdicionarAoCarrinho();
		
		return memoria;
	}
	
	public Memoria pesquisaDeProdutoEmLote() throws Exception{
		
		Memoria memoria = new Memoria();
		MassaDados massa = new MassaDados(ct,produto);
		memoria.setCt(ct);
		
		TelaMenuInicial menu = new TelaMenuInicial(ct);
		menu.digitarBarraPesquisa(massa.getProduto());
		menu.clicarLupa();
		
		TelaResultadoPesquisa pesquisa = new TelaResultadoPesquisa(ct);
		pesquisa.clicarTerceiroProduto();
		
		TelaProduto produto = new TelaProduto(ct);
		memoria.setProduto(produto.recuperarTituloProduto());
		memoria.setFornecedor(produto.recuperarFornecedorProduto());
		memoria.setPrecoNormal(produto.recuperarPrecoProduto());
		memoria.setPrecoAssinantel(produto.recuperarPrecoAssinanteProduto());
		produto.clicarAdicionarAoCarrinho();
		
		return memoria;
	}
}

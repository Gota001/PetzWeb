package com.petz.web.PetzWeb.apoio;

public class Memoria {
	
	private String fornecedor;
	private String produto;
	private String precoNormal;
	private String precoAssinante;
	private String ct;
	
	public void setFornecedor(String fornecedor){
		this.fornecedor = fornecedor;
	}
	
	public void setProduto(String produto){
		this.produto = produto;
	}
	
	public void setPrecoNormal(String precoNormal){
		this.precoNormal = precoNormal;
	}
	
	public void setPrecoAssinantel(String precoAssinante){
		this.precoAssinante = precoAssinante;
	}
	
	public void setCt(String ct){
		this.ct = ct;
	}
	
	public String getCt(){
		return ct;
	}
	
	public String getFornecedor(){
		return fornecedor;
	}
	
	public String getProduto(){
		return produto;
	}
	
	public String getPrecoNormal(){
		return precoNormal;
	}
	
	public String getPrecoAssinantel(){
		return precoAssinante;
	}
	

}

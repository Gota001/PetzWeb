package com.petz.web.PetzWeb.func;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.petz.web.PetzWeb.apoio.LeitorMassaDados;


public class MassaDados {

	ObjectMapper mapper = new ObjectMapper();

	private String produto;


	public MassaDados(String ct) throws JsonProcessingException, FileNotFoundException, IOException {
		try {
			
			LeitorMassaDados leitorMassaDados = new LeitorMassaDados();
			String ct2 = ct.substring(0,ct.indexOf("-"));
			JsonNode json = leitorMassaDados.lerJsonMassaDados(ct2);
		
			produto = json.get("produto").asText();
		
		} catch (Exception e) {
			System.out.print("erro");
		}
	}
	
	public MassaDados(String ct, int p) throws JsonProcessingException, FileNotFoundException, IOException {
		try {
			
			LeitorMassaDados leitorMassaDados = new LeitorMassaDados();
			String ct2 = ct.substring(0,ct.indexOf("-"));
			JsonNode json = leitorMassaDados.lerJsonMassaDados(ct2);
			json = json.get("data");
			produto = json.get(p).get("produto").asText();
		
		} catch (Exception e) {
			System.out.print("erro");
		}
	}

	
	public String getProduto() {
		return produto;
	}
}

	
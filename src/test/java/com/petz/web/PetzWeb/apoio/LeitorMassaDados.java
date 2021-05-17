package com.petz.web.PetzWeb.apoio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeitorMassaDados {
	
	ObjectMapper mapper = new ObjectMapper();
	
	public JsonNode lerJsonMassaDados(String ct) throws IOException, ParseException{
		
		File currentDirFile = new File("");
		String helper = currentDirFile.getAbsolutePath();
		Path path = Paths.get(helper+"\\src\\test\\java\\com\\petz\\web\\PetzWeb\\massadados\\" +ct+".json");
		BufferedReader arqIn = Files.newBufferedReader(path,StandardCharsets.ISO_8859_1);
		JSONParser parser = new JSONParser();
		Object js = parser.parse(arqIn);
		JsonNode json = mapper.readTree(js.toString());
		arqIn.close();
		
		return json;
	}

}

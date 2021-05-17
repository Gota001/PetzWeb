package com.petz.web.PetzWeb.aplicacao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.petz.web.PetzWeb.apoio.FrameSelenium;
import com.petz.web.PetzWeb.ct.CT01;

public class Aplicacao extends FrameSelenium{

	static WebDriver driver;

	final static Log log = LogFactory.getLog(Aplicacao.class);

	public void iniciarAplicacaoPetz() throws Exception {
		try {
			String endereco = "https://www.petz.com.br";
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--disable-notifications");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
			driver.get(endereco);
			this.registrarDriver(driver);
			log.info("Navegador iniciado: " + endereco);
		} catch (Exception e) {
			log.error("Erro ao iniciar o navegador");
			throw new Exception("Erro ao iniciar o navegador");
		}
	}
	
	public void fecharAplicacao(){
		driver.close();
	}
}

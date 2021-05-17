package com.petz.web.PetzWeb.apoio;


import java.awt.Robot;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameSelenium {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private boolean ativaHighLight = true;
	private int tempoHighLight_segundos = 1;
	
	Logger logger = LogManager.getLogger(FrameSelenium.class);
	
	protected void desativarHighLight(boolean opcao) {
		if(!opcao){
			ativaHighLight = false;
		}
	}
	
	public static void registrarDriver(WebDriver driverExec) {
		driver = driverExec;
		wait = new WebDriverWait(driverExec,80);
	}
	
	protected WebDriver retornaDriver() {
		return driver;
	}
	
	protected void aguardarCarregamento(WebDriver driver,int tempoSegundos) {
//		wait = new WebDriverWait(driver,tempoSegundos);
	}
	
	protected boolean aguardarElementoFicarVisivel(String xpath, int tempoSegundos) {
		try{	
				this.aguardarCarregamento(driver, 60);
//				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
				int cont = 0;
				while(cont<tempoSegundos) {
					if(driver.findElements(By.xpath(xpath)).size() != 0){
						return true;
					}
					Thread.sleep(1000);
					cont++;
					}
				return false;
		}catch(Exception e) {
				logger.error("");
				}
		return false;
				
	}
	
	protected boolean aguardarElementoFicarVisivel(String xpath) {
		return aguardarElementoFicarVisivel(xpath,60);
	}
	
	protected WebElement recuperarWebElement(String xpath) throws InterruptedException {
		this.aguardarCarregamento(driver, 60);
		WebElement e = driver.findElement(By.xpath(xpath));
		if(ativaHighLight){
			highLight(e, tempoHighLight_segundos);
		}
		Thread.sleep(1000);
		return e;
	}
	
	protected void clicarElemento(String xpath) throws InterruptedException {
		aguardarCarregamento(driver,60);
		aguardarElementoFicarVisivel(xpath);
		WebElement e = driver.findElement(By.xpath(xpath));
		if(ativaHighLight){
			highLight(e, tempoHighLight_segundos);
		}
		e.click();
	}
	
	protected void realizarSelectItemPorValor(String xpath, String valorTexto) throws InterruptedException {
		Select s = new Select(this.recuperarWebElement(xpath));
		s.selectByValue(valorTexto);
	}
			
	protected void alterarFocoElemento(String xpath) throws InterruptedException {
		aguardarCarregamento(driver,60);
		aguardarElementoFicarVisivel(xpath);
		driver.switchTo().frame(this.recuperarWebElement(xpath));
	}
	
	protected void realizaFocoElemento(String xpath) throws InterruptedException {
		aguardarCarregamento(driver,60);
		aguardarElementoFicarVisivel(xpath);
		Actions ac = new Actions(driver);
		ac.moveToElement(recuperarWebElement(xpath)).perform();
	}
	
	protected void realizarSelectItemPorTexto(String xpath, String valorTexto) throws InterruptedException {
		aguardarCarregamento(driver,60);
		aguardarElementoFicarVisivel(xpath);
		Select s = new Select(this.recuperarWebElement(xpath));
		s.selectByVisibleText(valorTexto);
	}
	
	protected void digitaTexto(String xpath, String texto) throws Exception{
		aguardarCarregamento(driver,60);
		aguardarElementoFicarVisivel(xpath);
		WebElement e = driver.findElement(By.xpath(xpath));
		if(ativaHighLight){
			highLight(e, tempoHighLight_segundos);
		}
		e.sendKeys(texto);
	}
	
	public void alterarNovaAba() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
	protected void aguardarElementoClicavel(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	protected boolean validaExistenciaElemento(String xpath, int timeOut_segundos) throws Exception {
		boolean existe = false;
		try{
				Thread.sleep(3000);
				aguardarCarregamento(driver, timeOut_segundos);
				existe = driver.findElements(By.xpath(xpath)).size() != 0;
		}catch(Exception e) {
				existe = false;
		}
		return existe;
	}
	
	protected boolean validaExistenciaElemento(String xpath) throws Exception {
		return validaExistenciaElemento(xpath,30);
	}
	
	protected void alterarFocoFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	protected void alterarFocoFrame(String index) {
		driver.switchTo().frame(index);
	}
	
	protected void alterarFocoFramedefault() {
		driver.switchTo().defaultContent();
	}
	
	protected String recuperarValorPropriedade(String xpath, String propriedade) throws InterruptedException {
		this.aguardarElementoFicarVisivel(xpath);
		WebElement e = driver.findElement(By.xpath(xpath));
		if(ativaHighLight){
			highLight(e,tempoHighLight_segundos);
		}
		return e.getAttribute(propriedade);
	}
	
	protected int recuperarQuantidadeLinhasTabela(String xpath) {
		this.aguardarElementoFicarVisivel(xpath);
		return driver.findElements(By.xpath(xpath)).size();
	}
	
	protected String recuperarTextoCelula(String xpath, int linha, int coluna) {
		return driver.findElement(By.xpath(xpath+"/descendant::tr["+linha+"]/td["+coluna+"]")).getText();
	}
	
	protected String recuperarTexto(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	protected void clicarIndex(String xpath, int index) {
		java.util.List<WebElement> lista = driver.findElements(By.xpath(xpath));
		lista.get(index).click();
	}
	
	protected void moverMouse(String xpath) throws Exception{
		try {
			Point coordinates = driver.findElement(By.xpath(xpath)).getLocation();
			Robot robot = new Robot();
			robot.mouseMove(coordinates.getX(), coordinates.getY());
		} catch (Exception e) {
			throw new Exception("Erro ao movimentar mouse.");
		}
		
	}
	
	protected void clicarElementoJS(String xpath) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
	}
	
	protected void limparInput(String xpath) throws InterruptedException {
		Thread.sleep(50);
		WebElement e = driver.findElement(By.xpath(xpath));
			if(ativaHighLight){
				highLight(e, tempoHighLight_segundos);
			}
			e.clear();
	}
	
	protected void digitaTeclaEspecial(Keys tecla) throws Exception {
		driver.findElement(By.xpath("//body")).sendKeys(tecla);
	}

	protected WebElement recuperarElementoByXpath(String xpath) throws Exception {
		this.aguardarElementoFicarVisivel(xpath);
		WebElement e = driver.findElement(By.xpath(xpath));
		if(ativaHighLight){
			highLight(e, tempoHighLight_segundos);
		}
		return e;
	}
	
	protected boolean verificaSeSelecionado(String xpath) throws Exception {
		return driver.findElement(By.xpath(xpath)).isSelected();
	}
	
	
	private void highLight(WebElement element, int tempo) throws InterruptedException{
		String originalstyle = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", element);
		Thread.sleep(tempo*1000);
		js.executeScript("arguments[0].setAttribute('style', '"+originalstyle+"');", element);
	}
}



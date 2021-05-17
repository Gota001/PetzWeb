package com.petz.web.PetzWeb.apoio;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CapturaTela {

	public void tirarPrintTela(String ct, String metodo) {

		try {

			Robot robot = new Robot();
	        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = (int)size.getWidth();
	        int height = (int)size.getHeight();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(width, height));
			ImageIO.write(bi, "jpg", new File("C:/Users/Public/"+ct+"/"+metodo+".jpg"));
			
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

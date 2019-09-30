package com.automation.page;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.*;

public class OfertasPage extends PageObject {		
	
	@FindBy(xpath="/html/body/div[8]/div[2]/h1")
	WebElementFacade lblTitulo; 

	@FindBy(xpath="/html/body/div[8]/div[4]/div[2]/div[1]/div/div[1]/div/div/label")
	List <WebElementFacade> chkSalario;
		
	@FindBy(xpath="/html/body/div[8]/div[4]/div[2]/div[1]/div/div[3]/div/div/label/input")
	List <WebElementFacade> chkFechaPublicacion;	
	
	@FindBy(xpath="/html/body/div[8]/div[4]/div[2]/div[1]/div/div[3]/div")
	WebElementFacade chkFechaPublicacionElement;
	
	@FindBy(id="WorkAreaFilter1")
	WebElementFacade slctAreatrabajo;
	
	@FindBy(xpath="/html/body/div[8]/div[4]/div[1]/div[3]/div/div/ul/li/h2/a")
	List <WebElementFacade> lblCargo;
	
	@FindBy(xpath="/html/body/div[8]/div[4]/div[1]/div[3]/div/div/ul/li/h3/span/span")
	List <WebElementFacade> lblCompania;
	
	public boolean validarMensaje (String mensajeEsperado) {
		boolean salida = false;
		String textoObtenido = lblTitulo.getText();
		if(textoObtenido.equals(mensajeEsperado)) {
			
			salida = true;
		}
		return salida;
	}
	
	public void SeleccionarSalario(String RangoSalario) {
		
		for(WebElement salario : chkSalario) {
			
			if(salario.getText().contains(RangoSalario)) {
				salario.click();	
				break;
			}		
			
		}		
		
		Scroll.to(chkFechaPublicacionElement);
									
	}
	
	public void SeleccionarFechaPublicacion(String FechaPublicacion) {
		
		for(WebElement fecha : chkFechaPublicacion) {
			
			if(fecha.getText().contains(FechaPublicacion)) {
				fecha.click();				
			}

		}		
		
	} 
	
	public void SeleccionarAreaTrabajo(String AreaDetrabajo) {
		
		Select SlctTipoServicios = new Select(slctAreatrabajo);
		SlctTipoServicios.selectByVisibleText(AreaDetrabajo);
		
	}
	
	public void EscribirArchivo(String NombreOferta, String NombreCopañia) throws IOException {		
		
		File f;
		f = new File("ofertas.txt");
		try {
			
			FileWriter w = new FileWriter(f);
			BufferedWriter  bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			
			
			for (int posicion = 0; posicion<lblCargo.size(); posicion ++) {
				
				System.out.println(lblCargo.get(posicion).getText());
											
				wr.write("DATOS :");
				wr.append('\n' + lblCargo.get(posicion).getText());
								
			}
			
			wr.close();
			bw.close();
		}catch(IOException e) {
			
		}
		

		
	}
	
}

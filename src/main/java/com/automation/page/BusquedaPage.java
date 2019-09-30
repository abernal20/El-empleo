package com.automation.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.*;


@DefaultUrl("https://www.elempleo.com/co/")
public class BusquedaPage extends PageObject{

	@FindBy(xpath = "/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[1]/div/span[1]/input[2]")
	WebElementFacade txtCargo;
	
	@FindBy(xpath = "/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[1]/div/span[1]/div/div/div")
	List<WebElementFacade> optCargo;
	
	@FindBy(xpath = "/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[2]/div/span[1]/input[2]")
	WebElementFacade txtCiudad;
	
	@FindBy(xpath = "/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[2]/div/span[1]/div/div/div")
	List<WebElementFacade> optCiudad;	
	
	@FindBy(xpath = "//*[@id=\"politics_cookieCO\"]/div/div[2]/a[2]")
	WebElementFacade btnCookies;
	
	@FindBy(xpath = "//*[@id=\"politics_cookieCO\"]/div/div[1]/span")
	WebElementFacade msgCookies;
	
	public void ValidarMensajeCookies(){
		
		String textoObtenido = msgCookies.getText();
		if(!textoObtenido.equals("")) {			
			btnCookies.click();
		}					
	}
	
	public void BuscarCargoCiudad(String Cargo, String Ciudad) {
		
		txtCargo.sendKeys(Cargo);					
		for(WebElement opcionCargo : optCargo) {
			if(opcionCargo.getText().contains(Cargo)) {
				opcionCargo.click();				
			}
		}
		
		txtCiudad.sendKeys(Ciudad);
		for(WebElement opcionCiudad : optCiudad) {
			if(opcionCiudad.getText().contains(Ciudad)) {
				opcionCiudad.click();
				break;
			}	
			
		}
							
	}
}

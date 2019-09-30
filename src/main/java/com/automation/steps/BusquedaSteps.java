package com.automation.steps;

import java.io.IOException;

import com.automation.page.BusquedaPage;
import com.automation.page.OfertasPage;

import net.thucydides.core.annotations.Step;

public class BusquedaSteps {
	
	BusquedaPage busquedaPage;
	OfertasPage ofertasPage;
	
	@Step
	public void abrirUrl() {
		
		busquedaPage.open();
		
	}
	
	@Step
	public void ValidarCookies() {
		
		busquedaPage.ValidarMensajeCookies();
		
	}
	
	@Step
	public void BuscarCargoCiudad(String Cargo, String Ciudad) {
		
		busquedaPage.BuscarCargoCiudad(Cargo , Ciudad);
		
	}
	
	@Step
	public boolean validarMendaje(String mensajeEsperado) {
		
		return ofertasPage.validarMensaje(mensajeEsperado);
		
	}
	
	@Step
	public void SeleccionarDatos(String RangoSalario) {
		
		ofertasPage.SeleccionarSalario(RangoSalario);
		
	}
	
	@Step
	public void SeleccionarFechaPublicacion(String FechaPublicacion) {
		
		ofertasPage.SeleccionarFechaPublicacion(FechaPublicacion);
		
	}
	
	@Step
	public void SeleccionarAreaDeTrabajo(String AreaDetrabajo) {
		
		ofertasPage.SeleccionarAreaTrabajo(AreaDetrabajo);
		
	}
	
	@Step
	public void EscribirArchivo(String NombreOferta, String NombreCopañia) throws IOException {
		
		ofertasPage.EscribirArchivo(NombreOferta, NombreCopañia);
		
	}
	/*@Step
	public void EscribirArchivo(String [] args) throws IOException{
		
		OfertasPage.EscribirArchivo(args);
		
	}*/
	
	

}

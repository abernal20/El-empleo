package com.automation.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.automation.page.OfertasPage;
import com.automation.steps.BusquedaSteps;

import cucumber.api.java.ast.Y;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class BusquedaStepdefinition {
	
	@Steps
	BusquedaSteps busquedaSteps;
	OfertasPage ofertasPage;

	@Dado("^que estoy en la pagina de elemplo$")
	public void queEstoyEnLaPaginaDeElemplo() {
		
		busquedaSteps.abrirUrl();
		
	}

	@Cuando("^ingreso los datos (.*) y (.*)$")
	public void ingresoLosDatosContYBogotá(String Cargo, String Ciudad) {
	   
		busquedaSteps.ValidarCookies();
		busquedaSteps.BuscarCargoCiudad(Cargo, Ciudad);
		
	}

	@Cuando("^ingrese a las ofertas seleccionar el (.*)$")
	public void ingreseALasOfertasSeleccionarEl$A$(String RangoSalario) {
		
		assertTrue(ofertasPage.validarMensaje("Empleos Contador en Bogotá"));
		ofertasPage.SeleccionarSalario(RangoSalario);
				
	}
	
	@Cuando("^seleccione el rango de salario ingreso la (.*)$")
	public void seleccioneElRangoDeSalarioIngresoLaHaceSemana(String FechaPublicacion) {
		
		ofertasPage.SeleccionarFechaPublicacion(FechaPublicacion);
	}
	
	@Cuando("^seleccione la fecha publicacion ingreso el (.*)$")
	public void seleccioneLaFechaPublicacionIngresoElAdministrativaYFinanciera(String AreaDetrabajo) {
				
	    ofertasPage.SeleccionarAreaTrabajo(AreaDetrabajo);
	    
	}	
	
	@Cuando("^ya ingresados los datos quiero obtener un archivo plano con las ofertas filtradas donde me muestre el(.*) y (.*)$")
	public void yaIngresadosLosDatosQuieroObtenerUnArchivoPlanoConLasOfertasFiltradasDondeMeMuestreElY(String NombreOferta, String NombreCopañia) throws IOException {

		ofertasPage.EscribirArchivo(NombreOferta, NombreCopañia);

	}
		
}

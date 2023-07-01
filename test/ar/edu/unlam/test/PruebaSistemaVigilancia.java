package ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.dominio.Cumple;
import ar.edu.unlam.dominio.Evento;
import ar.edu.unlam.dominio.PlanificadorDeEventos;
import ar.edu.unlam.dominio.Usuario;

public class PruebaSistemaVigilancia {

	
	@Test
	public void queSePuedaCrearUnCumpleanios() {
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		// Preparación
		String mailOrganizador = "chiquitapia@afa.com"; 
		String nombreOrganizador = "Chiqui Tapia"; 
		Integer edadOrganizador = 55; 	
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);		
		
		String mailAgasajado = "lio@Messi.com";
		String nombreAgasajado = "Lionel Messi";
		Integer edadAgasajado = 36;
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
				
		String usuarioBuscado = principal.getUsuario(mailOrganizador);
		Usuario organizadorBuscado = principal.getEvento("El cumple de Lionel Messi").getOrganizador();
		
		Integer cantidadDeUsuariosEsperados = 2; 
		Integer	cantidadDeEventosEsperados = 1; 
		Integer	cantidadDeCumpleaniosEsperados = 1; 
		Integer	cantidadDeCasamientosEsperados = 0;
		
		// Ejecución
		
		principal.add(organizador);
		principal.crear(usuarioBuscado, agasajado);
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(usuarioBuscado, organizadorBuscado);
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaCrearUnCasamiento() {
		// Preparación
		final String mailOrganizador = "roberto@galan.com";
		String nombreOrganizador = "Roberto Galan"; 
		final Integer edadOrganizador = 101;
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);
		
		String mailAgasajado1 = "luli@salazar.com"; 
		String nombreAgasajado1 = "Luciana Zalazar";
		Integer edadAgasajado1 = 36;
		Usuario  agasajado1= new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1);
		
		String mailAgasajado2 = "rodrigo@redrado.com";
		String nombreAgasajado2 = "Rodrigo Redrado";
		Integer edadAgasajado2 = 43;
		Usuario  agasajado2= new Usuario(mailAgasajado2, nombreAgasajado2, edadAgasajado2);
		
		String nombreDelEvento = "El casamiento de Luli y Rodri";
		
		final Integer cantidadDeUsuariosEsperados = 2;
		Integer cantidadDeEventosEsperados = 1;
		Integer cantidadDeCumpleaniosEsperados = 1;
		Integer cantidadDeCasamientosEsperados = 0;
		
		// Ejecución
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		principal.add(organizador);
		principal.add(agasajado1);
		principal.add(agasajado2);
		Evento casamiento = principal.getEvento(nombreDelEvento);
		casamiento.add(agasajado1);
		casamiento.add(agasajado2);
		
		Usuario usuarioBuscado = principal.getUsuario(mailOrganizador);
		principal.crear(usuarioBuscado, nombreDelEvento);
		
		Usuario usuarioOrganizador = principal.getEvento("El cumple de Lionel Messi").getOrganizador());
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeEventosEsperados, principal.getCantidadDeEventos());
		assertEquals(cantidadDeCumpleaniosEsperados, principal.getCantidadDeCumpleanios());
		assertEquals(organizador,usuarioOrganizador) ;
		assertEquals(cantidadDeCasamientosEsperados, principal.getCantidadDeCasamientos());
	}
	
	@Test
	public void queSePuedaInvitarGenteAUnCumpleanios() {
		// Preparación
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		// Preparación
		String mailOrganizador = "chiquitapia@afa.com"; 
		String nombreOrganizador = "Chiqui Tapia"; 
		Integer edadOrganizador = 55; 	
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);		
		
		String mailAgasajado = "lio@Messi.com";
		String nombreAgasajado = "Lionel Messi";
		Integer edadAgasajado = 36;
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);

		String mailInvitado = "kunaguero@kunisports.com";
		String nombreInvitado = "Sergio Aguero";
		Integer edadInvitado = 36;
		Usuario invitado = new Usuario(mailInvitado, nombreInvitado, edadInvitado);
		
		String mailInvitado2 = "kmbappe@second.com";
		String nombreInvitado2 = "Kylian Mbapee";
		Integer edadInvitado2 = 24;
		Usuario invitado2 = new Usuario(mailInvitado2, nombreInvitado2, edadInvitado2);
		
		final Integer cantidadDeUsuariosEsperados = 4;
		Integer cantidadDeInvitadosEsperados = 2;
		
		// Ejecución
		
		principal.add(organizador);
		principal.add(invitado);
		principal.add(invitado2);
		
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		Cumple elCumpleDeLeo = new Cumple(agasajado);
		principal.crear(organizadorDelEvento, elCumpleDeLeo);
		principal.invitar(elCumpleDeLeo, invitado);
		principal.invitar(elCumpleDeLeo, invitado2);
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados());
	}
	
	@Test
	public void queUnInvitadoPuedaConfirarSuAsistencia () {
		PlanificadorDeEventos principal = new PlanificadorDeEventos();
		// Preparación
		String mailOrganizador = "chiquitapia@afa.com"; 
		String nombreOrganizador = "Chiqui Tapia"; 
		Integer edadOrganizador = 55; 	
		Usuario organizador = new Usuario(mailOrganizador, nombreOrganizador, edadOrganizador);		
		
		String mailAgasajado = "lio@Messi.com";
		String nombreAgasajado = "Lionel Messi";
		Integer edadAgasajado = 36;
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		
		
		final Integer cantidadDeUsuariosEsperados = 4;
		Integer cantidadDeInvitadosEsperados = 2;
		Integer cantidadDeInvitadosConfirmados = 1;
		
		Usuario elKun = new Usuario("kunaguero@kunisports.com", "Sergio Aguero", 36);
		Usuario elSegundo = new Usuario("kmbappe@second.com", "Kylian Mbapee", 24);
		
		// Ejecución
		principal.add(organizador);
		principal.add(elKun);
		principal.add(elSegundo);
		Usuario organizadorDelEvento = principal.getUsuario(mailOrganizador);
		
		Cumple elCumpleDeLeo = new Cumple(agasajado);
		
		principal.crear(organizadorDelEvento, elCumpleDeLeo);
		principal.invitar(elCumpleDeLeo, elKun);
		principal.invitar(elCumpleDeLeo, elSegundo);
		principal.confirmar(elCumpleDeLeo, elKun);
		
		// Validación
		assertEquals(cantidadDeUsuariosEsperados, principal.getCantidadDeUsuarios());
		assertEquals(cantidadDeInvitadosEsperados, principal.getCantidadDeInvitados());
		assertEquals(cantidadDeInvitadosConfirmados, principal.getCantidadDeInvitadosConfirmados());
	}

}

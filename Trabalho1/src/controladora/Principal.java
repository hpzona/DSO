package controladora;
import modelo.Modelo;
import visao.InterfaceComUsuario;

public class Principal {
	
	public static void main(String args[]) {
		
		Controladora logica;
		Modelo persistencia;
		InterfaceComUsuario jp;
		
		persistencia = new Modelo();
		logica = new Controladora(persistencia);
		jp = new InterfaceComUsuario(logica);
		
		jp.interaja();
	}
}

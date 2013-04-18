package controladora;
import modelo.Modelo;
import visao.InterfaceComUsuario;
import visao.Visao;

public class Principal {
	
	public static void main(String args[]) {
		
		Controladora controladora;
		Modelo modelo;
		Visao visao;
                InterfaceComUsuario jp;
		
		modelo = new Modelo();
                visao = new Visao();
		controladora = new Controladora(visao, modelo);
                jp = new InterfaceComUsuario();
				
		jp.interaja();
	}
}

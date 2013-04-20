package controladora;
import modelo.Modelo;
import visao.Visao;

public class Principal {
	
	public static void main(String args[]) {
		
		Controladora controladora;
		Modelo modelo;
		Visao visao;
		
		modelo = new Modelo();
                visao = new Visao(modelo);
		controladora = new Controladora(visao, modelo);
				
		visao.setVisible(true);
        }
}

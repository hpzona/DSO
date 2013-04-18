package controladora;
import modelo.ServicosPersistencia;
import visao.InterfaceComUsuario;

public class Principal {
	
	public static void main(String args[]) {
		
		ServicosLogica logica;
		ServicosPersistencia persistencia;
		InterfaceComUsuario jp;
		
		persistencia = new ServicosPersistencia();
		logica = new ServicosLogica(persistencia);
		jp = new InterfaceComUsuario(logica);
		
		jp.interaja();
	}
}

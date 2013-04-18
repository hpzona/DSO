package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import controladora.Controladora;

public class InterfaceComUsuario extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Controladora servicosLogica;
	
	public InterfaceComUsuario(Controladora servicosLogica) {
		this.servicosLogica = servicosLogica;
	}
	
	public void interaja()
	{
		try {	
			//FramePrincipal frame = new FramePrincipal();
                        JanelaPrincipal frame = new JanelaPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

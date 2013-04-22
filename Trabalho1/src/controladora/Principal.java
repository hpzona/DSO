package controladora;

import java.io.IOException;
import modelo.Modelo;
import visao.JanelaPrincipal;

public class Principal {

   public static void main(String args[]) throws IOException {
      
      Modelo modelo;
      JanelaPrincipal visao;
      Controladora controladora;

      modelo = new Modelo();
      visao = new JanelaPrincipal();
      controladora = new Controladora(visao, modelo);

      visao.setVisible(true);
   }
}

package controladora;

import java.io.IOException;
import modelo.Modelo;
import visao.Visao;

public class Principal {

   public static void main(String args[]) throws IOException {
      
      Modelo modelo;
      Visao visao;
      Controladora controladora;

      modelo = new Modelo();
      visao = new Visao();
      controladora = new Controladora(visao, modelo);

      visao.setVisible(true);
   }
}

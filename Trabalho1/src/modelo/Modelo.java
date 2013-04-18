package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Modelo {
	
	public void RegistrarEmArquivo(ArrayList<Produto> listaProdutos) {
		
		serializarListaProdutos(listaProdutos, "D:\\Produtos.dat");
		
	}
	
	public ArrayList<Produto> AbrirArquivo(String arquivo)
	{
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		return listaProdutos = deserializarListaProdutos(arquivo);
	}
	
	private static void serializarListaProdutos(ArrayList<Produto> listaProdutos, String arquivo) {
		
		FileOutputStream arq = null;
		ObjectOutputStream out = null;
		
		try {
			//arquivo no qual os dados vao ser gravados
			arq = new FileOutputStream(arquivo);
	 
			//objeto que vai escrever os dados
			out = new ObjectOutputStream(arq);
	 
			//escreve todos os dados
			out.writeObject(listaProdutos);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				arq.close();
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static ArrayList<Produto> deserializarListaProdutos(String arquivo) {
		FileInputStream arqLeitura = null;
		ObjectInputStream in = null;
		ArrayList<Produto> lista = null;
		try {
			//arquivo onde estao os dados serializados
			arqLeitura = new FileInputStream(arquivo);
	 
			//objeto que vai ler os dados do arquivo
			in = new ObjectInputStream(arqLeitura);
	 
			//recupera os dados
			lista = (ArrayList<Produto>) in.readObject();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				arqLeitura.close();
				in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	 
		return lista;
	}
	
	/*ArrayList<tenis> listaRecuperada = deserializaListaTenis("D:\serializados.dat");
	 
	for (Tenis t : listaRecuperada) {
		System.out.println(t);
	}*/

	
}

package modelo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ListaProduto {
    
    DefaultListModel listModelProdutos = new DefaultListModel();
    
    public ListaProduto(ArrayList<Produto> arrayListProdutos) {
                
        for (int i = 0; i < arrayListProdutos.size(); i++)
        {
            listModelProdutos.addElement(arrayListProdutos.get(i).getNome());
        }
    }
 
    public DefaultListModel getLista(){
        return listModelProdutos;
    }
    
    public void addLista(String nome){
        listModelProdutos.addElement(nome);
    }
    
    public String getNome(int index){
        return listModelProdutos.getElementAt(index).toString();
    }
    
    public void clear(){
        listModelProdutos.clear();
    }
    
    public void removerItem(int index){
        listModelProdutos.remove(index);
    }
    
}

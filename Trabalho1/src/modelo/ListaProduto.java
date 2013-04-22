package modelo;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ListaProduto {
    
    DefaultListModel listModelProdutos = new DefaultListModel();
    
    public ListaProduto() {
         
    }
    public ListaProduto(ArrayList<Produto> arrayListProdutos) {
                
        for (int i = 0; i < arrayListProdutos.size(); i++)
        {
            listModelProdutos.addElement(arrayListProdutos.get(i).getNome());
        }
    }
 
    public DefaultListModel getLista(){
        return listModelProdutos;
    }
    
    public void addNomeDoProdutoNaListaModel(String nome){
        listModelProdutos.addElement(nome);
    }
    
    public String getNome(int index){
        return listModelProdutos.getElementAt(index).toString();
    }
    
    public void clear(){
        listModelProdutos.clear();
    }
    
    public boolean possuiProduto(String nome){
        boolean possui = false;
        for (int i = 0; i < listModelProdutos.size(); i++){
            if ((listModelProdutos.getElementAt(i).toString()).equalsIgnoreCase(nome)){
                possui = true;
            }
        }
        return possui;
    }
    
    public void removerItem(ArrayList<Produto> arrayListProdutos, int index){
        Produto vendido = arrayListProdutos.get(index);
        vendido.setQuantidade(vendido.getQuantidade() - 1);
        if (vendido.getQuantidade() <= 0){
           arrayListProdutos.remove(index);
           listModelProdutos.remove(index);
        }
    }
    
    public int getTamanho() {
        return listModelProdutos.getSize();
    }
    
}

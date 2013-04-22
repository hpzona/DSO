package visao;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Visao extends javax.swing.JFrame {
    
    public Visao() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeEmpresa = new javax.swing.JLabel();
        jLabelDescricaoEmpresa = new javax.swing.JLabel();
        jButtonAbrirJanelaCadastroProduto = new javax.swing.JButton();
        jButtonAbrirJanelaEstoque = new javax.swing.JButton();
        jButtonAbrirJanelaVenda = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoTech - Informática");

        jLabelNomeEmpresa.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabelNomeEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNomeEmpresa.setText("InfoTech");
        jLabelNomeEmpresa.setToolTipText("");

        jLabelDescricaoEmpresa.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabelDescricaoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescricaoEmpresa.setText("Loja de Informática");

        jButtonAbrirJanelaCadastroProduto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAbrirJanelaCadastroProduto.setText("Cadastro de Produto");

        jButtonAbrirJanelaEstoque.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAbrirJanelaEstoque.setText("Controle de Estoque");
        jButtonAbrirJanelaEstoque.setPreferredSize(new java.awt.Dimension(147, 25));

        jButtonAbrirJanelaVenda.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButtonAbrirJanelaVenda.setText("Venda de Produtos");
        jButtonAbrirJanelaVenda.setPreferredSize(new java.awt.Dimension(147, 25));

        jMenuArquivo.setText("Arquivo");

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar.add(jMenuArquivo);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAbrirJanelaCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAbrirJanelaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAbrirJanelaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabelDescricaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabelNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescricaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbrirJanelaCadastroProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAbrirJanelaEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAbrirJanelaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
                       
    }//GEN-LAST:event_jMenuItemSairActionPerformed
 
   public void addAbrirJanelaEstoqueButtonListener(ActionListener lis) {
        jButtonAbrirJanelaEstoque.addActionListener(lis);
    }
   
   public void addAbrirJanelaCadastroButtonListener(ActionListener lis) {
        jButtonAbrirJanelaCadastroProduto.addActionListener(lis);
    }
      
   public void addAbrirJanelaVendaButtonListener(ActionListener lis) {
        jButtonAbrirJanelaVenda.addActionListener(lis);
    }
   
   public void addSairMenuItem(ActionListener lis){
        jMenuItemSair.addActionListener(lis);
   }
   
   public void AlertaLojaSemProdutos() {
       JOptionPane.showMessageDialog(null, "A loja não possui nenhum produto cadastrado", "Sem produtos", WIDTH);
   }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirJanelaCadastroProduto;
    private javax.swing.JButton jButtonAbrirJanelaEstoque;
    private javax.swing.JButton jButtonAbrirJanelaVenda;
    private javax.swing.JLabel jLabelDescricaoEmpresa;
    private javax.swing.JLabel jLabelNomeEmpresa;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}


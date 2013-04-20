package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.KeyStroke;

public class JanelaConfirmarVenda extends javax.swing.JDialog {

    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    private DefaultListModel lista;
    
    public JanelaConfirmarVenda(java.awt.Frame parent, boolean modal, DefaultListModel lista) {
        super(parent, modal);
        this.lista = lista;
        initComponents();
        setLocationRelativeTo(null);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    public JanelaConfirmarVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.lista = lista;
        initComponents();
        setLocationRelativeTo(null);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }
    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConcluirVenda = new javax.swing.JButton();
        jButtonCancelarVenda = new javax.swing.JButton();
        jLabeTitulo = new javax.swing.JLabel();
        jLabelPergunta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListConfimaVenda = new javax.swing.JList();
        jButtonRemoverDaListaDeVendas = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jButtonConcluirVenda.setText("Concluir");

        jButtonCancelarVenda.setText("Cancelar");

        jLabeTitulo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabeTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabeTitulo.setText("LISTA DE VENDAS:");
        jLabeTitulo.setToolTipText("");

        jLabelPergunta.setText("Gostaria de concluir sua venda?");

        jScrollPane1.setViewportView(jListConfimaVenda);

        jButtonRemoverDaListaDeVendas.setText("Remover");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonRemoverDaListaDeVendas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConcluirVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelarVenda)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPergunta)
                            .addComponent(jLabeTitulo))
                        .addContainerGap(278, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPergunta)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarVenda)
                    .addComponent(jButtonConcluirVenda)
                    .addComponent(jButtonRemoverDaListaDeVendas))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(jButtonConcluirVenda);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void addBotaoConcluirVendaListener (ActionListener col) {
	        jButtonConcluirVenda.addActionListener(col);
    }
    
    public void addBotaoCancelarVendaListener (ActionListener cal) {
	        jButtonCancelarVenda.addActionListener(cal);
    }
    
    public void addBotaoRemoverDaListaDeVendasListener (ActionListener cal) {
	        jButtonRemoverDaListaDeVendas.addActionListener(cal);
    }
        
    private void addLista(String nome){  
        lista.addElement(nome);
    }
        
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarVenda;
    private javax.swing.JButton jButtonConcluirVenda;
    private javax.swing.JButton jButtonRemoverDaListaDeVendas;
    private javax.swing.JLabel jLabeTitulo;
    private javax.swing.JLabel jLabelPergunta;
    private javax.swing.JList jListConfimaVenda;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
}
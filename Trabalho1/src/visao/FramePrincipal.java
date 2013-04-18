package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.ScrollPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FramePrincipal extends JFrame implements ListSelectionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public FramePrincipal() {
		setTitle("InfoTech - Loja de Informática");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 624);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnNewMenu.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(65, 11, 376, 536);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastrar Produto", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setBounds(28, 17, 104, 14);
		panel.add(lblNomeDoProduto);
		
		textField = new JTextField();
		textField.setBounds(135, 14, 118, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(135, 121, 118, 23);
		panel.add(btnCadastrar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 45, 118, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 78, 118, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(28, 48, 97, 14);
		panel.add(lblQuantidade);
		
		JLabel lblValorr = new JLabel("Valor (R$):");
		lblValorr.setBounds(28, 81, 75, 14);
		panel.add(lblValorr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("ScrollPane.border"));
		tabbedPane.addTab("Alterar Estoque", null, panel_1, null);
		panel_1.setLayout(null);
		//panel_1.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 65, 300, 343);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblSelecioneOProduto = new JLabel("Selecione o produto que deseja alterar a quantidade");
		lblSelecioneOProduto.setBounds(37, 41, 300, 14);
		panel_1.add(lblSelecioneOProduto);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(209, 423, 128, 23);
		panel_1.add(btnAlterar);
		
		JLabel lblQuantidade_1 = new JLabel("Quantidade: ");
		lblQuantidade_1.setBounds(37, 427, 77, 14);
		panel_1.add(lblQuantidade_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 424, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Vender Produto", null, panel_2, null);
		panel_2.setLayout(null);
		
		JList list_1 = new JList();
		JScrollPane scrollPane_1 = new JScrollPane(list_1);
		scrollPane_1.setBounds(37, 65, 300, 343);
		panel_2.add(scrollPane_1);
		
		JLabel lblSelecioneOProdute = new JLabel("Selecione o produte e especifique a quantidade");
		lblSelecioneOProdute.setBounds(37, 40, 300, 14);
		panel_2.add(lblSelecioneOProdute);
		
		JLabel lblQuantidade_2 = new JLabel("Quantidade:");
		lblQuantidade_2.setBounds(37, 428, 77, 14);
		panel_2.add(lblQuantidade_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 425, 86, 20);
		panel_2.add(textField_4);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setBounds(209, 424, 128, 23);
		panel_2.add(btnVender);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

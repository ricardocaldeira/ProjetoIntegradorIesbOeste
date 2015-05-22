package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.ModeloTabela;
import model.Produtos;
import persistencia.ConectaBanco;
import persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author Ricardo Caldeira
 */

public class FrmVendas extends javax.swing.JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConectaBanco conecta = new ConectaBanco();
	DAO dao = new DAO();
	Produtos p = new Produtos();
	private ResultSet rs;

	public FrmVendas() {
		setLocation(new Point(0, 200));

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				FrmVendas.class.getResource("/images/th.jpg")));
		setResizable(false);
		setTitle("VENDAS");
		setType(Type.UTILITY);
		initComponents();
		conecta.conexao();
		selectProdutos();
		try {
			preencherTabela("select *from produtos order by idProdutos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void selectProdutos() {
		PreparedStatement pst;
		try {

			pst = conecta.conn.prepareStatement("select * from produtos");
			rs = pst.executeQuery();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lbCodigoProduto = new javax.swing.JLabel();
		lbCodigoBarras = new javax.swing.JLabel();
		lbDescricao = new javax.swing.JLabel();
		lbAplicacao = new javax.swing.JLabel();
		txtCodigoBarras = new javax.swing.JTextField();
		txtCodigoProduto = new javax.swing.JTextField();
		txtDescricao = new javax.swing.JTextField();
		txtAplicacao = new javax.swing.JTextField();
		lbImagem = new javax.swing.JLabel();
		btnPesquisar = new javax.swing.JButton();
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!txtCodigoProduto.getText().equals("")) {
					p.setIdProdutos(Integer.parseInt(txtCodigoProduto.getText()));
				}
				if (!txtCodigoBarras.getText().equals("")) {
					p.setCodigoBarras(txtCodigoBarras.getText());
				}
				if (!txtDescricao.getText().equals("")) {
					p.setDescricao(txtDescricao.getText());
				}
				if (!txtAplicacao.getText().equals("")) {
					p.setAplicacao(txtAplicacao.getText());
				}
				if ((txtCodigoProduto.getText().equals(""))
						&& (txtCodigoBarras.getText().equals(""))
						&& (txtDescricao.getText().equals(""))
						&& (txtAplicacao.getText().equals(""))) {
					JOptionPane
							.showMessageDialog(null,
									"E necess�rio digitar alguma coisa para a pesquisa");
				} else {
					try {
						preencherTabela("select * from produtos where idProdutos like '%"
								+ p.getIdProdutos()
								+ "%' or codigoBarras like '%"
								+ p.getCodigoBarras()
								+ "%'"
								+ " or descricao like '%"
								+ p.getDescricao()
								+ "%' or aplicacao like '%"
								+ p.getAplicacao()
								+ "%'");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		btnPesquisar.setIcon(new ImageIcon(FrmVendas.class
				.getResource("/images/zoom.png")));
		jPanel2 = new javax.swing.JPanel();
		lbItens = new javax.swing.JLabel();
		btnLimpa = new javax.swing.JButton();
		btnLimpa.setIcon(new ImageIcon(FrmVendas.class
				.getResource("/images/cancel.png")));
		btnFinaliza = new javax.swing.JButton();
		btnFinaliza.setIcon(new ImageIcon(FrmVendas.class
				.getResource("/images/money_dollar.png")));
		btnFechar = new javax.swing.JButton();
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnFechar.setIcon(new ImageIcon(FrmVendas.class
				.getResource("/images/door_out.png")));
		lbSubTotal = new javax.swing.JLabel();
		scrProdutoVenda = new javax.swing.JScrollPane();
		tabelaVendaProduto = new javax.swing.JTable();
		tabelaVendaProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		//		tabelaVendaProduto.set
			}
		});
		tabelaVendaProduto.setGridColor(Color.WHITE);
		tabelaVendaProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaVendaProduto.setSurrendersFocusOnKeystroke(true);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		lbCodigoProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbCodigoProduto.setText("Codigo Produto");

		lbCodigoBarras.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbCodigoBarras.setText("C�digo Barras");

		lbDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbDescricao.setText("Descri��o");

		lbAplicacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbAplicacao.setText("Aplica��o");

		lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/th.jpg"))); // NOI18N

		btnPesquisar.setText("Pesquisar");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				lbCodigoProduto)
																		.addGap(18)
																		.addComponent(
																				txtCodigoProduto,
																				GroupLayout.DEFAULT_SIZE,
																				103,
																				Short.MAX_VALUE)
																		.addGap(35)
																		.addComponent(
																				lbCodigoBarras)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				txtCodigoBarras,
																				GroupLayout.DEFAULT_SIZE,
																				153,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lbDescricao)
																						.addComponent(
																								lbAplicacao))
																		.addGap(18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtDescricao)
																						.addComponent(
																								txtAplicacao))))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnPesquisar).addGap(22)
										.addComponent(lbImagem)
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lbCodigoProduto)
																						.addComponent(
																								lbCodigoBarras)
																						.addComponent(
																								txtCodigoBarras,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtCodigoProduto,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(24)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lbDescricao)
																						.addComponent(
																								txtDescricao,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lbAplicacao)
																						.addComponent(
																								txtAplicacao,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnPesquisar)))
														.addComponent(
																lbImagem,
																GroupLayout.DEFAULT_SIZE,
																116,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1.setLayout(jPanel1Layout);

		lbItens.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lbItens.setForeground(new java.awt.Color(51, 51, 255));
		lbItens.setText("Itens");

		btnLimpa.setText("Limpa F6");

		btnFinaliza.setText("Finaliza F5");

		btnFechar.setText("Fechar F4");

		lbSubTotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lbSubTotal.setForeground(new java.awt.Color(51, 51, 255));
		lbSubTotal.setText("SubTotal");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lbItens)
														.addGroup(
																Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				btnLimpa)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnFinaliza)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnFechar))
														.addComponent(
																lbSubTotal))
										.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						jPanel2Layout
								.createSequentialGroup()
								.addGap(41)
								.addComponent(lbItens)
								.addGap(18)
								.addComponent(lbSubTotal)
								.addPreferredGap(ComponentPlacement.RELATED,
										42, Short.MAX_VALUE)
								.addGroup(
										jPanel2Layout
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnFechar)
												.addComponent(btnFinaliza)
												.addComponent(btnLimpa))
								.addContainerGap()));
		jPanel2.setLayout(jPanel2Layout);

		tabelaVendaProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaVendaProduto.getColumnModel().getColumn(1).setPreferredWidth(300);
		scrProdutoVenda.setViewportView(tabelaVendaProduto);

		JScrollPane scrPesquisaProduto = new JScrollPane();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addComponent(scrProdutoVenda, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addComponent(scrPesquisaProduto, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(scrPesquisaProduto, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrProdutoVenda, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(3))
		);

		tabelaPesquisaProdutos = new JTable();
		tabelaPesquisaProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getButton() == MouseEvent.BUTTON1
						&& e.getClickCount() == 2) {
					if (tabelaPesquisaProdutos.getSelectedRow() > -1) {

						int linhaSelecionada = tabelaPesquisaProdutos
								.getSelectedRow();
						if (linhaSelecionada == -1) {
							JOptionPane.showMessageDialog(null,
									"N�o tem nada selecionado");
						} else {
							
							
							Object codigo = (tabelaPesquisaProdutos.getValueAt(linhaSelecionada, 0));
							Object descricao = (tabelaPesquisaProdutos.getValueAt(linhaSelecionada, 2));
							Object valorItem = (tabelaPesquisaProdutos.getValueAt(linhaSelecionada, 4));
							Object quantidade = (1);
							//JOptionPane.showMessageDialog(null, codigo);
							Object valorTotal = (tabelaPesquisaProdutos.getValueAt(linhaSelecionada, 4));
							
							DefaultTableModel dtm = (DefaultTableModel) tabelaVendaProduto.getModel();
							dtm.addRow(new Object[] {codigo, descricao, quantidade, valorItem,valorTotal});
							
							 
							
						}
							

					}

				

				}
			}
		});
		tabelaPesquisaProdutos.setModel(new DefaultTableModel(
				new Object[][] {}, new String[] {}));
		scrPesquisaProduto.setViewportView(tabelaPesquisaProdutos);
		getContentPane().setLayout(layout);

		pack();
	}

	public void preencherTabela(String sql) throws SQLException {
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] { "Codigo", "Codigo Barras",
				"Descricao", "Aplicacao", "Preco", "Quantidade" };

		rs = conecta.executaSQL(sql);

		try {
			rs.first();
			do {
				dados.add(new Object[] { rs.getInt("idProdutos"),
						rs.getString("codigoBarras"),
						rs.getString("descricao"), rs.getString("aplicacao"),
						rs.getDouble("valorVenda"), rs.getDouble("quantidade") });

			} while (rs.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane
					.showMessageDialog(
							null,
							"Erro ao preencher a Tabela (ArrayList)\n"
									+ e.getMessage());
		}
		ModeloTabela modelo = new ModeloTabela(dados, colunas);
		tabelaPesquisaProdutos.setModel(modelo);
		tabelaPesquisaProdutos.getColumnModel().getColumn(0)
				.setPreferredWidth(95);
		tabelaPesquisaProdutos.getColumnModel().getColumn(0)
				.setResizable(false);
		tabelaPesquisaProdutos.getColumnModel().getColumn(1)
				.setPreferredWidth(190);
		tabelaPesquisaProdutos.getColumnModel().getColumn(1)
				.setResizable(false);
		tabelaPesquisaProdutos.getColumnModel().getColumn(2)
				.setPreferredWidth(355);
		tabelaPesquisaProdutos.getColumnModel().getColumn(2)
				.setResizable(false);
		tabelaPesquisaProdutos.getColumnModel().getColumn(3)
				.setPreferredWidth(355);
		tabelaPesquisaProdutos.getColumnModel().getColumn(3)
				.setResizable(false);
		tabelaPesquisaProdutos.getColumnModel().getColumn(4)
				.setPreferredWidth(180);
		tabelaPesquisaProdutos.getColumnModel().getColumn(4)
				.setResizable(false);
		tabelaPesquisaProdutos.getColumnModel().getColumn(5)
				.setPreferredWidth(180);
		tabelaPesquisaProdutos.getColumnModel().getColumn(5)
				.setResizable(false);
		tabelaPesquisaProdutos.getTableHeader().setReorderingAllowed(false);
		tabelaPesquisaProdutos
				.setAutoResizeMode(tabelaPesquisaProdutos.AUTO_RESIZE_OFF);
		tabelaPesquisaProdutos
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	public static void main(String args[]) {

		/*
		 * Inicio do programa
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmVendas.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FrmVendas vendas = new FrmVendas();
				vendas.setVisible(true);
				vendas.setExtendedState(MAXIMIZED_BOTH);

			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnLimpa;
	private javax.swing.JButton btnFinaliza;
	private javax.swing.JButton btnFechar;
	private javax.swing.JButton btnPesquisar;
	private javax.swing.JLabel lbCodigoProduto;
	private javax.swing.JLabel lbCodigoBarras;
	private javax.swing.JLabel lbDescricao;
	private javax.swing.JLabel lbAplicacao;
	private javax.swing.JLabel lbImagem;
	private javax.swing.JLabel lbItens;
	private javax.swing.JLabel lbSubTotal;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane scrProdutoVenda;
	private javax.swing.JTable tabelaVendaProduto;
	private javax.swing.JTextField txtCodigoBarras;
	private javax.swing.JTextField txtCodigoProduto;
	private javax.swing.JTextField txtDescricao;
	private javax.swing.JTextField txtAplicacao;
	private JTable tabelaPesquisaProdutos;
}

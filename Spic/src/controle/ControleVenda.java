package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import persistencia.ConectaBanco;
import model.ModeloVendas;

public class ControleVenda {
	ConectaBanco conecta = new ConectaBanco();
	private int codigoProduto;
	
	public void adicionaItem(ModeloVendas mod){
		
	
		try {
			
			achaCodigoProduto(mod.getNomeProduto());
			conecta.conexao();
			PreparedStatement pst = conecta.conn.prepareStatement("insert into vendaItens (vendas_idvendas, produtos_idprodutos, quantidade)"
					+ "values (?,?,?)");
			pst.setInt(1, mod.getIdVendas());
			pst.setInt(2, codigoProduto);
			pst.setDouble(3, mod.getQuantidadeItem());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Produto de codigo "+codigoProduto+" adicionado com sucesso");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao realizar a venda\n CONTROLE VENDA "+e.getMessage());
			
		}
		
		conecta.desconecta();
	
	}
	public void achaCodigoProduto(String nome) throws SQLException{
		conecta.conexao();
	conecta.executaSQL("select * from produtos where descricao = '"+nome+"'");
	conecta.rs.first();
	codigoProduto = conecta.rs.getInt("idProdutos");	
	conecta.desconecta();
	}

}

/**
 * 
 */
package model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;



/**
 * @author RicardoNote
 *
 */
public class Produtos {
	//declara��o de variaves
	private int idProdutos;
	private long codigoBarras;
	private String descricao;
	private String aplicacao;
	private String medida;
	private String lote;
	private double valorVenda;
	private double valorCusto;
	private double quantidade;
	
	//m�todo construtor
	public Produtos(){
		
	}
	
	/*//M�todo construtor aprimorado
	public Produtos(int idProdutos,int codigoBarras,String descricao,String aplicacao,String medida,Boolean ativo, String dataValidade,  String dataFabricacao,String lote) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
		
		this.idProdutos = idProdutos;
		this.codigoBarras = codigoBarras;
		this.descricao = descricao;
		this.aplicacao = aplicacao;
		this.medida =medida;
		this.ativo = ativo;
		this.dataValidade = df.parse(dataValidade);
		this.dataFabricacao = df.parse(dataFabricacao);
		this.lote = lote;	
	}*/


// inicio dos getters
	public int getIdProdutos() {
		return idProdutos;
	}
	public long getCodigoBarras() {
		return codigoBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public String getMedida() {
		return medida;
	}

	public String getLote() {
		return lote;
	}
	
	public double getValorVenda(){
		
		return valorVenda;
	}
	
	public double getValorCusto(){
		
		return valorCusto;
		
	}
	
	public double getQuantidade(){
		
		return quantidade;
	}
	

	// inicio dos setters 
	
	public void setIdProdutos(int idProdutos) {
		this.idProdutos = idProdutos;
	}
	
	public void setCodigoBarras(long codigoBarras) {
		
		this.codigoBarras = codigoBarras;
		
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	
	public void setLote(String lote) {
		this.lote = lote;
	}
	
	
	public void setValorVenda(double valorVenda){
		
		this.valorVenda = valorVenda;
		
	}
	
	public void setValorCusto(double valorCusto){
		
		this.valorCusto = valorCusto;
		
	}
	
	public void setQuantidade(double quantidade){
		
		this.quantidade = quantidade;
		
	}
	
	

}

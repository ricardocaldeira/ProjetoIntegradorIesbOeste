package persistencia;

import java.util.Calendar;

/* Denominado Construtor Produto, com fun��o de receber e fornecer dados para as classes que assim solicitarem.
 * com variaveis privadas e proibindo qualquer contato com as mesmas, caso seja necess�rio qualquer dado
 * solicitar utilizando gets and sets
 */
public class ProdutosFactory {

	private int idProdutos;
	private int codigoBarras;
	private String descricao;
	private String aplicacao;
	private String medida;
	private Calendar dataValidade;
	private Calendar dataFabricacao;
	private String lote;

	
	public ProdutosFactory(){
		
	}
	//Metodo construtor para ser utilizado pelo pacote de Regras de Neg�cios (BusinessRules)
//	public ProdutosFactory(int idProdutos, int codigoBarras,
//			String descricao, String aplicacao, String medida,
//			Calendar dataValidade, Calendar dataFabricacao, String lote) {
//		super();
//		this.idProdutos = idProdutos;
//		this.codigoBarras = codigoBarras;
//		this.descricao = descricao;
//		this.aplicacao = aplicacao;
//		this.medida = medida;
//		this.dataValidade = dataValidade;
//		this.dataFabricacao = dataFabricacao;
//		this.lote = lote;
//	}

	public int getIdProdutos() {
		return idProdutos;
	}

	public int getCodigoBarras() {
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

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public String getLote() {
		return lote;
	}

	public void setIdProdutos(int idProdutos) {
		this.idProdutos = idProdutos;
	}

	public void setCodigoBarras(int codigoBarras) {
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

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}
	
	

}

/**
 * 
 */
package Cadastro;

/**
 * @author Ricardo Caldeira / Gabriel Fernandes
 *
 */
public class Servicos {
	private String nomeServico;
	private String descricaoServico;
	private double precoServico;
	/**
	 * @return the nomeServico
	 */
	public String getNomeServico() {
		return nomeServico;
	}
	
	/**
	 * @param nomeServico the nomeServico to set
	 */
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricaoServico;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}
	/**
	 * @return the preco
	 */
	public double getPrecoServico() {
		return precoServico;
	}
	/**
	 * @param preco the preco to set
	 */
	public void setPrecoServico(double preco) {
		this.precoServico = preco;
	}
	
	//metodo construtor do servišo com os parametros nomeServico, descricaoServico e prešoServico	
	public Servicos(String nomeServico, String descricaoServico, double precoServico) {
		super();
		this.nomeServico = nomeServico;
		this.descricaoServico = descricaoServico;
		this.precoServico = precoServico;
	}	
	

}

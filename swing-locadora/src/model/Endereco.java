package model;

/**
 * Classe por armazenar os atributos e métodos do objeto Endereco
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class Endereco 
{//inicio da classe
	
	//Declaração de atributos do objeto Endereco
	private int codigo;
	private String logradouro;
	private String nomeRua;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	//Construtor vazio
	public Endereco()
	{
		
	}
	
	//Getters e Setters

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getLogradouro() 
	{
		return logradouro;
	}

	public void setLogradouro(String logradouro) 
	{
		this.logradouro = logradouro;
	}

	public String getNomeRua() 
	{
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) 
	{
		this.nomeRua = nomeRua;
	}

	public int getNumero() 
	{
		return numero;
	}

	public void setNumero(int numero) 
	{
		this.numero = numero;
	}

	public String getComplemento() 
	{
		return complemento;
	}

	public void setComplemento(String complemento) 
	{
		this.complemento = complemento;
	}

	public String getBairro() 
	{
		return bairro;
	}

	public void setBairro(String bairro) 
	{
		this.bairro = bairro;
	}

	public String getCidade() 
	{
		return cidade;
	}

	public void setCidade(String cidade) 
	{
		this.cidade = cidade;
	}

	public String getEstado() 
	{
		return estado;
	}

	public void setEstado(String estado) 
	{
		this.estado = estado;
	}

	public String getCep() 
	{
		return cep;
	}

	public void setCep(String cep) 
	{
		this.cep = cep;
	}
	
}//fim da classe

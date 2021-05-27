package model;

/**
 * Classe para armazenar os atributos e métodos do objeto Estado
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class Estado 
{//inicio da classe

	//Declaração de atributos do objeto Estado
	private String uf;
	private String nome;
	
	//Construtor vazio
	public Estado()
	{
		
	}
	
	//Construtor com parâmetros
	
	public Estado(String uf, String nome) 
	{	
		this.uf = uf;
		this.nome = nome;
		
	}
	
	//Getters e setters
	
	public String getUf() 
	{
		return uf;
	}

	public void setUf(String uf) 
	{
		this.uf = uf;
	}	

	public String getNome()
	{
		return nome;
	}	

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
		
}//fim da classe

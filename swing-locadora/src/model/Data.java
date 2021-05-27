package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Data
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class Data 
{//inicio da classe
	
	//Declaração de atributos do objeto Data
	private int dia;
	private int mes;
	private int ano;
	
	//Construtor vazio
	public Data()
	{
		
	}
	
	//Getters e Setters

	public int getDia() 
	{
		return dia;
	}

	public void setDia(int dia) 
	{
		this.dia = dia;
	}

	public int getMes() 
	{
		return mes;
	}

	public void setMes(int mes) 
	{
		this.mes = mes;
	}

	public int getAno() 
	{
		return ano;
	}

	public void setAno(int ano) 
	{
		this.ano = ano;
	}
	
	//toString formatado
	
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return dia + "/" + mes + "/" + ano;
	}
	
}//fim da classe

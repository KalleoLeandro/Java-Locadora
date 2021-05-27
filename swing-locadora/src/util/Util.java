package util;

/**
 * Classe responsável por armazenar métodos de conversão de dados
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */

public class Util
{//inicio da classe
	/*
	 * Método para converter uma String em um inteiro
	 * */
	
	public static Integer getInt(String args)
	{//inicio do método
		return Integer.parseInt(args);
	}//fim do método
	
	/*
	 * Método para converter uma String em double
	 * */
	
	public static Double getDouble(String args)
	{//inicio do método
		return Double.parseDouble(args);
	}//fim do método

}//fim da classe

package util;

/**
 * Classe respons�vel por armazenar m�todos de convers�o de dados
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */

public class Util
{//inicio da classe
	/*
	 * M�todo para converter uma String em um inteiro
	 * */
	
	public static Integer getInt(String args)
	{//inicio do m�todo
		return Integer.parseInt(args);
	}//fim do m�todo
	
	/*
	 * M�todo para converter uma String em double
	 * */
	
	public static Double getDouble(String args)
	{//inicio do m�todo
		return Double.parseDouble(args);
	}//fim do m�todo

}//fim da classe

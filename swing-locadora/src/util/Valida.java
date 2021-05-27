package util;

/**
 * Classe responsável por armazenar os métodos de validação do projeto
 * @author Kalleo Leandro dos Santos Leal
 * @since 08/03/2021
 * @version 1.0
 */

public class Valida 
{//inicio da classe
	
	/*
	 * Método para verificar se o conteúdo dos campos é vazio-nulo ou não
	 * */
	
	public static boolean isEmptyOrNull(String args)
	{//inicio do método
		//verificando se o argumento está preenchido
		return (args.trim().equals("") || args == null);				
	}//fim do método
	
	/*
	 * Método para verificar se o conteúdo dos campos formatados é vazio-nulo ou não
	 * */
	
	public static boolean formatadoIsEmptyOrNull(String args)
	{//inicio do método
		String temp = args.trim().replace("(","").replace(")", "").replace("-", "").replace(".", "").replace("/","");
		return (temp.equals("") || temp == null);
		
	}//fim do método
	
	/*
	 * Método para verificar se o conteúdo dos campos é um número inteiro 
	 * */
	public static boolean isInteger(String args)
	{//inicio do método
		try
		{
			Integer.parseInt(args);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}//fim do método
	
	/*
	 * Método para verificar se o conteúdo dos campos é um número real de precisão dupla 
	 */
	
	public static boolean isDouble(String args)
	{//inicio do método
		try
		{
			Double.parseDouble(args);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}//fim do método	
	
}//fim da classe

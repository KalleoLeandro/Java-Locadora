package util;

/**
 * Classe respons�vel por armazenar os m�todos de valida��o do projeto
 * @author Kalleo Leandro dos Santos Leal
 * @since 08/03/2021
 * @version 1.0
 */

public class Valida 
{//inicio da classe
	
	/*
	 * M�todo para verificar se o conte�do dos campos � vazio-nulo ou n�o
	 * */
	
	public static boolean isEmptyOrNull(String args)
	{//inicio do m�todo
		//verificando se o argumento est� preenchido
		return (args.trim().equals("") || args == null);				
	}//fim do m�todo
	
	/*
	 * M�todo para verificar se o conte�do dos campos formatados � vazio-nulo ou n�o
	 * */
	
	public static boolean formatadoIsEmptyOrNull(String args)
	{//inicio do m�todo
		String temp = args.trim().replace("(","").replace(")", "").replace("-", "").replace(".", "").replace("/","");
		return (temp.equals("") || temp == null);
		
	}//fim do m�todo
	
	/*
	 * M�todo para verificar se o conte�do dos campos � um n�mero inteiro 
	 * */
	public static boolean isInteger(String args)
	{//inicio do m�todo
		try
		{
			Integer.parseInt(args);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}//fim do m�todo
	
	/*
	 * M�todo para verificar se o conte�do dos campos � um n�mero real de precis�o dupla 
	 */
	
	public static boolean isDouble(String args)
	{//inicio do m�todo
		try
		{
			Double.parseDouble(args);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}//fim do m�todo	
	
}//fim da classe

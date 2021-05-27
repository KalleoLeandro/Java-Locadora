package controller;

import javax.swing.UIManager;

import view.MenuPrincipalView;

/**
 * Classe principal para executar o projeto
 * @author Kalleo Leandro dos Santos Leal
 * @since 08/03/2021
 * @version 1.0
 */

public class Main 
{//inicio da classe

	/*
	 * Método principal de execução do programa
	 * */
	
	public static void main(String[] args) 
	{
		/*
		 * Configurando o estilo inicial do projeto
		 * */
		try 
		{
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); //Passando LookAndFeel padrão do sistema operacional		    		    
		} catch (Exception e) 
		{
			//Tratativa de erro
			e.printStackTrace();
		}		
		new MenuPrincipalView().iniciaGui();
	}
	
}//fim da classe
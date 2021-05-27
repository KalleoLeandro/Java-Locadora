package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Estado;
import util.Mensagem;
import util.Titulo;

/**
 * Classe repons�vel por controlar os m�todos do objeto Estado
 * @author Kalleo Leandro dos Santos Leal
 * @since 08/03/2021
 * @version 1.0
 */

public class EstadoController 
{//inicio da classe
	
	//Declarar o nome do arquivo TXT utilizado
	private String arquivo = "estados.txt";

	/*
	 * M�todo respons�vel por retornar uma lista de estado
	 * */
	
	public ArrayList<Estado> getEstados()
	{//inicio do m�todo
		
		//Objeto lista
		ArrayList<Estado> estados =  buscarTodos();		
		return estados;
		
	}//fim do m�todo
	
	/*
	 * M�todo respons�vel por ler o arquivo de estados 
	 * */
	private ArrayList<Estado> buscarTodos()
	{//inicio do m�todo

		//Lista auxiliar para retornar no m�todo
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		//Ler o arquivo de entrada de dados
		try 
		{
			//Classe Scanner para auxiliar a ler o arquivo de estados
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//La�o de repeti��o para ler as linhas do arquivo
			while(leitor.hasNext())
			{
				//Objeto auxiliar para retornar no m�todo
				Estado estado = getEstado(leitor.nextLine());
				
				//Atribuindo o objeto estado na lista de retorno
				estados.add(estado);
			}
		}
		catch (FileNotFoundException e) 
		{
			//Exibindo mensagem de erro ao usu�rio
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			//Tratando o erro
			e.printStackTrace();
		}			
		
		//Retornando a lista de estados
		return estados;
		
	}//fim do m�todo
	
	/*
	 * M�todo respons�vel por retornar um objeto do tipo Estado
	 * */
	private Estado getEstado(String linha)
	{//inicio do m�todo	

		//Vari�vel auxiliar para converter a linha em objeto 
		String aux[] = linha.split(";");

		//Retornando o objeto j� declarado e valorizado
		return new Estado(aux[0],aux[1]);		 
	}//fim do m�todo
}//fim da classe

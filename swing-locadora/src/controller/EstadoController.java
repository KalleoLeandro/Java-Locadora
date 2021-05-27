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
 * Classe reponsável por controlar os métodos do objeto Estado
 * @author Kalleo Leandro dos Santos Leal
 * @since 08/03/2021
 * @version 1.0
 */

public class EstadoController 
{//inicio da classe
	
	//Declarar o nome do arquivo TXT utilizado
	private String arquivo = "estados.txt";

	/*
	 * Método responsável por retornar uma lista de estado
	 * */
	
	public ArrayList<Estado> getEstados()
	{//inicio do método
		
		//Objeto lista
		ArrayList<Estado> estados =  buscarTodos();		
		return estados;
		
	}//fim do método
	
	/*
	 * Método responsável por ler o arquivo de estados 
	 * */
	private ArrayList<Estado> buscarTodos()
	{//inicio do método

		//Lista auxiliar para retornar no método
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		//Ler o arquivo de entrada de dados
		try 
		{
			//Classe Scanner para auxiliar a ler o arquivo de estados
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//Laço de repetição para ler as linhas do arquivo
			while(leitor.hasNext())
			{
				//Objeto auxiliar para retornar no método
				Estado estado = getEstado(leitor.nextLine());
				
				//Atribuindo o objeto estado na lista de retorno
				estados.add(estado);
			}
		}
		catch (FileNotFoundException e) 
		{
			//Exibindo mensagem de erro ao usuário
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			//Tratando o erro
			e.printStackTrace();
		}			
		
		//Retornando a lista de estados
		return estados;
		
	}//fim do método
	
	/*
	 * Método responsável por retornar um objeto do tipo Estado
	 * */
	private Estado getEstado(String linha)
	{//inicio do método	

		//Variável auxiliar para converter a linha em objeto 
		String aux[] = linha.split(";");

		//Retornando o objeto já declarado e valorizado
		return new Estado(aux[0],aux[1]);		 
	}//fim do método
}//fim da classe

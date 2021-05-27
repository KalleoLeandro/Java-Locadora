package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Vendedor;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar os processos de gravação e leitura das telas de vendedor
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */

public class VendedorController 
{//inicio da classe
	
	//Declarar o nome do arquivo txt a ser utilizado
	private String arquivo = "vendedor.txt";

	/*
	 * Método para gravar registros no arquivo TXT
	 * */
	public void gravarTxtVendededor(Vendedor vendedor)
	{//inicio do método
		//Classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file =  new File(arquivo);
				
		try
		{
			//Classe auxiliar para gerar um objeto de memória para gravação do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file,true);
					
			//Classe auxiliar para gerar o arquivo de gravação
			PrintStream gravador = new PrintStream(arquivoOutput);
					
			//Gravando o conteúdo do arquivo
			gravador.print(vendedor.getCodigo());
			gravador.print(";");
			gravador.print(vendedor.getNome());
			gravador.print(";");
			gravador.print(vendedor.getAreaVenda());
			gravador.print(";");
			gravador.print(vendedor.getCidade());
			gravador.print(";");
			gravador.print(vendedor.getEstado());
			gravador.print(";");
			gravador.print(vendedor.getSexo());
			gravador.print(";");
			gravador.print(vendedor.getIdade());
			gravador.print(";");
			gravador.print(vendedor.getSalario());
			gravador.print("\n");
			
			//Fechando o processo de gravação
			gravador.close();
			arquivoOutput.close();			
		}
		catch (FileNotFoundException e) 
		{			
			JOptionPane.showMessageDialog(null, e.toString(),Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, e.toString(),Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}//fim do método
	
	/*
	 * Método para retornar uma lista de vendedores 
	 * */
	public ArrayList<Vendedor> getVendedores()
	{//inicio do método
		//Objeto de lista para retornar no método
		ArrayList<Vendedor> vendedores = buscarTodos();
		
		//Retornando a lista
		return vendedores;
	}//fim do método
	
	/*
	 * Método para ler o arquivo TXT de vendedor
	 * */
	
	public ArrayList<Vendedor> buscarTodos()
	{//inicio do método
		//lista auxiliar para retornar no método
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		try
		{
			//Declaração de classe Scanner para ler arquivo Txt de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//laço de repetição para ler as linhas do arquivo
			while(leitor.hasNext())
			{
				//Objeto auxiliar para retornar no método
				Vendedor vendedor = getVendedor(leitor.nextLine());
					
				//Atribuindo o objeto vendedor na lista de retorno
				vendedores.add(vendedor);
			}			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		//Retornando a lista
		return vendedores;
	}//fim do método
	
	/*
	 * Método para retornar um vendedor
	 * */
	
	private Vendedor getVendedor(String args)
	{//inicio do método
		
		//Declaração de objeto auxiliar para retornar no método
		Vendedor vendedor = new Vendedor();
		
		//Variavel auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");
		
		//Valorizando o objeto vendedor
		
		vendedor.setCodigo(Util.getInt(aux[0]));
		vendedor.setNome(aux[1]);
		vendedor.setAreaVenda(aux[2]);
		vendedor.setCidade(aux[3]);
		vendedor.setEstado(aux[4]);
		vendedor.setSexo(aux[5].charAt(0));
		vendedor.setIdade(Util.getInt(aux[6]));
		vendedor.setSalario(Util.getDouble(aux[7]));
		
		//Retornando o objeto
		return vendedor;
	}//fim do método
	
}//fim da classe

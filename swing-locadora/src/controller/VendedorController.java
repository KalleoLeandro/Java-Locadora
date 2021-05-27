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
 * Classe respons�vel por controlar os processos de grava��o e leitura das telas de vendedor
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */

public class VendedorController 
{//inicio da classe
	
	//Declarar o nome do arquivo txt a ser utilizado
	private String arquivo = "vendedor.txt";

	/*
	 * M�todo para gravar registros no arquivo TXT
	 * */
	public void gravarTxtVendededor(Vendedor vendedor)
	{//inicio do m�todo
		//Classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file =  new File(arquivo);
				
		try
		{
			//Classe auxiliar para gerar um objeto de mem�ria para grava��o do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file,true);
					
			//Classe auxiliar para gerar o arquivo de grava��o
			PrintStream gravador = new PrintStream(arquivoOutput);
					
			//Gravando o conte�do do arquivo
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
			
			//Fechando o processo de grava��o
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
	}//fim do m�todo
	
	/*
	 * M�todo para retornar uma lista de vendedores 
	 * */
	public ArrayList<Vendedor> getVendedores()
	{//inicio do m�todo
		//Objeto de lista para retornar no m�todo
		ArrayList<Vendedor> vendedores = buscarTodos();
		
		//Retornando a lista
		return vendedores;
	}//fim do m�todo
	
	/*
	 * M�todo para ler o arquivo TXT de vendedor
	 * */
	
	public ArrayList<Vendedor> buscarTodos()
	{//inicio do m�todo
		//lista auxiliar para retornar no m�todo
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
		try
		{
			//Declara��o de classe Scanner para ler arquivo Txt de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//la�o de repeti��o para ler as linhas do arquivo
			while(leitor.hasNext())
			{
				//Objeto auxiliar para retornar no m�todo
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
	}//fim do m�todo
	
	/*
	 * M�todo para retornar um vendedor
	 * */
	
	private Vendedor getVendedor(String args)
	{//inicio do m�todo
		
		//Declara��o de objeto auxiliar para retornar no m�todo
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
	}//fim do m�todo
	
}//fim da classe

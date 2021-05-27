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

import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar os processos de gravação e leitura das telas de filme
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */

public class FilmeController 
{//inicio da classe
	//Declarar o nome do arquivo txt a ser utilizado
		private String arquivo = "filme.txt";
		
		/*
		 * Método para gravar registros no arquivo TXT
		 * */
		public void gravarTxtFilme(Filme filme)
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
				gravador.print(filme.getCodigo());//aux[0]
				gravador.print(";");
				gravador.print(filme.getNome());//aux[1]
				gravador.print(";");
				gravador.print(filme.getValor());//aux[2]
				gravador.print(";");
				gravador.print(filme.getValorPromocao());//aux[3]
				gravador.print(";");
				gravador.print(filme.isDisponivel());//aux[4]
				gravador.print(";");
				gravador.print(filme.isPromocao());	//aux[5]			
				gravador.print(";");
				gravador.print(filme.getGenero());//aux[6]
				
				
				gravador.print("\n");			
				
				//Fechando o processo de gravação
				gravador.close();
				arquivoOutput.close();			
			}
			catch (FileNotFoundException e) 
			{			
				JOptionPane.showMessageDialog(null,Mensagem.erroGravarArquivoFilme,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null,Mensagem.erroGravarArquivoFilme,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}//fim do método
		
		/*
		 * Método para retornar uma lista de vendedores 
		 * */
		public ArrayList<Filme> getFilmes()
		{//inicio do método
			//Objeto de lista para retornar no método
			ArrayList<Filme> Filmes = buscarTodos();
			
			//Retornando a lista
			return Filmes;
		}//fim do método
		
		/*
		 * Método para ler o arquivo TXT de vendedor
		 * */
		
		public ArrayList<Filme> buscarTodos()
		{//inicio do método
			//lista auxiliar para retornar no método
			ArrayList<Filme> filmes = new ArrayList<Filme>();
			try
			{
				//Declaração de classe Scanner para ler arquivo Txt de vendedor
				Scanner leitor = new Scanner(new FileReader(arquivo));
				
				//laço de repetição para ler as linhas do arquivo
				while(leitor.hasNext())
				{
					//Objeto auxiliar para retornar no método
					Filme filme = getFilme(leitor.nextLine());
						
					//Atribuindo o objeto vendedor na lista de retorno
					filmes.add(filme);
				}			
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}

			//Retornando a lista
			return filmes;
		}//fim do método
		
		/*
		 * Método para retornar um vendedor
		 * */
		
		private Filme getFilme(String args)
		{//inicio do método
			
			//Declaração de objeto auxiliar para retornar no método
			Filme filme = new Filme();
			
			//Variavel auxiliar para quebrar o registro do arquivo
			String aux[] = args.split(";");
			
			//Valorizando o objeto filme
			filme.setCodigo(Util.getInt(aux[0]));
			filme.setNome(aux[1]);
			filme.setValor(Util.getDouble(aux[2]));
			filme.setValorPromocao(Util.getDouble(aux[3]));
			filme.setDisponivel(aux[4].equals("true") ? true : false);
			filme.setPromocao(aux[5].equals("true") ? true : false);
			filme.setGenero(aux[6]);
			
			//Retornando o objeto
			return filme;
		}//fim do método
}//fim da classe

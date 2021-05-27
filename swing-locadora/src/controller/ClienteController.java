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

import model.Cliente;
import model.Data;
import model.Endereco;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe respons�vel por controlar os processos de grava��o e leitura das telas de cliente
 * @author Kalleo Leandro dos Santos Leal
 * @since 09/03/2021
 * @version 1.0
 */
public class ClienteController
{//inicio da classe
	
	//Declarar o nome do arquivo txt a ser utilizado
	private String arquivo = "cliente.txt";

	/*
	 * M�todo para gravar registros no arquivo TXT
	 * */
	public void gravarTxtCliente(Cliente cliente)
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
			gravador.print(cliente.getCodigo());//aux[0]
			gravador.print(";");
			gravador.print(cliente.getNome());//aux[1]
			gravador.print(";");
			gravador.print(cliente.getCpf());//aux[2]
			gravador.print(";");
			gravador.print(cliente.getRg());//aux[3]
			gravador.print(";");
			gravador.print(cliente.getDataNascimento().getDia() + "/" + cliente.getDataNascimento().getMes() + "/" + cliente.getDataNascimento().getAno());//aux[4]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCodigo());//aux[5]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getLogradouro());//aux[6]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getNomeRua());//aux[7]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getNumero());//aux[8]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getComplemento());//aux[9]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getBairro());//aux[10]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getCidade());//aux[11]
			gravador.print(";");
			gravador.print(cliente.getEndereco().getEstado());//aux[12]
			gravador.print(";");
			gravador.print(cliente.getSexo());//aux[13]
			gravador.print(";");
			gravador.print(cliente.getIdade());//aux[14]
			gravador.print(";");			
			gravador.print(cliente.getTelefone());//aux[15]
			gravador.print(";");
			gravador.print(cliente.getEmail());//aux[16]
			gravador.print(";");
			gravador.print(cliente.getCelular());//aux[17]
			gravador.print("\n");			
			
			//Fechando o processo de grava��o
			gravador.close();
			arquivoOutput.close();			
		}
		catch (FileNotFoundException e) 
		{			
			JOptionPane.showMessageDialog(null,Mensagem.erroGravarArquivoCliente,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivoCliente,Titulo.cadastroVendedor,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}//fim do m�todo
	
	/*
	 * M�todo para retornar uma lista de vendedores 
	 * */
	public ArrayList<Cliente> getClientes()
	{//inicio do m�todo
		//Objeto de lista para retornar no m�todo
		ArrayList<Cliente> clientes = buscarTodos();
		
		//Retornando a lista
		return clientes;
	}//fim do m�todo
	
	/*
	 * M�todo para ler o arquivo TXT de vendedor
	 * */
	
	public ArrayList<Cliente> buscarTodos()
	{//inicio do m�todo
		//lista auxiliar para retornar no m�todo
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try
		{
			//Declara��o de classe Scanner para ler arquivo Txt de vendedor
			Scanner leitor = new Scanner(new FileReader(arquivo));
			
			//la�o de repeti��o para ler as linhas do arquivo
			while(leitor.hasNext())
			{
				//Objeto auxiliar para retornar no m�todo
				Cliente cliente = getCliente(leitor.nextLine());
					
				//Atribuindo o objeto vendedor na lista de retorno
				clientes.add(cliente);
			}			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		//Retornando a lista
		return clientes;
	}//fim do m�todo
	
	/*
	 * M�todo para retornar um vendedor
	 * */
	
	private Cliente getCliente(String args)
	{//inicio do m�todo
		
		//Declara��o de objeto auxiliar para retornar no m�todo
		Cliente cliente = new Cliente();
		
		//Declara��o de objetos auxiliares para complementar cliente
		Endereco endereco = new Endereco();
		Data data = new Data();
		
		//Variavel auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");
		String vetor[] = aux[4].split("/");
		//Valorizando o objeto cliente
		
		cliente.setCodigo(Util.getInt(aux[0]));
		cliente.setNome(aux[1]);
		cliente.setCpf(aux[2]);
		cliente.setRg(aux[3]);
		
		//Valorizando o objeto de data
		
		data.setDia(Integer.parseInt(vetor[0]));
		data.setMes(Integer.parseInt(vetor[1]));
		data.setAno(Integer.parseInt(vetor[2]));
		
		//Atribuindo a data ao cliente
		cliente.setDataNascimento(data);
		
		//Valorizando o objeto endereco
		
		endereco.setCodigo(Util.getInt(aux[5]));
		endereco.setLogradouro(aux[6]);
		endereco.setNomeRua(aux[7]);
		endereco.setNumero(Util.getInt(aux[8]));
		endereco.setComplemento(aux[9]);
		endereco.setBairro(aux[10]);
		endereco.setCidade(aux[11]);
		endereco.setEstado(aux[12]);
		
		//Atribuindo o endere�o ao cliente
		cliente.setEndereco(endereco);
		
		cliente.setSexo(aux[13].charAt(0));
		cliente.setIdade(Util.getInt(aux[14]));
		cliente.setTelefone(aux[15]);
		cliente.setEmail(aux[16]);
		cliente.setCelular(aux[17]);
		
		//Retornando o objeto
		return cliente;
	}//fim do m�todo
}//fim da classe

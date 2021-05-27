package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.Cliente;

/**
 * Classe responsável por armazenar as telas e componentes do processo de consulta de clientes
 * @author Kalleo Leandro dos Santos Leal
 * @since 05/03/2021
 * @version 1.0
 */

public class ConsultaClienteView 
{//inicio da classe		
	
	/*
	 * Declaração dos atributos
	 */
	
	//Declaração do JFrame - janela
	private JFrame janelaConsultaClientes;	
	
	//Declaração do JTable - tabela para exibir os registros
	private JTable tabela;
			
	//Declaração do JScrollPane - para exibir os registros que ultrapassarem o limite da area da tabela
	private JScrollPane scroll;
	
	//Vetor auxiliar para armazenar os nomes das colunas
	private String colunastabela [] = {"Nome", "Sexo", "Idade", "Cidade", "Celular"};
	private String linhastabela[][] = {};
	
	//Declaração dos JButtons para permitir as ações pré-definidas na tela
	private JButton btSair;
	
	//Declaraçãdo do JPanel para organizar os elementos na tela
	private JPanel painelPrincipal;
	
	/*
	 * Método gerador de tela
	 * */
	
	public void iniciaGui()
	{//inicio do metodo
		
		//inicio do método
		
		/*
		 * Configurações da Frame
		 * */
		
		//Instanciando a Tela
		janelaConsultaClientes = new JFrame();
				
		//Configurando o título da tela
		janelaConsultaClientes.setTitle("CONSULTA DE CLIENTES");
			
		//Configurando o tamanho da tela - largura/altura
		janelaConsultaClientes.setSize(800,500);
		
		//Configurando a ação do fechar(X) do JFrame
		janelaConsultaClientes.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posição inicial da tela - centralizada
		janelaConsultaClientes.setLocationRelativeTo(null);
		
		/*
		 * Configurações do JTable
		 * */
		
		//Definição da razão da matriz da tabela
		DefaultTableModel modelo =  new DefaultTableModel(linhastabela, colunastabela);
		
		//Instanciando a tabela
		tabela = new JTable(modelo);
		
		//Configurar a posição e tamanho
		tabela.setBounds(0,0,798,380);
		
		//Configurar a ação do usuário ao clicar na linha do registro
		tabela.setEnabled(true);
		
		/*
		 * Configurações do JScrollPane
		 * */		
		//Instanciando o scroll
		scroll = new JScrollPane(tabela);
		
		//Configurar local de exibição do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Configurar o tamanho e a posição do Scroll
		scroll.setBounds(0,0,782,380);		
	
		
		/*
		 * Configurações dos JButtons 
		 * */
		
		//Instanciando o Botão Salvar		
		btSair = new JButton();
				
		//Configurando o texto interno do botão Salvar
		btSair.setText("SAIR");	
		
		//Configurando o tamanho e a posição do botão Salvar
		btSair.setBounds(250,400,250,50);
		
		btSair.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Fecha a janela e mantém o menu aberto
				janelaConsultaClientes.dispose();
			}
		});
		
		
		/*
		 * Configurações do JPanel
		 * */
		
		//Instanciando o painel principal
		painelPrincipal = (JPanel) janelaConsultaClientes.getContentPane();
						
		//Configurando o layout inicial
		painelPrincipal.setLayout(null);	
		
		//Adicionando os componentes no painel principal
		painelPrincipal.add(scroll);
		painelPrincipal.add(btSair);
		
		//Carregando a tabela
		carregarTabela();
		
		//configurando a visibilidade da tela
		janelaConsultaClientes.setVisible(true);
	}//fim do método
	
	/*
	 * Método para carregar a tabela com os vendedores gravados no arquivo TXT 
	 * */
	
	private void carregarTabela()
	{//inicio do método
		//Obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
				
		//Limpando os dados das linhas da tabela(0 apaga todas as linhas, um int != 0 apaga a linha específica)	

		
		//Laço de repetição para preencher as linhas da tabela
		for(Cliente cliente : new ClienteController().getClientes())
		{
			//Adicionando a linha na tabela			
			modelo.addRow(new String[] {cliente.getNome(),cliente.getSexo() + "", cliente.getIdade() + "" ,					
										cliente.getEndereco().getCidade() , cliente.getCelular()});
		}
	}//fim do método
}//fim da classe

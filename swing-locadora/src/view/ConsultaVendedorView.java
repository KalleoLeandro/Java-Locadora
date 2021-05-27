package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.VendedorController;
import model.Vendedor;

/**
 * Classe respons�vel por armazenar as telas e componentes do processo de consulta de vendedores
 * @author Kalleo Leandro dos Santos Leal
 * @since 05/03/2021
 * @version 1.0
 */

public class ConsultaVendedorView 
{//inicio da classe		
	
	/*
	 * Declara��o dos atributos
	 */
	
	//Declara��o do JFrame - janela
	private JFrame janelaConsultaVendedores;	
	
	//Declara��o do JTable - tabela para exibir os registros
	private JTable tabela;
			
	//Declara��o do JScrollPane - para exibir os registros que ultrapassarem o limite da area da tabela
	private JScrollPane scroll;
	
	//Vetor auxiliar para armazenar os nomes das colunas
	private String colunas [] = {"Nome", "�rea de Vendas", "Cidade", "Estado", "Sexo", "Idade","Salario"};
	private String linhas[][] = {};
	
	//Declara��o dos JButtons para permitir as a��es pr�-definidas na tela
	private JButton btSair;
	
	//Declara��do do JPanel para organizar os elementos na tela
	private JPanel painelPrincipal;
	
	/*
	 * M�todo gerador de tela
	 * */
	
	public void iniciaGui()
	{//inicio do metodo
		
		//inicio do m�todo
		
		/*
		 * Configura��es da Frame
		 * */
		
		//Instanciando a Tela
		janelaConsultaVendedores = new JFrame();
				
		//Configurando o t�tulo da tela
		janelaConsultaVendedores.setTitle("CONSULTA DE VENDEDORES");
			
		//Configurando o tamanho da tela - largura/altura
		janelaConsultaVendedores.setSize(800,500);
		
		//Configurando a a��o do fechar(X) do JFrame
		janelaConsultaVendedores.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posi��o inicial da tela - centralizada
		janelaConsultaVendedores.setLocationRelativeTo(null);
		
		/*
		 * Configura��es do JTable
		 * */
		
		//Defini��o da raz�o da matriz da tabela
		DefaultTableModel modelo =  new DefaultTableModel(linhas, colunas);
		
		//Instanciando a tabela
		tabela = new JTable(modelo);
		
		//Configurar a posi��o e tamanho
		tabela.setBounds(0,0,798,380);			
		
		//Configurar a a��o do usu�rio ao clicar na linha do registro
		tabela.setEnabled(true);		
		
		/*
		 * Configura��es do JScrollPane
		 * */		
		//Instanciando o scroll
		scroll = new JScrollPane(tabela);
		
		//Configurar local de exibi��o do scroll
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Configurar o tamanho e a posi��o do Scroll
		scroll.setBounds(0,0,782,380);		
		
		/*
		 * Configura��es dos JButtons 
		 * */
		
		//Instanciando o Bot�o Salvar		
		btSair = new JButton();
				
		//Configurando o texto interno do bot�o Salvar
		btSair.setText("SAIR");	
		
		//Configurando o tamanho e a posi��o do bot�o Salvar
		btSair.setBounds(250,400,250,50);
		
		btSair.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Fecha a janela e mant�m o menu aberto
				janelaConsultaVendedores.dispose();
			}
		});
		
		
		/*
		 * Configura��es do JPanel
		 * */
		
		//Instanciando o painel principal
		painelPrincipal = (JPanel) janelaConsultaVendedores.getContentPane();
						
		//Configurando o layout inicial
		painelPrincipal.setLayout(null);	
		
		//Adicionando os componentes no painel principal
		painelPrincipal.add(scroll);
		painelPrincipal.add(btSair);
		
		//Carregando a tabela
		carregarTabela();
		
		//configurando a visibilidade da tela
		janelaConsultaVendedores.setVisible(true);
	}//fim do m�todo
	
	/*
	 * M�todo para carregar a tabela com os vendedores gravados no arquivo TXT 
	 * */
	
	private void carregarTabela()
	{//inicio do m�todo
		//Obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		
		//Limpando os dados das linhas da tabela(0 apaga todas as linhas, um int != 0 apaga a linha espec�fica)	

		
		//La�o de repeti��o para preencher as linhas da tabela
		for(Vendedor vendedor : new VendedorController().getVendedores())
		{
			//Adicionando a linha na tabela			
			modelo.addRow(new String[] {vendedor.getNome(),vendedor.getAreaVenda(),
										vendedor.getCidade(),vendedor.getEstado(), vendedor.getSexo() + "",
										vendedor.getIdade()+"",vendedor.getSalario() + ""});
		}
	}//fim do m�todo
	
}//fim da classe

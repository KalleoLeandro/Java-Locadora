package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe responsável por armazenar os menus de execução do programa
 * @author Kalleo Leandro dos Santos Leal
 * @since 05/03/2021
 * @version 1.0
 */

public class MenuPrincipalView
{//inicio da classe
	
	/*
	 * Declaração de atributos
	 * */
	//Declaração de JFrame - janela
	private JFrame janelaMenu;
	
	//Declaração de JMenu - barra de menus
	private JMenuBar barraMenu;
	
	//Declarando os menu1 e menu2
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	
	//Declarando os itens de menu
	private JMenuItem itemMenu1;
	private JMenuItem itemMenu2;
	private JMenuItem itemMenu3;
	private JMenuItem itemMenu4;
	private JMenuItem itemMenu5;
	private JMenuItem itemMenu6;
	private JMenuItem itemMenu7;
	private JMenuItem itemMenu8;
	
	
	/*
	 * Método para criar a tela
	 * */
	
	public void iniciaGui()
	{//inicio do método
		/*
		 * Declaração de Estilos de Interface
		 */	
		
		//Função para mudar o texto do ConfirmDialog
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.okButtonText", "Ok");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		/*
		 * Criando as instâncias dos objetos
		 * */
		//Instanciando os objetos
		
		janelaMenu = new JFrame();
		barraMenu = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menu3 = new JMenu();
		itemMenu1 = new JMenuItem();
		itemMenu2 = new JMenuItem();
		itemMenu3 = new JMenuItem();
		itemMenu4 = new JMenuItem();
		itemMenu5 = new JMenuItem();
		itemMenu6 = new JMenuItem();
		itemMenu7 = new JMenuItem();
		itemMenu8 = new JMenuItem();
		/*
		 * Configurações do menu
		 * */
		
		//Configurando o texto inicial dos menus
		menu1.setText("CADASTRO");
		menu2.setText("CONSULTA");
		menu3.setText("SAIR");		
		
		/*
		 * Configurações itens de menu
		 * */
		
		itemMenu1.setText("Cliente");
		itemMenu2.setText("Vendedor");
		itemMenu3.setText("Filme");
		itemMenu4.setText("Locação");
		itemMenu5.setText("Cliente");
		itemMenu6.setText("Vendedor");
		itemMenu7.setText("Filme");
		itemMenu8.setText("Sair");
		
		
		/*
		 * Adicionando o menu na barra de menus
		 * */
		
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		barraMenu.add(menu3);
		
		/*
		 * Configurando os itens de menu no menu 1 
		 * */
		
		menu1.add(itemMenu1);
		menu1.add(itemMenu2);
		menu1.add(itemMenu3);
		menu1.add(itemMenu4);
		menu2.add(itemMenu5);
		menu2.add(itemMenu6);
		menu2.add(itemMenu7);
		menu3.add(itemMenu8);
		

		/*
		 * Adicionando as ações aos itens de menu
		 * */
		
		itemMenu1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					new CadastrarClienteView().iniciaGui();
				}
				catch (ParseException e1) 
				{
					
					e1.printStackTrace();
				}
				
			}
		});
		
		itemMenu2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CadastrarVendedorView().iniciaGui();
				
			}
		});
		
		itemMenu3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CadastrarFilmeView().iniciaGui();
				
			}
		});
		
		itemMenu4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CadastrarLocacaoView().iniciaGui();
				
			}
		});
		
		itemMenu5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new ConsultaClienteView().iniciaGui();
				
			}
		});
		
		itemMenu6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new ConsultaVendedorView().iniciaGui();
				
			}
		});
	
		itemMenu7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new ConsultaFilmeView().iniciaGui();
				
			}
		});
		
		itemMenu8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Vai se retirar?", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}			
		});
		
		/*
		 * Configurações do JFrame
		 * */
		
		//Configurando o tamanho da tela - largura/altura
		janelaMenu.setSize(400,300);
		
		//Adicionando a barra de menu a janela
		janelaMenu.setJMenuBar(barraMenu);
		
		//Configurando o título do menu
		janelaMenu.setTitle("LOCADORA");
		
		//Configurando a ação do fechar(X) do JFrame
		janelaMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//Configurando o tamanho maximizado
		//janelaMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//Configurando a visibilidade da janela
		janelaMenu.setVisible(true);		
	}//fim do método
}//fim da classe

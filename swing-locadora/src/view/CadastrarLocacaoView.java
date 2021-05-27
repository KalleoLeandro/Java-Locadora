package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável por armazenar as telas e componentes do processo de locação de filme
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class CadastrarLocacaoView 
{//inicio da classe

	/*
	 * Declaração dos atributos
	 */
	
	//Declaração do JFrame - janela
	private JFrame janelaLocacaoFilme;
	
	//Declaração das JLabel para exibir os rótulos na tela
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;	
	private JLabel lbFormaPagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	
	//Declaração do JTable - tabela para exibir os registros
	private JTable tabela;
		
	//Declaração do JScrollPane - para exibir os registros que ultrapassarem o limite da area da tabela
	private JScrollPane scroll;
	
	//Declaração dos JButtons para permitir as ações pré-definidas na tela
	private JButton btIncluir;
	private JButton btSalvar;
	private JButton btCancelar;
	
	//Declaração de JComboBox
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNomeVendedor;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNomeFilme;
	
	//Declaração dos JTextField para exibir os campos de preenchimento na tela
	private JTextField tfValorTotal;
	private JTextField tfValorPago;
	private JTextField tfTroco;
	
	//Declaração dos JRadioButtons para exibir a seleção única na tela
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
			
	//Declaração do grupo de RadioButton(ButtonGroup, responsável por gerenciar os componentes radio button)
	private ButtonGroup grpRadioFormaPagamento;
	
	
	//Declaraçãdo do JPanel para organizar os elementos na tela
	private JPanel painelPrincipal;
	
	//Vetor auxiliar para armazenar os nomes das colunas
	private String colunastabela [] = {"Código", "Nome", "Valor", "Disponível", "Promoção", "Valor Promocional","Gênero"};
	private String linhastabela[][] = {};
	
	//vetor auxiliar para armazenar os nomes dos vendedores
	private String vendedores[] = {"-Selecione um Vendedor-","Kalleo Leandro dos Santos Leal"};
	
	//vetor auxiliar para armazenar os estados
	private String filmes[] = {"-Selecione um Filme-","A Hora do Pesadelo"};
	
	
	/*
	 * Método gerador de tela
	 * */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void iniciaGui()
	{//inicio do metodo
		
		//inicio do método
		
		/*
		 * Configurações da Frame
		 * */
		
		//Instanciando a Tela
		janelaLocacaoFilme = new JFrame();
				
		//Configurando o título da tela
		janelaLocacaoFilme.setTitle("LOCAÇÃO DE FILME");
			
		//Configurando o tamanho da tela - largura/altura
		janelaLocacaoFilme.setSize(800,505);
		//Configurando a ação do fechar(X) do JFrame
		janelaLocacaoFilme.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posição inicial da tela - centralizada
		janelaLocacaoFilme.setLocationRelativeTo(null);
		
		/*
		 * Configurações dos JLabels
		 * */
		
		//Instanciando o label nome do vendedor
		lbNomeVendedor = new JLabel();
						
		//Configurando o texto inicial
		lbNomeVendedor.setText("Nome do Vendedor:");
		
		//Configurando o tamanho e a posição do label nome do vendedor
		lbNomeVendedor.setBounds(20,30,110,30);
		
		//Instanciando o label nome do filme
		lbNomeFilme = new JLabel();
		
		//Configurando o texto inicial
		lbNomeFilme.setText("Nome do Filme:");
		
		//Configurando o tamanho e a posição do label nome do filme
		lbNomeFilme.setBounds(20,60,100,30);
		
		//Instanciando o label Forma de pagamento
		lbFormaPagamento = new JLabel();
		
		//Configurando o texto inicial
		lbFormaPagamento.setText("Forma de pagamento:");
		
		//Configurando o tamanho e a posição do label forma de pagamento
		lbFormaPagamento.setBounds(20,300,150,25);
		
		//Instanciando o label Valor total
		lbValorTotal = new JLabel();
		
		//Configurando o texto inicial
		lbValorTotal.setText("Valor Total:");
		
		//Configurando o tamanho e a posição do label Valor total
		lbValorTotal.setBounds(380,300,150,25);
		
		//Instanciando o label Valor pago
		lbValorPago = new JLabel();
		
		//Configurando o texto inicial
		lbValorPago.setText("Valor Pago:");
		
		//Configurando o tamanho e a posição do label Valor pago
		lbValorPago.setBounds(380,330,150,25);
		
		//Instanciando o label Troco
		lbTroco = new JLabel();
		
		//Configurando o texto inicial
		lbTroco.setText("Troco:");
		
		//Configurando o tamanho e a posição do label Troco
		lbTroco.setBounds(380,360,150,25);
		
		/*
		 * configurações do JComboBox
		 * */
		
		//Instanciando o Combo Box Nome Vendedor 
		cbxNomeVendedor = new JComboBox (vendedores);

		//Configurando o tamanho e a posição
		cbxNomeVendedor.setBounds(150,30,600,30);
		
		//Instanciando o Combo Box Nome Filme
		cbxNomeFilme = new JComboBox (filmes);
		
		//Configurando o tamanho e a posição
		cbxNomeFilme.setBounds(150,65,400,30);
		
		/*
		 * Configurações do JButton Incluir 
		 * */
		
		//Instanciando o Botão Salvar		
		btIncluir = new JButton();
				
		//Configurando o texto interno do botão Salvar
		btIncluir.setText("INCLUIR");
				
		//Configurando o tamanho e a posição do botão Salvar
		btIncluir.setBounds(565,65,185,30);
		
		/*
		 * Configurações do JTable
		 * */
		
		//Definição da razão da matriz da tabela
		DefaultTableModel modelo =  new DefaultTableModel(linhastabela, colunastabela);
		
		//Instanciando a tabela
		tabela = new JTable(modelo);
		
		//Configurar a posição e tamanho
		tabela.setBounds(1,125,750,150);
		
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
		scroll.setBounds(1,145,782,150);
		
		/*
		 * Configurações do JRadioButton
		 * */
		
		rbDinheiro = new JRadioButton();
		rbCheque = new JRadioButton();
		rbDebito = new JRadioButton();
		rbCredito = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbDinheiro.setText("Dinheiro");	
		rbCheque.setText("Cheque");
		rbDebito.setText("Débito");
		rbCredito.setText("Crédito");
		
		//Configurando a posição inicial
		rbDinheiro.setBounds(170,300,80,25);
		rbCheque.setBounds(170,325,80,25);
		rbDebito.setBounds(170,350,80,25);
		rbCredito.setBounds(170,375,80,25);
		
		/*
		 * Configurações do Button Group
		 * */
		
		grpRadioFormaPagamento = new ButtonGroup();
		
		//Adicionando os elementos ao RadioButtonGroup
		grpRadioFormaPagamento.add(rbDinheiro);
		grpRadioFormaPagamento.add(rbCheque);
		grpRadioFormaPagamento.add(rbDebito);
		grpRadioFormaPagamento.add(rbDebito);
		
		/*
		 * Configurações dos JTextField
		 * */
		
		//Instanciando o TextField Valor total
		tfValorTotal = new JTextField();
				
		//Configurando a posição e o tamanho
		tfValorTotal.setBounds(480,300,150,25);
		
		//Instanciando o TextField Valor pago
		tfValorPago = new JTextField();
						
		//Configurando a posição e o tamanho
		tfValorPago.setBounds(480,330,150,25);
		
		//Instanciando o TextField troco
		tfTroco = new JTextField();
						
		//Configurando a posição e o tamanho
		tfTroco.setBounds(480,360,150,25);
		
		/*
		 * Configurações dos JButtons 
		 * */
		
		//Instanciando o Botão Salvar		
		btSalvar = new JButton();
				
		//Configurando o texto interno do botão Salvar
		btSalvar.setText("SALVAR");
				
		//Configurando o tamanho e a posição do botão Salvar
		btSalvar.setBounds(230,420,155,30);
		
		//Instanciando o Botão Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do botão Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posição do botão Cancelar
		btCancelar.setBounds(385,420,155,30);
		
		/*
		 * Configurações do JPanel
		 * */
		
		//Instanciando o painel principal
		painelPrincipal = (JPanel) janelaLocacaoFilme.getContentPane();
						
		//Configurando o layout inicial
		painelPrincipal.setLayout(null);	
		
		//Adicionando os componentes no painel principal
		painelPrincipal.add(lbNomeVendedor);
		painelPrincipal.add(cbxNomeVendedor);
		painelPrincipal.add(lbNomeFilme);
		painelPrincipal.add(cbxNomeFilme);
		painelPrincipal.add(btIncluir);
		painelPrincipal.add(scroll);
		painelPrincipal.add(lbFormaPagamento);
		painelPrincipal.add(rbDinheiro);
		painelPrincipal.add(rbCheque);
		painelPrincipal.add(rbDebito);
		painelPrincipal.add(rbCredito);
		painelPrincipal.add(lbValorTotal);
		painelPrincipal.add(tfValorTotal);
		painelPrincipal.add(lbValorPago);
		painelPrincipal.add(tfValorPago);		
		painelPrincipal.add(lbTroco);
		painelPrincipal.add(tfTroco);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);
		
		
		
		//configurando a visibilidade da tela
		janelaLocacaoFilme.setVisible(true);
	}//fim do método
	
}//fim da classe

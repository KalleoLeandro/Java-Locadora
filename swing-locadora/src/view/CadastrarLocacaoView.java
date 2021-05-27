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
 * Classe respons�vel por armazenar as telas e componentes do processo de loca��o de filme
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class CadastrarLocacaoView 
{//inicio da classe

	/*
	 * Declara��o dos atributos
	 */
	
	//Declara��o do JFrame - janela
	private JFrame janelaLocacaoFilme;
	
	//Declara��o das JLabel para exibir os r�tulos na tela
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;	
	private JLabel lbFormaPagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	
	//Declara��o do JTable - tabela para exibir os registros
	private JTable tabela;
		
	//Declara��o do JScrollPane - para exibir os registros que ultrapassarem o limite da area da tabela
	private JScrollPane scroll;
	
	//Declara��o dos JButtons para permitir as a��es pr�-definidas na tela
	private JButton btIncluir;
	private JButton btSalvar;
	private JButton btCancelar;
	
	//Declara��o de JComboBox
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNomeVendedor;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxNomeFilme;
	
	//Declara��o dos JTextField para exibir os campos de preenchimento na tela
	private JTextField tfValorTotal;
	private JTextField tfValorPago;
	private JTextField tfTroco;
	
	//Declara��o dos JRadioButtons para exibir a sele��o �nica na tela
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
			
	//Declara��o do grupo de RadioButton(ButtonGroup, respons�vel por gerenciar os componentes radio button)
	private ButtonGroup grpRadioFormaPagamento;
	
	
	//Declara��do do JPanel para organizar os elementos na tela
	private JPanel painelPrincipal;
	
	//Vetor auxiliar para armazenar os nomes das colunas
	private String colunastabela [] = {"C�digo", "Nome", "Valor", "Dispon�vel", "Promo��o", "Valor Promocional","G�nero"};
	private String linhastabela[][] = {};
	
	//vetor auxiliar para armazenar os nomes dos vendedores
	private String vendedores[] = {"-Selecione um Vendedor-","Kalleo Leandro dos Santos Leal"};
	
	//vetor auxiliar para armazenar os estados
	private String filmes[] = {"-Selecione um Filme-","A Hora do Pesadelo"};
	
	
	/*
	 * M�todo gerador de tela
	 * */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void iniciaGui()
	{//inicio do metodo
		
		//inicio do m�todo
		
		/*
		 * Configura��es da Frame
		 * */
		
		//Instanciando a Tela
		janelaLocacaoFilme = new JFrame();
				
		//Configurando o t�tulo da tela
		janelaLocacaoFilme.setTitle("LOCA��O DE FILME");
			
		//Configurando o tamanho da tela - largura/altura
		janelaLocacaoFilme.setSize(800,505);
		//Configurando a a��o do fechar(X) do JFrame
		janelaLocacaoFilme.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posi��o inicial da tela - centralizada
		janelaLocacaoFilme.setLocationRelativeTo(null);
		
		/*
		 * Configura��es dos JLabels
		 * */
		
		//Instanciando o label nome do vendedor
		lbNomeVendedor = new JLabel();
						
		//Configurando o texto inicial
		lbNomeVendedor.setText("Nome do Vendedor:");
		
		//Configurando o tamanho e a posi��o do label nome do vendedor
		lbNomeVendedor.setBounds(20,30,110,30);
		
		//Instanciando o label nome do filme
		lbNomeFilme = new JLabel();
		
		//Configurando o texto inicial
		lbNomeFilme.setText("Nome do Filme:");
		
		//Configurando o tamanho e a posi��o do label nome do filme
		lbNomeFilme.setBounds(20,60,100,30);
		
		//Instanciando o label Forma de pagamento
		lbFormaPagamento = new JLabel();
		
		//Configurando o texto inicial
		lbFormaPagamento.setText("Forma de pagamento:");
		
		//Configurando o tamanho e a posi��o do label forma de pagamento
		lbFormaPagamento.setBounds(20,300,150,25);
		
		//Instanciando o label Valor total
		lbValorTotal = new JLabel();
		
		//Configurando o texto inicial
		lbValorTotal.setText("Valor Total:");
		
		//Configurando o tamanho e a posi��o do label Valor total
		lbValorTotal.setBounds(380,300,150,25);
		
		//Instanciando o label Valor pago
		lbValorPago = new JLabel();
		
		//Configurando o texto inicial
		lbValorPago.setText("Valor Pago:");
		
		//Configurando o tamanho e a posi��o do label Valor pago
		lbValorPago.setBounds(380,330,150,25);
		
		//Instanciando o label Troco
		lbTroco = new JLabel();
		
		//Configurando o texto inicial
		lbTroco.setText("Troco:");
		
		//Configurando o tamanho e a posi��o do label Troco
		lbTroco.setBounds(380,360,150,25);
		
		/*
		 * configura��es do JComboBox
		 * */
		
		//Instanciando o Combo Box Nome Vendedor 
		cbxNomeVendedor = new JComboBox (vendedores);

		//Configurando o tamanho e a posi��o
		cbxNomeVendedor.setBounds(150,30,600,30);
		
		//Instanciando o Combo Box Nome Filme
		cbxNomeFilme = new JComboBox (filmes);
		
		//Configurando o tamanho e a posi��o
		cbxNomeFilme.setBounds(150,65,400,30);
		
		/*
		 * Configura��es do JButton Incluir 
		 * */
		
		//Instanciando o Bot�o Salvar		
		btIncluir = new JButton();
				
		//Configurando o texto interno do bot�o Salvar
		btIncluir.setText("INCLUIR");
				
		//Configurando o tamanho e a posi��o do bot�o Salvar
		btIncluir.setBounds(565,65,185,30);
		
		/*
		 * Configura��es do JTable
		 * */
		
		//Defini��o da raz�o da matriz da tabela
		DefaultTableModel modelo =  new DefaultTableModel(linhastabela, colunastabela);
		
		//Instanciando a tabela
		tabela = new JTable(modelo);
		
		//Configurar a posi��o e tamanho
		tabela.setBounds(1,125,750,150);
		
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
		scroll.setBounds(1,145,782,150);
		
		/*
		 * Configura��es do JRadioButton
		 * */
		
		rbDinheiro = new JRadioButton();
		rbCheque = new JRadioButton();
		rbDebito = new JRadioButton();
		rbCredito = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbDinheiro.setText("Dinheiro");	
		rbCheque.setText("Cheque");
		rbDebito.setText("D�bito");
		rbCredito.setText("Cr�dito");
		
		//Configurando a posi��o inicial
		rbDinheiro.setBounds(170,300,80,25);
		rbCheque.setBounds(170,325,80,25);
		rbDebito.setBounds(170,350,80,25);
		rbCredito.setBounds(170,375,80,25);
		
		/*
		 * Configura��es do Button Group
		 * */
		
		grpRadioFormaPagamento = new ButtonGroup();
		
		//Adicionando os elementos ao RadioButtonGroup
		grpRadioFormaPagamento.add(rbDinheiro);
		grpRadioFormaPagamento.add(rbCheque);
		grpRadioFormaPagamento.add(rbDebito);
		grpRadioFormaPagamento.add(rbDebito);
		
		/*
		 * Configura��es dos JTextField
		 * */
		
		//Instanciando o TextField Valor total
		tfValorTotal = new JTextField();
				
		//Configurando a posi��o e o tamanho
		tfValorTotal.setBounds(480,300,150,25);
		
		//Instanciando o TextField Valor pago
		tfValorPago = new JTextField();
						
		//Configurando a posi��o e o tamanho
		tfValorPago.setBounds(480,330,150,25);
		
		//Instanciando o TextField troco
		tfTroco = new JTextField();
						
		//Configurando a posi��o e o tamanho
		tfTroco.setBounds(480,360,150,25);
		
		/*
		 * Configura��es dos JButtons 
		 * */
		
		//Instanciando o Bot�o Salvar		
		btSalvar = new JButton();
				
		//Configurando o texto interno do bot�o Salvar
		btSalvar.setText("SALVAR");
				
		//Configurando o tamanho e a posi��o do bot�o Salvar
		btSalvar.setBounds(230,420,155,30);
		
		//Instanciando o Bot�o Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do bot�o Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posi��o do bot�o Cancelar
		btCancelar.setBounds(385,420,155,30);
		
		/*
		 * Configura��es do JPanel
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
	}//fim do m�todo
	
}//fim da classe

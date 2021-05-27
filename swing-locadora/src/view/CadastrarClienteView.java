
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por armazenar as telas e componentes do processo de cadastro de cliente 
 * @author Kalleo Leandro dos Santos Leal
 * @since 05/03/2021
 * @version 1.0
 */

public class CadastrarClienteView 
{//inicio da classe		
	
	/*
	 * Declara��o dos atributos
	 */
	
	//Declara��o do JFrame - janela
	private JFrame janelaCadastroCliente;
		
	//Declara��o das JLabel para exibir os r�tulos na tela	
	private JLabel lbDadosPessoais;	
	private JLabel lbEndereco;	
	private JLabel lbCodigo;	
	private JLabel lbNome;
	private JLabel lbLogradouro;	
	private JLabel lbNomeRua;	
	private JLabel lbNumero;	
	private JLabel lbComplemento;	
	private JLabel lbBairro;	
	private JLabel lbCidade;	
	private JLabel lbEstado;	
	private JLabel lbCep;	
	private JLabel lbCpf;	
	private JLabel lbRg;	
	private JLabel lbDataNascimento;	
	private JLabel lbIdade;
	private JLabel lbSexo;
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	
	//Declara��o dos JTextField para preenchimento dos campos
	private JTextField tfCodigo;
	private JTextField tfNome;	
	private JTextField tfNomeRua;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;	
	private JTextField tfIdade;
	private JTextField tfEmail;
	
	
	//Declara��o de campos formatados	
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
		
	//Declara��o dos atributos de formata��o de TextField
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	
	//Declara��o dos JRadioButtons para exibir a sele��o �nica na tela
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
		
	//Declara��o do grupo de RadioButton(ButtonGroup, respons�vel por gerenciar os componentes radio button)
	private ButtonGroup grpRadioSexo;
	
	//Declara��o dos JButtons para permitir as a��es pr�-definidas na tela
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	
	//Declara��o de JComboBox
	@SuppressWarnings("rawtypes")
	private JComboBox cbxEstados;	
	@SuppressWarnings("rawtypes")
	private JComboBox cbxLogradouro;
	
	//vetor auxiliar para armazenar os estados
	private String estados[] = {};
	private String logradouros[] = {"-Selecione-","Alameda","Avenida","Cal�ada","Ch�cara","Conjunto", "Estrada","Loteamento","Pra�a",
									"Parque","Rua","Residencial","S�tio","Travessa"};
	
	//Declara��do do JPanel para organizar os elementos na tela	
	private JPanel painelPrincipal;
	
	
	/*
	 * M�todo gerador de tela
	 * */	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void iniciaGui() throws ParseException
	{//inicio do metodo
		
		/*
		 * Configura��es dos campos de formata��o
		 * */
		
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("#.###.###-#");
		fmtCep = new MaskFormatter("#####-###");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##)# ####-####");
		
		/*
		 * Configuran��o de formata��o 
		 * */
		
		Font title = new Font("Arial", 0, 18);		
		
		//Fun��o para mudar as propriedades de fonte do JoptionPane
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier", Font.PLAIN, 18)));		
		
		//Fun��o para mudar o texto do ConfirmDialog
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "N�o");
		UIManager.put("OptionPane.okButtonText", "Ok");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		/*
		 * Configura��es da Frame
		 * */
		
		//Instanciando a Tela
		janelaCadastroCliente = new JFrame();
				
		//Configurando o t�tulo da tela
		janelaCadastroCliente.setTitle("CADASTRO DE CLIENTE");
			
		//Configurando o tamanho da tela - largura/altura
		janelaCadastroCliente.setSize(900,400);
		
		//Configurando a a��o do fechar(X) do JFrame
		janelaCadastroCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posi��o inicial da tela - centralizada
		janelaCadastroCliente.setLocationRelativeTo(null);
			
		//Configurando a posi��o inicial da tela - centralizada
		janelaCadastroCliente.setLocationRelativeTo(null);
		
		
		
		/*
		 * Configura��es dos JLabels
		 * */
		//Labels de Dados Pessoais
		//Instanciando o label Dados Pessoais
		lbDadosPessoais = new JLabel();
						
		//Configurando o texto inicial
		lbDadosPessoais.setText("Dados Pessoais");
		
		//Configurando a fonte e estilo do label Dados Pessoais
		lbDadosPessoais.setFont(title);
		
		//Configurando o tamanho e a posi��o
		lbDadosPessoais.setBounds(10,5,250,25);
		
		//Instanciando o label codigo
		lbCodigo = new JLabel();
				
		//Configurando o texto inicial
		lbCodigo.setText("C�digo: ");
				
		//Configurando o tamanho e a posi��o
		lbCodigo.setBounds(10,35,50,25);

		//Instanciando o label nome
		lbNome = new JLabel();
		
		//Configurando o texto inicial
		lbNome.setText("Nome: ");
		
		//Configurando o tamanho e a posi��o
		lbNome.setBounds(200,35,50,25);
		
		//Instanciando o label idade
		lbIdade = new JLabel();
		
		//Configurando o texto inicial
		lbIdade.setText("Idade: ");
		
		//Configurando o tamanho e a posi��o
		lbIdade.setBounds(610,70,50,25);
		
		//Instanciando o label Data de Nascimento
		lbDataNascimento = new JLabel();
		
		//Configurando o texto inicial
		lbDataNascimento.setText("Data de Nascimento: ");
		
		//Configurando o tamanho e a posi��o
		lbDataNascimento.setBounds(10,70,120,25);
		
		//Instanciando o label Cpf
		lbCpf = new JLabel();
		
		//Configurando o texto inicial
		lbCpf.setText("CPF: ");
		
		//Configurando o tamanho e a posi��o
		lbCpf.setBounds(250,70,50,25);
		
		//Instanciando o label Rg
		lbRg = new JLabel();
		
		//Configurando o texto inicial
		lbRg.setText("RG: ");
		
		//Configurando o tamanho e a posi��o
		lbRg.setBounds(425,70,50,25);
		
		//Instanciando o label Sexo
		lbSexo = new JLabel();
		
		//Configurando o texto inicial
		lbSexo.setText("Sexo: ");
		
		//Configurando o tamanho e a posi��o
		lbSexo.setBounds(10,100,50,25);
		
		//Instanciando o label Telefone
		lbTelefone = new JLabel();
		
		//Configurando o texto inicial
		lbTelefone.setText("Telefone: ");
		
		//Configurando o tamanho e a posi��o
		lbTelefone.setBounds(10,130,60,25);
		
		//Instanciando o label Celular
		lbCelular = new JLabel();
		
		//Configurando o texto inicial
		lbCelular.setText("Celular: ");
		
		//Configurando o tamanho e a posi��o
		lbCelular.setBounds(255,130,60,25);		
		
		//Instanciando o label Email
		lbEmail = new JLabel();
		
		//Configurando o texto inicial
		lbEmail.setText("Email: ");
		
		//Configurando o tamanho e a posi��o
		lbEmail.setBounds(440,130,60,25);		
		
		
		//Labels de Endere�o
		//Instanciando o label Endere�o
		lbEndereco = new JLabel();
								
		//Configurando o texto inicial
		lbEndereco.setText("Endereco");
				
		//Configurando a fonte e estilo do label Endere�o
		lbEndereco.setFont(title);
				
		//Configurando o tamanho e a posi��o
		lbEndereco.setBounds(10,185,250,25);
		
		//Labels de Endere�o
		//Instanciando o label Logradouro
		lbLogradouro = new JLabel();
		
		//Configurando o texto inicial
		lbLogradouro.setText("Logradouro: ");
		
		//Configurando o tamanho e a posi��o
		lbLogradouro.setBounds(10,215,90,25);	
		
		//Instanciando o label Nome Rua
		lbNomeRua = new JLabel();
		
		//Configurando o texto inicial
		lbNomeRua.setText("Via: ");
		
		//Configurando o tamanho e a posi��o
		lbNomeRua.setBounds(250,215,40,25);	
		
		//Instanciando o label Numero
		lbNumero = new JLabel();
		
		//Configurando o texto inicial
		lbNumero.setText("N�: ");
		
		//Configurando o tamanho e a posi��o
		lbNumero.setBounds(550,215,20,25);	
		
		//Instanciando o label Complemento
		lbComplemento = new JLabel();
		
		//Configurando o texto inicial
		lbComplemento.setText("Complemento: ");
		
		//Configurando o tamanho e a posi��o
		lbComplemento.setBounds(640,215,90,25);	
		
		//Instanciando o label Bairro
		lbBairro = new JLabel();
		
		//Configurando o texto inicial
		lbBairro.setText("Bairro: ");
		
		//Configurando o tamanho e a posi��o
		lbBairro.setBounds(10,245,50,25);	
		
		//Instanciando o label Cidade
		lbCidade = new JLabel();
		
		//Configurando o texto inicial
		lbCidade.setText("Cidade: ");
		
		//Configurando o tamanho e a posi��o
		lbCidade.setBounds(300,245,50,25);
		
		//Instanciando o label Estado
		lbEstado = new JLabel();
		
		//Configurando o texto inicial
		lbEstado.setText("Estado: ");
		
		//Configurando o tamanho e a posi��o
		lbEstado.setBounds(570,245,50,25);	
		
		//Instanciando o label Cep
		lbCep = new JLabel();
		
		//Configurando o texto inicial
		lbCep.setText("CEP: ");
		
		//Configurando o tamanho e a posi��o
		lbCep.setBounds(750,245,40,25);	
		
		/*
		 * Configura��es dos JTextFields
		 * */
		
		//Instanciando o TextField codigo
		tfCodigo = new JTextField();
								
		//Configurando a posi��o e o tamanho
		tfCodigo.setBounds(140,35,50,25);

		//Instanciando o TextField codigo
		tfNome = new JTextField();
		
		//Configurando a posi��o e o tamanho
		tfNome.setBounds(260,35,610,25);
		
		//Instanciando o TextField codigo
		tfIdade = new JTextField();
		
		//Configurando a posi��o e o tamanho
		tfIdade.setBounds(670,70,200,25);
		
		//Instanciando o TextField Data de Nascimento
		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);		
		
		//Configurando a posi��o e o tamanho
		tfDataNascimento.setBounds(140,70,100,25);
		
		//Instanciando o TextField Cpf
		tfCpf = new JFormattedTextField(fmtCpf);		
		
		//Configurando a posi��o e o tamanho
		tfCpf.setBounds(310,70,105,25);
		
		//Instanciando o TextField Rg
		tfRg = new JFormattedTextField(fmtRg);		
		
		//Configurando a posi��o e o tamanho
		tfRg.setBounds(485,70,105,25);
		
		//Instanciando o TextField Telefone
		tfTelefone = new JFormattedTextField(fmtTelefone);		
		
		//Configurando a posi��o e o tamanho
		tfTelefone.setBounds(140,130,105,25);
		
		//Instanciando o TextField Celular
		tfCelular = new JFormattedTextField(fmtCelular);		
		
		//Configurando a posi��o e o tamanho
		tfCelular.setBounds(325,130,105,25);

		//Instanciando o TextField Email
		tfEmail = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfEmail.setBounds(510,130,360,25);
		
		//TextFields de Endere�o		
		
		//Instanciando o TextField Nome da Rua
		tfNomeRua = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfNomeRua.setBounds(290,215,250,25);
		
		//Instanciando o TextField Numero
		tfNumero = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfNumero.setBounds(580,215,50,25);
		
		//Instanciando o TextField Complemento
		tfComplemento = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfComplemento.setBounds(740,215,130,25);
		
		//Instanciando o TextField Bairro
		tfBairro = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfBairro.setBounds(140,245,150,25);
		
		//Instanciando o TextField Cidade
		tfCidade = new JTextField();		
		
		//Configurando a posi��o e o tamanho
		tfCidade.setBounds(360,245,190,25);
		
		//Instanciando o TextField Cep
		tfCep = new JFormattedTextField(fmtCep);	
		
		//Configurando a posi��o e o tamanho
		tfCep.setBounds(800,245,70,25);
		
		/*
		 * configura��es do JComboBox
		 * */
		
		//Instanciando o Combo Box estados
		cbxEstados = new JComboBox (estados);

		//Configurando o tamanho e a posi��o
		cbxEstados.setBounds(620,245,120,25);
		
		//Instanciando o TextField Logradouro
		cbxLogradouro = new JComboBox(logradouros);	
				
		//Configurando a posi��o e o tamanho
		cbxLogradouro.setBounds(140,215,100,25);
		
		/*
		 * Configura��es dos RadioButtons
		 * */
		
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbMasculino.setText("Masculino");	
		rbFeminino.setText("Feminino");
		
		//Configurando a posi��o inicial
		rbMasculino.setBounds(140,100,80,25);
		rbFeminino.setBounds(230,100,80,25);
		
		/*
		 * Configura��es do Button Group
		 * */
		
		grpRadioSexo = new ButtonGroup();
		
		//Adicionando os elementos ao RadioButtonGroup
		grpRadioSexo.add(rbMasculino);
		grpRadioSexo.add(rbFeminino);
		
		/*
		 * Configura��es dos JButtons 
		 * */
		
		//Instanciando o Bot�o Salvar		
		btSalvar = new JButton();
				
		//Configurando o texto interno do bot�o Salvar
		btSalvar.setText("SALVAR");
				
		//Configurando o tamanho e a posi��o do bot�o Salvar
		btSalvar.setBounds(200,300,155,30);
		
		//Instanciando o Bot�o Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do bot�o Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posi��o do bot�o Cancelar
		btCancelar.setBounds(400,300,155,30);
		
		//Instanciando o Bot�o Novo		
		btNovo = new JButton();
						
		//Configurando o texto interno do bot�o Novo
		btNovo.setText("NOVO");
						
		//Configurando o tamanho e a posi��o do bot�o Novo
		btNovo.setBounds(200,300,155,30);
				
		//Instanciando o Bot�o Sair		
		btSair = new JButton();
						
		//Configurando o texto interno do bot�o Sair
		btSair.setText("SAIR");
						
		//Configurando o tamanho e a posi��o do bot�o Sair
		btSair.setBounds(400,300,155,30);
		
		//Configurando as a��es dos bot�es
		
		btSalvar.addActionListener(new ActionListener() 
		{
					
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//M�todo para gravar um cliente
				salvar();
			}
		});
		
		btCancelar.addActionListener(new ActionListener() 
		{
					
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//M�todo para limpar os campos da tela				
				limparTela();
				
				//M�todo para bloquear os campos da tela
				bloquearTela();
				
			}
		});
				
		btNovo.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//M�todo para liberar os campos da tela			
				liberarTela();
				
			}
		});
		
		btSair.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Fecha a janela e mant�m o menu aberto
				janelaCadastroCliente.dispose();
			}
		});
		
		
		
		/*
		 * Configura��es do JPanel
		 * */	
		
		//Instanciando o painel principal		
		painelPrincipal = (JPanel) janelaCadastroCliente.getContentPane();
						
		//Configurando o layout inicial		
		painelPrincipal.setLayout(null);		
		
		//Adicionando os componentes no painel Dados pessoais
		painelPrincipal.add(lbDadosPessoais);
		painelPrincipal.add(lbCodigo);
		painelPrincipal.add(tfCodigo);
		painelPrincipal.add(lbNome);
		painelPrincipal.add(tfNome);
		painelPrincipal.add(lbIdade);
		painelPrincipal.add(tfIdade);
		painelPrincipal.add(lbDataNascimento);
		painelPrincipal.add(tfDataNascimento);
		painelPrincipal.add(lbCpf);
		painelPrincipal.add(tfCpf);		
		painelPrincipal.add(lbRg);		
		painelPrincipal.add(tfRg);
		painelPrincipal.add(lbSexo);
		painelPrincipal.add(rbMasculino);
		painelPrincipal.add(rbFeminino);
		painelPrincipal.add(lbTelefone);
		painelPrincipal.add(tfTelefone);
		painelPrincipal.add(lbCelular);
		painelPrincipal.add(tfCelular);
		painelPrincipal.add(lbEmail);
		painelPrincipal.add(tfEmail);
		painelPrincipal.add(lbEndereco);		
		painelPrincipal.add(lbLogradouro);		
		painelPrincipal.add(cbxLogradouro);		
		painelPrincipal.add(lbNomeRua);		
		painelPrincipal.add(tfNomeRua);		
		painelPrincipal.add(lbNumero);		
		painelPrincipal.add(tfNumero);		
		painelPrincipal.add(lbComplemento);		
		painelPrincipal.add(tfComplemento);		
		painelPrincipal.add(lbBairro);		
		painelPrincipal.add(tfBairro);		
		painelPrincipal.add(lbCidade);		
		painelPrincipal.add(tfCidade);		
		painelPrincipal.add(lbEstado);		
		painelPrincipal.add(cbxEstados);	
		painelPrincipal.add(lbCep);	
		painelPrincipal.add(tfCep);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);		
		painelPrincipal.add(btNovo);		
		painelPrincipal.add(btSair);		
		
		//Chamando m�todo para carregar a combo de estados
		carregaComboEstados();
				
		//configurando a visibilidade da tela
		bloquearTela();		
		janelaCadastroCliente.setVisible(true);		
		
	}//fim do m�todo
	
	/*
	 * M�todo para bloquear a tela de cadastro
	 * */
	
	private void bloquearTela()
	{//inicio do m�todo	
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfCpf.setEditable(false);
		tfRg.setEditable(false);
		tfTelefone.setEditable(false);
		tfCelular.setEditable(false);
		tfEmail.setEditable(false);
		tfDataNascimento.setEditable(false);
		cbxLogradouro.setEnabled(false);
		tfNomeRua.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		tfBairro.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		tfIdade.setEditable(false);		
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}//fim do m�todo
	
	/*
	 * M�todo para liberar os campos da tela de cadastro
	 * */
	
	private void liberarTela()
	{//inicio do m�todo
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfCpf.setEditable(true);
		tfRg.setEditable(true);
		tfTelefone.setEditable(true);
		tfCelular.setEditable(true);
		tfEmail.setEditable(true);
		tfDataNascimento.setEditable(true);
		cbxLogradouro.setEnabled(true);
		tfNomeRua.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		tfBairro.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);		
		rbMasculino.setEnabled(true);
		rbFeminino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}//fim do m�todo
	
	/*
	 * M�todo para limpar os campos da tela de cadastro
	 * */
	
	private void limparTela()
	{//inicio do m�todo
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfCpf.setText(null);
		tfRg.setText(null);
		tfTelefone.setText(null);
		tfCelular.setText(null);
		tfEmail.setText(null);
		tfDataNascimento.setText(null);
		cbxLogradouro.setSelectedIndex(0);
		tfNomeRua.setText(null);
		tfNumero.setText(null);
		tfComplemento.setText(null);
		tfBairro.setText(null);
		tfCidade.setText(null);		
		tfIdade.setText(null);		
		grpRadioSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);		
	}//fim do m�todo
	
	/*
	 * M�todo para preencher a combo de estados
	 * */
	
	@SuppressWarnings("unchecked")
	private void carregaComboEstados()
	{
		//Valor inicial da combo
		cbxEstados.addItem("-Selecione UF-");
		
		//La�o de repeti��o para carregar a combo de estados
		for(Estado estado : new EstadoController().getEstados())
		{
			cbxEstados.addItem(estado.getNome());
		}
	}
	
	/*
	 * M�todo para receber a��o do clique salvar 
	 * */
	
	public void salvar()
	{//inicio do m�todo
		
		//Salvar o vendedor apenas se estiver v�lido todos os dados
		if(validar())
		{
			/*
			 * Procedimentos de grava��o do objeto Vendedor no arquivo TXT
			 */
			
			//Instanciando o objeto a ser enviado para o m�todo de grava��o 
			Cliente cliente = getCliente();
			
			//Chamando o m�todo respons�vel por gravar o arquivo TXT
			new ClienteController().gravarTxtCliente(cliente);
			
			//Limpar a tela preenchida
			limparTela();
			
			//Bloquear a tela
			bloquearTela();
			
			//Exibindo mensagem de sucesso para o usu�rio
			JOptionPane.showMessageDialog(null,Mensagem.clienteGravado,Titulo.cadastroCliente,JOptionPane.INFORMATION_MESSAGE);
		}		
	}//fim do m�todo
	
	
	/*
	 * M�todo para validar os campos do cadastro de vendedor
	 * */
	
	private boolean validar()
	{//inicio do m�todo
		//Validando o campo c�digo
		if(Valida.isEmptyOrNull(tfCodigo.getText()))
		{
			//Informando o usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		} 
		else if(!Valida.isInteger(tfCodigo.getText()))
		{
			//Informando o usu�rio que o c�digo est� preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		}
		
		//Validando o campo nome
		if(Valida.isEmptyOrNull(tfNome.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNome.grabFocus();
			return false;
		}
		
		//Validando o campo cpf
		if(Valida.formatadoIsEmptyOrNull(tfCpf.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCpf.grabFocus();
			return false;
		}
		
		//Validando o campo rg
		if(Valida.formatadoIsEmptyOrNull(tfRg.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfRg.grabFocus();
			return false;
		}
		
		//Validando o campo Data de Nascimento	
		
		if(Valida.formatadoIsEmptyOrNull(tfDataNascimento.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.dataVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			return false;
		}
		
		//Validando o campo sexo		
		if(!rbMasculino.isSelected() && !rbFeminino.isSelected())
		{
			//Informando o usu�rio que o estado n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.sexoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo idade
		if(Valida.isEmptyOrNull(tfIdade.getText()))
		{
			//Informando o usu�rio que a idade n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		else if(!Valida.isInteger(tfIdade.getText()))
		{
			//Informando o usu�rio que a idade est� preenchida incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		
		//Validando o campo telefone
		if(Valida.formatadoIsEmptyOrNull(tfTelefone.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfTelefone.grabFocus();
			return false;
		}
		
		//Validando o campo celular
		if(Valida.formatadoIsEmptyOrNull(tfCelular.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCelular.grabFocus();
			return false;
		}
		
		//Validando o campo email
		if(Valida.isEmptyOrNull(tfEmail.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfEmail.grabFocus();
			return false;
		}
		
		//Validando o campo logradouro
		if (cbxLogradouro.getSelectedIndex() == 0) 
		{
			//Informando o usu�rio que o logradouro n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo nomeRua
		if(Valida.isEmptyOrNull(tfNomeRua.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeRuaVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNomeRua.grabFocus();
			return false;
		}
		
		//Validando o campo numero
		if(Valida.isEmptyOrNull(tfNumero.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNumero.grabFocus();
			return false;
		}else if(!Valida.isInteger(tfNumero.getText()))
		{
			//Informando o usu�rio que o c�digo est� preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNumero.grabFocus();
			return false;
		}
		
		//Validando o campo bairro
		if(Valida.isEmptyOrNull(tfBairro.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfBairro.grabFocus();
			return false;
		}
		
		//Validando o campo cidade
		if(Valida.isEmptyOrNull(tfCidade.getText()))
		{
			//Informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCidade.grabFocus();
			return false;
		}
		
		//Validando o campo estado
		if (cbxEstados.getSelectedIndex() == 0) 
		{
			//Informando o usu�rio que o logradouro n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}		
		
		//Devolvendo true caso esteja tudo valido
		return true;
	}//fim do m�todo
	
	/*
	 * m�todo para valorizar um objeto vendedor utilizando os campos da tela
	 * */
	private Cliente getCliente()
	{
		//Declara��o e instancia��o de objeto Cliente
		Cliente cliente = new Cliente();
		
		//Declara��o e instancia��o de objeto Endereco
		Endereco endereco = new Endereco();
		
		//Declara��o e instancia��o de objeto Data
		Data data = new Data();
				
		//Valorizando o objeto Cliente - parte 1
		cliente.setCodigo(Util.getInt(tfCodigo.getText()));		
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		cliente.setRg(tfRg.getText());
		
		//Valorizando o objeto Endereco
		endereco.setCodigo(Util.getInt(tfCodigo.getText()));
		endereco.setLogradouro(cbxLogradouro.getSelectedItem() + "");
		endereco.setNomeRua(tfNomeRua.getText());
		endereco.setNumero(Util.getInt(tfNumero.getText()));
		endereco.setComplemento(tfComplemento.getText());
		endereco.setBairro(tfBairro.getText());
		endereco.setCidade(tfCidade.getText());
		endereco.setEstado(cbxEstados.getSelectedItem() + "");
		
		cliente.setEndereco(endereco);
		
		//Valorizando o objeto Data
		
		String vetor[] = tfDataNascimento.getText().split("/");
		
		data.setDia(Integer.parseInt(vetor[0]));
		data.setMes(Integer.parseInt(vetor[1]));
		data.setAno(Integer.parseInt(vetor[2]));
		
		cliente.setDataNascimento(data);
		
		//Valorizando o objeto Cliente - parte 2
		cliente.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		cliente.setIdade(Integer.parseInt(tfIdade.getText()));
		cliente.setTelefone(tfTelefone.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setCelular(tfCelular.getText());		
		return cliente;
	}

}//fim da classe

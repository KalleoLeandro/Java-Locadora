
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
 * Classe responsável por armazenar as telas e componentes do processo de cadastro de cliente 
 * @author Kalleo Leandro dos Santos Leal
 * @since 05/03/2021
 * @version 1.0
 */

public class CadastrarClienteView 
{//inicio da classe		
	
	/*
	 * Declaração dos atributos
	 */
	
	//Declaração do JFrame - janela
	private JFrame janelaCadastroCliente;
		
	//Declaração das JLabel para exibir os rótulos na tela	
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
	
	//Declaração dos JTextField para preenchimento dos campos
	private JTextField tfCodigo;
	private JTextField tfNome;	
	private JTextField tfNomeRua;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;	
	private JTextField tfIdade;
	private JTextField tfEmail;
	
	
	//Declaração de campos formatados	
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
		
	//Declaração dos atributos de formatação de TextField
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	private MaskFormatter fmtCep;
	
	//Declaração dos JRadioButtons para exibir a seleção única na tela
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
		
	//Declaração do grupo de RadioButton(ButtonGroup, responsável por gerenciar os componentes radio button)
	private ButtonGroup grpRadioSexo;
	
	//Declaração dos JButtons para permitir as ações pré-definidas na tela
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	
	//Declaração de JComboBox
	@SuppressWarnings("rawtypes")
	private JComboBox cbxEstados;	
	@SuppressWarnings("rawtypes")
	private JComboBox cbxLogradouro;
	
	//vetor auxiliar para armazenar os estados
	private String estados[] = {};
	private String logradouros[] = {"-Selecione-","Alameda","Avenida","Calçada","Chácara","Conjunto", "Estrada","Loteamento","Praça",
									"Parque","Rua","Residencial","Sítio","Travessa"};
	
	//Declaraçãdo do JPanel para organizar os elementos na tela	
	private JPanel painelPrincipal;
	
	
	/*
	 * Método gerador de tela
	 * */	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void iniciaGui() throws ParseException
	{//inicio do metodo
		
		/*
		 * Configurações dos campos de formatação
		 * */
		
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("#.###.###-#");
		fmtCep = new MaskFormatter("#####-###");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##)# ####-####");
		
		/*
		 * Configuranção de formatação 
		 * */
		
		Font title = new Font("Arial", 0, 18);		
		
		//Função para mudar as propriedades de fonte do JoptionPane
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier", Font.PLAIN, 18)));		
		
		//Função para mudar o texto do ConfirmDialog
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.okButtonText", "Ok");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		/*
		 * Configurações da Frame
		 * */
		
		//Instanciando a Tela
		janelaCadastroCliente = new JFrame();
				
		//Configurando o título da tela
		janelaCadastroCliente.setTitle("CADASTRO DE CLIENTE");
			
		//Configurando o tamanho da tela - largura/altura
		janelaCadastroCliente.setSize(900,400);
		
		//Configurando a ação do fechar(X) do JFrame
		janelaCadastroCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroCliente.setLocationRelativeTo(null);
			
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroCliente.setLocationRelativeTo(null);
		
		
		
		/*
		 * Configurações dos JLabels
		 * */
		//Labels de Dados Pessoais
		//Instanciando o label Dados Pessoais
		lbDadosPessoais = new JLabel();
						
		//Configurando o texto inicial
		lbDadosPessoais.setText("Dados Pessoais");
		
		//Configurando a fonte e estilo do label Dados Pessoais
		lbDadosPessoais.setFont(title);
		
		//Configurando o tamanho e a posição
		lbDadosPessoais.setBounds(10,5,250,25);
		
		//Instanciando o label codigo
		lbCodigo = new JLabel();
				
		//Configurando o texto inicial
		lbCodigo.setText("Código: ");
				
		//Configurando o tamanho e a posição
		lbCodigo.setBounds(10,35,50,25);

		//Instanciando o label nome
		lbNome = new JLabel();
		
		//Configurando o texto inicial
		lbNome.setText("Nome: ");
		
		//Configurando o tamanho e a posição
		lbNome.setBounds(200,35,50,25);
		
		//Instanciando o label idade
		lbIdade = new JLabel();
		
		//Configurando o texto inicial
		lbIdade.setText("Idade: ");
		
		//Configurando o tamanho e a posição
		lbIdade.setBounds(610,70,50,25);
		
		//Instanciando o label Data de Nascimento
		lbDataNascimento = new JLabel();
		
		//Configurando o texto inicial
		lbDataNascimento.setText("Data de Nascimento: ");
		
		//Configurando o tamanho e a posição
		lbDataNascimento.setBounds(10,70,120,25);
		
		//Instanciando o label Cpf
		lbCpf = new JLabel();
		
		//Configurando o texto inicial
		lbCpf.setText("CPF: ");
		
		//Configurando o tamanho e a posição
		lbCpf.setBounds(250,70,50,25);
		
		//Instanciando o label Rg
		lbRg = new JLabel();
		
		//Configurando o texto inicial
		lbRg.setText("RG: ");
		
		//Configurando o tamanho e a posição
		lbRg.setBounds(425,70,50,25);
		
		//Instanciando o label Sexo
		lbSexo = new JLabel();
		
		//Configurando o texto inicial
		lbSexo.setText("Sexo: ");
		
		//Configurando o tamanho e a posição
		lbSexo.setBounds(10,100,50,25);
		
		//Instanciando o label Telefone
		lbTelefone = new JLabel();
		
		//Configurando o texto inicial
		lbTelefone.setText("Telefone: ");
		
		//Configurando o tamanho e a posição
		lbTelefone.setBounds(10,130,60,25);
		
		//Instanciando o label Celular
		lbCelular = new JLabel();
		
		//Configurando o texto inicial
		lbCelular.setText("Celular: ");
		
		//Configurando o tamanho e a posição
		lbCelular.setBounds(255,130,60,25);		
		
		//Instanciando o label Email
		lbEmail = new JLabel();
		
		//Configurando o texto inicial
		lbEmail.setText("Email: ");
		
		//Configurando o tamanho e a posição
		lbEmail.setBounds(440,130,60,25);		
		
		
		//Labels de Endereço
		//Instanciando o label Endereço
		lbEndereco = new JLabel();
								
		//Configurando o texto inicial
		lbEndereco.setText("Endereco");
				
		//Configurando a fonte e estilo do label Endereço
		lbEndereco.setFont(title);
				
		//Configurando o tamanho e a posição
		lbEndereco.setBounds(10,185,250,25);
		
		//Labels de Endereço
		//Instanciando o label Logradouro
		lbLogradouro = new JLabel();
		
		//Configurando o texto inicial
		lbLogradouro.setText("Logradouro: ");
		
		//Configurando o tamanho e a posição
		lbLogradouro.setBounds(10,215,90,25);	
		
		//Instanciando o label Nome Rua
		lbNomeRua = new JLabel();
		
		//Configurando o texto inicial
		lbNomeRua.setText("Via: ");
		
		//Configurando o tamanho e a posição
		lbNomeRua.setBounds(250,215,40,25);	
		
		//Instanciando o label Numero
		lbNumero = new JLabel();
		
		//Configurando o texto inicial
		lbNumero.setText("N°: ");
		
		//Configurando o tamanho e a posição
		lbNumero.setBounds(550,215,20,25);	
		
		//Instanciando o label Complemento
		lbComplemento = new JLabel();
		
		//Configurando o texto inicial
		lbComplemento.setText("Complemento: ");
		
		//Configurando o tamanho e a posição
		lbComplemento.setBounds(640,215,90,25);	
		
		//Instanciando o label Bairro
		lbBairro = new JLabel();
		
		//Configurando o texto inicial
		lbBairro.setText("Bairro: ");
		
		//Configurando o tamanho e a posição
		lbBairro.setBounds(10,245,50,25);	
		
		//Instanciando o label Cidade
		lbCidade = new JLabel();
		
		//Configurando o texto inicial
		lbCidade.setText("Cidade: ");
		
		//Configurando o tamanho e a posição
		lbCidade.setBounds(300,245,50,25);
		
		//Instanciando o label Estado
		lbEstado = new JLabel();
		
		//Configurando o texto inicial
		lbEstado.setText("Estado: ");
		
		//Configurando o tamanho e a posição
		lbEstado.setBounds(570,245,50,25);	
		
		//Instanciando o label Cep
		lbCep = new JLabel();
		
		//Configurando o texto inicial
		lbCep.setText("CEP: ");
		
		//Configurando o tamanho e a posição
		lbCep.setBounds(750,245,40,25);	
		
		/*
		 * Configurações dos JTextFields
		 * */
		
		//Instanciando o TextField codigo
		tfCodigo = new JTextField();
								
		//Configurando a posição e o tamanho
		tfCodigo.setBounds(140,35,50,25);

		//Instanciando o TextField codigo
		tfNome = new JTextField();
		
		//Configurando a posição e o tamanho
		tfNome.setBounds(260,35,610,25);
		
		//Instanciando o TextField codigo
		tfIdade = new JTextField();
		
		//Configurando a posição e o tamanho
		tfIdade.setBounds(670,70,200,25);
		
		//Instanciando o TextField Data de Nascimento
		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);		
		
		//Configurando a posição e o tamanho
		tfDataNascimento.setBounds(140,70,100,25);
		
		//Instanciando o TextField Cpf
		tfCpf = new JFormattedTextField(fmtCpf);		
		
		//Configurando a posição e o tamanho
		tfCpf.setBounds(310,70,105,25);
		
		//Instanciando o TextField Rg
		tfRg = new JFormattedTextField(fmtRg);		
		
		//Configurando a posição e o tamanho
		tfRg.setBounds(485,70,105,25);
		
		//Instanciando o TextField Telefone
		tfTelefone = new JFormattedTextField(fmtTelefone);		
		
		//Configurando a posição e o tamanho
		tfTelefone.setBounds(140,130,105,25);
		
		//Instanciando o TextField Celular
		tfCelular = new JFormattedTextField(fmtCelular);		
		
		//Configurando a posição e o tamanho
		tfCelular.setBounds(325,130,105,25);

		//Instanciando o TextField Email
		tfEmail = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfEmail.setBounds(510,130,360,25);
		
		//TextFields de Endereço		
		
		//Instanciando o TextField Nome da Rua
		tfNomeRua = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfNomeRua.setBounds(290,215,250,25);
		
		//Instanciando o TextField Numero
		tfNumero = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfNumero.setBounds(580,215,50,25);
		
		//Instanciando o TextField Complemento
		tfComplemento = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfComplemento.setBounds(740,215,130,25);
		
		//Instanciando o TextField Bairro
		tfBairro = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfBairro.setBounds(140,245,150,25);
		
		//Instanciando o TextField Cidade
		tfCidade = new JTextField();		
		
		//Configurando a posição e o tamanho
		tfCidade.setBounds(360,245,190,25);
		
		//Instanciando o TextField Cep
		tfCep = new JFormattedTextField(fmtCep);	
		
		//Configurando a posição e o tamanho
		tfCep.setBounds(800,245,70,25);
		
		/*
		 * configurações do JComboBox
		 * */
		
		//Instanciando o Combo Box estados
		cbxEstados = new JComboBox (estados);

		//Configurando o tamanho e a posição
		cbxEstados.setBounds(620,245,120,25);
		
		//Instanciando o TextField Logradouro
		cbxLogradouro = new JComboBox(logradouros);	
				
		//Configurando a posição e o tamanho
		cbxLogradouro.setBounds(140,215,100,25);
		
		/*
		 * Configurações dos RadioButtons
		 * */
		
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbMasculino.setText("Masculino");	
		rbFeminino.setText("Feminino");
		
		//Configurando a posição inicial
		rbMasculino.setBounds(140,100,80,25);
		rbFeminino.setBounds(230,100,80,25);
		
		/*
		 * Configurações do Button Group
		 * */
		
		grpRadioSexo = new ButtonGroup();
		
		//Adicionando os elementos ao RadioButtonGroup
		grpRadioSexo.add(rbMasculino);
		grpRadioSexo.add(rbFeminino);
		
		/*
		 * Configurações dos JButtons 
		 * */
		
		//Instanciando o Botão Salvar		
		btSalvar = new JButton();
				
		//Configurando o texto interno do botão Salvar
		btSalvar.setText("SALVAR");
				
		//Configurando o tamanho e a posição do botão Salvar
		btSalvar.setBounds(200,300,155,30);
		
		//Instanciando o Botão Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do botão Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posição do botão Cancelar
		btCancelar.setBounds(400,300,155,30);
		
		//Instanciando o Botão Novo		
		btNovo = new JButton();
						
		//Configurando o texto interno do botão Novo
		btNovo.setText("NOVO");
						
		//Configurando o tamanho e a posição do botão Novo
		btNovo.setBounds(200,300,155,30);
				
		//Instanciando o Botão Sair		
		btSair = new JButton();
						
		//Configurando o texto interno do botão Sair
		btSair.setText("SAIR");
						
		//Configurando o tamanho e a posição do botão Sair
		btSair.setBounds(400,300,155,30);
		
		//Configurando as ações dos botões
		
		btSalvar.addActionListener(new ActionListener() 
		{
					
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Método para gravar um cliente
				salvar();
			}
		});
		
		btCancelar.addActionListener(new ActionListener() 
		{
					
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Método para limpar os campos da tela				
				limparTela();
				
				//Método para bloquear os campos da tela
				bloquearTela();
				
			}
		});
				
		btNovo.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Método para liberar os campos da tela			
				liberarTela();
				
			}
		});
		
		btSair.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Fecha a janela e mantém o menu aberto
				janelaCadastroCliente.dispose();
			}
		});
		
		
		
		/*
		 * Configurações do JPanel
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
		
		//Chamando método para carregar a combo de estados
		carregaComboEstados();
				
		//configurando a visibilidade da tela
		bloquearTela();		
		janelaCadastroCliente.setVisible(true);		
		
	}//fim do método
	
	/*
	 * Método para bloquear a tela de cadastro
	 * */
	
	private void bloquearTela()
	{//inicio do método	
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
	}//fim do método
	
	/*
	 * Método para liberar os campos da tela de cadastro
	 * */
	
	private void liberarTela()
	{//inicio do método
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
	}//fim do método
	
	/*
	 * Método para limpar os campos da tela de cadastro
	 * */
	
	private void limparTela()
	{//inicio do método
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
	}//fim do método
	
	/*
	 * Método para preencher a combo de estados
	 * */
	
	@SuppressWarnings("unchecked")
	private void carregaComboEstados()
	{
		//Valor inicial da combo
		cbxEstados.addItem("-Selecione UF-");
		
		//Laço de repetição para carregar a combo de estados
		for(Estado estado : new EstadoController().getEstados())
		{
			cbxEstados.addItem(estado.getNome());
		}
	}
	
	/*
	 * Método para receber ação do clique salvar 
	 * */
	
	public void salvar()
	{//inicio do método
		
		//Salvar o vendedor apenas se estiver válido todos os dados
		if(validar())
		{
			/*
			 * Procedimentos de gravação do objeto Vendedor no arquivo TXT
			 */
			
			//Instanciando o objeto a ser enviado para o método de gravação 
			Cliente cliente = getCliente();
			
			//Chamando o método responsável por gravar o arquivo TXT
			new ClienteController().gravarTxtCliente(cliente);
			
			//Limpar a tela preenchida
			limparTela();
			
			//Bloquear a tela
			bloquearTela();
			
			//Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null,Mensagem.clienteGravado,Titulo.cadastroCliente,JOptionPane.INFORMATION_MESSAGE);
		}		
	}//fim do método
	
	
	/*
	 * Método para validar os campos do cadastro de vendedor
	 * */
	
	private boolean validar()
	{//inicio do método
		//Validando o campo código
		if(Valida.isEmptyOrNull(tfCodigo.getText()))
		{
			//Informando o usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		} 
		else if(!Valida.isInteger(tfCodigo.getText()))
		{
			//Informando o usuário que o código está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		}
		
		//Validando o campo nome
		if(Valida.isEmptyOrNull(tfNome.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNome.grabFocus();
			return false;
		}
		
		//Validando o campo cpf
		if(Valida.formatadoIsEmptyOrNull(tfCpf.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCpf.grabFocus();
			return false;
		}
		
		//Validando o campo rg
		if(Valida.formatadoIsEmptyOrNull(tfRg.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfRg.grabFocus();
			return false;
		}
		
		//Validando o campo Data de Nascimento	
		
		if(Valida.formatadoIsEmptyOrNull(tfDataNascimento.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.dataVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			return false;
		}
		
		//Validando o campo sexo		
		if(!rbMasculino.isSelected() && !rbFeminino.isSelected())
		{
			//Informando o usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.sexoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo idade
		if(Valida.isEmptyOrNull(tfIdade.getText()))
		{
			//Informando o usuário que a idade não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		else if(!Valida.isInteger(tfIdade.getText()))
		{
			//Informando o usuário que a idade está preenchida incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		
		//Validando o campo telefone
		if(Valida.formatadoIsEmptyOrNull(tfTelefone.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfTelefone.grabFocus();
			return false;
		}
		
		//Validando o campo celular
		if(Valida.formatadoIsEmptyOrNull(tfCelular.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCelular.grabFocus();
			return false;
		}
		
		//Validando o campo email
		if(Valida.isEmptyOrNull(tfEmail.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfEmail.grabFocus();
			return false;
		}
		
		//Validando o campo logradouro
		if (cbxLogradouro.getSelectedIndex() == 0) 
		{
			//Informando o usuário que o logradouro não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo nomeRua
		if(Valida.isEmptyOrNull(tfNomeRua.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeRuaVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNomeRua.grabFocus();
			return false;
		}
		
		//Validando o campo numero
		if(Valida.isEmptyOrNull(tfNumero.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNumero.grabFocus();
			return false;
		}else if(!Valida.isInteger(tfNumero.getText()))
		{
			//Informando o usuário que o código está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNumero.grabFocus();
			return false;
		}
		
		//Validando o campo bairro
		if(Valida.isEmptyOrNull(tfBairro.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfBairro.grabFocus();
			return false;
		}
		
		//Validando o campo cidade
		if(Valida.isEmptyOrNull(tfCidade.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCidade.grabFocus();
			return false;
		}
		
		//Validando o campo estado
		if (cbxEstados.getSelectedIndex() == 0) 
		{
			//Informando o usuário que o logradouro não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio,Titulo.cadastroCliente, JOptionPane.ERROR_MESSAGE);			
			return false;
		}		
		
		//Devolvendo true caso esteja tudo valido
		return true;
	}//fim do método
	
	/*
	 * método para valorizar um objeto vendedor utilizando os campos da tela
	 * */
	private Cliente getCliente()
	{
		//Declaração e instanciação de objeto Cliente
		Cliente cliente = new Cliente();
		
		//Declaração e instanciação de objeto Endereco
		Endereco endereco = new Endereco();
		
		//Declaração e instanciação de objeto Data
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

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EstadoController;
import controller.VendedorController;
import model.Estado;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por armazenar as telas e componentes do processo de cadastro de vendedor
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class CadastrarVendedorView
{//inicio da classe
		
	/*
	 * Declaração dos atributos
	 */
		
	//Declaração do JFrame - janela
	private JFrame janelaCadastroVendedor;
	
	//Declaração das JLabel para exibir os rótulos na tela
	private JLabel lbCodigo;
	private JLabel lbNome;	
	private JLabel lbAreaVenda;	
	private JLabel lbCidade;	
	private JLabel lbEstado;	
	private JLabel lbSexo;	
	private JLabel lbIdade;	
	private JLabel lbSalario;
	
	//Declaração de JComboBox
	@SuppressWarnings("rawtypes")
	private JComboBox cbxEstados;
	
	//Declaração dos JRadioButtons para exibir a seleção única na tela
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	
	//Declaração do grupo de RadioButton(ButtonGroup, responsável por gerenciar os componentes radio button)
	private ButtonGroup grpRadioSexo;
	
	//Declaração dos JTextField para exibir os campos de preenchimento na tela
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfAreaVenda;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	
	//Declaração dos JButtons para permitir as ações pré-definidas na tela
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	
	
	//vetor auxiliar para armazenar os estados
	
	private String estados[] = {};
	
	//Declaraçãdo do JPanel para organizar os elementos na tela
	private JPanel painelPrincipal;
	
	
	/*
	 * Método gerador de tela
	 * */	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void iniciaGui()
	{//inicio do metodo
		
		//inicio do método
		
		/*
		 * Configurações da Frame
		 * */
		
		//Instanciando a Tela
		janelaCadastroVendedor = new JFrame();
				
		//Configurando o título da tela
		janelaCadastroVendedor.setTitle("CADASTRO DE VENDEDOR");
			
		//Configurando o tamanho da tela - largura/altura
		janelaCadastroVendedor.setSize(600,380);
		
		//Configurando a ação do fechar(X) do JFrame
		janelaCadastroVendedor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroVendedor.setLocationRelativeTo(null);
			
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroVendedor.setLocationRelativeTo(null);
		

		/*
		 * Configurações dos JLabels
		 * */
		
		//Instanciando o label codigo
		lbCodigo = new JLabel();
						
		//Configurando o texto inicial
		lbCodigo.setText("Código:");
		
		//Configurando o tamanho e a posição do label codigo
		lbCodigo.setBounds(20,10,70,25);
		
		//Instanciando o label nome
		lbNome = new JLabel();
				
		//Configurando o texto inicial
		lbNome.setText("Nome:");
				
		//Configurando o tamanho e a posição do label nome
		lbNome.setBounds(20,40,70,25);
		
		//Instanciando o label Area Venda
		lbAreaVenda = new JLabel();
		
		//Configurando o texto inicial
		lbAreaVenda.setText("Área de Venda:");
		
		//Configurando o tamanho e a posição do label Area Venda
		lbAreaVenda.setBounds(20,70,90,25);
		
		//Instanciando o label Cidade
		lbCidade = new JLabel();
		
		//Configurando o texto inicial
		lbCidade.setText("Cidade:");
		
		//Configurando o tamanho e a posição do label Estado
		lbCidade.setBounds(20,100,70,25);
		
		//Instanciando o label Estado
		lbEstado = new JLabel();
		
		//Configurando o texto inicial
		lbEstado.setText("Estado:");
		
		//Configurando o tamanho e a posição do label Estado
		lbEstado.setBounds(20,130,70,25);
		
		//Instanciando o label Sexo
		lbSexo = new JLabel();
		
		//Configurando o texto inicial
		lbSexo.setText("Sexo:");
		
		//Configurando o tamanho e a posição do label Sexo
		lbSexo.setBounds(20,160,70,25);
		
		//Instanciando o label Idade
		lbIdade = new JLabel();
		
		//Configurando o texto inicial
		lbIdade.setText("Idade:");
		
		//Configurando o tamanho e a posição do label Idade
		lbIdade.setBounds(20,190,70,25);
		
		//Instanciando o label Salario
		lbSalario = new JLabel();
		
		//Configurando o texto inicial
		lbSalario.setText("Salario:");
		
		//Configurando o tamanho e a posição do label Salario
		lbSalario.setBounds(20,220,70,25);
		
		
		
		/*
		 * Configurações dos JTextField
		 * */
		
		//Instanciando o TextField codigo
		tfCodigo = new JTextField();
						
		//Configurando a posição e o tamanho
		tfCodigo.setBounds(130,10,400,25);
		
		//Instanciando o TextField nome
		tfNome = new JTextField();
				
		//Configurando a posição e o tamanho
		tfNome.setBounds(130,40,400,25);
		
		//Instanciando o TextField AreaVenda
		tfAreaVenda = new JTextField();
						
		//Configurando a posição e o tamanho
		tfAreaVenda.setBounds(130,70,400,25);
		
		//Instanciando o TextField Cidade
		tfCidade = new JTextField();
		
		//Configurando a posição e o tamanho
		tfCidade.setBounds(130,100,400,25);

		//Instanciando o TextField Idade
		tfIdade = new JTextField();
		
		//Configurando a posição e o tamanho
		tfIdade.setBounds(130,190,400,25);
		
		//Instanciando o TextField Salario
		tfSalario = new JTextField();
		
		//Configurando a posição e o tamanho
		tfSalario.setBounds(130,220,400,25);
		
		/*
		 * configurações do JComboBox
		 * */
		
		//Instanciando o Combo Box
		cbxEstados = new JComboBox (estados);

		//Configurando o tamanho e a posição
		cbxEstados.setBounds(130,130,120,25);
		
		/*
		 * Configurações do JRadioButton
		 * */
		
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbMasculino.setText("Masculino");	
		rbFeminino.setText("Feminino");
		
		//Configurando a posição inicial
		rbMasculino.setBounds(130,160,80,25);
		rbFeminino.setBounds(220,160,80,25);
		
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
		btSalvar.setBounds(130,250,155,30);
		
		//Instanciando o Botão Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do botão Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posição do botão Cancelar
		btCancelar.setBounds(300,250,155,30);
		
		//Instanciando o Botão Novo
		btNovo = new JButton();
		
		//Configurando o texto interno do botão Novo
		btNovo.setText("NOVO");
		
		//Configurando o tamanho e a posição do botão Novo
		btNovo.setBounds(130,250,155,30);
		
		//Instanciando o Botão Sair
		btSair = new JButton();
		
		//Configurando o texto interno do botão Sair
		btSair.setText("SAIR");
		
		//Configurando o tamanho e a posição do botão Sair
		btSair.setBounds(300,250,155,30);
		
		//Configurando as ações dos botões
		
		btSalvar.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
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
				janelaCadastroVendedor.dispose();
				
			}
		});
		
		/*
		 * Configurações do JPanel
		 * */
		
		//Instanciando o painel principal
		painelPrincipal = (JPanel) janelaCadastroVendedor.getContentPane();
				
		//Configurando o layout inicial
		painelPrincipal.setLayout(null);
				
		//Adicionando os componentes no painel principal
		painelPrincipal.add(lbCodigo);
		painelPrincipal.add(tfCodigo);
		painelPrincipal.add(lbNome);
		painelPrincipal.add(tfNome);
		painelPrincipal.add(lbAreaVenda);
		painelPrincipal.add(tfAreaVenda);
		painelPrincipal.add(lbCidade);
		painelPrincipal.add(tfCidade);
		painelPrincipal.add(lbEstado);
		painelPrincipal.add(cbxEstados);
		painelPrincipal.add(lbSexo);
		painelPrincipal.add(rbMasculino);
		painelPrincipal.add(rbFeminino);
		painelPrincipal.add(lbIdade);
		painelPrincipal.add(tfIdade);
		painelPrincipal.add(lbSalario);
		painelPrincipal.add(tfSalario);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);
		painelPrincipal.add(btNovo);
		painelPrincipal.add(btSair);
		
		//Chamando método para carregar a combo de estados
		carregaComboEstados();
		
		//configurando a visibilidade da tela
		bloquearTela();
		janelaCadastroVendedor.setVisible(true);		
	}//fim do método	
	
	/*
	 * Método para bloquear a tela de cadastro
	 * */
	
	private void bloquearTela()
	{//inicio do método	
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfAreaVenda.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);
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
		tfAreaVenda.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);
		tfSalario.setEditable(true);
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
		tfAreaVenda.setText(null);
		tfCidade.setText(null);
		cbxEstados.setEnabled(false);
		tfIdade.setText(null);
		tfSalario.setText(null);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
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
			Vendedor vendedor = getVendedor();
			
			//Chamando o método responsável por gravar o arquivo TXT
			new VendedorController().gravarTxtVendededor(vendedor);
			
			//Limpar a tela preenchida
			limparTela();
			
			//Bloquear a tela
			bloquearTela();
			
			//Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null,Mensagem.vendedorGravado,Titulo.cadastroVendedor,JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		} 
		else if(!Valida.isInteger(tfCodigo.getText()))
		{
			//Informando o usuário que o código está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		}
		
		//Validando o campo nome
		if(Valida.isEmptyOrNull(tfNome.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNome.grabFocus();
			return false;
		}
		
		//Validando o campo área de venda
		if(Valida.isEmptyOrNull(tfAreaVenda.getText()))
		{
			//Informando o usuário que a área de venda não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			return false;
		}
		
		//Validando o campo cidade
		if(Valida.isEmptyOrNull(tfCidade.getText()))
		{
			//Informando o usuário que a cidade não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCidade.grabFocus();
			return false;
		}
		
		//Validando o campo estado
		if (cbxEstados.getSelectedIndex() == 0) 
		{
			//Informando o usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			cbxEstados.grabFocus();
			return false;
		}
		
		//Validando o campo sexo		
		if(!rbMasculino.isSelected() && !rbFeminino.isSelected())
		{
			//Informando o usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.sexoVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo idade
		if(Valida.isEmptyOrNull(tfIdade.getText()))
		{
			//Informando o usuário que a idade não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		else if(!Valida.isInteger(tfIdade.getText()))
		{
			//Informando o usuário que a idade está preenchida incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfIdade.grabFocus();
			return false;
		}
		
		//Validando o campo salário
		if(Valida.isEmptyOrNull(tfSalario.getText()))
		{
			//Informando o usuário que o salário não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfSalario.grabFocus();
			return false;
		}
		else if(!Valida.isDouble(tfSalario.getText()))
		{
			//Informando o usuário que o salário está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido,Titulo.cadastroVendedor, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfSalario.grabFocus();
			return false;
		}
		//Devolvendo true caso esteja tudo valido
		return true;
	}//fim do método
	
	/*
	 * método para valorizar um objeto vendedor utilizando os campos da tela
	 * */
	private Vendedor getVendedor()
	{
		//Declaração e instanciação de objeto vendedor
		Vendedor vendedor = new Vendedor();
		
		//Valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));
		
		return vendedor;
	}
	
	
}//fim da classe

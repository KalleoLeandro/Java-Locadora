package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por armazenar as telas e componentes do processo de cadastro de filme
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class CadastrarFilmeView 
{//inicio da classe		
	
	/*
	 * Declaração dos atributos
	 */
	
	//Declaração do JFrame - janela
	private JFrame janelaCadastroFilme;
		
	//Declaração das JLabel para exibir os rótulos na tela	
	private JLabel lbCodigo;	
	private JLabel lbNome;	
	private JLabel lbValor;	
	private JLabel lbDisponivel;	
	private JLabel lbPromocao;	
	private JLabel lbValorPromocao;	
	private JLabel lbGenero;
	
	//Declaração dos JTextField para exibir os campos de preenchimento na tela
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	
	//Declaração dos JRadioButtons para exibir a seleção única na tela
	private JRadioButton rbDisponivelSim;
	private JRadioButton rbDisponivelNao;
	private JRadioButton rbPromocaoSim;
	private JRadioButton rbPromocaoNao;
	
	//Declaração do grupo de RadioButton(ButtonGroup, responsável por gerenciar os componentes radio button)
	private ButtonGroup grpRadioDisponivel;
	private ButtonGroup grpRadioPromocao;
	
	//Declaração dos JCheckBoxes para permitir múltiplas seleções	
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;	
	private JCheckBox cbOutro;
	
	//Declaração dos JButtons para permitir as ações pré-definidas na tela
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	
	
	
	//Declaração do painel principal
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
		janelaCadastroFilme = new JFrame();
				
		//Configurando o título da tela
		janelaCadastroFilme.setTitle("CADASTRO DE FILME");
			
		//Configurando o tamanho da tela - largura/altura
		janelaCadastroFilme.setSize(600,380);
		
		//Configurando a ação do fechar(X) do JFrame
		janelaCadastroFilme.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroFilme.setLocationRelativeTo(null);
			
		//Configurando a posição inicial da tela - centralizada
		janelaCadastroFilme.setLocationRelativeTo(null);
		
		/*
		 * Configurações dos JLabels
		 * */
		
		//Instanciando o label código
		lbCodigo = new JLabel();
				
		//Configurando o texto inicial
		lbCodigo.setText("Código:");
				
		//Configurando o tamanho e a posição do label codigo
		lbCodigo.setBounds(20,30,70,25);
		
		//Instanciando o label nome
		lbNome = new JLabel();
		
		//Configurando o texto inicial
		lbNome.setText("Nome:");
		
		//Configurando o tamanho e a posição do label nome
		lbNome.setBounds(20,60,70,25);
		
		//Instanciando o label valor
		lbValor = new JLabel();
		
		//Configurando o texto inicial
		lbValor.setText("Valor:");
		
		//Configurando o tamanho e a posição do valor
		lbValor.setBounds(20,90,70,25);
		
		//Instanciando o label valor
		lbDisponivel = new JLabel();
				
		//Configurando o texto inicial
		lbDisponivel.setText("Disponível:");
				
		//Configurando o tamanho e a posição do disponível
		lbDisponivel.setBounds(20,120,70,25);
		
		//Instanciando o label Promoção
		lbPromocao = new JLabel();
				
		//Configurando o texto inicial
		lbPromocao.setText("Promoção:");
				
		//Configurando o tamanho e a posição
		lbPromocao.setBounds(20,150,70,25);

		//Instanciando o label valorPromoção
		lbValorPromocao = new JLabel();
		
		//Configurando o texto inicial
		lbValorPromocao.setText("Valor Promoção:");
		
		//Configurando o tamanho e a posição do valorPromoção
		lbValorPromocao.setBounds(20,180,100,25);

		//Instanciando o label valorPromoção
		lbGenero = new JLabel();
		
		//Configurando o texto inicial
		lbGenero.setText("Gênero:");
		
		//Configurando o tamanho e a posição do valorPromoção
		lbGenero.setBounds(20,210,100,25);
		
		
		
		/*
		 * Configurações dos JTextField
		 * */
		
		//Instanciando o TextField codigo
		tfCodigo = new JTextField();
				
		//Configurando a posição e o tamanho
		tfCodigo.setBounds(130,30,400,25);
		
		//Instanciando o TextField nome
		tfNome = new JTextField();
		
		//Configurando a posição e o tamanho
		tfNome.setBounds(130,60,400,25);
		
		//Instanciando o TextField valor
		tfValor = new JTextField();
		
		//Configurando a posição e o tamanho
		tfValor.setBounds(130,90,400,25);
		
		//Instanciando o TextField valorPromoção
		tfValorPromocao= new JTextField();
		
		//Configurando a posição e o tamanho
		tfValorPromocao.setBounds(130,180,400,25);
		
		/*
		 * Configurações dos JRadioButtons
		 * */
		
		rbDisponivelSim = new JRadioButton();
		rbDisponivelNao = new JRadioButton();
		rbPromocaoSim = new JRadioButton();
		rbPromocaoNao = new JRadioButton();

		//Configurando o texto dos Radio Buttons
		
		rbDisponivelSim.setText("Sim");	
		rbDisponivelNao.setText("Não");
		rbPromocaoSim.setText("Sim");
		rbPromocaoNao.setText("Não");
		
		
		//Configurando a posição inicial
		rbDisponivelSim.setBounds(130,120,50,25);
		rbDisponivelNao.setBounds(180,120,50,25);
		rbPromocaoSim.setBounds(130,150,50,25);
		rbPromocaoNao.setBounds(180,150,50,25);
		
		/*
		 * Configurações do Button Group
		 * */
		
		grpRadioDisponivel = new ButtonGroup();
		grpRadioPromocao = new ButtonGroup();
		
		//Adicionando os elementos ao RadioButtonGroup
		grpRadioDisponivel.add(rbDisponivelSim);
		grpRadioDisponivel.add(rbDisponivelNao);
		grpRadioPromocao.add(rbPromocaoSim);
		grpRadioPromocao.add(rbPromocaoNao);
		
		/*
		 * Configurações do JCheckBox
		 * */
		
		//Instanciando os check boxes
		
		cbAcao = new JCheckBox();
		cbComedia = new JCheckBox();
		cbFiccao= new JCheckBox();
		cbTerror = new JCheckBox();
		cbOutro = new JCheckBox();
		
		//Configurando o texto inicial
		cbAcao.setText("Ação");
		cbComedia.setText("Comédia");
		cbFiccao.setText("Ficção");
		cbTerror.setText("Terror");
		cbOutro.setText("Outro");
				
				
		//Configurando o tamanho e a posição dos check boxes
		
		cbAcao.setBounds(130,210,50,25);		
		cbFiccao.setBounds(190,210,70,25);
		cbTerror.setBounds(260,210,70,25);
		cbComedia.setBounds(330,210,80,25);
		cbOutro.setBounds(410,210,70,25);
		
		/*
		 * Configurações dos JButtons 
		 * */
		
		//Instanciando o Botão Salvar		
		btSalvar = new JButton();
				
		//Configurando o texto interno do botão Salvar
		btSalvar.setText("SALVAR");
				
		//Configurando o tamanho e a posição do botão Salvar
		btSalvar.setBounds(130,280,155,30);
		
		//Instanciando o Botão Cancelar		
		btCancelar = new JButton();
						
		//Configurando o texto interno do botão Cancelar
		btCancelar.setText("CANCELAR");
						
		//Configurando o tamanho e a posição do botão Cancelar
		btCancelar.setBounds(300,280,155,30);
		
		//Instanciando o Botão Novo		
		btNovo = new JButton();
						
		//Configurando o texto interno do botão Novo
		btNovo.setText("NOVO");
						
		//Configurando o tamanho e a posição do botão Novo
		btNovo.setBounds(130,280,155,30);
		
		//Instanciando o Botão Sair		
		btSair = new JButton();
								
		//Configurando o texto interno do botão Sair
		btSair.setText("SAIR");
								
		//Configurando o tamanho e a posição do botão Sair
		btSair.setBounds(300,280,155,30);
		
		//Configurando as ações dos botões
		
		btSalvar.addActionListener(new ActionListener() 
		{
					
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Método para gravar os dados
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
				janelaCadastroFilme.dispose();
				
			}
		});		
		
		/*
		 * Configurações do JPanel
		 * */
		
		//Instanciando o painel principal
		painelPrincipal = (JPanel) janelaCadastroFilme.getContentPane();
				
		//Configurando o layout inicial
		painelPrincipal.setLayout(null);
				
		//Adicionando os componentes no painel principal
		painelPrincipal.add(lbCodigo);
		painelPrincipal.add(lbNome);
		painelPrincipal.add(tfCodigo);
		painelPrincipal.add(tfNome);
		painelPrincipal.add(lbValor);
		painelPrincipal.add(tfValor);
		painelPrincipal.add(lbDisponivel);
		painelPrincipal.add(rbDisponivelSim);
		painelPrincipal.add(rbDisponivelNao);
		painelPrincipal.add(rbPromocaoSim);
		painelPrincipal.add(rbPromocaoNao);		
		painelPrincipal.add(lbPromocao);
		painelPrincipal.add(lbValorPromocao);
		painelPrincipal.add(tfValorPromocao);
		painelPrincipal.add(lbGenero);
		painelPrincipal.add(cbAcao);
		painelPrincipal.add(cbComedia);
		painelPrincipal.add(cbFiccao);
		painelPrincipal.add(cbTerror);
		painelPrincipal.add(cbOutro);
		painelPrincipal.add(btSalvar);
		painelPrincipal.add(btCancelar);
		painelPrincipal.add(btNovo);
		painelPrincipal.add(btSair);
		
		//configurando a visibilidade da tela
		bloquearTela();
		janelaCadastroFilme.setVisible(true);
	}//fim do método
	
	/*
	 * Método para bloquear a tela de cadastro
	 * */
	
	private void bloquearTela()
	{//inicio do método	
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbTerror.setEnabled(false);
		cbOutro.setEnabled(false);		
		cbAcao.setEnabled(false);
		cbAcao.setEnabled(false);
		rbDisponivelSim.setEnabled(false);
		rbDisponivelNao.setEnabled(false);
		rbPromocaoSim.setEnabled(false);
		rbPromocaoNao.setEnabled(false);
		tfValor.setEditable(false);
		tfValorPromocao.setEditable(false);
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
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbTerror.setEnabled(true);
		cbOutro.setEnabled(true);		
		cbAcao.setEnabled(true);
		cbAcao.setEnabled(true);
		rbDisponivelSim.setEnabled(true);
		rbDisponivelNao.setEnabled(true);
		rbPromocaoSim.setEnabled(true);
		rbPromocaoNao.setEnabled(true);
		tfValor.setEditable(true);
		tfValorPromocao.setEditable(true);
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
		cbAcao.setSelected(false);		
		cbComedia.setSelected(false);		
		cbFiccao.setSelected(false);		
		cbTerror.setSelected(false);		
		cbOutro.setSelected(false);		
		tfValor.setText(null);
		tfValorPromocao.setText(null);
		grpRadioDisponivel.clearSelection();
		grpRadioPromocao.clearSelection();		
	}//fim do método
	
	/*
	 * Método para receber ação do clique salvar 
	 * */
	
	public void salvar()
	{//inicio do método
		
		//Salvar o Filme apenas se estiver válido todos os dados
		if(validar())
		{
			/*
			 * Procedimentos de gravação do objeto Filme no arquivo TXT
			 */
			
			//Instanciando o objeto a ser enviado para o método de gravação 
			Filme filme = getFilme();
			
			//Chamando o método responsável por gravar o arquivo TXT
			new FilmeController().gravarTxtFilme(filme);
			
			//Limpar a tela preenchida
			limparTela();
			
			//Bloquear a tela
			bloquearTela();
			
			//Exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null,Mensagem.filmeGravado,Titulo.cadastroFilme,JOptionPane.INFORMATION_MESSAGE);
		}
		
	}//fim do método
	
	/*
	 * Método para validar os campos do cadastro de Filme
	 * */
	
	private boolean validar()
	{//inicio do método
		//Validando o campo código
		if(Valida.isEmptyOrNull(tfCodigo.getText()))
		{
			//Informando o usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		} 
		else if(!Valida.isInteger(tfCodigo.getText()))
		{
			//Informando o usuário que o código está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfCodigo.grabFocus();
			return false;
		}
		
		//Validando o campo nome
		if(Valida.isEmptyOrNull(tfNome.getText()))
		{
			//Informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfNome.grabFocus();
			return false;
		}		
		
		//Validando o campo disponibilidade		
		if(!rbDisponivelSim.isSelected() && !rbDisponivelNao.isSelected())
		{
			//Informando o usuário que a disponibilidade não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.disponivelNaoMarcado,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo Promoção
		if(!rbDisponivelSim.isSelected() && !rbDisponivelNao.isSelected())
		{
			//Informando o usuário que a disponibilidade não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.PromocaoNaoMarcado,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);			
			return false;
		}
		
		//Validando o campo ValorPromoção
		if(Valida.isEmptyOrNull(tfValor.getText()))
		{
			//Informando o usuário que o valor não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorVazio,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfValor.grabFocus();
			return false;
		}
		else if(!Valida.isDouble(tfValor.getText()))
		{
			//Informando o usuário que o valor está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalido,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfValor.grabFocus();
			return false;
		}
		
		//Validando o campo ValorPromoção
		if(Valida.isEmptyOrNull(tfValorPromocao.getText()))
		{
			//Informando o usuário que o valorPromoção não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocaoVazio,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			return false;
		}
		else if(!Valida.isDouble(tfValorPromocao.getText()))
		{
			//Informando o usuário que o ValorPromoção está preenchido incorretamente
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocaoInvalido,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			//Colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			return false;
		}
		
		//Validando as caixas de seleção
		if(!cbAcao.isSelected() && !cbComedia.isSelected() && !cbFiccao.isSelected() && !cbOutro.isSelected() && ! cbTerror.isSelected())
		{
			//Informando o usuário que pelo menos 1 campo não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.generoVazio,Titulo.cadastroFilme, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		//Devolvendo true caso esteja tudo valido
		return true;
	}//fim do método
	
	/*
	 * método para valorizar um objeto Filme utilizando os campos da tela
	 * */
	private Filme getFilme()
	{//inicio do método
		//Declaração e instanciação de objeto Filme
		Filme filme = new Filme();
		
		//Valorizando o objeto Filme
		filme.setCodigo(Util.getInt(tfCodigo.getText()));
		filme.setNome(tfNome.getText());
		filme.setDisponivel(rbDisponivelSim.isSelected()? true: false);
		filme.setPromocao(rbPromocaoSim.isSelected() ? true : false);
		filme.setValor(Util.getDouble(tfValor.getText()));
		filme.setValorPromocao(Util.getDouble(tfValorPromocao.getText()));
		filme.setGenero(getGenero());
		
		return filme;
	}//fim do método
	
	/*
	 * Método para retornar os gêneros selecionados
	 * */	
	private String getGenero()
	{
		String aux = "";
		int cont = 0;
		//ação
		if(cbAcao.isSelected())
		{
			if(cont == 0)
			{
				aux ="Ação";
				cont++;
			}
			else
			{
				aux =";Ação";
			}
		}
		//comedia
		if(cbComedia.isSelected())
		{
			if(cont == 0)
			{
				aux ="Comédia";
				cont++;
			}
			else
			{
				aux =";Comédia";
			}
		}
		//ficcao
		if(cbFiccao.isSelected())
		{
			if(cont == 0)
			{
				aux ="Ficção";
				cont++;
			}
			else
			{
				aux =";Ficção";
			}
		}
		//terror
		if(cbTerror.isSelected())
		{
			if(cont == 0)
			{
				aux ="Terror";
				cont++;
			}
			else
			{
				aux =";Terror";
			}
		}
		//outro
		if(cbOutro.isSelected())
		{
			if(cont == 0)
			{
				aux ="Outro";
				cont++;
			}
			else
			{
				aux =";Outro";
			}
		}
		return aux;
	}

}//fim da classe

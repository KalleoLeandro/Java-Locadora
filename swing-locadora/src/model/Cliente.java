package model;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Cliente
 * @author Kalleo Leandro dos Santos Leal
 * @since 04/03/2021
 * @version 1.0
 */

public class Cliente 
{//inicio da classe

	//Declaração de atributos do objeto Cliente
	private int codigo;
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String rg;
	private Data dataNascimento;
	private int idade;
	private char sexo;
	private String telefone;
	private String celular;
	private String email;

	//Construtor vazio
	public Cliente()
	{
		
	}
	
	//Getters e Setters

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public Endereco getEndereco()
	{
		return endereco;
	}

	public void setEndereco(Endereco endereco) 
	{
		this.endereco = endereco;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public String getRg() 
	{
		return rg;
	}

	public void setRg(String rg) 
	{
		this.rg = rg;
	}

	public Data getDataNascimento() 
	{
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() 
	{
		return idade;
	}

	public void setIdade(int idade) 
	{
		this.idade = idade;
	}

	public char getSexo()
	{
		return sexo;
	}

	public void setSexo(char sexo)
	{
		this.sexo = sexo;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getCelular() 
	{
		return celular;
	}

	public void setCelular(String celular)
	{
		this.celular = celular;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
}//fim da classe

package model;

public class Instituicao{
    private int id = 0;
    private String nome;
    private String telefone;
    private String endereco;
    private int validacao = 0;

    public Instituicao(int id, String nome, String telefone, String endereco){;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Instituicao(int id, String nome, String telefone, String endereco, int validacao){;
    this.id = id;
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
    this.validacao = validacao;
}

    public Instituicao(String nome, String telefone, String endereco){;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Instituicao(){
    	
    }

    public int getId(){
  		  return this.id;
  	}
  	public void setId(int id){
  		  this.id = id;
  	}

    public String getNome() {
  		  return nome;
  	}
  	public void setNome(String nome) {
  		  this.nome = nome;
  	}

  	public String getTelefone() {
  		  return telefone;
  	}
  	public void setTelefone(String telefone) {
  		  this.telefone = telefone;
  	}

  	public String getEndereco() {
  		  return endereco;
  	}
  	public void setEndereco(String endereco) {
  		  this.endereco = endereco;
  	}

	public int getValidacao() {
		return validacao;
	}

	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}   
}
package model;

public class Instituicao{
    private int id = 0;
    private String nome;
    private String telefone;
    private String email;

    public Instituicao(int id, String nome, String telefone, String email){;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Instituicao(String nome, String telefone, String email){;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
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

  	public String getEmail() {
  		  return email;
  	}
  	public void setEmail(String email) {
  		  this.email = email;
  	}   
}
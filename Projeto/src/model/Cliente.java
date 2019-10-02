package model;
import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private int id_cli;
	private String nome_cli;
	private String email_cli;
	private String tel_cli;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, String email, String telefone) {
		super();
		this.id_cli = id;
		this.nome_cli = nome;
		this.email_cli = email;
		this.tel_cli = telefone;
	}

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}

	public void setTel_cli(String te_cli) {
		this.tel_cli = te_cli;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_cli;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id_cli != other.id_cli)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id_cli=" + id_cli + ", nome_cli=" + nome_cli + ", email_cli=" + email_cli + ", tel_cli="
				+ tel_cli + "]";
	}

	
	
}

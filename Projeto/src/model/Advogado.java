package model;
import java.io.Serializable;
public class Advogado implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int id_adv;
	private String nome_adv;
	private String email_adv;
	private String tel_adv;
	
	public Advogado() {
		
	}
	
	public Advogado(int id, String nome, String email, String telefone) {
		super();
		this.id_adv = id;
		this.nome_adv = nome;
		this.email_adv = email;
		this.tel_adv = telefone;
	}
	
	public int getId_adv() {
		return id_adv;
	}
	public void setId_adv(int id_adv) {
		this.id_adv = id_adv;
	}
	public String getNome_adv() {
		return nome_adv;
	}
	public void setNome_adv(String nome_adv) {
		this.nome_adv = nome_adv;
	}
	public String getEmail_adv() {
		return email_adv;
	}
	public void setEmail_adv(String email_adv) {
		this.email_adv = email_adv;
	}
	public String getTel_adv() {
		return tel_adv;
	}
	public void setTel_adv(String tel_adv) {
		this.tel_adv = tel_adv;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_adv;
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
		Advogado other = (Advogado) obj;
		if (id_adv != other.id_adv)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Advogado [id_adv=" + id_adv + ", nome_adv=" + nome_adv + ", email_adv=" + email_adv + ", tel_adv="
				+ tel_adv + "]";
	}
	
	
}

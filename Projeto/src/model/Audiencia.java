package model;
import java.io.Serializable;
import java.util.Date;

import model.Advogado;
import model.Cliente;
import model.Processo;
public class Audiencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id_audiencia;
	private Advogado adv;
	private Cliente cli;
	private Processo processo;
	private String nomeJuiz;
	private Date data_audiencia;
	
	public Audiencia() {
		
	}
	public Audiencia(int id_audiencia, Advogado advogado, Cliente cliente, Processo processo, String nomeJuiz , Date data_audiencia) {
		super();
		this.id_audiencia = id_audiencia;
		this.cli = cliente;
		this.adv = advogado;
		this.processo = processo;
		this.nomeJuiz = nomeJuiz;
		this.data_audiencia = data_audiencia;
	}

	public int getId_audiencia() {
		return id_audiencia;
	}

	public void setId_audiencia(int id_audiencia) {
		this.id_audiencia = id_audiencia;
	}

	
	public Advogado getAdv() {
		return adv;
	}
	public void setAdv(Advogado adv) {
		this.adv = adv;
	}
	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public String getNomeJuiz() {
		return nomeJuiz;
	}

	public void setNomeJuiz(String nomeJuiz) {
		this.nomeJuiz = nomeJuiz;
	}

	public Date getData_audiencia() {
		return data_audiencia;
	}
	public void setData_audiencia(Date data_audiencia) {
		this.data_audiencia = data_audiencia;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_audiencia;
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
		Audiencia other = (Audiencia) obj;
		if (id_audiencia != other.id_audiencia)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Audiencia [id_audiencia=" + id_audiencia + ", adv=" + adv + ", cli=" + cli + ", processo=" + processo
				+ ", nomeJuiz=" + nomeJuiz + ", data_audiencia=" + data_audiencia + "]";
	}
	
}

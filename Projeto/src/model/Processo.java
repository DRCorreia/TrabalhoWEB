package model;
import java.io.Serializable;

public class Processo implements Serializable {
private static final long serialVersionUID = 1L;
private int id_processo;
private Cliente cliente;
private Advogado advogado;
private String tipo_processo;
private String situacao_processo;

public Processo() {
	
}

public Processo(int id_processo, Cliente cliente, Advogado advogado, String tipo_processo, String situacao_processo) {
	super();
	this.id_processo = id_processo;
	this.cliente = cliente;
	this.advogado = advogado;
	this.tipo_processo = tipo_processo;
	this.situacao_processo = situacao_processo;
}

public int getId_processo() {
	return id_processo;
}

public void setId_processo(int id_processo) {
	this.id_processo = id_processo;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Advogado getAdvogado() {
	return advogado;
}

public void setAdvogado(Advogado advogado) {
	this.advogado = advogado;
}

public String getTipo_processo() {
	return tipo_processo;
}

public void setTipo_processo(String tipo_processo) {
	this.tipo_processo = tipo_processo;
}

public String getSituacao_processo() {
	return situacao_processo;
}

public void setSituacao_processo(String situacao_processo) {
	this.situacao_processo = situacao_processo;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}



}

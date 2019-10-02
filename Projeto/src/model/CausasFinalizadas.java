package model;
import java.io.Serializable;
public class CausasFinalizadas implements Serializable {
	   private static final long serialVersionUID = 1L;
       private Processo processo;
       private String veredito;
       
    public CausasFinalizadas() {
    	
    }
    
    public CausasFinalizadas(Processo processo,String veredito) {
    	super();
    	this.processo = processo;
        this.veredito = veredito;
    }

       
	public Processo getProcesso() {
		return processo;
	}
	public void setId_processo(Processo processo) {
		this.processo = processo;
	}
	public String getVeredito() {
		return veredito;
	}
	public void setVeredito(String veredito) {
		this.veredito = veredito;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processo == null) ? 0 : processo.hashCode());
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
		CausasFinalizadas other = (CausasFinalizadas) obj;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		return true;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "CausasFinalizadas [processo=" + processo + ", veredito=" + veredito + "]";
	}
	
       
       
}

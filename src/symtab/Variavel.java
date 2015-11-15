package symtab;

public class Variavel extends TipoSemantico{
	private String id, tipo;
	private Object valor;

	public Variavel(String id, String tipo, Object valor) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}
	
	public String getNome() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}
	
	public Object getValor() {
		return valor;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public String toString(){
		return id + " " +tipo + " " + valor;
	}
	
	public String getTipoSemantico(){
		return "Variavel";
		
	}
}

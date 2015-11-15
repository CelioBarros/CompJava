package symtab;

import java.util.ArrayList;

import assembly.GeradorAssembly;

public class Context {

	private String nome;
	private static Context instance = null;
	private ArrayList<Variavel> variaveisDoContexto;
	private ArrayList<Context> listContexts;

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		return instance;
	}

	public Context() {
		variaveisDoContexto = new ArrayList<Variavel>();
	}

	public ArrayList<Variavel> getVariaveisDoContexto() {
		return variaveisDoContexto;
	}

	public Variavel getVariavel(String var) {
		for (Variavel variavel : variaveisDoContexto) {
			// System.out.println(variavel.getId());
			if (var.equals(variavel.getId())) {
				return variavel;
			}
		}
		return null;
	}

	public void addVariavel(Variavel var) {
		variaveisDoContexto.add(var);
	}

	public String getNome() {

		return nome;
	}

}

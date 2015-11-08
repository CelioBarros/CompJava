package assembly;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Stack;

	//Regras de assembly retiradas daqui
	//http://pt.slideshare.net/mksaad/assembly-language-lecture-5-presentation
	public class GeradorAssembly {
		
	private static GeradorAssembly instance = null;
	private String literalAtual;
	private String tab = "";
	private int reg = 0;
	private int label = 0;
	boolean callFunction = false;
	private Stack pilha = new Stack<String>();
	private String result = "";	
		
	public static GeradorAssembly getInstance() {
		if (instance == null) {
			instance = new GeradorAssembly();
		}
		return instance;
	}

	public String getLiteralAtual() {
		//if(literalAtual != null){
		//	return literalAtual;
		//}
		if(!pilha.empty()){
			String retorno = (String) pilha.pop();
			if(retorno.equals("true") || retorno.equals("false")){
				retorno = "#"+retorno;
			}
			return retorno;
		}
		return "";
	}

	public void setLiteralAtual(String literalAtual) {
	pilha.push(literalAtual);
		this.literalAtual = literalAtual;
	}
	
	public void Storage(String variavel, String valor){
		if(!valor.equals("")){
			String regValor = Load(valor);
			result += tab + "ST " + variavel + ", R" + regValor + "\n";
		}else{
			if(callFunction){
				result += tab + "ST " + variavel + ", EAX" + "\n";
				callFunction = false;
			}else{
				result += tab + "ST " + variavel + ", R" + (reg-1) + "\n";
			}
		}
	}
	public String Load(String valor){
		result += tab + "LD R" + reg + ", " + valor + "\n";
		reg++;
		return (reg -1)+"";
	}
	
	public String ADD(String regA, String regB){
		result += tab + "ADD R" + reg + ", " + "R" + regA + ", R" + regB + "\n";
		reg++;
		return (reg -1)+"";
	}
	
	public String SUB(String regA, String regB){
		result += tab + "SUB R" + reg + ", " + "R" + regA + ", R" + regB + "\n";
		reg++;
		return (reg -1)+"";
	}
	
	public String MUL(String regA, String regB){
		result += tab + "MUL R" + reg + ", " + "R" + regA + ", R" + regB + "\n";
		reg++;
		return (reg -1)+"";
	}
	
	public String DIV(String regA, String regB){
		result += tab + "DIV R" + reg + ", " + "R" + regA + ", R" + regB + "\n";
		reg++;
		return (reg -1)+"";
	}
	
	public String expressaoRelacional(String operador, String regA, String regB){
		if(operador.equals("menor")){
			String regTemp = SUB(regA, regB);
			result += "BLTZ R" + regTemp + ", L" + label + "\n";
			
		}
		return (reg -1)+"";
	}
	
		
	public void declaraMetodo(String nome){
		result += ".global " + nome + "\n";
		result += nome+":" + "\n";
	}
	
	public void chamaMetodo(String nome){
		result += tab + "CALL " + nome + "\n";
		callFunction = true;

	}
		
	public void generateAssembly(){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("codeAssembly.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(result);
		writer.close();
	}
	


}

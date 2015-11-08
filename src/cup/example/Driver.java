package cup.example;

import assembly.GeradorAssembly;
import java_cup.runtime.*;

class Driver {

	public static String arquivo = "";
	
	public static void main(String[] args) throws Exception {
		if (0 < args.length) {
			arquivo= args[0];
		} else {
			arquivo = "input.txt";
		}

		Parser parser = new Parser();
		parser.parse();
		GeradorAssembly.getInstance().generateAssembly();
	}
	
}
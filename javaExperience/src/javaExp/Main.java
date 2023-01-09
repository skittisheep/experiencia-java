package javaExp;

public class Main {
	
	public static void main(String[] args) {
	
		int t;
		
		Menu menu = new Menu();
		
		for(t=0; t<73; t++) System.out.printf("-");
		System.out.printf("\n\t\t>>>>>>>>>> atividade academica <<<<<<<<<<");
		System.out.printf("\n\t\t>>>>>> ver 1.0 (barely functional) <<<<<<");
		System.out.printf("\n\t\t> Proof of monkey brain Special Edition <\n");
		for(t=0; t<73; t++) System.out.printf("-");
		System.out.printf("\n\n");
		
		menu.logIn();
		
		do {
			menu.show();
		} while (menu.opt != 0);
		System.out.printf("\nAlgoritmo finalizado...\n\n");
	}
}
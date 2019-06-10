package index;

import java.util.Scanner;

import controlerUserView.ControlerUsuarioView;

public class Index {
	private static Scanner input;

	public static void main(String[] args) {
		ControlerUsuarioView cU = new ControlerUsuarioView();
		input = new Scanner(System.in);
		do {
			System.out.println("\n\n-------------------------------------------------------------------------\n");
			System.out.println(cU.tela);
			if(!cU.exit) {
				cU.entrada(input.nextLine());
			}
		}while(!cU.exit);
	}
}

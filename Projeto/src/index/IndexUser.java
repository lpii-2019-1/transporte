package index;

import java.util.Scanner;

import controlerUserView.ControlerUsuarioView;

public class IndexUser {
	private static Scanner input;

	public static void main(String[] args) {
		ControlerUsuarioView ctrU = new ControlerUsuarioView();
		input = new Scanner(System.in);
		do {
			System.out.println("\n\n-------------------------------------------------------------------------\n");
			System.out.println(ctrU.tela);
			if(!ctrU.exit) {
				ctrU.entrada(input.nextLine());
			}
			if(ctrU.exit){
				System.out.println(ctrU.tela);
			}
		}while(!ctrU.exit);
	}
}

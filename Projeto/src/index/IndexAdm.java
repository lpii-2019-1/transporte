package index;

import java.util.Scanner;

import controlerAdmView.ControlerAdministradorView;

public class IndexAdm {
	private static Scanner input;

	public static void main(String[] args) {
		ControlerAdministradorView ctrA = new ControlerAdministradorView();
		input = new Scanner(System.in);
		do {
			System.out.println("\n\n-------------------------------------------------------------------------\n");
			System.out.println(ctrA.tela);
			if(!ctrA.exit) {
				ctrA.entrada(input.nextLine());
			}
			if(ctrA.exit){
				System.out.println(ctrA.tela);
			}
		}while(!ctrA.exit);
	}
}

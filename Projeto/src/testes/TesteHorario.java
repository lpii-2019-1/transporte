package testes;

import model.Horario;

public class TesteHorario {
	public static void main(String[] args) {
		Horario h1 = new Horario("16:30","22:40");
		
		System.out.println(h1.getHrRegresso());
	}
}

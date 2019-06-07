package telas;

import java.util.Scanner;

import telas.Controler;

public class TesteTelas {

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controler controler = new Controler();
        input = new Scanner(System.in);
        
        String op = null;
        do{
            System.out.println(controler.tela());
        	op = input.next();
        	
            controler.entrada(op);
        }while(op != "0");
    }
}

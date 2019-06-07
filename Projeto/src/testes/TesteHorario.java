/*package testes;
import java.text.SimpleDateFormat;

public class TesteHorario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
			SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm" );
			
			int hora = 17;
			int minutos = 30;
			
			Horario h = new Horario();
//			System.out.println("ok");
			if(h.insereHrSaida(hora, minutos)) {
				System.out.println("Hora Saída do primeiro ponto: " + (String) sdf.format( h.getHrSaidaPrimeiroPonto().getTime()));
			}else {
				System.out.println("Erro ao inserir horário de saida");
			}
			
			int horaRegresso = 22;
			int minutosRegresso = 40;
			
			if(h.insereHrRegresso(horaRegresso, minutosRegresso)) {
				System.out.println("Hora Saída da Faculdade: " + (String) sdf.format( h.getHrRegresso().getTime()));
			}else {
				System.out.println("Erro ao inserir hora de regresso");
			}
			
			// System.out.println("texto aqui: " + (String) sdf.format(h.getHrSaidaPrimeiroPonto().getTime()));
		}catch(Exception e){
			System.out.println(e);
		}
	}

}*/

package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else 
                System.out.println("Contato realizado com sucesso");
        }while(continuarTentando && tentativasRealizadas <3);

        if(atendeu)
			System.out.println("Conseguimos contato com " + candidato +" na " + tentativasRealizadas + " tentativa");
		else
			System.out.println("Não conseguimos contato com " + candidato +", número máximo de tantativas " + tentativasRealizadas + " realizadas");
	}
    //método auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imorimirSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

        System.out.println("Imprimindo a lista de candidatos informando o indece do elemento");
    
        for( int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " +(indice+1)+ " é o(a) " +candidatos[indice]);
        }
        /*System.out.println("FOR EACH");

            for(String candidato : candidatos){
                System.out.println("O condidato selecionado(a) foi: "+candidato);
            }
    }*/

    static void selecaoCantidados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Canditado " + candidato + " Solicitou este valor de salário "+ salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println(" O " +candidato+ " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
   }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o Candidato");
        }else if (salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato, com contra proposta");
        else {
            System.out.println("Aguardando demais Candidatos");
        }
    }
}
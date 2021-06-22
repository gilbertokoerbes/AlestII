import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {
        
        Scanner entrada = new Scanner(System.in);
        while(true){
            String input = "";
            System.out.println("informe o nome do arquivo, sem .txt | enter para sair");
            input = entrada.nextLine();
            input = input+".txt";
            if(input.equalsIgnoreCase("\n"))break; 

            Leitura ler = new Leitura();     

            ler.carrega(input); 

            BuscaCaminho bp = new BuscaCaminho();            
            System.out.println("==================================================================================");
            System.out.println("==============================P-R-O-C-E-S-S-A-N-D-O===============================");
            System.out.println("==================================================================================");
            
            bp.BuscaCaminho(ler);
            ler.gravar();     
        } 
    }
}
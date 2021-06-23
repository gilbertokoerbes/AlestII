import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {

        ArrayList<String> arquivos = new ArrayList<>();
        arquivos.add("50_50");
        arquivos.add("75_75");
        arquivos.add("75_75_1");
        arquivos.add("75_75_2");
        arquivos.add("75_75_3");
        //arquivos.add("75_75_4");
        arquivos.add("75_75_5");
        arquivos.add("100_50");
        arquivos.add("100_100");
        arquivos.add("250_250");
        arquivos.add("640_480");
        arquivos.add("1000_1000");
        for (String files: arquivos){
            String input = files;
            input = input+".txt";      

           Leitura ler = new Leitura();     
           ler.carrega(input); 
           BuscaCaminho bp = new BuscaCaminho();         
           System.out.println("P-R-O-C-E-S-S-A-N-D-O....");
           
           Boolean retorno = bp.BuscaCaminho(ler);
           if (retorno) ler.gravar();
           System.out.println("                                                                                 ");
           System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - -  ");
           System.out.println("                                                                                 ");
           

        }



        
        /* -------iterativo/modular---
        
        
        Scanner entrada = new Scanner(System.in);
        while(true){
            String input = "";
            System.out.println("informe o nome do arquivo (da pasta casos_de_teste), sem .txt | 0 para sair");
            input = entrada.nextLine();
            if(input.equalsIgnoreCase("0"))System.exit(0);; 
            input = input+".txt";           

            Leitura ler = new Leitura();     

            ler.carrega(input); 

            BuscaCaminho bp = new BuscaCaminho();            
            System.out.println("==================================================================================");
            System.out.println("==============================P-R-O-C-E-S-S-A-N-D-O===============================");
            System.out.println("==================================================================================");
            
            bp.BuscaCaminho(ler);
            ler.gravar();     
        } */
    }
}
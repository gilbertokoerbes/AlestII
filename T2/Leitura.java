import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.element.Element;



public class Leitura {
    int CaranguejoI;
    int CaranguejoJ;
    int SaidaI;
    int SaidaJ;
    Object[][] Matriz;
    ArrayList<ArrayList<Vertices>> MatrizList = new ArrayList<ArrayList<Vertices>>();
    public Vertices v;
    String nameFileIn = null;
    
    public void Leitura(){
    CaranguejoI = -1;
    CaranguejoJ = -1;
    SaidaI = -1;
    SaidaJ = -1;
    nameFileIn = null;
    }

    public void carrega(String nameFile) throws Exception{
        
        Leitura();
        nameFileIn = nameFile;
        String fName = nameFile; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\casos_de_teste\\"+ fName;
        Path path = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            System.out.print("Lendo arquivo: dir=  "); 
            System.out.println(path);

            String[] tamanho = fName.split(".txt");
            tamanho = tamanho[0].split("_");
            int Largura = Integer.parseInt(tamanho[0]);
            int Altura = Integer.parseInt(tamanho[1]);

            
            int i=0; 
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                if (linha.length()!=Largura) throw new Exception("Largura informada do arquivo nao confere com caracteres linha");
                MatrizList.add(new ArrayList<Vertices>());
                for(int j=0; j<linha.length(); j++){
                
                    MatrizList.get(i).add(new Vertices());
                    MatrizList.get(i).get(j).add(linha.substring(j, j+1), i ,j);

                    if(MatrizList.get(i).get(j).getElement().equalsIgnoreCase("C")){
                        System.out.println("pos. C A R A N G U E I J O = "+i+"|"+j);
                        CaranguejoI=i;
                        CaranguejoJ=j;                          
                    
                    }
                    if(MatrizList.get(i).get(j).getElement().equalsIgnoreCase("S")){
                        System.out.println("pos. S A I D A = "+i+"|"+j);
                        SaidaI=i;
                        SaidaJ=j;                     
                    }  
                }
                i++;                         
            }
            if (i!=Altura) throw new Exception("Altura informada do arquivo não confere com a total de linha");                    
        }catch (Exception x) {
            System.err.format("Erro durante a leitura do arquivo: %s%n", x);
            System.exit(0);
        }
    }
    
    public void gravar() throws Exception{
        String nameFileOut = "Out_"+nameFileIn;
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\casos_de_teste\\out\\"+ nameFileOut;
        Path path = Paths.get(nameComplete);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8))){
            int i=0;                
            for (ArrayList array : MatrizList) {
                    String linha ="";
                    for(int j=0; j<MatrizList.get(i).size(); j++){
                        linha = linha+MatrizList.get(i).get(j).getElement();
                    }
                    writer.println(linha);
                    i++;
            }
            System.out.println("Verifique o arquivo em = '"+path+"'");    
        }catch (IOException x){
          System.err.format("Erro de E/S: %s%n", x);
          System.exit(0);
      }     

    }
    
}

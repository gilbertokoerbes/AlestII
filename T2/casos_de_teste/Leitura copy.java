import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.element.Element;



public class Leitura {
    int CarangueijoI;
    int CarangueijoJ;
    int SaidaI;
    int SaidaJ;
    Object[][] Matriz;
    ArrayList<ArrayList<Vertices>> List = new ArrayList<ArrayList<Vertices>>()
    public Vertices v;
    
    public void Leitura(){
    CarangueijoI = -1;
    CarangueijoJ = -1;
    SaidaI = -1;
    SaidaJ = -1;
    Matriz = new Vertices[0][0];
    v = new Vertices();
    }

    public String carrega(String nameFile) throws Exception{
        
        Leitura();
        String fName = nameFile; //nome dinamico do arquivo
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+ fName;
        Path path = Paths.get(nameComplete);

        System.out.print("Lendo arquivo: dir=  "); 
        System.out.println(path);

        String[] tamanho = fName.split(".txt");
        tamanho = tamanho[0].split("_");
        int Largura = Integer.parseInt(tamanho[0]);
        int Altura = Integer.parseInt(tamanho[1]);
        Matriz = new Object[Altura][Largura];
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            int i=0; 
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                if (linha.length()!=Largura) throw new Exception("Largura informada do arquivo nao confere com caracteres linha");
                for(int j=0; j<linha.length(); j++){
                    v = new Vertices();
                    Matriz[i][j] = v;
                    System.out.println("["+i+"]"+"["+j+"]"+linha.substring(j, j+1));
                    ((Vertices) Matriz[i][j]).add(linha.substring(j, j+1), i ,j);
                    if(i>0&&j>0)System.out.println("Verifica anteior " + ((Vertices) Matriz[i-1][j-1]).getElement());
                    if(((Vertices) Matriz[i][j]).getElement().equalsIgnoreCase("C")){
                        System.out.println("C A R A N G U E I J O= "+i+"|"+j);
                        CarangueijoI=i;
                        CarangueijoJ=j;                          
                
                    }
                    if(((Vertices) Matriz[i][j]).getElement().equalsIgnoreCase("S")){
                        System.out.println("S A I D A= "+i+"|"+j);
                        SaidaI=i;
                        SaidaJ=j;                     
                    }  
                }
                i++;                         
            }
            if (i!=Altura) throw new Exception("Altura informada do arquivo não confere com a total de linha");
                    
        } catch (Exception x) {
            System.err.format("Erro durante a leitura do arquivo: %s%n", x);
        }
        return "";

    }
    
}

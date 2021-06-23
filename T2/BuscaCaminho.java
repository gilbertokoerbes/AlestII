import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaCaminho {
    Leitura ler; //recebe instancia lida para poder verificar argumentos
    Queue<Vertices> fila = new LinkedList<>();
    
    public boolean BuscaCaminho(Leitura entrada){
        this.ler = entrada;
        System.out.println("Compatiblidade entre Caranguejo e Saida = " + validaPosicao());
        if(validaPosicao()) {
            realizaBusca();
            return true;
        }
        else{
            System.out.println("ENCERRANDO O PROGRAMA - SEM EXECUCAO NECESSARIA");
            return false;
        }
        
    }

    //verifica se a posição é compativel entre o Caranguejo e a saida
    //(pares/pares ||  impares/impares)
    private boolean validaPosicao(){ 
        if(((((ler.CaranguejoI))%2)==(((ler.SaidaI))%2)) && (((ler.CaranguejoJ%2))==((ler.SaidaJ%2)))) return true;
        else return false;
    }

    private void realizaBusca(){
        
        int iniciali = ler.CaranguejoI;
        int inicialj = ler.CaranguejoJ;
        int finali = ler.SaidaI;
        int finalj = ler.SaidaJ;
        fila.add(ler.MatrizList.get(iniciali).get(inicialj));
        while (fila.size()>0){
             Vertices u = fila.poll();
             int[] pos = u.getPosition();            
            
             processa(u);
             u.setVisited();
             
             if(pos[0]==finali && pos[1]==finalj){
                //encontrou saida
                 break;
            }
         
                   
        }        

        //busca caminho PAI e altera os elemtnos dos vertices por pontos por [O]
        Vertices fathers = ler.MatrizList.get(finali).get(finalj);
        int D = 0;
        while(true){
            if((fathers.father[0]==(iniciali))&&(fathers.father[1]==(inicialj))) break;
            ler.MatrizList.get(fathers.father[0]).get(fathers.father[1]).setElement("|");
            fathers = ler.MatrizList.get(fathers.father[0]).get(fathers.father[1]);
            D++;
        }
        System.out.println("Disancia/saltos total = "+D);
    }

    private void processa(Vertices u){
        int[] pos = u.getPosition(); 
        int i = pos[0];
        int j = pos[1];      
        BFS( (i-1), (j-1), pos);//left-up        
        BFS( (i-1), (j+1), pos);//right-up       
        BFS( (i+1), (j+1), pos);//right-down        
        BFS( (i+1), (j-1), pos);//left-down        
        BFS( (i-2), (j), pos);//up       
        BFS( (i),   (j+2), pos);//right        
        BFS( (i+2), (j), pos);//down        
        BFS( (i),   (j-2), pos);//left

    }
    private void BFS( int i, int j, int[] posFather){
        Vertices u;
        if(((i)>=0)&&i<ler.MatrizList.size()){
            if(((j)>=0)&&j<ler.MatrizList.get(posFather[0]).size()){
                u = ler.MatrizList.get(i).get(j);               
                if(u.getVisited()==false){
                    if(!(u.getElement().equalsIgnoreCase("x"))){
                        int newI = i;
                        int newJ = j;
                        fila.add(ler.MatrizList.get(newI).get(newJ));
                        ler.MatrizList.get(newI).get(newJ).setFather(posFather[0], posFather[1]);
                        ler.MatrizList.get(newI).get(newJ).setVisited();
                    
                            
                    }
                }
            }
        }

    }
}    

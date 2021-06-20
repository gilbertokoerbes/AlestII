public class BuscaCaminho {
    Leitura ler; //recebe instancia lida para poder verificar argumentos
    
    
    public void BuscaCaminho(Leitura entrada){
        this.ler = entrada;
        System.out.println("Compatibilidade saida " + posicao());
    }

    //verifica se a posição é compativel entre o carangueijo e a saida
    //(pares/pares ||  impares/impares)
    private boolean posicao(){ 
        if(((ler.CarangueijoI%2)==(ler.SaidaI%2)) && ((ler.CarangueijoJ%2)==(ler.SaidaJ%2))) return true;
        else return false;
    }
}
    

public class App{
    public static void main(String[] args) throws Exception {
        Leitura ler = new Leitura();
        ler.carrega("40_20.txt");    
        BuscaCaminho bp = new BuscaCaminho();
        bp.BuscaCaminho(ler);
        System.out.println("Visualiza elemento = " +((Vertices) ler.Matriz[10][30]).getElement());
        int[] pos = ((Vertices) ler.Matriz[10][30]).getPosition();
        System.out.println("Posição = " +pos[0]+"|"+pos[1]);
    }
}
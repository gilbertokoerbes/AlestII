import javax.lang.model.element.Element;

public class Vertices {
    private static final class Node {
        public static int[] position;
        public static int[] father;
        public static Boolean Visited;
        public static String element;
    

        public Node(String elemento, int i, int j) {
            //public Node(String elemento) {
            position = new int[2];
            position[0]=i;
            position[1]=j;
            father = new int[2];
            Visited = false;
            element = elemento;
        }
    }
    public Node add(String elemento, int i, int j){
       Node novo = new Node( elemento,  i, j);
        //public Node add(String elemento){
        //Node novo = new Node( elemento);
        return novo;
    }
    public String getElement(){
        return Vertices.Node.element;
    }
    public Boolean getVisited(){
        return Vertices.Node.Visited;
    }
    public void setVisited(){
        Vertices.Node.Visited = true;
    }
    public int[] getFather(){
        return Vertices.Node.father;
    }
    public void setFather(int i, int j){
        Vertices.Node.father[0] = i;
        Vertices.Node.father[1] = j;
    }
    public int[] getPosition(){
        return Vertices.Node.position;
    }
}

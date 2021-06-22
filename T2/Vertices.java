

public class Vertices {
    
        public  int[] position;
        public  int[] father;
        public  Boolean Visited;
        public  String element;
    

    public void add(String elemento, int i, int j) {
            //public Node(String elemento) {
            this.position = new int[2];
            this.position[0]=i;
            this.position[1]=j;
            this.father = new int[2];
            father[0]=-1;
            father[1]=-1;
            this.Visited = false;
            this.element = elemento;
    }
        
    
    public String getElement(){
        return element;
    }
    public void setElement(String element){
        this.element = element;
    }
    public Boolean getVisited(){
        return Visited;
    }
    public void setVisited(){
        Visited = true;
    }
    public int[] getFather(){
        return father;
    }
    public void setFather(int i, int j){
        father[0] = i;
        father[1] = j;
    }
    public int[] getPosition(){
        return position;
    }
}

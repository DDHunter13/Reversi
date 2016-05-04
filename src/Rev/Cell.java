package Rev;

public class Cell {
    
    private int state;
    
    Cell(){
        this.state = 0;
    }
    
    public int getState(){
        return this.state;
    }
    
    public void setState(int st){
        this.state = st;
    }
}

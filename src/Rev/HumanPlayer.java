package Rev;

public class HumanPlayer implements Player {
    
    private int color;
    
    public void HumanPlayer(int col){
        this.color = col;
    }
    
    @Override
    public int getColor(){
        return this.color;
    }
    
    @Override
    public boolean makeMove(Field field, int i, int j){
        int flag = field.courseCheck(i, j, color);
        if (flag > 0){
            field.setCellState(i, j, color);
            return true;
        } else{
            return false;
        }
    }
}

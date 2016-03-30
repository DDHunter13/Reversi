package Rev;

public class AIPlayer implements Player{
    
    private int color;
    private int cellScore;
    
    public void AIPlayer(int col){
        this.color = col;
        this.cellScore = 0;
    }
    
    @Override
    public int getColor(){
        return this.color;
    }
    
    @Override
    public boolean makeMove(Field field, int i, int j){
        field.setCellState(i, j, color);
        return true;
    }
    
    public int[] chooseMove(Field field){
        int[] result = new int[2];
        int totalScore = 0;
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                int currentScore = field.courseCheck(i, j, color);
                if (currentScore != 0){
                    if (((i == 0) && (j == 0)) || ((i == 0) && (j == 7)) || ((i == 7) && (j == 0)) || ((i == 7) && (j == 7))){
                        currentScore += 100;
                    } else{
                        if ((i == 0) || (i == 7) || (j == 0) || (j == 7)){
                            currentScore += 10;
                        }
                    }
                }
                if (currentScore > totalScore){
                    totalScore = currentScore;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        
        return result;
    }
}

package Rev;

import java.io.Writer;

public class Console {
    
    public static void paintField(Field field){
        System.out.println();
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                System.out.print(field.getCellState(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main (String args[]){
        
        Player hp = new HumanPlayer(1);
        Player ai = new AIPlayer(2);
        
        Field fl = new Field(System.out);
        //paintField(fl);
        fl.outputField();
        
        
        int fff = 0;
        int x, y;
        while (fff == 0){
            
            if(FieldAnalyzer.playerCheck(fl, hp.getColor())){
                hp.makeMove(fl);
            }
            
            paintField(fl);
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            if(FieldAnalyzer.playerCheck(fl, ai.getColor())){
                ai.makeMove(fl);
            }
            
            paintField(fl);
            
            if(FieldAnalyzer.gameOver(fl)){
                System.out.println("GameOver");
                break;
            }            
        }
        
    }
}

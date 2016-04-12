package Rev;

import java.util.Scanner;

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
        
        HumanPlayer hp = new HumanPlayer(1);
        AIPlayer ai = new AIPlayer(2);
        Scanner sc = new Scanner(System.in);
        Field fl = new Field();
        paintField(fl);
        
        int fff = 0;
        int x, y;
        while (fff == 0){
            
            if(FieldAnalyzer.playerCheck(fl, hp.getColor())){
                x = sc.nextInt();
                y = sc.nextInt();
                if((x == 0) && (y == 0)){
                    break;
                }
                while(!hp.makeMove(fl, x - 1, y - 1)){
                    x = sc.nextInt();
                    y = sc.nextInt();
                   if((x == 0) && (y == 0)){
                        break;
                    }
                }
            }
            
            paintField(fl);
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            if(FieldAnalyzer.playerCheck(fl, ai.getColor())){
                int[] r = new int[2];
                r = ai.chooseMove(fl);
                ai.makeMove(fl, r[0], r[1]);
            }
            
            paintField(fl);
            
            if(FieldAnalyzer.gameOver(fl)){
                System.out.println("GameOver");
                break;
            }            
        }
        
    }
}

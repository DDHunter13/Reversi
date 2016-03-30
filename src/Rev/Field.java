package Rev;

public class Field {
    
    private Cell[][] fieldMatrix = new Cell[8][8];
    
    //Creates the empty field and places 1st 4 chips.
    public Field(){
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                fieldMatrix[i][j].setState(0);
            }
        }
        fieldMatrix[3][3].setState(1);
        fieldMatrix[4][4].setState(1);
        fieldMatrix[3][4].setState(2);
        fieldMatrix[4][3].setState(2);
    }
    
    public void setCellState(int i, int j, int st){
        fieldMatrix[i][j].setState(st);
    }
    
    public int getCellState(int i, int j){
        return fieldMatrix[i][j].getState();
    }
    
    //Check course. Returns the number of the cath chips.
    public int courseCheck(int i, int j, int pl){
        int flag = 0;
        
        if (fieldMatrix[i][j].getState() != 0) return 0; 
        
        if ((j - 1 > -1) && (fieldMatrix[i][j-1].getState() != pl) && (fieldMatrix[i][j-1].getState() != 0)){
            for (int k = j - 2; k > -1; --k){
                if (fieldMatrix[i][k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i][k].getState() == pl){
                        flag += Math.abs(j - k - 1);
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j - 1 > -1) && (fieldMatrix[i-1][j-1].getState() != pl) && (fieldMatrix[i-1][j-1].getState() != 0)){
            int k = 2;
            while ((i - k > -1) && (j - k > -1)){
                if (fieldMatrix[i-k][j-k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i-k][j-k].getState() == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i - 1 > -1) && (fieldMatrix[i-1][j].getState() != 0) && (fieldMatrix[i-1][j].getState() != pl)){
            for (int k = i - 2; k > -1; --k){
                if (fieldMatrix[k][j].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[k][j].getState() == pl){
                        flag += Math.abs(i - k - 1);
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j + 1 < 8) && (fieldMatrix[i-1][j+1].getState() != 0) && (fieldMatrix[i-1][j+1].getState() != pl)){
            int k = 2;
            while ((i - k > -1) && (j + k < 8)){
                if (fieldMatrix[i-k][j+k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i-k][j+k].getState() == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((j + 1 < 8) && (fieldMatrix[i][j+1].getState() != 0) && (fieldMatrix[i][j+1].getState() != pl)){
            for (int k = j + 2; k < 8; ++k){
                if (fieldMatrix[i][k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i][k].getState() == pl){
                        flag += Math.abs(k - j - 1);
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j + 1 < 8) && (fieldMatrix[i+1][j+1].getState() != 0) && (fieldMatrix[i+1][j+1].getState() != pl)){
            int k = 2;
            while ((i + k < 8) && (j + k < 8)){
                if (fieldMatrix[i+k][j+k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i+k][j+k].getState() == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i + 1 < 8) && (fieldMatrix[i+1][j].getState() != 0) && (fieldMatrix[i+1][j].getState() != pl)){
            for (int k = i + 2; k < 8; ++k){
                if (fieldMatrix[k][j].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[k][j].getState() == pl){
                        flag += Math.abs(k - i - 1);
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j - 1 > -1) && (fieldMatrix[i+1][j-1].getState() != 0) && (fieldMatrix[i+1][j-1].getState() != pl)){
            int k = 2;
            while ((i + k < 8) && (j - k > -1)){
                if (fieldMatrix[i+k][j-k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i+k][j-k].getState() == pl){
                        flag += k - 1;
                        break;
                    }
                }
            }
        }

        return flag;
    }
    
    
}

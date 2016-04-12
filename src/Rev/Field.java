package Rev;

public class Field {
    
    private Cell[][] fieldMatrix;
    
    //Creates the empty field and places 1st 4 chips.
    Field(){
        this.fieldMatrix = new Cell[8][8];
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                fieldMatrix[i][j] = new Cell();
            }
        }
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                this.fieldMatrix[i][j].setState(0);
            }
        }
        this.fieldMatrix[3][3].setState(1);
        this.fieldMatrix[4][4].setState(1);
        this.fieldMatrix[3][4].setState(2);
        this.fieldMatrix[4][3].setState(2);
    }
    
    
    public void setCellState(int i, int j, int st){
        fieldMatrix[i][j].setState(st);
        
        if ((j - 1 > -1) && (fieldMatrix[i][j - 1].getState() != st) && (fieldMatrix[i][j - 1].getState() != 0)){
            for (int k = j - 2; k > -1; --k){
                if (fieldMatrix[i][k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i][k].getState() == st){
                        for (int p = k + 1; p < j; ++p){
                            fieldMatrix[i][p].setState(st);
                        }
                        break;
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j - 1 > -1) && (fieldMatrix[i - 1][j - 1].getState() != st) && (fieldMatrix[i - 1][j - 1].getState() != 0)){
            int k = 2;
            while ((i - k > -1) && (j - k > -1)){
                if (fieldMatrix[i - k][j - k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i - k][j - k].getState() == st){
                        int p = k - 1;
                        while (p != 0){
                            fieldMatrix[i - p][j - p].setState(st);
                            --p;
                        }
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i - 1 > -1) && (fieldMatrix[i - 1][j].getState() != 0) && (fieldMatrix[i - 1][j].getState() != st)){
            for (int k = i - 2; k > -1; --k){
                if (fieldMatrix[k][j].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[k][j].getState() == st){
                        for (int p = k + 1; p < i; ++p){
                            fieldMatrix[p][j].setState(st);
                        }
                        break;
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j + 1 < 8) && (fieldMatrix[i - 1][j + 1].getState() != 0) && (fieldMatrix[i - 1][j + 1].getState() != st)){
            int k = 2;
            while ((i - k > -1) && (j + k < 8)){
                if (fieldMatrix[i - k][j + k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i - k][j + k].getState() == st){
                        int p = k - 1;
                        while (p != 0){
                            fieldMatrix[i - p][j + p].setState(st);
                            --p;
                        }
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((j + 1 < 8) && (fieldMatrix[i][j + 1].getState() != 0) && (fieldMatrix[i][j + 1].getState() != st)){
            for (int k = j + 2; k < 8; ++k){
                if (fieldMatrix[i][k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i][k].getState() == st){
                        for (int p = k - 1; p > j; --p){
                            fieldMatrix[i][p].setState(st);
                        }
                        break;
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j + 1 < 8) && (fieldMatrix[i + 1][j + 1].getState() != 0) && (fieldMatrix[i + 1][j + 1].getState() != st)){
            int k = 2;
            while ((i + k < 8) && (j + k < 8)){
                if (fieldMatrix[i + k][j + k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i + k][j + k].getState() == st){
                        int p = k - 1;
                        while (p != 0){
                            fieldMatrix[i + p][j + p].setState(st);
                            --p;
                        }
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i + 1 < 8) && (fieldMatrix[i + 1][j].getState() != 0) && (fieldMatrix[i + 1][j].getState() != st)){
            for (int k = i + 2; k < 8; ++k){
                if (fieldMatrix[k][j].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[k][j].getState() == st){
                        for (int p = k - 1; p > i; --p){
                            fieldMatrix[p][j].setState(st);
                        }
                        break;
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j - 1 > -1) && (fieldMatrix[i + 1][j - 1].getState() != 0) && (fieldMatrix[i + 1][j - 1].getState() != st)){
            int k = 2;
            while ((i + k < 8) && (j - k > -1)){
                if (fieldMatrix[i + k][j - k].getState() == 0){
                    break;
                } else{
                    if (fieldMatrix[i + k][j - k].getState() == st){
                        int p = k - 1;
                        while (p != 0){
                            fieldMatrix[i + p][j - p].setState(st);
                            --p;
                        }
                        break;
                    }
                }
                ++k;
            }
        }
    }
    
    public int getCellState(int i, int j){
        return fieldMatrix[i][j].getState();
    }    
    
}

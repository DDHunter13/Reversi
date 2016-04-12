package Rev;

public class FieldAnalyzer {
    
    public static boolean playerCheck(Field fl, int pl){
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                int flag = analize(fl, i, j, pl);
                if (flag != 0){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean gameOver(Field fl){
        int pl1 = 1;
        int pl2 = 2;
        if(!playerCheck(fl, pl1)){
            if(!playerCheck(fl, pl2)){
                return true;
            }
        }
        return false;
    }
    
    public static int analize(Field fl, int i, int j, int pl){
        int flag = 0;
        
        if (fl.getCellState(i, j) != 0) return 0; 
        
        if ((j - 1 > -1) && (fl.getCellState(i, j - 1) != pl) && (fl.getCellState(i, j - 1) != 0)){
            for (int k = j - 2; k > -1; --k){
                if (fl.getCellState(i, k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i, k) == pl){
                        flag += Math.abs(j - k - 1);
                        break;
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j - 1 > -1) && (fl.getCellState(i - 1, j - 1) != pl) && (fl.getCellState(i - 1, j - 1) != 0)){
            int k = 2;
            while ((i - k > -1) && (j - k > -1)){
                if (fl.getCellState(i - k, j - k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i - k, j - k) == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i - 1 > -1) && (fl.getCellState(i - 1, j) != 0) && (fl.getCellState(i - 1, j) != pl)){
            for (int k = i - 2; k > -1; --k){
                if (fl.getCellState(k, j) == 0){
                    break;
                } else{
                    if (fl.getCellState(k, j) == pl){
                        flag += Math.abs(i - k - 1);
                        break;
                    }
                }
            }
        }
        
        if ((i - 1 > -1) && (j + 1 < 8) && (fl.getCellState(i - 1, j + 1) != 0) && (fl.getCellState(i - 1, j + 1) != pl)){
            int k = 2;
            while ((i - k > -1) && (j + k < 8)){
                if (fl.getCellState(i - k, j + k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i - k, j + k) == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((j + 1 < 8) && (fl.getCellState(i, j + 1) != 0) && (fl.getCellState(i, j + 1) != pl)){
            for (int k = j + 2; k < 8; ++k){
                if (fl.getCellState(i, k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i, k) == pl){
                        flag += Math.abs(k - j - 1);
                        break;
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j + 1 < 8) && (fl.getCellState(i + 1, j + 1) != 0) && (fl.getCellState(i + 1, j + 1) != pl)){
            int k = 2;
            while ((i + k < 8) && (j + k < 8)){
                if (fl.getCellState(i + k, j + k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i + k, j + k) == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }
        
        if ((i + 1 < 8) && (fl.getCellState(i + 1, j) != 0) && (fl.getCellState(i + 1, j) != pl)){
            for (int k = i + 2; k < 8; ++k){
                if (fl.getCellState(k, j) == 0){
                    break;
                } else{
                    if (fl.getCellState(k, j) == pl){
                        flag += Math.abs(k - i - 1);
                        break;
                    }
                }
            }
        }
        
        if ((i + 1 < 8) && (j - 1 > -1) && (fl.getCellState(i + 1, j - 1) != 0) && (fl.getCellState(i + 1, j - 1) != pl)){
            int k = 2;
            while ((i + k < 8) && (j - k > -1)){
                if (fl.getCellState(i + k, j - k) == 0){
                    break;
                } else{
                    if (fl.getCellState(i + k, j - k) == pl){
                        flag += k - 1;
                        break;
                    }
                }
                ++k;
            }
        }

        return flag;      
    }
}

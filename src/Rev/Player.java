package Rev;

public interface Player {
    
    public boolean makeMove(Field field);
    public int[] moveAsk(Field field);
    public int getColor();
    
}

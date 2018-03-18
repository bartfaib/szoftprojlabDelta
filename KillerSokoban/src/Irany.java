
public enum Irany {
	FEL(1), JOBBRA(2), LE(3), BALRA(4);
	
	 private int value;

	    private Irany(int value) {
	        this.value = value;
	    }
	    
	    
	    public int getValue() {
	        return value;
	    }
}

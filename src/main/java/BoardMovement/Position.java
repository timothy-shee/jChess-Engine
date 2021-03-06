package BoardMovement;

public class Position {
	int x;
	int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}

	public void setX(int x) {
		this.x = x;
	}
	public boolean equals(Position otherPos){
		return((x==otherPos.x)&&(y==otherPos.y));
	}
}

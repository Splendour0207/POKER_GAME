package poker_demo;


public class Poker {
	private String pokerPoint;
	private String pokerColour;
	
	
	public Poker(){
	}
	public Poker(String pokerPoint,String pokerColour){
		this.pokerPoint= pokerPoint;
		this.pokerColour = pokerColour;
		
	}
	
	public String getPokerPoint(){
		return pokerPoint;
	}
	public void setPokerPoint(String pokerPoint){
		this.pokerPoint = pokerPoint;
	}
	public String getPokerColour() {
		return pokerColour;
	}
	public void setPokerColour(String pokerColour) {
		this.pokerColour = pokerColour;
	}
	
}

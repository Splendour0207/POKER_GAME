package poker_demo;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private String name;
	private List<Poker> handPoker;
	
	public Player(){
		this.handPoker  = new ArrayList<Poker>();
	}
	public Player(int id,String name){
		this.id = id;
		this.name = name;
//		this.handPoker  = new ArrayList<Poker>();只是初始化，就得放在无参数的构造函数中
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Poker> getHandPoker() {
		return handPoker;
	}
	public void setHandPoker(List<Poker> handPoker) {
		this.handPoker = handPoker;
	}
	
	
	
	
	
	
}

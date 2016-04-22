package poker_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestGame {
	private List<Poker> pokers;
	private List<Player> players;
	
	public TestGame(){
		this.players = new ArrayList<Player>();
		this.pokers = new ArrayList<Poker>();
		
	}
	/**
	 * 创建一副牌
	 */
	public void pokersGenerate(){
		
		String[] colours = {"方块","梅花","红桃","黑桃"};
		String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","k","A"};
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
//				实例化一副具体的牌
				Poker card= new Poker();
				card.setPokerColour(colours[i]);
				card.setPokerPoint(points[j]);
				
				pokers.add(card);
			}
		}
		System.out.println("共有扑克牌：" + pokers.size() + "张！");
		System.out.println("分别为：");
		for(int n = 0; n < pokers.size(); n++){
		System.out.print( pokers.get(n).getPokerColour() + pokers.get(n).getPokerPoint() + "\t");
//		System.out.println();
		
		}
		System.out.println();
	}
	
	
	/**
	 * 创建两个玩家
	 */
	public void playerGenerate(){
		int i = 1;
		while(i < 3){
			try{
			int flag = 0 ;//标志位
			Scanner console = new Scanner(System.in);
			System.out.println("请输入第" + i + "名玩家id：");
			int ID = console.nextInt();
//			判断玩家Id是否已经存在
			for(Player ppp : players){
					if(ppp.getId() == ID){
						flag = 1 ;
					}
				}
			if(flag ==1 ){
				System.out.println("该ID已经被占用！");
				continue;
			}else{
			System.out.println("请输入玩家姓名：");
			String name = console.next();
//			实例化一个具体玩家
			Player pl = new Player();
			pl.setId(ID);
			pl.setName(name);
//			将玩家i添加到玩家列表中
			players.add(pl);
			System.out.println("玩家" + i + "创建成功！");
			i++;
			}
			}catch(Exception e){
				System.out.println("您的输入有误，请重新输入数字id：");
				continue;
			}
		}
		System.out.println("共有2名玩家：");
		System.out.println("为：");
		for(Player p : players){
			System.out.println( p.getId() + p.getName() );
		}
	}
	
	/**
	 * 洗牌
	 */
	public void pokerWashing(){
		System.out.println("---------洗牌开始--------");
		Collections.shuffle(pokers);
		System.out.println("---------洗牌结束---------");
		System.out.println("共有：");
		for(Poker p : pokers){
			
			System.out.println(p.getPokerColour() + p.getPokerPoint());
		}
	}
	
	/**
	 *发牌
	 * @param args
	 */
	public void pokerGiving(){

		System.out.println("---------开始发牌--------");
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
//				从上开始拿出一张牌
				Poker poker = pokers.get(0);
//				发给一名玩家
				Player playerj = players.get(j);
//				添加至玩家的手牌列表中
				playerj.getHandPoker().add(poker);
//				移除pokers列表中的第一张，以便拿出下一张
				pokers.remove(0);
				
			}
		}
		System.out.println("---------发牌成功---------");
	}
	/**
	 * 打印双方的牌
	 * @param args
	 */
	public void allTheCard(){
		for(int i = 1; i < 3; i++){
			for(int j = 1; j < 3; j++){
			System.out.println("玩家"+ players.get(i - 1).getId() + ": " + players.get(i - 1).getName() + "的第"+ j + "张手牌为：" +
					players.get(i - 1).getHandPoker().get(j - 1).getPokerColour() +
						players.get(i - 1).getHandPoker().get(j - 1).getPokerPoint());
			}
		}
	}
	
	/**
	 * 比较牌大小
	 * @param args
	 */
	public void pokerComparing(){
		/*
		 * 找出同一玩家手中的最大牌,然后比较两名玩家手中最大的牌
		 */
//		实例化比较规则
		PokerComparator pc = new PokerComparator();
		for(int i = 0; i < 2; i++){
			Collections.sort(players.get(i).getHandPoker(),pc);//列表的比较方法
			System.out.println("玩家" + players.get(i).getId() + ": " + players.get(i).getName() + "手中最大的牌为：" + 
					players.get(i).getHandPoker().get(1).getPokerColour() +
						players.get(i).getHandPoker().get(1).getPokerPoint());
		}
//		此处只需比较两个玩家手中牌列表中的最大值
		if(pc.compare(players.get(0).getHandPoker().get(1), players.get(1).getHandPoker().get(1)) > 0){
			System.out.println("所以，玩家" + players.get(0).getName() + "获胜！");
		}else{
			System.out.println("所以，玩家" + players.get(1).getName() + "获胜！");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestGame  tg = new TestGame();
		tg.pokersGenerate();
		tg.playerGenerate();
		tg.pokerWashing();
		tg.pokerGiving();
		tg.pokerComparing();
		tg.allTheCard();
	}

}

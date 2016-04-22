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
	 * ����һ����
	 */
	public void pokersGenerate(){
		
		String[] colours = {"����","÷��","����","����"};
		String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","k","A"};
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
//				ʵ����һ���������
				Poker card= new Poker();
				card.setPokerColour(colours[i]);
				card.setPokerPoint(points[j]);
				
				pokers.add(card);
			}
		}
		System.out.println("�����˿��ƣ�" + pokers.size() + "�ţ�");
		System.out.println("�ֱ�Ϊ��");
		for(int n = 0; n < pokers.size(); n++){
		System.out.print( pokers.get(n).getPokerColour() + pokers.get(n).getPokerPoint() + "\t");
//		System.out.println();
		
		}
		System.out.println();
	}
	
	
	/**
	 * �����������
	 */
	public void playerGenerate(){
		int i = 1;
		while(i < 3){
			try{
			int flag = 0 ;//��־λ
			Scanner console = new Scanner(System.in);
			System.out.println("�������" + i + "�����id��");
			int ID = console.nextInt();
//			�ж����Id�Ƿ��Ѿ�����
			for(Player ppp : players){
					if(ppp.getId() == ID){
						flag = 1 ;
					}
				}
			if(flag ==1 ){
				System.out.println("��ID�Ѿ���ռ�ã�");
				continue;
			}else{
			System.out.println("���������������");
			String name = console.next();
//			ʵ����һ���������
			Player pl = new Player();
			pl.setId(ID);
			pl.setName(name);
//			�����i��ӵ�����б���
			players.add(pl);
			System.out.println("���" + i + "�����ɹ���");
			i++;
			}
			}catch(Exception e){
				System.out.println("��������������������������id��");
				continue;
			}
		}
		System.out.println("����2����ң�");
		System.out.println("Ϊ��");
		for(Player p : players){
			System.out.println( p.getId() + p.getName() );
		}
	}
	
	/**
	 * ϴ��
	 */
	public void pokerWashing(){
		System.out.println("---------ϴ�ƿ�ʼ--------");
		Collections.shuffle(pokers);
		System.out.println("---------ϴ�ƽ���---------");
		System.out.println("���У�");
		for(Poker p : pokers){
			
			System.out.println(p.getPokerColour() + p.getPokerPoint());
		}
	}
	
	/**
	 *����
	 * @param args
	 */
	public void pokerGiving(){

		System.out.println("---------��ʼ����--------");
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
//				���Ͽ�ʼ�ó�һ����
				Poker poker = pokers.get(0);
//				����һ�����
				Player playerj = players.get(j);
//				�������ҵ������б���
				playerj.getHandPoker().add(poker);
//				�Ƴ�pokers�б��еĵ�һ�ţ��Ա��ó���һ��
				pokers.remove(0);
				
			}
		}
		System.out.println("---------���Ƴɹ�---------");
	}
	/**
	 * ��ӡ˫������
	 * @param args
	 */
	public void allTheCard(){
		for(int i = 1; i < 3; i++){
			for(int j = 1; j < 3; j++){
			System.out.println("���"+ players.get(i - 1).getId() + ": " + players.get(i - 1).getName() + "�ĵ�"+ j + "������Ϊ��" +
					players.get(i - 1).getHandPoker().get(j - 1).getPokerColour() +
						players.get(i - 1).getHandPoker().get(j - 1).getPokerPoint());
			}
		}
	}
	
	/**
	 * �Ƚ��ƴ�С
	 * @param args
	 */
	public void pokerComparing(){
		/*
		 * �ҳ�ͬһ������е������,Ȼ��Ƚ������������������
		 */
//		ʵ�����ȽϹ���
		PokerComparator pc = new PokerComparator();
		for(int i = 0; i < 2; i++){
			Collections.sort(players.get(i).getHandPoker(),pc);//�б�ıȽϷ���
			System.out.println("���" + players.get(i).getId() + ": " + players.get(i).getName() + "����������Ϊ��" + 
					players.get(i).getHandPoker().get(1).getPokerColour() +
						players.get(i).getHandPoker().get(1).getPokerPoint());
		}
//		�˴�ֻ��Ƚ���������������б��е����ֵ
		if(pc.compare(players.get(0).getHandPoker().get(1), players.get(1).getHandPoker().get(1)) > 0){
			System.out.println("���ԣ����" + players.get(0).getName() + "��ʤ��");
		}else{
			System.out.println("���ԣ����" + players.get(1).getName() + "��ʤ��");
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

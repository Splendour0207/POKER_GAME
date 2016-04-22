package poker_demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PokerComparator implements Comparator<Poker> {
	
//	List<String> colours = 
 
//	String[] colours = {"����","÷��","����","����"};
//	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K"};
//	����ֻ��һ��λ�÷���һ�������������γ�һ���ܵ��ַ���
	List<String> colours =Arrays.asList("����","÷��","����","����");
	List<String> points = Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A");
	@Override
	public int compare(Poker o1, Poker o2) {
		// TODO Auto-generated method stub
		if((points.indexOf(o1.getPokerPoint())) == 
				(points.indexOf(o2.getPokerPoint()))){
			return ((Integer)(colours.indexOf(o1.getPokerColour())))
					.compareTo((Integer)(colours.indexOf(o2.getPokerColour())));
		}
		else{
			return((Integer)(points.indexOf(o1.getPokerPoint())))
					.compareTo((Integer)(points.indexOf(o2.getPokerPoint())));
		}
		
		
		
	}

}

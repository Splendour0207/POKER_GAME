package poker_demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PokerComparator implements Comparator<Poker> {
	
//	List<String> colours = 
 
//	String[] colours = {"方块","梅花","红桃","黑桃"};
//	String[] points = {"2","3","4","5","6","7","8","9","10","J","Q","K"};
//	数组只是一个位置放置一个数，而不能形成一个总的字符串
	List<String> colours =Arrays.asList("方块","梅花","红桃","黑桃");
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

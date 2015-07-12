package utils;

public class Utils {
	
	public static String formatNumber(float x) {
		String y = String.valueOf(x);
		for(int i = y.length(); i < 15; i++)
			y += " ";
		
		return y;	
	}

}

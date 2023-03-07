package Generic_utility;

import java.util.Random;

public class Java_Utility {
/**
 * this method is used to avoid duplicate value
 * @return
 * @author adhi1
 */

	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}


import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String word = scanner.nextLine();
		
	    System.out.println(word);
	    scanner.close();
	}
	
	/** Check Date is valid or not
	 * @param date
	 * @throw illegalArgumentException
	 * 	If year, month, day contains decimal point parsing from string,
	 * 	it will throw illegalArgument Exception
	 * @return true if date exist. Otherwise, false
	 * 	* Example: someObject.ValidDate(2022/02/29): return false
	 * 	Time estimate: O(1)
	 */
	public boolean ValidDate(String date) {
		return true;
	}
}

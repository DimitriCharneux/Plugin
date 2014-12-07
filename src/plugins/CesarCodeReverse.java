package plugins;

import plugin.Plugin;

public class CesarCodeReverse implements Plugin{

	/** the down of character (1 for strict Cesar Code reverse) 
	  */
	private int down;

	/**
	 * a Cesar Code reverse where down is 1
	 */
	public CesarCodeReverse() {
		this(1); 
	}

	/** Create a code where the down of character is more than 1 (no more a strict Cesar Code reverse)
	 * @param down value of character down
	 */
	public CesarCodeReverse(int down) {
		this.down = down;
	}

	/** Apply a Cesar Code reverse to the text (ie. a down by 1 character)
	 * @see plugin.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isLowerCase(c)) {
					c = (char) ('a' + (((c - 'a') - this.down) % 26));
				} else {
					c = (char) ('A' + (((c - 'A') - this.down) % 26));
				}
			}
			res = res + c;
		}
		return res;
	}

	/**
	 * @see plugin.Plugin#getLabel()
	 */
	public String getLabel() {
		return "Cesar Code reverse " + this.down;
	}

	/**
	 * @see plugin.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Apply a Cesar Code reverse to the text (ie. a down by 1 character)";
	}
}

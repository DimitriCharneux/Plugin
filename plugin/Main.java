package plugin;

public class Main {
	public static void main(String[] args) {
		/*ClassFile file = new ClassFile();
		String[] str = file.listName(new ClassFilter());
		for(String st : str){
			System.out.println(st);
		}*/
		
		FileChecker checker = new FileChecker(new ClassFilter());
		FileListener listener = new FileDetector();
		checker.addFileListener(listener);
		checker.startTimer();
		while(true){
			
		}
	}

}

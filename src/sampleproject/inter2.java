package sampleproject;
abstract class tfi {
	String name;
	abstract void start();
}
 class banisa extends tfi {
	void start() {
		System.out.println("movie is starting..");
		
	}
}
public class inter2 {

	public static void main(String[] args) {
		banisa b = new banisa();
		b.start();

	}

}

package sampleproject;
interface movie{
	void start();
}
class khaleja implements movie{
	public void start() {
		System.out.println("Movie is starting..");
	}
}
public class interface1 {
	public static void main(String[] args) {
		khaleja k = new khaleja();
		k.start();
	}
}

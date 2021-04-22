package bfsdfs.p2;

public class Test {

	public static void main(String[] args) {
		boolean[] chk = new boolean[2];
		change(chk);
		System.out.println(chk[0]+", "+chk[1]);
	}
	
	public static void change(boolean[] ch) {
		ch[0] = true;
	}

}


public class Test {

	public static void main(String[] args) {
		String s = "a b c  ";
		System.out.println(s.trim());
		try {
			Thread.sleep(1000);
			Thread.currentThread().start();
			new Test().s();
		} catch (Exception e) {
			System.out.println("main========");
			e.printStackTrace();
		}finally{
			System.out.println("hh");
		}
		System.out.println("bb");
	}
	public void s(){
		try {
			Thread.sleep(1000);
			//Thread.currentThread().start();
		} catch (Exception e) {
			System.out.println("way");
			e.printStackTrace();
		}
	}
}

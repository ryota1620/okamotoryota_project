package method.q05;

public class Triangle {
	public static void main(String[] args) {
		int x = 8,y = 5;
		int ans = getTriangleArea(x,y);
		System.out.println("底辺:" + x);
		System.out.println("高さ:" + y);
		System.out.println("三角形の面積:" + ans);
	}
	
	public static int getTriangleArea(int x,int y) {
		return x * y / 2;
	}
}
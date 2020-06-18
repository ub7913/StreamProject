package lambdaExample;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		IntSupplier intSupplier = new IntSupplier() {

			@Override
			public int getAsInt() {
				int num = (int) (Math.random() * 6) + 1;
				return num;
			}
			
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수: "+num);
	}
}

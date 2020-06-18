package lambdaExample;

import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + "8");
			}
			
		};
		
		consumer.accept("java");
	}
}

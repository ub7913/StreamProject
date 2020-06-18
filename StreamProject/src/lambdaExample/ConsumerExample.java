package lambdaExample;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + "8");
			}
			
		};
		consumer.accept("java");
		
		BiConsumer<String, String> bigConsumer = new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.println(t + u);
			}
			
		};
		bigConsumer.accept("java", "8");
		
		DoubleConsumer doubleConsumer = new DoubleConsumer() {

			@Override
			public void accept(double value) {
				System.out.println("Java"+value);
			}
			
		};
		doubleConsumer.accept(8.0);
		
		ObjIntConsumer<String> objIntconsumer = new ObjIntConsumer<String>() {

			@Override
			public void accept(String t, int value) {
				System.out.println(t+value);
			}
			
		};
		objIntconsumer.accept("java", 8);
	}
}

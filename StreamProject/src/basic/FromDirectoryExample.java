package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FromDirectoryExample {
	public static void main(String[] args) {
		// path
		Path path = Paths.get("c:/program files");
		try {
			Stream<Path> stream = Files.list(path);
//			stream.forEach(new Consumer<Path>() {
//
//				@Override
//				public void accept(Path t) {
//					System.out.println(t.getFileName());
//				}
//			});
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// file
		path = Paths.get(".project");//src/basic/FromDirectoryExample.java : 현재 파일의 위치, 아무 위치 지정 없이(상대경로 없이) 파일만 넣으니까 현재 위치는 D:\Dev\workspace\StreamProject 이다. StreamProject 하위 ..root디렉토리.
		try {
			Stream<String> strStream = Files.lines(path); // 한라인씩 이파일의 내용들을 읽어 온다.
			strStream.forEach(System.out::println);/*(t -> System.out.println(t .toString() ));*/  //매개값 t가 별로 하는 일이 없어서 람다식으로 없애고System.out::println 출력해낼 수 있다.
			strStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

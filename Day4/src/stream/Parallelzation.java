package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parallelzation {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("»ç°ú", "¹è", "µþ±â", "±Ö", "¸Á°í", "´ëÃß");
		System.out.println("ÄÚ¾î °³¼ö: " + Runtime.getRuntime().availableProcessors());
		
//		Stream<String> stream = list.stream(); // run by serially 
		Stream<String> stream = list.parallelStream(); // run by parallelly on multi-core CPU. fast speed
		stream.forEach( a -> {System.out.println(a);} );
	}
}

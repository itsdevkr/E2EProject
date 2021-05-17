package StreamsTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alkheya");
		names.add("Adam");
		names.add("Ram");
		
		int count = 0;
		for(int i=0;i<names.size();i++) {
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alkheya");
		names.add("Adam");
		names.add("Ram");
		
		//There is no life for intermediary operation if there is no terminal operation
		//Terminal operation will execute only if intermediary operation return true
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
	
		long d = Stream.of("Abhijeet","Don","Alkheya","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			return false;
		}).count();
		
		System.out.println(d);
		
		//Print all name whose length is greater than 4
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Man");
		names.add("Don");
		names.add("Woman");
		
		//Print names ending with "a" in Upper Case
		Stream.of("Abhijeet","Don","Alkheya","Adam","Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		//Print names staring with "A" in sorting order
		List<String> names1 = Arrays.asList("Azbhijeet","Don","Alkheya","Adam","Ram");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void stramCollect() {
		List<String> ls = Stream.of("Abhijeet","Don","Alkheya","Adam","Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,5,7,9,1,7);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(3));
	}
	
}

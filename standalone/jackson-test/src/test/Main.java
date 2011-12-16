package test;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonView;

public class Main {
	public static class PublicView {}
	
	public static class Foo {
		@JsonProperty
		String name = "fooName";
		public String getName() { return this.name; }
	}
	
	public static class Bar extends Foo {
		@JsonProperty
		@JsonView(PublicView.class) String more = "fooMore";
		public String getMore() { return this.more; }
	}

	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		Foo foo = new Foo();
		String pretty = mapper.writerWithView(Object.class).withDefaultPrettyPrinter().writeValueAsString(foo);
		
		System.out.println(pretty);
	}

}

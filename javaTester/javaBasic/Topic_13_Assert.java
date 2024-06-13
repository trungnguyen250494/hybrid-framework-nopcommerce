package javaBasic;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class Topic_13_Assert {

	@Test
	public void TC_01(){
		Topic_13_Assert frodo = new Topic_13_Assert();
		Topic_13_Assert sauron = new Topic_13_Assert();

		// basic assertions
		assertThat(frodo.getName()).isEqualTo("Frodon");
		assertThat(frodo).isNotEqualTo(sauron);

		// chaining string specific assertions
		assertThat(frodo.getName()).startsWith("Fro")
		                           .endsWith("do")
		                           .isEqualToIgnoringCase("frodo");
	}

	public String getName() {
		return "Frodo";
	}
}

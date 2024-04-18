package com.cwr.tliaswebmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Map.of(
				"key1", "value1",
				"key2", "value2",
				"key3", "value3"
		));
	}

}

package com.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationServiceTest {

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		OperationService os=new OperationService();
		int result=os.add(100, 200);
		assertEquals(300, result);
	}

	@Test
	void testSub() {
		//fail("Not yet implemented");
		OperationService os=new OperationService();
		int result=os.sub(1000, 500);
		assertEquals(500, result);
	}

}

package com.jdes.darts;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


class DmInstrucTest {
	
	

	@Test
	void test1() {
		MainInstructions instruc = mock(MainInstructions.class);
		doNothing().when(instruc).start();
		
		
		
		verify(instruc, times(1)).start();
		
		
		
		
	}

}

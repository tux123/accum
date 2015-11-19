package my.accum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public abstract class AccumulatorAbstractTest {

	Accumulator accumulator;
	@Before
	public abstract void setUp() throws Exception;

	@Test
	public void testAccumulate() {
		
		System.out.println("INFO: Java version=" +  System.getProperty("java.version"));
		
		assertEquals(accumulator.accumulate(), 0);
		assertEquals(accumulator.accumulate(1), 1);
		assertEquals(accumulator.accumulate(), 0);
		assertEquals(accumulator.accumulate(10,20,30), 60);
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testAccumulateMaxOverflow() {
		
		int overflow = Integer.MAX_VALUE - 1 ;
		accumulator.accumulate(10);
		accumulator.accumulate(overflow);
		
		
	}
	
	@Test(expected=ArithmeticException.class)
	public void testAccumulateMinOverflow() {
		
		int overflow = Integer.MIN_VALUE + 1;
		accumulator.accumulate(-1000);
		accumulator.accumulate(overflow);
		
		
		
	}

	@Test
	public void testGetTotal() {
		assertEquals(accumulator.getTotal(), 0);
		accumulator.accumulate(30,30);
		assertEquals(accumulator.getTotal(), 60);
		
	}

	@Test
	public void testReset() {
		accumulator.reset();
		assertEquals(accumulator.getTotal(), 0);
	}

}

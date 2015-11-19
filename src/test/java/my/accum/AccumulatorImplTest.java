package my.accum;

public class AccumulatorImplTest extends AccumulatorTest {

	public void setUp() throws Exception {
		accumulator = new AccumulatorImpl();
	}
	
	public void tearDown() throws Exception {
		accumulator.reset();
	}

}

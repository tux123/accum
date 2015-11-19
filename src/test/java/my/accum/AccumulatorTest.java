package my.accum;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccumulatorTest extends AccumulatorAbstractTest {

	@Override
	public void setUp() throws Exception {

		accumulator = mock(Accumulator.class);

		{
			// accumulate() method tests
			when(accumulator.accumulate()).thenReturn(0).thenReturn(0);
			when(accumulator.accumulate(1)).thenReturn(1);
			when(accumulator.accumulate(1, 2)).thenReturn(3);
			when(accumulator.accumulate(10, 20, 30)).thenReturn(60);
		}
		{
			// accumulate() overflow tests
			int max = Integer.MAX_VALUE - 1;
			when(accumulator.accumulate(max)).thenThrow(new ArithmeticException());
			int min = Integer.MIN_VALUE + 1;
			when(accumulator.accumulate(min)).thenThrow(new ArithmeticException());
		}
		{
			// getTotal() test
			when(accumulator.getTotal()).thenReturn(0).thenReturn(60);
		}
		{
			// reset() tests
		}

	}

}

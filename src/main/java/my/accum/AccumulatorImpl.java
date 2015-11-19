package my.accum;

public class AccumulatorImpl implements Accumulator {
	
	private int total = 0;

	public int accumulate(int... values) {
		
		if ( values.length == 0 ){
			return 0;
		}
		
		int sum = 0;
		for (int i:values){
			sum= addSafely(sum, i);
		}
		
		total = addSafely(total, sum); 
		return sum;
	}

	public int getTotal() {
		return this.total;
	}

	public void reset() {
		this.total = 0;
	}
	
	
	private int addSafely(int a, int b){
		return Math.addExact(a, b);
	}
	

}

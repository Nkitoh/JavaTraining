package ch03_05;

abstract class Benchmark {
	abstract void benchmark();

	public final long repeat(int count) {
		long start = System.nanoTime();
		
		for (int i = 0; i < count; i++)
			benchmark();
		
		return (System.nanoTime() - start);
	}
}

class MethodBenchmark extends Benchmark {
	private int benchLoopCount;
	
	void setBenchLoopCount(int count){
		benchLoopCount = count;
	}
	
	void benchmark() {
		for(int i = 0; i < benchLoopCount ; i++);
	}
	
}

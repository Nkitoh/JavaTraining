package ch03_05;

public class Ex03_05 {

	public static void main(String[] args) {
		int count = 1000;
		MethodBenchmark Benchmark = new MethodBenchmark();
		Benchmark.setBenchLoopCount(100000);
		long time = Benchmark.repeat(count);
		System.out.println(count + "meghods in" + time + "nanoseconds");

	}

}

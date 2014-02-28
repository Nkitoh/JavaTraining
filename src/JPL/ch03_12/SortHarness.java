package ch03_12;

abstract class SortHarness {
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	
	public final SortMetrics sort(Object[] data) {
		values = data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}
	
	protected final int getDataLength() {
		return values.length;
	}
	
	protected final Object probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}
	
	protected final int compare(int i, int j){
		curMetrics.compareCnt++;
		Object o1 = values[i];
		Object o2 = values[j];
		
		
		return o1.toString().compareTo(o2.toString());
	}
	
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	//ソートが成功しているかを判定
	protected final boolean isSorted(){
		for(int i = 0; i < getDataLength()-1; i++)
			if(compare(i, i+1) > 0)
				return false;
		
		return true;		
	}
	
	protected abstract void doSort();

}

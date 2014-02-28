package ch04_02;

class SimpleSortHarness implements SortKind {

	public void doSort(SortHarness method) {
		for(int i = 0; i < method.getDataLength(); i++) {
			for(int j = i + 1; j < method.getDataLength(); j ++) {
				if (method.compare(i, j) > 0)
					method.swap(i, j);
			}
		}
	}
}




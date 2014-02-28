package ch03_11;

class SimpleSortDouble extends SortDouble implements Cloneable{
	double[] hackData = {0.1,0,2};
	int count = 0;
	
	protected void doSort() {
			if(count == 0){
				doSort2();
				count++;
				super.sort(hackData);
			}
	}
	
	protected void doSort2(){
		for(int i = 0; i < getDataLength(); i++) {
			for(int j = i + 1; j < getDataLength(); j ++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
	}

}




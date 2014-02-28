package ch01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex01_16 {

	public static void main(String[] args) throws BadDataSetException {
		MyUtilityeis test = new MyUtilityeis();
		double[] data_test = new double[10];
		data_test = test.getDataSet("ex_01_16");

		for (int i = 0; i < data_test.length; i++) {
			System.out.println(data_test[i]);
		}
	}

}

class BadDataSetException extends Exception {
	private String dataSetName;
	private IOException e;

	BadDataSetException(String dataSetName, IOException e) {
		this.dataSetName = dataSetName;
		this.e = e;
	}

	public String getDataSetName() {
		return this.dataSetName;
	}

	public IOException getIOException() {
		return this.e;
	}
}

class MyUtilityeis {
	public double[] getDataSet(String setName) throws BadDataSetException {

		String file = setName + ".dset";
		FileInputStream in = null;

		try {
			in = new FileInputStream(file);
			return readDataSet(in);

		} catch (IOException e) {
			BadDataSetException err = new BadDataSetException(setName, e);
			System.err.println(err.getIOException());
			throw err;
		} finally {
			try {
				if (in != null)
					in.close();

			} catch (IOException e) {
			}
		}
	}

	// .dsetファイルの","で区切られた実数を配列に代入
	public double[] readDataSet(FileInputStream in)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<Double> dlist = new ArrayList<Double>();
		String line;

		while ((line = br.readLine()) != null) {
			String[] sp = line.split(",");

			for (int i = 0; i < sp.length; i++) {
				dlist.add(Double.parseDouble(sp[i]));
			}

		}

		double[] array = new double[dlist.size()];
		for (int i = 0; i < dlist.size(); i++) {
			array[i] = dlist.get(i);

		}

		br.close();

		return array;
	}

}

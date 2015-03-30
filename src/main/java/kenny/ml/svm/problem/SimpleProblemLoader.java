package kenny.ml.svm.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kenny.ml.svm.FeatureSpace;


public class SimpleProblemLoader implements IProblemLoader {

	/**
	 * Loads a binary problem from file, i.e. having 2 classes.
	 */
	@Override
	public Problem load(String fileName) {
		System.out.println("Loading problem: " + fileName);
		Problem problem = new Problem();
		String row;
		ArrayList<Integer> classes = new ArrayList<Integer>();
		ArrayList<FeatureSpace> examples = new ArrayList<FeatureSpace>();

		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)));
			while ((row = r.readLine()) != null) {
				String[] elems = row.split(" ");
				// Category:
				Integer cat = Integer.parseInt(elems[0]);
				System.out.print(cat + ": ");
				problem.catmap.addCategory(cat);
				if (problem.catmap.size() > 2) {
					throw new IllegalArgumentException("only 2 classes allowed!");
				}
				classes.add(problem.catmap.getNewCategoryOf(cat));
				// Index/value pairs:
				examples.add(parseRow(elems));
			}
			problem.x = new FeatureSpace[examples.size()];
			problem.y = new int[examples.size()];
			for (int i = 0; i < examples.size(); i++) {
				problem.x[i] = examples.get(i);
				problem.y[i] = 2 * classes.get(i) - 1; // 0,1 => -1,1
			}
			problem.l = examples.size();
		} catch (Exception e) {
			System.out.println(e);
		}
		return problem;
	}

	/**

	 * @param row The already split row on spaces.
	 * @return The corresponding FeatureSpace.
	 */
	private FeatureSpace parseRow(String[] row) {
		FeatureSpace example = new FeatureSpace(row.length - 1);
		for (int i = 1; i < row.length; i++) {
			System.out.print(row[i] + " ");
			double value = Double.parseDouble(row[i]);
			example.set(i - 1, value);
		}
		System.out.println();
		return example;
	}
}

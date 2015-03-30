package kenny.ml.svm;

import org.junit.Test;

import kenny.ml.svm.kernels.Polynomial;
import kenny.ml.svm.problem.IProblemLoader;
import kenny.ml.svm.problem.Problem;
import kenny.ml.svm.problem.SimpleProblemLoader;

public class LinearRunner {
	
	@Test
	public void runTest() {
		SupportVectorMachine svm = new SupportVectorMachine();

		IProblemLoader loader = new SimpleProblemLoader();
		
		Problem train = loader.load("data/linear_train.svm");
		Problem test = loader.load("data/linear_test.svm");
		
		System.out.println("Loaded.");
		System.out.println("Training...");
		KernelParams kp = new KernelParams(new Polynomial(), 10, 1, 1);
		svm.train(train, kp);
		System.out.println("Testing...");
		int[] pred = svm.test(test, true);

		EvalMeasures e = new EvalMeasures(test, pred, 2);
		System.out.println("Accuracy=" + e.accuracy());

		System.out.println("Done.");
	}
}
package svm;

import org.junit.Test;

import svm.EvalMeasures;
import svm.KernelParams;
import svm.SupportVectorMachine;
import svm.kernels.Polynomial;
import svm.problem.IProblemLoader;
import svm.problem.Problem;
import svm.problem.SimpleProblemLoader;

public class LinearRunner {
	
	@Test
	public void runTest() {
		SupportVectorMachine svm = new SupportVectorMachine();

		IProblemLoader loader = new SimpleProblemLoader();
		
		Problem train = loader.load("svm/data/linear_train.svm");
		Problem test = loader.load("svm/data/linear_test.svm");
		
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

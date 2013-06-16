package svm;

import org.junit.Test;

import svm.EvalMeasures;
import svm.KernelParams;
import svm.SupportVectorMachine;
import svm.kernels.Polynomial;
import svm.problem.IProblemLoader;
import svm.problem.LibSVMProblemLoader;
import svm.problem.Problem;

public class LinearLibSVMFormatRunner {
	
	@Test
	public void runTest() {
		SupportVectorMachine svm = new SupportVectorMachine();

		IProblemLoader loader = new LibSVMProblemLoader();
		
		Problem train = loader.load("svm/data/libsvm/linear_train.libsvm");
		Problem test = loader.load("svm/data/libsvm/linear_test.libsvm");
		
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

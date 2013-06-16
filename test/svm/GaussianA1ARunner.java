package svm;

import org.junit.Test;

import svm.EvalMeasures;
import svm.KernelParams;
import svm.SupportVectorMachine;
import svm.kernels.Gaussian;
import svm.problem.IProblemLoader;
import svm.problem.LibSVMProblemLoader;
import svm.problem.Problem;

public class GaussianA1ARunner {
	
	@Test
	public void runTest() {
		SupportVectorMachine svm = new SupportVectorMachine();

		IProblemLoader loader = new LibSVMProblemLoader();
		
		Problem train = loader.load("svm/data/libsvm/a1a_train.libsvm");
		Problem test = loader.load("svm/data/libsvm/a1a_test.libsvm");
		
		System.out.println("Loaded.");
		System.out.println("Training...");
		
		KernelParams kp = new KernelParams(new Gaussian(), 0.03);
		kp.setC(Math.pow(2, 0));
		
		svm.train(train, kp);
		System.out.println("Testing...");
		int[] pred = svm.test(test, true);

		EvalMeasures e = new EvalMeasures(test, pred, 2);
		System.out.println("Accuracy=" + e.accuracy());

		System.out.println("Done.");
	}
	
}

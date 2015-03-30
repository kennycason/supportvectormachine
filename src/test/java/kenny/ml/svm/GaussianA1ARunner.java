package kenny.ml.svm;

import org.junit.Test;

import kenny.ml.svm.kernels.Gaussian;
import kenny.ml.svm.problem.IProblemLoader;
import kenny.ml.svm.problem.LibSVMProblemLoader;
import kenny.ml.svm.problem.Problem;

public class GaussianA1ARunner {
	
	@Test
	public void runTest() {
		SupportVectorMachine svm = new SupportVectorMachine();

		IProblemLoader loader = new LibSVMProblemLoader();
		
		Problem train = loader.load("data/libsvm/a1a_train.libsvm");
		Problem test = loader.load("data/libsvm/a1a_test.libsvm");
		
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

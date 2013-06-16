package svm;

import svm.kernels.Gaussian;
import svm.kernels.IKernel;
import svm.kernels.Linear;
import svm.kernels.Polynomial;
import svm.kernels.Tanh;
import svm.problem.IProblemLoader;
import svm.problem.LibSVMProblemLoader;
import svm.problem.Problem;
import svm.problem.SimpleProblemLoader;
import svm.smo.AbstractSequentialMinimalOptimization;
import svm.smo.Platts;
import svm.smo.Simple;
import lib.Arguments;

public class Main {
	public static void main(String[] args) {
		Arguments arg = Arguments.getInstance();
		arg.parse(args);

		if(arg.get("train") == null) {
			System.err.println("must specify train data file!");
			System.exit(0);
		}
		if(arg.get("test") == null) {
			arg.set("test", arg.get("train"));
		}
		
		IProblemLoader loader;
		if("libsvm".equalsIgnoreCase(arg.get("format"))) {
			loader = new LibSVMProblemLoader();
		} else {
			loader = new SimpleProblemLoader();
		}
		
		IKernel k = null; 
		if("linear".equalsIgnoreCase(arg.get("kernel"))) {
			k = new Linear();
		} else if("polynomial".equalsIgnoreCase(arg.get("kernel"))) {
			k = new Polynomial();
		} else if("tanh".equalsIgnoreCase(arg.get("kernel"))) {
			k = new Tanh();
		} else if("gaussian".equalsIgnoreCase(arg.get("kernel"))) {
			k = new Gaussian();
		} else {
			k = new Gaussian();
		}
		
		AbstractSequentialMinimalOptimization smo;
		if("simple".equalsIgnoreCase(arg.get("smo"))) {
			smo = new Simple();
		} else if("platts".equalsIgnoreCase(arg.get("smo"))) {
			smo = new Platts();
		} else {
			smo = new Simple();
		} 
		
		double a = 1;
		double b = 1;
		double c = 1;
		if(arg.get("a") == null) {
			a = arg.getDouble("a");
		}
		if(arg.get("b") == null) {
			b = arg.getDouble("b");
		}	
		if(arg.get("c") == null) {
			c = arg.getDouble("c");
		}
		
		SupportVectorMachine svm = new SupportVectorMachine(smo);
		
		Problem train = loader.load(arg.get("train"));
		Problem test = loader.load(arg.get("test"));
		
		System.out.println("Loaded.");
		System.out.println("Training...");
		
		
		
		KernelParams kp = new KernelParams(k, a, b, c);
		kp.setC(Math.pow(2, 0));
		
		svm.train(train, kp);
		System.out.println("Testing...");
		int[] pred = svm.test(test, true);

		EvalMeasures e = new EvalMeasures(test, pred, 2);
		System.out.println("Accuracy=" + e.accuracy());

		System.out.println("Done.");
	}
}

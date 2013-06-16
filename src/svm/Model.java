package svm;

import svm.problem.Problem;

/**
 * Class for representing a model
 * 
 */
public class Model extends Problem {
	/** Array of alpha */
	public double[] alpha;
	/** Bias */
	public double b;
	/** Kernel parameters */
	public KernelParams params;

	public void saveModel(String filename) {

	}

	public void loadModel(String filename) {

	}
}

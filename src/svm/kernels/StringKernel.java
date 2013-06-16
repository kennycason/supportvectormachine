package svm.kernels;

import svm.FeatureSpace;

public class StringKernel implements IKernel {

	// private String Σ;	// alphabet
	
	public StringKernel(String Σ) {
		//this.Σ = Σ;
	}
	
	/**
	 * The most common discrete kernel is the string kernel, which is used to compute
	 * similarity between different strings
	 * @param x first vector
	 * @param z second vector
	 * 
	 */
	@Override
	public double k(FeatureSpace x, FeatureSpace z, double... params) {
		return 0;
	}

}

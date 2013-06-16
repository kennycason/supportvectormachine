package svm.kernels;

import svm.FeatureSpace;

public interface IKernel {
	
	double k(FeatureSpace x, FeatureSpace z, double ... params);

}

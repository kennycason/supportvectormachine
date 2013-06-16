Support Vector Machine/サポートベクターマシン/支持向量机
======================
Java OOP Port from C LibSVM library

<table>
<tr>
<td>
Linear Kernel
<img src="https://raw.github.com/kennycason/supportvectormachine/master/save/svm_linear.png" width="350px"/>
</td>
<td>
Gaussian Kernel
<img src="https://raw.github.com/kennycason/supportvectormachine/master/save/svm_gaussian.png" width="350px"/>
</td>
</tr>
<tr>
<td>
Polynomial Kernel
<img src="https://raw.github.com/kennycason/supportvectormachine/master/save/svm_polynomial.png" width="350px"/>
</td>
<td>
Polynomial Kernel
<img src="https://raw.github.com/kennycason/supportvectormachine/master/save/svm_polynomial2.png" width="350px"/>
</td>
</tr>
</table>


**Problem Loaders**
```java
IProblemLoader loader = new LibSVMProblemLoader();
		
Problem train = loader.load("svm/data/libsvm/linear_train.libsvm");
Problem test = loader.load("svm/data/libsvm/linear_test.libsvm");
/*
The typical LibSVM format, the first item represents the Class, the remaining 
elements are prefixed by the index in the vector input that they represent

-1 1:1 2:1
-1 1:1 2:-1
-1 1:-1 2:1
-1 1:-1 2:-1
+1 1:5 2:5
+1 1:10 2:10
+1 2:10
*/
```

```java
IProblemLoader loader = new SimpleProblemLoader(); 
Problem train = loader.load("svm/data/linear_train.svm");
Problem test = loader.load("svm/data/linear_test.svm");
/*
In this simple format, the first item represents the Class, the remaining 
elements represent features of the class
i.e. -1 1 1 means Class = -1, input vector <1, 1>. 
this simple format does not allow for sparse vectors

-1 1 1
-1 1 -1
-1 -1 1
-1 -1 -1
1 5 5
1 10 10
1 0 10
*/
```

Sample Outputs
```
Loading problem: svm/data/linear_train.svm
-1: 1 1 
-1: 1 -1 
-1: -1 1 
-1: -1 -1 
1: 5 5 
1: 10 10 
1: 0 10 
Loading problem: svm/data/linear_test.svm
-1: 1 1 
-1: 1 -1 
-1: -1 1 
-1: -1 -1 
1: 5 5 
1: 10 10 
1: 0 10 
Loaded.
Training...
...
Testing...
-1: 1.0 1.0 
-1: 1.0 -1.0 
-1: -1.0 1.0 
-1: -1.0 -1.0 
1: 5.0 5.0 
1: 10.0 10.0 
1: 0.0 10.0 
7/7 correct
Accuracy=1.0
Done.
```

```
Loading problem: svm/data/libsvm/nonlinear_train.libsvm
1 1:1 2:1 
1 1:1 2:-1 
1 1:-1 2:1 
1 -1:1 2:-1 
1 
-1 1:5 2:5 
-1 1:5 2:-5 
-1 1:-5 2:5 
-1 1:-5 2:-5 
-1 2:-5 
-1 1:5 
-1 2:5 
-1 1:-5 
1 1:15 2:15 
1 1:15 2:-15 
1 1:-15 2:15 
1 1:-15 2:-15 
-1 1:25 2:25 
-1 1:25 2:-25 
-1 1:-25 2:25 
-1 1:-25 2:-25 
-1 2:-25 
-1 1:25 
-1 2:25 
-1 1:-25 
-1 1:10 2:-25 
-1 1:25 2:10 
-1 1:10 2:25 
-1 1:-25 2:10 
1 1:35 2:35 
1 1:35 2:-35 
1 1:-35 2:35 
1 1:-35 2:-35 
1 2:-35 
1 1:35 
1 2:35 
1 1:-35 
1 1:-35 
Loading problem: svm/data/libsvm/nonlinear_test.libsvm
1 1:1 2:1 
1 1:1 2:-1 
1 1:-1 2:1 
1 -1:1 2:-1 
1 
-1 1:5 2:5 
-1 1:5 2:-5 
-1 1:-5 2:5 
-1 1:-5 2:-5 
-1 2:-5 
-1 1:5 
-1 2:5 
-1 1:-5 
1 1:15 2:15 
1 1:15 2:-15 
1 1:-15 2:15 
1 1:-15 2:-15 
-1 1:25 2:25 
-1 1:25 2:-25 
-1 1:-25 2:25 
-1 1:-25 2:-25 
-1 2:-25 
-1 1:25 
-1 2:25 
-1 1:-25 
-1 1:10 2:-25 
-1 1:25 2:10 
-1 1:10 2:25 
-1 1:-25 2:10 
1 1:35 2:35 
1 1:35 2:-35 
1 1:-35 2:35 
1 1:-35 2:-35 
1 2:-35 
1 1:35 
1 2:35 
1 1:-35 
1 1:-35 
Loaded.
Training...
.............
Testing...
-1: 1.0 1.0 
-1: 1.0 -1.0 
-1: -1.0 1.0 
-1: 0.0 -1.0 
-1: 
1: 5.0 5.0 
1: 5.0 -5.0 
1: -5.0 5.0 
1: -5.0 -5.0 
1: 0.0 -5.0 
1: 5.0 
1: 0.0 5.0 
1: -5.0 
-1: 15.0 15.0 
-1: 15.0 -15.0 
-1: -15.0 15.0 
-1: -15.0 -15.0 
1: 25.0 25.0 
1: 25.0 -25.0 
1: -25.0 25.0 
1: -25.0 -25.0 
1: 0.0 -25.0 
1: 25.0 
1: 0.0 25.0 
1: -25.0 
1: 10.0 -25.0 
1: 25.0 10.0 
1: 10.0 25.0 
1: -25.0 10.0 
-1: 35.0 35.0 
-1: 35.0 -35.0 
-1: -35.0 35.0 
-1: -35.0 -35.0 
-1: 0.0 -35.0 
-1: 35.0 
-1: 0.0 35.0 
-1: -35.0 
-1: -35.0 
38/38 correct
Accuracy=1.0
Done.
```


package com.junitchk;


public class ArithmeticDay26 {
	
	public ArithmeticDay26() {
		System.out.println("Arithematic()");
	}

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public int[] reverse(int []arr) {
    	int tmp;
    	int n=arr.length;
    	for(int i=0;i<n/2;i++) {
    		tmp=arr[i];
    		arr[i]=arr[n-i-1];
    		arr[n-i-1]=tmp;
    		
    	}
    	System.out.println("reverse");
    	return arr;
    }
    
    
    
    
    
    
    
    
}
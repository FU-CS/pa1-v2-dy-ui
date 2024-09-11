package pa1_v2;

import java.util.Arrays;

/**
 * Vector class represents a vector in n-dimensional space with basic operations.
 */
public class Vector {

    // Attributes
    private int n;
    private int[] data;

    /**
     * Constructor to initialize the Vector with the specified number of 
     * dimensions (n) and sets all elements to -1.
     * @param n The number of dimensions of the vector.
     */
    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1;
        }
    }

    /**
     * Get the number of dimensions of the vector.
     * @return The number of dimensions.
     */
    public int getDimension() {
    	return this.data.length;
    }

    /**
     * Get the element at the specified index in the vector.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    public int read(int index) {
    	return this.data[index];
    }

    /**
     * Set the element at the specified index in the vector to the given value.
     * @param index
     * @param value
     */
    public void update(int index, int value) {
    	this.data[index] = value;
    }

    /**
     * Remove the element at the specified index in the vector.
     * @param index The index of the element to remove.
     */
    public void delete(int index) {
    	this.n -= 1;
    	while (index < this.data.length - 1){
    		this.data[index] = this.data[index+1];
    		index++;
    	}
    	data[index] = -1;
    }

    /**
     * Add the elements of the given vector v to the current vector.
     * The vectors must have the same number of dimensions.
     * @param v The vector to add.
     */
    public void add(Vector v) {
    	if (v.data.length != this.data.length) {
    		return;
    	}
    	for(int i=0; i<this.data.length;i++) {
    		this.data[i] += v.data[i];
    	}

    }

    /**
     * Subtract the elements of the given vector v from the current vector.
     * @param v
     */
    public void subtract(Vector v) {
    	if (v.data.length != this.data.length) {
    		return;
    	}
    	for(int i=0; i<this.data.length;i++) {
    		this.data[i] -= v.data[i];
    	}
    }

    /**
     * Get the maximum element in the vector.
     * @return The maximum element.
     */
    public int max() {
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i<this.data.length; i++) {
    		if (this.data[i] > max) {
    			max = this.data[i];
    		}
    	}
    	return max;
    }

    /**
     * Get the minimum element in the vector.
     * @return The minimum element.
     */
    public int min() {
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i<this.data.length; i++) {
    		if (this.data[i] < min) {
    			min = this.data[i];
    		}
    	}
    	return min;
    }

    /**
     * Get the average of all elements in the vector.
     * @return The average of all elements.
     */
    public double average() {
        double sum = 0;
        for (int x : this.data) {
        	sum += x;
        }
        return sum / this.data.length;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int search(int value) {
        for (int i =0;i < this.data.length;i++) {
        	if (this.data[i] == value) {
        		return i;
        	}
        }
        return -1;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * This method is optimized for speed using the Binary Search Algorithm.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int searchFast(int value) {
    	sort();
    	int i = 0; int j = this.data.length-1;
    	while(i<=j) {
    		int mid = (i+j) / 2;
    		if (data[mid] == value) {
    			return mid;
    		}
    		if (data[mid] < value) {
    			i = mid + 1;
    		}
    		else {
    			j = mid - 1;
    		}
    	}
		return -1;
    }

    /**
     * Sort the elements of the vector in ascending order.
     */
    public void sort() {
    	this.data = sorthelp(this.data);
    }
    
    private static int[] sorthelp(int[] data) {
    	if(data.length <= 1) {
    		return data;
    	}
    	int mid = data.length / 2;
    	int[] left = Arrays.copyOfRange(data, 0, mid);
    	int[] right = Arrays.copyOfRange(data, mid, data.length);
    	return merge(sorthelp(left), sorthelp(right));
    }
    
    private static int[] merge(int[] a, int[] b) {
    	int[] res = new int[a.length + b.length];
    	int i = 0; int j = 0; int k = 0;
    	while (i < a.length && j < b.length) {
    		if (a[i] < b[j]) {
    			res[k] = a[i];
    			k++;i++;
    		}
    		else {
    			res[k] = b[j];
    			k++;j++;
    		}
    	}
    	while (i < a.length) {
    		res[k] = a[i];
			k++;i++;
    	}
    	while (j < b.length) {
    		res[k] = b[j];
			k++;j++;
    	}
    	return res;
    }
    
}

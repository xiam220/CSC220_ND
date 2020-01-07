package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		/*
		* TODO: write a constructor that would create a matrix
		* of correct size and initialize it to 0. 
		*/
		
		numRows = rowDim;
		numColumns = colDim;
		data = new int[numRows][numColumns];
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				data[row][col] = 0;
			}
		}
	}
	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
		
		numRows = d.length;
		data = new int[numRows][];
		for(int row = 0; row < d.length; row++) {
			numColumns = d[row].length;
			data[row]= new int[numColumns];
			for(int col = 0; col < numColumns; col++) {
				data[row][col] = d[row][col];
			}
		}
	}	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String printMatrix = "";
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				printMatrix += Integer.toString(data[row][col]) + " ";
			}
			printMatrix = printMatrix + "\n";
		}
		
			return "\n" + printMatrix;
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		//return ""; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		boolean sameArray = true;
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		
		if(numRows == m.data.length) {
			for(int row = 0; row < numRows; row++) {
				if(data[row].length == m.data[row].length) {
					for(int col = 0; col < data[row].length; col++) {
						if(data[row][col] == m.data[row][col]) {
							sameArray = true; 
						} else { sameArray = false; break; }
					}
				} else { sameArray = false; break; }
			}
		} else { sameArray = false; }
		
		return sameArray;
	}

	public Matrix times(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		int matrixLeftCol= data[0].length;
		int matrixRightRow= m.data.length; 
		Matrix productArrays = null;
		if(matrixLeftCol == matrixRightRow) {
			productArrays = new Matrix(data.length, m.data[0].length);
				for(int i = 0; i < data.length; i++) {
					for(int j = 0; j < m.data[0].length; j++) {
						for(int k = 0; k < data[0].length; k++) {
							productArrays.data[i][j] += data[i][k] * m.data[k][j];
						}
					}
				}
		}
		
		return productArrays; // placeholder
	}
	
	public Matrix plus(Matrix m)
	{
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		Matrix sumArrays = null;
		if(data.length == m.data.length) {
			for(int i = 0; i < numRows; i++) {
				numColumns = data[i].length;
				if(data[i].length == m.data[i].length) {
					sumArrays = new Matrix(numRows, data[i].length);
				} else { sumArrays = null; break; }
			}
			
			if(sumArrays != null) {
				for(int row = 0; row < numRows; row++) {
					for(int col = 0; col < data[row].length; col++) {
						sumArrays.data[row][col] = data[row][col] + m.data[row][col];
					}
				}
			} 
		}
		
		return sumArrays;
	}	

}

package pixLab.classes;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
    //this.Matrix = Matrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total += matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
  public void fillPattern2()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
          matrix[row][col] = 0;
      }
       
    }
  }
  
//  public void fillPattern3()
//  {
//    matrix[5][5] = 1;
//    int roomsAttached = (int) (Math.random() * 20);
//    if(roomsAttached)
//  }

  public int getCount(int searchValue)
  {
	  int count = 0;
	  
	  for(int[] myRow : matrix)
	  {
		  for(int value : myRow)
		  {
			  if(value == searchValue)
			  {
				  count ++;
			  }
		  }
	  }
		  
//	  for (int row = 0; row < matrix.length; row++)
//	    {
//	      for (int col = 0; col < matrix[row].length; col++)
//	      {
//	    	  if(matrix[row][col] == searchValue)
//	    	  {
//	    		  count ++;
//	    	  }
//	        
//	      }
//	    }
	    
	    return count;
  }

  public int getLargest()
	{
	  int largest =Integer.MIN_VALUE;
	  for (int row = 0; row < matrix.length; row++)
	    {
	      for (int col = 0; col < matrix[0].length; col++)
	      {
	        if(matrix[row][col] > largest)
	        {
	        	largest = matrix[row][col];
	        }
	      }
	    }
	    
	 
	  return largest;
	}

  public int getColTotal(int searchedColumn)
  {
	 int total = 0;
	 for (int row = 0; row < matrix.length; row++)
	    {
		 	total += matrix[row][searchedColumn];
	    }
	return total;
  }
 
}
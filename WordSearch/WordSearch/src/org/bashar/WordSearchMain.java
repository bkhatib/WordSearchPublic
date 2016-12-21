package org.bashar;

/**
 * 
 * WordSearchMain.java
 * Purpose: Given a 2D board and a word, find if the word exists in the grid. 
 *
 * @author Bashar Khatib
 * @version 1.0 21/12/2016
 */


public class WordSearchMain {

	public static void main(String[] args) {
		 char [][] wordsGrid = new char[][]{
			  { 'A', 'B', 'C', 'E' },
			  { 'S', 'F', 'C', 'S' },
			  { 'A', 'D', 'E', 'E' }			 
			};
			
		//String word = "ABCCED";
		//String word ="SEE";
		String word ="ABCB";
		boolean found = find(wordsGrid, word);
		System.out.println(found);
	
	
		
	}
	
	/**
	 * This method used to pass the grid and the word to the search function.
	 *
	 * @param Array of characters (grid), the word to be found (String word);
	 * 
	 * @return boolean.
	 */
	
	public static boolean find(char[][] grid, String word) {
	    int rowSize = grid.length;
	    int columnSize = grid[0].length;
	    boolean result = false;
	    for(int i=0; i<columnSize; i++){
	        for(int j=0; j<rowSize; j++){
	           if(search(grid,word,i,j,0)){
	               result = true;
	           }
	        }
	    }
	 
	    return result;
	}
	
	/**
	 * This is the main method used to find the word, we used the DFS search method.
	 *
	 * @param Array of characters (grid), the word to be found (String word); , index i,j,k
	 * 
	 * @return boolean.
	 */
	
	public static boolean search(char[][] grid, String word, int i, int j, int k){
	    int rowSize = grid.length;
	    int columnSize = grid[0].length;
	 
	    if(i<0 || j<0 || i>=rowSize || j>=columnSize){ // this is to break the recursive call
	        return false;
	    }
	 
	    if(grid[i][j] == word.charAt(k)){
	        char temp = grid[i][j];
	        grid[i][j]='#';
	        if(k==word.length()-1){
	            return true;
	        }else if(search(grid, word, i-1, j, k+1)
	        ||search(grid, word, i+1, j, k+1) // search down
	        ||search(grid, word, i, j-1, k+1) // search left
	        ||search(grid, word, i, j+1, k+1)){ // search right
	            return true;
	        }
	        grid[i][j]=temp;
	    }
	 
	    return false;
	}

}

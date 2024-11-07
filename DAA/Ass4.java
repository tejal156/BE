public class Ass4
{
	public static void main(String[] args) {
		int arr[][] = {
		  { 0 , 0 ,  0 , 0 },
		  { 0 , 0 ,  0 , 0 },
		  { 0 , 0 ,  0 , 0 },
		  { 0 , 0 ,  0 , 0 },
		};
		System.out.println(  nQueen(arr , 0) ) ;
	}
	
	public static boolean nQueen( int arr[][] , int r ) {
	    if( r == arr.length )return true ; 
	    for(int i = 0 ; i < arr.length ; i++){
	       
	        if( arr[r][i] == 1){
	            if( nQueen(arr , r+1) ){
	                return true ; 
	            }	            
	        }
	        else if( isSafe(arr, r , i) ){
	            
	            arr[r][i] = 1 ; 
	            System.out.println(r+" "+i) ;
	            if( nQueen(arr , r+1) ){
	                return true ; 
	            }
	            arr[r][i] = 0 ; 
	        }
	    }
	    return false ; 
	}
	
	
	public static boolean isSafe( int arr[][] , int r , int c ){
	    int n = arr.length ; 
	    
	   // chk vertically above
	   for(int i = 0 ; i < r ; i++ ){
	       if(arr[i][c] == 1 )return false ; 
	   }
	   
	   // chk vertically below
	   for(int i = r+1 ; i < n ; i++ ){
	       if(arr[i][c] == 1 )return false ; 
	   }
	   
	   //chk for positive diagonal above
	   int cr = r-1 ; 
	   int cc = c-1 ; 
	   while( cr >= 0 && cc >= 0 ){
	       if(arr[cr][cc] == 1 )return false ; 
	       cr-- ; 
	       cc-- ; 
	   }
	   
	   //chk for positive diagonal below
	   cr = r+1 ; cc = c+1 ; 
	   while( cr < n && cc < n){
	       if(arr[cr][cc] == 1 )return false ; 
	       cr++ ; cc++ ; 
	   }	   
	   
	   
	   //chk for negative diagonally above
	   cr = r-1 ;  cc = c+1 ; 
	   while( cr >= 0 && cc < arr.length  ){
	       if(arr[cr][cc] == 1 )return false ; 
	       cr-- ;  cc++ ; 
	   }
	   
	   //chk for negative diagonally above
	   cr = r+1 ;  cc = c-1 ; 
	   while( cr < n && cc >= 0  ){
	       if(arr[cr][cc] == 1 )return false ; 
	       cr++ ;  cc-- ; 
	   }
	   
	   
	   //chk horizontally
	   for(int i = 0 ; i < arr.length ; i++ ){
	       if(arr[r][i] == 1 && i != c)return false ; 
	   }
	   
	   return true ; 
	   
	}
}

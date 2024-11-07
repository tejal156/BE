public class Ass5
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr1[] = {  1 , 2,3 ,4 , 5} ;
		int arr2[] = {  1 , 2,3 ,4 , 5} ;
		
		int analysis1[] = new int[2] ;
		int analysis2[] = new int[2] ;
		
		quickSort( arr1 , 0 , arr1.length -1  , analysis1 ) ;
		quickSortWithRandomizedEle( arr1 , 0 , arr2.length -1  , analysis2 ) ;
		
		for(int ele : arr1)System.out.print( ele + ", ") ;
		System.out.println() ;
		System.out.println("steps : "+ analysis1[0]) ;
		System.out.println("swaps : "+ analysis1[1]) ;
		
		for(int ele : arr2)System.out.print( ele + ", ") ;
		System.out.println() ;
		System.out.println("steps : "+ analysis2[0]) ;
		System.out.println("swaps : "+ analysis2[1]) ;
		
	}
	
	public static void quickSort(int arr[] , int l , int r  , int a[]){
	    // take partion 
	   //call recursive fun for left and right side sub array
	   if(r > l ){
	        int pivot = partition( arr , l , r , a ) ;
	        quickSort( arr , l , pivot-1 , a ) ;
	        quickSort( arr , pivot+1 , r , a ) ;	       
	   }

	}
	
	public static void quickSortWithRandomizedEle(int arr[] , int l , int r  , int a[]){
	    // take partion 
	   //call recursive fun for left and right side sub array
	   if(r > l ){
	        int pivot = partitionWithRandomizedEle( arr , l , r , a ) ;
	        quickSortWithRandomizedEle( arr , l , pivot-1 , a ) ;
	        quickSortWithRandomizedEle( arr , pivot+1 , r , a ) ;	       
	   }

	}
	
	
	public static int partition(int arr[] , int left , int right , int a[]){
	    int pivot = arr[left] ;
	    int l = left +1 ; 
	    int r = right ;
	    int swaps = 0 ; 
	    int steps = 0 ; 
	    while(true ){
	        while( l <= right &&pivot >= arr[l]){
	            l++ ; 
	            steps++ ; 
	        }
	        while( r > left && pivot < arr[r]){
	            r-- ;
	            steps++ ; 
	        }
	        if( r > l ){
	            int temp = arr[l] ;
	            arr[l] = arr[r] ;
	            arr[r] = temp ; 
	            swaps++ ;
	        }else{
	            arr[left] = arr[r] ;
	            arr[r] = pivot ;
	            swaps++ ;
	            a[0] += steps ; 
	            a[1] += swaps ; 
	            return r ;
	        }
	    }
	}
	
	
	
	public static int partitionWithRandomizedEle(int arr[] , int left , int right , int a[]){
	    int randomPivot = left + (int)((right-left)* Math.random()) ;
	    int tempTemp = arr[left] ;
	    arr[left] = arr[randomPivot]  ;
	    arr[randomPivot] = tempTemp ; 
	    int pivot = arr[left] ;
	    int l = left +1 ; 
	    int r = right ;
	    int swaps = 0 ; 
	    int steps = 0 ; 
	    while(true ){
	        while( l <= right &&pivot >= arr[l]){
	            l++ ; 
	            steps++ ; 
	        }
	        while( r > left && pivot < arr[r]){
	            r-- ;
	            steps++ ; 
	        }
	        if( r > l ){
	            int temp = arr[l] ;
	            arr[l] = arr[r] ;
	            arr[r] = temp ; 
	            swaps++ ;
	        }else{
	            arr[left] = arr[r] ;
	            arr[r] = pivot ;
	            swaps++ ;
	            a[0] += steps ; 
	            a[1] += swaps ; 
	            return r ;
	        }
	    }
	}
	
	
}

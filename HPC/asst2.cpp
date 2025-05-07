// write for s and p bubble sort
// write for s and p merge sort
// print array
// create array of 10^7

#include <bits/stdc++.h>
using namespace std ; 
using namespace std::chrono ; 

void initializeArr(int arr[] , int n ){
    for(int i = 0 ; i < n ; i++)arr[i] = rand() % n ; 
}

void printArr(int arr[] , int n , string str = "" ){
    if(str!="")cout << str<<" : ";
    for(int i = 0 ; i < n ; i++) {
        // cout << arr[i] << " " ;
    }
    cout<< endl ; 
}

void bubblesortSeq( int arr[] , int n ){
    for(int i = n-2 ; i >= 0 ; i--) for(int j = 0 ; j <= i ; j++)if(arr[j] >arr[j+1])swap(arr[j], arr[j+1]) ;
}

void bubblesortParallel( int arr[] , int n ){
    bool swapped = true ; 
    
    for(int i = 0 ; i < n ; i++) 
    {
        if(swapped == true){
            swapped = false ; 
            #pragma omp parallel for shared(swapped)
            for(int j = 0 ; j < n ; j+=2)if(arr[j] >arr[j+1]){
                swap(arr[j], arr[j+1]) ;
                swapped = true ; 
            }

            #pragma omp parallel for shared(swapped)
            for(int j = 1 ; j < n ; j+=2)if(arr[j] >arr[j+1]){
                swap(arr[j], arr[j+1]) ;
                swapped = true ; 
            }
        }
    }
}

void merge(int arr[] ,int  s, int e,int mid){
    int temp[e-s+1];
    int p1 = s ; 
    int p2 = mid+1 ;
    int tempi = 0 ; 
    while(p1 <= mid && p2 <= e){
        if( arr[p1] > arr[p2]){
            temp[tempi++] = arr[p2++] ;
        }else{
            temp[tempi++] = arr[p1++] ;
        }
    } 

    while( p2 <= e){
        temp[tempi++] = arr[p2++] ;
    } 
    while(p1 <= mid){
        temp[tempi++] = arr[p1++] ;
    } 

    for(int i = 0 ; i < e-s+1 ; i++) arr[s+i] = temp[i] ;
}

void mergeSortSeq(int arr[] , int s , int e ){
    if(s < e){
        int mid =  s + (e-s)/2 ;
        mergeSortSeq( arr , s, mid) ;
        mergeSortSeq( arr , mid+1, e) ;
        merge(arr , s, e, mid) ;
    }

}

void mergeSortParallel(int arr[] , int s , int e ){
    if(s <= e){
        int mid = s + (e-s)/2 ;
        #pragma omp parallel sections
        {
            #pragma omp section
            {
                mergeSortSeq( arr , s, mid) ;
            }
            
            #pragma omp section
            {
                mergeSortSeq( arr , mid+1, e) ;
            }
            
        }
        merge(arr , s, e, mid) ;

    }
}

int main(){
    int n = 100000; 
    int arr[n]  ;
    initializeArr(arr, n ) ;

    auto start = high_resolution_clock::now() ;
    printArr(arr, n , "inital arr") ;
    bubblesortSeq(arr,n);
    printArr(arr, n , "seq bubble sort") ;
    auto end = high_resolution_clock::now() ;
    cout << "time : "<< duration_cast<microseconds>(end-start).count() << endl;

    cout<<endl ;

    start = high_resolution_clock::now() ;
    initializeArr(arr, n ) ;
    printArr(arr, n , "inital arr") ;
    bubblesortSeq(arr,n);
    printArr(arr, n , "parallel bubble sort") ;
    end = high_resolution_clock::now() ;
    cout << "time : "<< duration_cast<microseconds>(end-start).count() << endl;

    cout<<endl ;

    start = high_resolution_clock::now() ;
    initializeArr(arr, n ) ;
    printArr(arr, n , "inital arr") ;
    mergeSortSeq(arr,0,n-1);
    printArr(arr, n , "seq merge sort") ;
    end = high_resolution_clock::now() ;
    cout << "time : "<< duration_cast<microseconds>(end-start).count() << endl;

    cout<<endl ;

    start = high_resolution_clock::now() ;
    initializeArr(arr, n ) ;
    printArr(arr, n , "inital arr") ;
    mergeSortParallel(arr,0,n-1);
    printArr(arr, n , "parallel merge sort") ;
    end = high_resolution_clock::now() ;
    cout << "time : "<< duration_cast<microseconds>(end-start).count() << endl;

    cout<<endl ;
    
    return 0 ; 
}
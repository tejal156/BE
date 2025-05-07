
#include <bits/stdc++.h>
using namespace std ;
#include <cuda.h>

// dynameic array 
// take n 
// fill array
// make arrr for paralle
// set config
// call s fun
// call p fun

__global__ void addp( int * a , int * b , int * c , int n){
    int tid = blockIdx.x * blockDim.x + threadIdx.x ;
    if(tid < n) c[tid] = a[tid] + b[tid];
}

void add( int * a , int * b , int * c , int n){
    for(int i = 0 ; i < n ; i++)c[i] = a[i] + b[i];
}

void print(int * arr , int n ){
  for(int i = 0 ; i < n ; i++)cout<< arr[i]<<" ";
  cout << endl ;
}

int main(){
  cout<< "Hii1";
  int n ; 
  n = 10 ; 
  int * a = new int[n] ;
  int * b = new int[n] ;
  int * c = new int[n] ;

  // initialize it
  for(int i = 0 ; i < n ; i++)a[i] = rand()%n ;
  for(int i = 0 ; i < n ; i++)b[i] = rand()%n ;
  for(int i = 0 ; i < n ; i++)c[i] = 0 ;

  int * pa , *pb , *pc ;
  cudaMalloc( & pa , n * sizeof(int)) ;
  cudaMalloc( & pb , n * sizeof(int)) ;
  cudaMalloc( & pc , n * sizeof(int)) ;
  cudaMemcpy(pa , a , n * sizeof(int) , cudaMemcpyHostToDevice ) ;
  cudaMemcpy(pb , b , n * sizeof(int) , cudaMemcpyHostToDevice ) ; 

  int threadPerBlock = 256 ; 
  int blockPerGrid = (n+ threadPerBlock -1)/threadPerBlock ; 

   print(c , n) ;
  addp<<<blockPerGrid ,threadPerBlock >>>(pa,pb,pc,n) ;
  cudaDeviceSynchronize();
   cudaMemcpy(c , pc , n * sizeof(int) , cudaMemcpyDeviceToHost ) ; 
   print(a,n) ;
   print(b,n) ;
   print(c , n) ;

   add(a,b,c,n) ;
   print(c , n) ;


   delete [] a;
   delete [] b;
   delete [] c;
   cudaFree(pa);
   cudaFree(pb);
   cudaFree(pc);

  return 0 ; 
}
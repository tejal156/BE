
// things to memorize
// #pragma omp parallel for reduction(min:minVal)
// auto end = high_resolution_clock :: now() ;
// cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl;
// vector<long> v;
// long n = 100; 
// v.resize(n , 0 ) ;
// v[i] = rand()%n;
// using namespace std::chrono ; 
// flow : make min, max, avg function for s and p and check for its time
    
#include <bits/stdc++.h>
using namespace std ;
using namespace std::chrono ; 


void minp( vector<long>& v){
    long minVal = v[0]; 
    #pragma omp parallel for reduction(min:minVal)
    
    for(long i = 0 ; i < v.size() ; i++){
        minVal = min( minVal , v[i]) ;
    }
    cout<< "minp : " << minVal <<endl; 
}

void mins( vector<long>& v){
    long minVal = v[0]; 
    for(long i = 0 ; i < v.size() ; i++){
        minVal = min( minVal , v[i]) ;
    }
    cout << "mins : " <<  minVal <<endl; 
}

void maxp( vector<long>& v){
    long maxVal = v[0]; 

    #pragma omp parallel for reduction(max:maxVal)
    for(long i = 0 ; i < v.size() ; i++){
        maxVal = max( maxVal , v[i]) ;
    }
    cout<< "maxp : " <<  maxVal <<endl; 
    
    
}

void maxs( vector<long>& v){
    long maxVal = v[0]; 
    for(long i = 0 ; i < v.size() ; i++){
        maxVal = max( maxVal , v[i]) ;
    }
    cout << "maxs : " <<   maxVal <<endl; 
}


void avgp( vector<long>& v){
    long avgVal = 0; 

    #pragma omp parallel for reduction(+:avgVal)
    for(long i = 0 ; i < v.size() ; i++){
        avgVal += v[i] ;
    }
    cout<< "avgp : " <<   avgVal/size(v) <<endl; 
}

void avgs( vector<long>& v){
    long avgVal = 0;  
    for(long i = 0 ; i < v.size() ; i++){
        avgVal += v[i] ;
    }
    cout<<"avgs : " <<  avgVal/size(v) <<endl; 
}


int main(){
    vector<long> v;
    long n = 1000000000; 
    // long nn = 100000000 ;
    v.resize(n , 0 ) ;
    for(long i = 0 ; i < n ; i++){
        v[i] = rand()%n - rand()%(n);
    }
    auto start = high_resolution_clock :: now() ;
    minp(v) ;
    auto end = high_resolution_clock :: now() ;
    cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl;

    start = high_resolution_clock :: now() ;
    mins(v) ;
    end = high_resolution_clock :: now() ;
    cout <<  "time :" <<duration_cast<microseconds>( end - start).count() <<endl<<endl;

    start = high_resolution_clock :: now() ;
    maxp(v) ;
    end = high_resolution_clock :: now() ;
    cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl;

    start = high_resolution_clock :: now() ;
    maxs(v) ;
    end = high_resolution_clock :: now() ;
    cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl<<endl;

    start = high_resolution_clock :: now() ;
    avgp(v) ;
    end = high_resolution_clock :: now() ;
    cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl;

    start = high_resolution_clock :: now() ;
    avgs(v) ;
    end = high_resolution_clock :: now() ;
    cout << "time :" << duration_cast<microseconds>( end - start).count() <<endl;



    return 0 ; 
}
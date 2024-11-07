import java.util.* ; 

class Ass2{
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        // convert into char and frq
        // create tree
            // create class for node
            // create pq
            // add all node to pq
            // pop 2 prepared one again add to pd
            // repeate until one get left
        // prepare hash table
        // also print message
        String str = "aaaabbbccd" ;
        HashMap<Character, Integer> hm = convertToCharNFrq(str);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            new Comparator<Node>(){
                public int compare(Node n1 , Node n2){
                return n1.frq - n2.frq ; 
                }
            }
        );

        
        for( Character c : hm.keySet()){
            System.out.println( c + " : "+  hm.get(c) ) ;
            pq.add( new Node( c, hm.get(c))  ) ;
        }
        System.out.println() ;
        
        while(pq.size() > 1 ){
            Node n1 = pq.remove() ;
            Node n2 = pq.remove() ;
            System.out.println( n1.frq + " " + n2.frq ) ;
            Node newnode = new Node( '-' , n1.frq+n2.frq , n1 , n2 ) ;
            pq.add( newnode ) ;
        }
        
        HashMap<Character, String> ansHm = new HashMap<>() ; 
        getCode(ansHm , pq.peek() , "" ) ; 
        for( Character c :  ansHm.keySet() ){
            System.out.println( c + " :  " + ansHm.get(c) ) ;
        }
        
    }
    
    public static HashMap<Character, Integer> convertToCharNFrq(String str){
        HashMap<Character, Integer>hm = new HashMap<>() ;
        for(int i = 0 ; i < str.length();i++){
            if( hm.containsKey(str.charAt(i) ) ){
                hm.put( str.charAt(i) , hm.get( str.charAt(i )) +1 ) ;
            }else{
                hm.put( str.charAt(i) , 1 ) ;
            }
        }
        
        return hm ; 
    }
    
    
    public static void getCode( HashMap<Character, String> ansHm , Node root , String code ){
        if(root.left == null && root.right == null ){
            ansHm.put( root.data , code ) ;
        }
        
        if(root.left != null ){
            getCode( ansHm , root.left , code+"0") ;
        }
        
        if(root.right != null ){
            getCode( ansHm , root.right , code+"1") ;
        }
        
    }

    
}

    class Node{
        Node( Character data  ,int frq  ){
            this.data = data ; 
            this.frq = frq ; 
        }
        
        Node( Character data  ,int frq, Node left, Node right ){
            this.data = data ; 
            this.frq = frq ;
            this.left = left ; 
            this.right = right ; 
        }
        
        Character data ;
        int frq ; 
        Node right ; 
        Node left ; 
    }
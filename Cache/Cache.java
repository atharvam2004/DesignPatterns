package Cache;

import java.util.*;

class Cache{
    private final Storage storage;
    private final Eviction Eviction;
    public Cache(Eviction e, Storage s){
        this.Eviction=e;
        this.storage=s;
    }   
    public void put(String key,String value){
        this.storage.add(key,value);
        this.Eviction.accessed(key);
    }  
    public String get(String key){
        String value=storage.retrieve(key);
        this.Eviction.accessed(key);
        return value;   
    }
    
}
class Storage{
     Map<String, String>map;
     private final int capacity;
     public Storage(int cap){
        this.capacity=cap;
     }
     public void add(String key,String value){
        if(map.size()==capacity){

        }
        map.put(key,value);
     }  
     public void remove(String key){
        if(!map.containsKey(key)){
            return;
        }
        map.remove(key);
     }
     public String retrieve(String key){
        if(!map.containsKey(key)){
            return null;
        }
        return map.get(key);
     }
}
class Eviction{
    private DLL dll;
    private Map<String, DLLN>map;
    public Eviction(){
        this.dll=new DLL();
        this.map=new HashMap<>();
    }
    public void accessed(String key){
        DLLN node=map.get(key);
        dll.detach(node);
    }
    public void evict(){
        dll.removeHead();
        return;
    }
}    
class DLL{
    DLLN node;
    public void detach(DLLN node){}
    public void removeHead(){}
} 
class DLLN{
    DLLN prev,next;
    public DLLN(DLLN prev, DLLN next){
        this.prev=prev;
        this.next=next;
    }

}
         // feature notify users when iphone available

package observer;

public class Main {
    public static void main(String[] args) { 
         // Create a new observable 6 
         IphoneObservable iphone = new IphoneObservable(); 
          // Creating new Observers 9 
          User userl = new User(iphone); 
          User user2= new User(iphone); 
          User user3 = new User(iphone); 
           // Adding observers to the notification list 
           iphone.add(userl); iphone.add(user2);  iphone.add(user3); 
           // Updating stock count for Iphone 
           iphone.setStockCount(10); iphone.setStockCount(0);  iphone.setStockCount(20); 
         }
}

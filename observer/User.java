package observer;
import java.util.*;
import java.io.*;

public class User implements IObserver{
// Reference variable for observable 
IObservable observable;
// Assigning the observable object through constructor injection
public User(IObservable observable){ this.observable = observable; }
// Perform some operations when the user is notified 
public void update(){
// 
System.out.println("User is notified that iphone is back in stock"); 
}
}
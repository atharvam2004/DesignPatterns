package observerpattern;

// Add observers who would subscribe to notifications 
public interface IObservable {

    public void add(IObserver observer);

    // Notify obserysers when Iphone is back in stock
    public void notifyObservers();

    // Set the new stock count for Iphone
    public void setStockCount(int stockCount);

    // Returns the current stock count for Iphone
    public int getStockCount();
     //Remove observers who would unsubscribe to notifications public void remove (IObserver observer);

}

package observerpattern;

import java.util.*;

public class IphoneObservable implements IObservable {
    private int stockCount = 0;
    // Initial Stock Count
    private List<IObserver> list = new ArrayList<>();

    // Add a per observer to the list
    public void add (IObserver observer) {list.add(observer);}

    // Remove an observer from the list Discover more job opportunities Boost your
    // career via Premium
    public void remove(IObserver observer) {
        list.remove(observer);
    } // 15 10 Set the new stock count and notify the observers 20 if previously
      // Iphone was out of stock

    public void setStockCount(int stockCount) {
        if (this.stockCount == 0)
            this.notifyObservers();// Profile viewers 4 D 24 View all analytics } 25
        this.stockCount = stockCount;
    }// Returns the current stock count 30

    public int getStockCount() {
        return this.stockCount;
    } // Iterate through the list of observers and notify them about
      // the change in stock/ 30

    public void notifyObservers() {
        for (IObserver observer : list)
            observer.update();
    }
}

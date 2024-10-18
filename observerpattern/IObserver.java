package observerpattern;

// Add observers who would subscribe to notifications 
public interface IObserver {

    public void update(); 
     //Remove observers who would unsubscribe to notifications public void remove (IObserver observer);

}

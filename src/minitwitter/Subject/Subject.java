package minitwitter.Subject;

import java.util.ArrayList;
import java.util.List;
import minitwitter.Observer.Observer;

/**
 * This abstract class represents a subject that will be extended to
 * concrete subject classes.
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private long creationTime;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }
    
    /**
     * This method adds observers to the list.
     * @param observer, new observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    /**
     * This method removes the observer from the list
     * @param observer, observer to be deleted
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }
	
    /**
     * This method notifies every observer in the list to update the view.
     */
    public void notifyObservers() {
        for(Observer ob : observers) {
            ob.update(this);
	}
    }
    
}

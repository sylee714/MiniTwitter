package minitwitter.Observer;

import minitwitter.Subject.Subject;

/**
 * This interface represents an observer. It observers its subjects
 * and update the view whenever its subject changes something.
 * @author Seungyun Lee
 */
public interface Observer {
    
    /**
     * This method updates the view whenever its subject notifies them.
     * @param subject
     */
    public void update(Subject subject);
    
}

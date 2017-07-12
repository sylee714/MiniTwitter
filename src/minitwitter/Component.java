package minitwitter;

import minitwitter.Visitor.Visitor;

/**
 * This interface represents a component that makes up Mini Twitter program.
 * Those components are users, groups, and twitter messages.
 * @author Seungyun Lee
 */
public interface Component {
    
    /**
     * This method accepts a visitor instance to let them
     * visit certain fields.
     * @param visitor, visitor that wants to visit certain fields
     */
    public void accept(Visitor visitor);
    
}

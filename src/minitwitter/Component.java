/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import minitwitter.Visitor.Visitor;

/**
 *
 * @author MingKie
 */
interface Component {
    
    public void accept(Visitor visitor);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3;

import java.util.ArrayList;
import weka.core.Attribute;
import weka.core.Instance;

/**
 *
 * @author paul
 */
public class Node {
    private Attribute attr;
    public ArrayList<Attribute> attrlist;
    public ArrayList<Instance> bin_0;
    public ArrayList<Instance> bin_1;
    public ArrayList<Instance> bin_2;
    public ArrayList<Instance> bin_3;
    
    
    public Node(){
        attrlist = new ArrayList<>();
        bin_0 = new ArrayList<>();
        bin_1 = new ArrayList<>();
        bin_2 = new ArrayList<>();
        bin_3 = new ArrayList<>();
    }

    public Attribute getAttr() {
        return attr;
    }

    public void setAttr(Attribute attr) {
        this.attr = attr;
    }

    
    
    
}

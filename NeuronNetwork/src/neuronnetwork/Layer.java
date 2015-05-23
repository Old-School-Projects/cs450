/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronnetwork;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paul
 */
public class Layer {
    private List<Neuron>neurons;
    
    public Layer(){
        neurons = new ArrayList<>();
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }
    
    
}

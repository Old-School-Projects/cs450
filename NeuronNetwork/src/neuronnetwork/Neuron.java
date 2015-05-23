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
public class Neuron {
    private List<NeuronValue>inputs;
    private NeuronValue output;
    
    public Neuron(){
        inputs = new ArrayList<>();
        output = new NeuronValue();
    }

    public List<NeuronValue> getInputs() {
        return inputs;
    }

    public void setInputs(List<NeuronValue> inputs) {
        this.inputs = inputs;
    }

    public NeuronValue getOutput() {
        return output;
    }

    public void setOutput(NeuronValue output) {
        this.output = output;
    }
    
}

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
public class Network {
    private List<Layer>layers;
    private List<NeuronValue>neuronValueList;
    
    public Network(int numLayers){
        layers = new ArrayList<>();
        neuronValueList = new ArrayList<>();
        
        for (int l = 0; l < numLayers; l++){
            Layer layer = new Layer();
            layers.add(layer);
        }
        
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public List<NeuronValue> getNeuronValueList() {
        return neuronValueList;
    }

    public void setNeuronValueList(List<NeuronValue> neuronValueList) {
        this.neuronValueList = neuronValueList;
    }
    
    
    
}

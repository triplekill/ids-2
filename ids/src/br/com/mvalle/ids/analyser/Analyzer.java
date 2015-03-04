/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvalle.ids.analyser;

import java.util.ArrayList;

/**
 *
 * @author mvalle
 */
public class Analyzer {
    private ArrayList httpData;
   
    public Analyzer(boolean flagStatus, ArrayList httpData){
        this.httpData = httpData;
        
        //Alternate between train/execute
        if(flagStatus){
            train();
        }else{
            execute();
        }
    }
    
    
    private void train(){
        
    }
    
    private void execute(){
    
    }
    
    
}

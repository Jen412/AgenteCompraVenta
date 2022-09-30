/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author Asus TUF
 */
public class Comprador extends Agent{
    private String titulo;
    
    @Override
    protected void setup(){
        System.out.println("Comprador" + getAID().getName());
        Object [] args = getArguments();
        if (args != null && args.length >0) {
            titulo = (String) args[0];
            System.out.println("Compra del libro: "+titulo);
            addBehaviour(new TickerBehaviour(this, 10000){
                @Override
                protected void onTick(){
                    System.out.println("Enviando Peticion a vendedores");
                }
            });
        }
        else{
            System.out.println("No se Especifico nombre del libro");
            doDelete();
        }
    }
    
    @Override
    protected  void takeDown(){
        System.out.println("Supongo que se Acabo " + getAID().getName());
    }
}

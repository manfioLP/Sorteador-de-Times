/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorteador_de_times.model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author LeopoldoManfio
 */
public class Sorteador {
    
    private static Sorteador instance;
    ArrayList<String> timeA, timeB;
    ArrayList<Integer> numerosQueJaForam;
    Integer numeroJogadores;
    
    private Sorteador(){
       timeA = new ArrayList<>();
       timeB = new ArrayList<>();
       numerosQueJaForam = new ArrayList<>();
    }
    
    public static Sorteador getInstance(){
        if (instance == null)
            instance = new Sorteador();
        
        return instance;
    }
    
    public void setNumeroJogadores(Integer numJogadores){
        this.numeroJogadores = numJogadores;
    }
    
    public String[][] sortear(String[] jogadores){
        int i = 0;
        int numJogador;
        String[][] aux = new String[2][];
        
        while(i < numeroJogadores){
            int rndIntTeam = ThreadLocalRandom.current().nextInt(2);
            numJogador = getRandomExcluse(numeroJogadores);
            if(timeA.size() < numeroJogadores)
                timeA.add(jogadores[numJogador]);
            else
                timeB.add(jogadores[numJogador]);
        }
        aux[0] = (String[]) timeA.toArray();
        aux[1] = (String[]) timeB.toArray();
        
        return aux;
    }

    private int getRandomExcluse(int bound) {
        int i = ThreadLocalRandom.current().nextInt(bound);
        
        while (numerosQueJaForam.contains(i))
            i = ThreadLocalRandom.current().nextInt(bound);
        
        return i;
    }
    
}

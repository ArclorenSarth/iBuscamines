/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;

import java.io.Serializable;
import javax.persistence.*;



//@Entity
//@Table(name="Caselles")

/**
 *
 * @author ArclorenSarth
 */
public class Casella implements Serializable {
    @Id private int numeroFila;
    @Id private int numeroColumna;
    private int numero;
    private boolean estaDescoberta;
    private boolean estaMarcada;
    private boolean teMina;

    

    public Casella(int f, int c){
        numeroFila = f;
        numeroColumna = c;
        numero = 0;
        estaDescoberta = false;
        estaMarcada = false;
        teMina = false;
    }
    
    /**
     * @return the numeroFila
     */
    public int getNumeroFila() {
        return numeroFila;
    }

    /**
     * @param numeroFila the numeroFila to set
     */
    public void setNumeroFila(int numeroFila) {
        this.numeroFila = numeroFila;
    }

    /**
     * @return the numeroColumna
     */
    public int getNumeroColumna() {
        return numeroColumna;
    }

    /**
     * @param numeroColumna the numeroColumna to set
     */
    public void setNumeroColumna(int numeroColumna) {
        this.numeroColumna = numeroColumna;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the estaDescoberta
     */
    public boolean isEstaDescoberta() {
        return estaDescoberta;
    }

    /**
     * @param estaDescoberta the estaDescoberta to set
     */
    public void setEstaDescoberta(boolean estaDescoberta) {
        this.estaDescoberta = estaDescoberta;
    }

    /**
     * @return the estaMarcada
     */
    public boolean isEstaMarcada() {
        return estaMarcada;
    }

    /**
     * @param estaMarcada the estaMarcada to set
     */
    public void setEstaMarcada(boolean estaMarcada) {
        this.estaMarcada = estaMarcada;
    }

    /**
     * @return the teMina
     */
    public boolean isTeMina() {
        return teMina;
    }

    /**
     * @param teMina the teMina to set
     */
    public void setTeMina(boolean teMina) {
        this.teMina = teMina;
    }
    
    
    
}

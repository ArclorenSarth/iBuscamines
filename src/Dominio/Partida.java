/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;



@Entity
@Table(name="Partides")


/**
 *
 * @author ArclorenSarth
 */
public class Partida implements Serializable {
    @Id private int idPartida;
    private boolean estaAcabada;
    private boolean estaGuanyada;
    private int nombreTirades;
    
    @ManyToOne private Nivell nivellPartida;
    //private Jugador jugadorPartida; not implemented
    //private Collection <Casella> CasellesPartida; not implemented
    
   
    //CREADORA
    public Partida (int id, /*Jugador j,*/ Nivell n){
        idPartida = id;
        estaAcabada = false;
        estaGuanyada = false;
        nombreTirades = 0;
        
        nivellPartida = n;
        //jugadorPartida = not implemented;
        //CasellesPartida = not implemented
        
    }

    /**
     * @return the idPartida
     */
    public int getIdPartida() {
        return idPartida;
    }

    /**
     * @param idPartida the idPartida to set
     */
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    /**
     * @return the estaAcabada
     */
    public boolean isEstaAcabada() {
        return estaAcabada;
    }

    /**
     * @param estaAcabada the estaAcabada to set
     */
    public void setEstaAcabada(boolean estaAcabada) {
        this.estaAcabada = estaAcabada;
    }

    /**
     * @return the estaGuanyada
     */
    public boolean isEstaGuanyada() {
        return estaGuanyada;
    }

    /**
     * @param estaGuanyada the estaGuanyada to set
     */
    public void setEstaGuanyada(boolean estaGuanyada) {
        this.estaGuanyada = estaGuanyada;
    }

    /**
     * @return the nombreTirades
     */
    public int getNombreTirades() {
        return nombreTirades;
    }

    /**
     * @param nombreTirades the nombreTirades to set
     */
    public void setNombreTirades(int nombreTirades) {
        this.nombreTirades = nombreTirades;
    }

    /**
     * @return the nivellPartida
     */
    public Nivell getNivellPartida() {
        return nivellPartida;
    }

    /**
     * @param nivellPartida the nivellPartida to set
     */
    public void setNivellPartida(Nivell nivellPartida) {
        this.nivellPartida = nivellPartida;
    }
     
}

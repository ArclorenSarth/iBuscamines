/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;


import javax.persistence.*;

//@Entity
//@Table(name="Jugadors")
/**
 *
 * @author ArclorenSarth
 */
public class Jugador {
    @Id private String nom;
    
    public Jugador(String n){
        nom = n;
    }
}

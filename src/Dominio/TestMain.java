/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;


import static java.lang.System.exit;
import org.hibernate.*;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory(); 
        Session s = sf.openSession(); // obtenemos la session para la comunicacion
                                      // con la Base de Datos
        
        Nivell n = new Nivell("level", 3,3,2);   //creamos una instancia de Nivell
        Partida p = new Partida(1,n);      //creamos una instancia de partida
        
        
        s.beginTransaction();
        s.delete(p);         //nos aseguramos que los objetos no existan ya
        s.delete(n);         //eliminandolos si es posible
        s.getTransaction().commit();
        
        try{
            s.beginTransaction();
            s.save(n);
            s.save(p);
            s.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Fallo en la insercion de Nivell y Partida");
            exit(0);
        }
        
        try{
            s.beginTransaction();           //modificamos los distintos 
            n.setNombreCasellesxFila(20);   //atributos de nivell y guardamos
            n.setNombreCasellesxColumna(20);//las modificaciones en la DB
            n.setNombreMines(300);
            s.update(n);
            s.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Fallo en la modificacion de Nivell");
            exit(0);
        }
        Nivell n2 = (Nivell) s.get(Nivell.class,"level");
        if (!n2.getNom().equals("level") || n2.getNombreCasellesxFila() != 20 ||
            n2.getNombreCasellesxColumna() != 20 || n2.getNombreMines() != 300){
            System.out.println("Fallo en la comprobacion de Nivell");
            exit(0);
        }//comprovamos que el objeto ha sido modificado en la DB correctamente
        
        n2 = new Nivell("level2",40,40,500);            
        try{                            //modificamos el nombre de la segunda
            s.beginTransaction();       //instancia de nivell para diferenciarla
            s.save(n2);                  //de la primera que hemos creado y la
            s.getTransaction().commit();//guardamos tambien en la DB
        }catch(Exception e){
            System.out.println("Fallo en la insercion de level2");
            exit(0);
        }
        
        
        try{
            s.beginTransaction();           //modificamos los distintos 
            p.setEstaAcabada(true);         //atributos de partida y guardamos
            p.setEstaGuanyada(true);        //las modificaciones en la DB
            p.setNombreTirades(1000);   
            p.setNivellPartida(n2);         //cambiamos tambien el Nivell de la 
            s.update(p);                    //partida    
            s.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Fallo en la modificacion de Partida");
            exit(0);
        }
        Partida p2 = (Partida) s.get(Partida.class,1);
        if (p2.getIdPartida() != 1 || p2.getNombreTirades() != 1000 ||
            p2.getNivellPartida() != n2 || !p2.isEstaAcabada() ||
            !p2.isEstaGuanyada()){
            System.out.println("Fallo en la comprobacion de Partida");
            exit(0);
        } //comprovamos que el objeto ha sido modificado en la DB correctamente        
    }
}

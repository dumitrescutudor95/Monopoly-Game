
package boardgame;

import java.util.LinkedList;
import java.util.List;


public class Player {

    public int pozitiePlayer ;    // X
    public int pozitieNouaPlayer; //Y
   //  X -> _ -> _ -> _ -> _ -> _ -> Y   Drumul parcurs in functie de zarul dat
    
    public int bugetPlayer = 2500;
    
    public CountProprietatiPlayer proprietatiPlayer = new CountProprietatiPlayer();
    
    //Lista domeniilor detinute (Folosita in optiunea de Trade)
    public List<Object> listaDomeniiPlayer = new LinkedList<>();
    
    //Variabile folosite pentru determinarea chiriilor in functie de numarul de fabrici si metrouri detinute
    public int numarDeFabriciCumparate;
    public int numarMetrouriCumparate;
    
    //Cat timp aceasta variabila este mai mica ca 0,jocul va decurge normal.
    //Cand jucatorul intra in inchisoare,aceasta variabila ia valoarea 2.
    //La fiecare tur,aceasta variabila scade -1.
    public int asteptarePlayer;
     
    public Player(){
        pozitiePlayer = 0;
        pozitieNouaPlayer=0;
        numarDeFabriciCumparate=0;
        asteptarePlayer = -1;
        numarMetrouriCumparate=0;
    }
    
    public void resetPlayer(){
     pozitiePlayer=0;
     pozitieNouaPlayer=0;
     bugetPlayer=2500;
     numarMetrouriCumparate=0;
     listaDomeniiPlayer.removeAll(listaDomeniiPlayer);
     proprietatiPlayer.resetProprietati(); //Resetarea numarului proprietatilor (clasa CountProprietatiPlayer)
    }
}

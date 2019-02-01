package boardgame;

//Clasa folosita pentru numararea tuturor proprietatilor de aceeasi culoare a fiecarui jucator
public class CountProprietatiPlayer {

    public int proprietati_1_3 = 0;      //Ferentari , Rahova
    public int proprietati_6_8_9 = 0;    //Titan,Vitan,Stefan cel Mare
    public int proprietati_11_13_14 = 0; //Izvor,MegaMall,Liberty Center
    public int proprietati_16_18_19 = 0; //Militari,Drumul Taberei,13 Septembrie
    public int proprietati_21_22_24 = 0; //Cotroceni,Oraselul Copiilor,Cismigiu
    public int proprietati_26_28_29 = 0; //Piata Unirii,Berceni,Baneasa
    public int proprietati_31_32_34 = 0; //Park Lake,Afi Palace,Herastrau
    public int proprietati_37_39 = 0;    //Dorobanti,Centrul vechi

    public CountProprietatiPlayer() {
    }

    public void resetProprietati() {
        proprietati_1_3 = 0;        //Ferentari , Rahova-----------------------|
        proprietati_6_8_9 = 0;      // Titan,Vitan,Stefan cel Mare-------------|
        proprietati_11_13_14 = 0;   //Izvor,MegaMall,Liberty Center------------|
        proprietati_16_18_19 = 0;   //Militari,Drumul Taberei,13 Septembrie----|
        proprietati_21_22_24 = 0;   //Cotroceni,Oraselul Copiilor,Cismigiu-----|
        proprietati_26_28_29 = 0;   //Piata Unirii,Berceni,Baneasa-------------|  
        proprietati_31_32_34 = 0;   //Park Lake,Afi Palace,Herastrau-----------|
        proprietati_37_39 = 0;      //Dorobanti,Centrul vechi------------------------> 0
    }
}

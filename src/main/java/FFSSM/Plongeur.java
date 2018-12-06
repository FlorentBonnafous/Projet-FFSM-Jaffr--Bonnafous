package FFSSM;

import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne {
    
    private int niveau;
    public HashSet<Licence> licences = new HashSet<>();
    private GroupeSanguin gs;

    public Plongeur(int niveau, GroupeSanguin gs, String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.gs = gs;
    }
    
    public void ajouteLicence(Licence l){
        licences.add(l);
    }
    
     public boolean licencesVal(Calendar d){
        boolean val = false;
        for(Licence l : licences){
            if(l.estValide(d)){
                val = true;
            }
        }
        return val;
    }	




    
    
    
     
}

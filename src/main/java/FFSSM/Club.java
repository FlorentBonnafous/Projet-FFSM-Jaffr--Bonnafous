/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    private HashSet<Plongee> plongeesNonConformes = new HashSet<>();
    private HashSet<Plongee> plongeesConformes = new HashSet<>();



    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Set<Plongee> plongeesNonConformes() {
        return plongeesNonConformes;
    }

    public void organisePlongee(Plongee plongee) {
        if (plongee.estConforme()) {
            plongeesConformes.add(plongee);
        } else {
            plongeesNonConformes.add(plongee);
        }
        }
    
    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
    

}

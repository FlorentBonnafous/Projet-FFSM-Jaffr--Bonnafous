/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.ok
 */


import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongeur;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import FFSSM.GroupeSanguin;
import FFSSM.Plongee;
import FFSSM.Site;
import java.util.HashSet;

public class FFSSM_Test {
    
    public Calendar dateDeNaissance;
    public Calendar delivrance;
    public Calendar delivrancefausse;
    public Calendar datePlongee;
    public Licence licenceR1;
    public Licence licenceInvalide;
    public Plongeur p1;
    public Plongeur p2;
    public Moniteur MoniteurR1;
    public Club club;
    public Personne R1;
    public Site StFereol;
    public Plongee plongee;
    public Licence licences;

    
    public FFSSM_Test() {
    }
    
    @Before
    public void setUp() {
        Calendar dateDeNaissance = Calendar.getInstance();
        Calendar delivrance = Calendar.getInstance();
        Calendar delivrancefausse =  Calendar.getInstance();
        Calendar dateval = Calendar.getInstance();
        dateval.set(2019,01,01);
        delivrancefausse.set(2015,11,20);
        delivrance.set(2018,11,17);
        dateDeNaissance.set(1988, 11,2);
        Personne R1 = new Personne("1","JAFFRE","R1","67 bd Baille","06.14.52.07.70",dateDeNaissance);
        Licence licenceR1 = new Licence(R1,"1",delivrance,4,club);
        Licence licenceInvalide = new Licence(R1,"2",delivrancefausse,2,club);
        Plongeur p1 = new Plongeur(2,GroupeSanguin.BMOINS,"4","BONNAFOUS","Florent","2 rue du swag","07.01.04.14.78",dateDeNaissance);
        Plongeur p2 = new Plongeur(3,GroupeSanguin.BMOINS,"5","SANDRE","Paul","5 rue du swag","06.01.04.14.78",dateDeNaissance);  
        Moniteur MoniteurR1 = new Moniteur(1,2,GroupeSanguin.APLUS,"12345","JAFFRE","R1","14 rue des anges","06.07.08.09.10",dateDeNaissance);
        Club club = new Club(MoniteurR1,"Mon club","06.08.09.10.11");
        Site StFereol = new Site("StFé","Lac magnifique"); 
        Plongee plongee = new Plongee(StFereol,MoniteurR1,datePlongee,10,30);
        licenceR1.setClub(club);
        this.dateDeNaissance = dateDeNaissance;
        this.delivrance = delivrance;
        this.delivrancefausse = delivrancefausse;
        this.R1 = R1;
        this.licenceR1 = licenceR1;
        this.licenceInvalide = licenceInvalide;
        this.p1 = p1;
        this.p2 = p2;
        this.MoniteurR1 = MoniteurR1;
        this.club = club;
        this.datePlongee = dateval;
        this.plongee = plongee;
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testLicence(){
        assertEquals(true,licenceR1.estValide(datePlongee));
        assertEquals(false,licenceInvalide.estValide(datePlongee));
    }
    
    @Test
    public void testEmbauche(){
        Embauche e = new Embauche(delivrance,MoniteurR1,club);
        Embauche f = new Embauche(datePlongee,MoniteurR1,club);
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        e.terminer(date);
        assertEquals(true,e.estTerminee());
        assertEquals(false,f.estTerminee());
    }
    
    @Test
    public void testMoniteur(){
        assertEquals(null,MoniteurR1.employeur());
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        MoniteurR1.nouvelleEmbauche(club, date);
        assertEquals(club,MoniteurR1.employeur());
    }
    
    @Test
    public void testAjoutPlongee(){
        
        plongee.ajouteParticipant(p1);
        assertEquals(1,plongee.LesParticipants.size());
 
        plongee.ajouteParticipant(p2);
        assertEquals(2,plongee.LesParticipants.size());
    }
    
    @Test
    public void testAjoutLicence(){
        
        p1.ajouteLicence(licenceR1);
        assertEquals(1,p1.licences.size());
      
    }
    
    
        
    /*
    
    
    @Test
    public void testLicencesValides(){
        assertEquals(true,MoniteurR1.licencesValides(dateval));
        assertEquals(false,p1.licencesValides(dateval));
    }*/
}


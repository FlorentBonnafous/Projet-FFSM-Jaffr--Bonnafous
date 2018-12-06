/**
 * @(#) Personne.java
 */

package FFSSM;

import java.util.Calendar;

public class Personne
{
	public String numeroINSEE;
	
	public String nom;
	
	public String prenom;
	
	public String adresse;
	
	public String telephone;
	
	public Calendar naissance;

    public Personne(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance) {
        setNumeroINSEE(numeroINSEE); // Le mutateur fait le contrôle non null
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.naissance = naissance;
    }

    public String getNumeroINSEE() {
        return numeroINSEE;
    }

    public void setNumeroINSEE(String numeroINSEE) {
        // Vérifier la cardinalité implicite [1]
	if (null == numeroINSEE)
		throw new IllegalArgumentException("numeroINSEE is null");
        this.numeroINSEE = numeroINSEE;
    }

 

	
}

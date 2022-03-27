package ma.ensa.tpvolleyhh.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Etudiant implements Parcelable {
    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private String sexe;
    public Etudiant() {
    }
    public Etudiant(int id, String nom, String prenom, String ville, String sexe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.sexe = sexe;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    public Etudiant(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        // TODO Auto-generated method stub
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
    }

    public static final Parcelable.Creator<Etudiant> CREATOR = new Parcelable.Creator<Etudiant>() {
        public Etudiant createFromParcel(Parcel in) {
            return new Etudiant(in);
        }

        public Etudiant[] newArray(int size) {
            return new Etudiant[size];
        }
    };
}

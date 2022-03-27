package ma.ensa.tpvolleyhh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.tpvolleyhh.adapter.EtudiantAdapter;
import ma.ensa.tpvolleyhh.beans.Etudiant;
import ma.ensa.tpvolleyhh.service.EtudiantService;

public class DisplayEtudiants extends AppCompatActivity {
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.etudiantlisteview);
        EtudiantService ns = new EtudiantService(getApplicationContext());
        ListView liste = findViewById(R.id.listView);
        intent = getIntent();
        System.out.println("khdemch");

        Bundle bundle = getIntent().getExtras();
        ArrayList<Etudiant> arraylist = bundle.getParcelableArrayList("MYLIST");
        for(Etudiant e:arraylist){
            System.out.println(e.getNom());
            System.out.println("e.getNom()");
        }
        liste.setAdapter(new EtudiantAdapter(this, arraylist));
        liste.setVisibility(View.VISIBLE);




    }
}

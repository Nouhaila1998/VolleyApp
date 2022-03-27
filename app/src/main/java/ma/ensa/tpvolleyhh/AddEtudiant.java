package ma.ensa.tpvolleyhh;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ma.ensa.tpvolleyhh.beans.Etudiant;

public class AddEtudiant extends AppCompatActivity implements View.OnClickListener {
    private EditText nom;
    private EditText prenom;
    private Spinner ville;
    private RadioButton m;
    private RadioButton f;
    private Button add;
    private Button move;
    RequestQueue requestQueue;
    String insertUrl = "http://192.168.1.26:4040/projet/ws/createEtudiant.php";
    private ArrayList<Etudiant> anass= new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        ville = (Spinner) findViewById(R.id.ville);
        add = (Button) findViewById(R.id.add);
        move = (Button) findViewById(R.id.move);
        m = (RadioButton) findViewById(R.id.m);
        f = (RadioButton) findViewById(R.id.f);
        add.setOnClickListener(this);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEtudiant.this, DisplayEtudiants.class);
                Bundle bundle = new Bundle();

                bundle.putParcelableArrayList("MYLIST",  anass);
                intent.putExtras(bundle);
                System.out.println("walo");

                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.d("ok", "ok");
        if (v == add || v==move) {
            String url = "your url";
            StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response);
                    try {
                        Log.d(TAG, response);
                        Type type = new TypeToken<Collection<Etudiant>>() {
                        }.getType();
                        Collection<Etudiant> etudiants = new Gson().fromJson(response, type);
                        for(Etudiant e : etudiants){
                            Log.d(TAG, e.toString());
                            Log.d(TAG,e.getNom());
                            anass.add(e);
                        }
                    }
catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        }){
//This is how you will send the data to API
            @Override
            protected Map<String, String> getParams(){
                String sexe="";
                if(m.isChecked()) sexe="homme";
                else sexe="femme";
                Map<String,String> map = new HashMap<>();
                map.put("nom",nom.getText().toString());
                map.put("prenom",prenom.getText().toString());
                map.put("ville",ville.getSelectedItem().toString());
                map.put("sexe",sexe);

                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
        }
    }

}

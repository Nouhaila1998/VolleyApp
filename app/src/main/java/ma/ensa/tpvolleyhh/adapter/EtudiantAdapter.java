package ma.ensa.tpvolleyhh.adapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import ma.ensa.tpvolleyhh.R;
import ma.ensa.tpvolleyhh.beans.Etudiant;

public class EtudiantAdapter extends BaseAdapter{

    private List<Etudiant> etudiants;
    private LayoutInflater inflater;

    public EtudiantAdapter(Activity activity,List<Etudiant> etudiants) {

        this.etudiants = etudiants;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return 0 ;}

    @Override
    public Object getItem(int position) {
        return 0;    }

    @Override
    public long getItemId(int position) {
return 0;    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.etudiantitem, null);

        TextView nom = convertView.findViewById(R.id.nom);
        TextView idf = convertView.findViewById(R.id.ville);


        idf.setText(etudiants.get(position).getVille()+"");
        nom.setText(etudiants.get(position).getNom());





        return convertView;    }
}

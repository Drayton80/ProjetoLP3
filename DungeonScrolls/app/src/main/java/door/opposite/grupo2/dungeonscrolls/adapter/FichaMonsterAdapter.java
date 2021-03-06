package door.opposite.grupo2.dungeonscrolls.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import door.opposite.grupo2.dungeonscrolls.R;
import door.opposite.grupo2.dungeonscrolls.databinding.ActivityRoomListviewFichaBinding;
import door.opposite.grupo2.dungeonscrolls.databinding.LineMonsterBinding;
import door.opposite.grupo2.dungeonscrolls.viewmodel.FichaModel;

/**
 * Created by ci on 11/04/18.
 */

public class FichaMonsterAdapter extends ArrayAdapter<FichaModel> {
    private ArrayList<FichaModel> fichaModelArrayList;
    Context context2;

    public FichaMonsterAdapter(@NonNull Context context, ArrayList<FichaModel> fichaModelArrayList)  {
        super(context, R.layout.line_monster, fichaModelArrayList);
        this.context2 = context;
        this.fichaModelArrayList = fichaModelArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LineMonsterBinding LineMonsterBinding = DataBindingUtil.inflate(layoutInflater, R.layout.line_monster, parent, false);
        LineMonsterBinding.setFichas(fichaModelArrayList.get(position));
        if (fichaModelArrayList.get(position).getImagem() != null) {
            Picasso.get().load(fichaModelArrayList.get(position).getImagem()).into(LineMonsterBinding.listviewFichaImageViewImagem);
        }
        return LineMonsterBinding.getRoot();
    }}

package com.example.oihana.chat.Mensajes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oihana.chat.R;

import java.util.List;

/**
 * Created by Oihana on 17/07/2018.
 */

public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.MensajesViewHolder> {

    private List<MensajeDeTexto> mensajeDeTextos;

    public MensajesAdapter(List<MensajeDeTexto> mensajeDeTextos) {
        this.mensajeDeTextos = mensajeDeTextos;
    }

    @Override
    public MensajesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mensajes,parent,false);
        return new MensajesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MensajesViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return mensajeDeTextos.size();
    }

    static class MensajesViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView TvMensaje, TvHora;

        MensajesViewHolder(View itemView ){
            super(itemView);





            cardView=(CardView) itemView.findViewById(R.id.cvMensaje);
            TvMensaje=(TextView) itemView.findViewById(R.id.msTexto);
            TvHora=(TextView) itemView.findViewById(R.id.msHora);

        }
    }
}

package com.example.oihana.chat.Mensajes;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

        RelativeLayout.LayoutParams rl=(RelativeLayout.LayoutParams) holder.cardView.getLayoutParams();
        FrameLayout.LayoutParams fl= (FrameLayout.LayoutParams) holder.mensajeBG.getLayoutParams();

        if(mensajeDeTextos.get(position).getTipoMensaje()==1) {
            holder.mensajeBG.setBackgroundResource(R.drawable.globo_de_texto);
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT,0);
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            fl.gravity= Gravity.LEFT;
        }else if(mensajeDeTextos.get(position).getTipoMensaje()==2){
            holder.mensajeBG.setBackgroundResource(R.drawable.globo_textoi);
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            fl.gravity=Gravity.RIGHT;
        }

        holder.cardView.setLayoutParams(rl);
        holder.mensajeBG.setLayoutParams(fl);
        holder.TvMensaje.setText(mensajeDeTextos.get(position).getMensaje());
        holder.TvHora.setText(mensajeDeTextos.get(position).getHoraDelMensaje());
    }

    @Override
    public int getItemCount() {
        return mensajeDeTextos.size();
    }

    static class MensajesViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView TvMensaje, TvHora;
        LinearLayout mensajeBG;

        MensajesViewHolder(View itemView ){
            super(itemView);

            cardView=(CardView) itemView.findViewById(R.id.cvMensaje);
            mensajeBG=(LinearLayout) itemView.findViewById(R.id.linearMensajeBG);
            TvMensaje=(TextView) itemView.findViewById(R.id.msTexto);
            TvHora=(TextView) itemView.findViewById(R.id.msHora);

        }
    }
}

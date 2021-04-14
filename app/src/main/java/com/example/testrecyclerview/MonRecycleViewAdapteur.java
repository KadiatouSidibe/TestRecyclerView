package com.example.testrecyclerview;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonRecycleViewAdapteur extends RecyclerView.Adapter<MonRecycleViewAdapteur.ConteneurDeDonnee> {
        private ArrayList<Donnee> donnees;
        private static DetecteurDeClicSurRecycler detecteurDeClicSurRecycler;

        public MonRecycleViewAdapteur(ArrayList<Donnee> donnees) {
            this.donnees = donnees;
        }

        @Override
        public ConteneurDeDonnee onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
            return new ConteneurDeDonnee(view);
        }

        @Override
        public void onBindViewHolder(ConteneurDeDonnee conteneur, int position) {
            conteneur.tv_principal.setText(donnees.get(position).getPrincipal());
            conteneur.tv_auxiliaire.setText(donnees.get(position).getAuxiliaire());
            conteneur.imageView.setImageResource(donnees.get(position).getImage());
        }

        @Override
        public int getItemCount() {
            return donnees.size();
        }

        public class ConteneurDeDonnee extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv_principal;
            TextView tv_auxiliaire;
            ImageView imageView;

            public ConteneurDeDonnee(View itemView) {
                super(itemView);
                tv_principal = (TextView) itemView.findViewById(R.id.tv_principal);
                tv_auxiliaire = (TextView) itemView.findViewById(R.id.tv_auxiliaire);
                imageView=itemView.findViewById(R.id.image);
                itemView.setOnClickListener(this);
            }


            public void onClick(View v) {
                ((CardView)v).setCardBackgroundColor(Color.rgb(255,0,0));
                detecteurDeClicSurRecycler.clicSurRecyclerItem(getAdapterPosition(), v);

            }

        }
        public void setDetecteurDeClicSurRecycler(DetecteurDeClicSurRecycler detecteurDeClicSurRecycler) {
            this.detecteurDeClicSurRecycler = detecteurDeClicSurRecycler;
        }



}

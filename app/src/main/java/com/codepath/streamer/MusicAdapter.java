package com.codepath.streamer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>{
    //Attributs
    Context context;
    ArrayList<Music> musicList;
    RecyclerItemClickListener listenerClick;


    public MusicAdapter(Context context, ArrayList<Music> musicList, RecyclerItemClickListener listenerClick){
        this.context = context;
        this.musicList = musicList;
        this.listenerClick = listenerClick;
    }

    @NonNull
    @Override
    public MusicAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music_row, viewGroup, false);

        return new MusicViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MusicViewHolder musicViewHolder, int i) {
        Music music = musicList.get(i);

        musicViewHolder.tv_title.setText(music.getTitre());
        musicViewHolder.tv_artist.setText(music.getArtiste());
        musicViewHolder.tv_duration.setText(music.getDuration());
        //Picasso.with(context).load().placeholder(R.drawable.music_placeholder).into(musicViewHolder.iv_artwork);
        // musicViewHolder.iv_artwork.setImageDrawable(music_placeholder);
        musicViewHolder.bind(music, listenerClick);

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }


    //class MusicViewHolder
    public static class MusicViewHolder extends RecyclerView.ViewHolder{
        //Attributs
        private TextView tv_artist;
        private TextView tv_title;
        private TextView tv_duration;
        private ImageView iv_artwork, iv_play_active;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_artist = (TextView) itemView.findViewById(R.id.tv_artist);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_duration = (TextView)itemView.findViewById(R.id.tv_duration);
            iv_artwork = (ImageView)itemView.findViewById(R.id.iv_artwork);
            iv_play_active = (ImageView)itemView.findViewById(R.id.iv_play_active);
        }

        public void bind(final Music music, final RecyclerItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickListener(music, getLayoutPosition());
                }
            });
        }
    }

    public interface RecyclerItemClickListener{
        void onClickListener(Music music, int position);
    }

}

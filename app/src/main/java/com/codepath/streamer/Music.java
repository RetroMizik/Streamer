package com.codepath.streamer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Music {
    private String titre;
    private String posterUrl;
    private String artiste;
    private String duration;
    private String imgPlayActive;


    //Getters
    public String getTitre() {
        return titre;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getDuration() {
        return duration;
    }

    public String getImgPlayActive() {
        return imgPlayActive;
    }

    //Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setImgPlayActive(String imgPlayActive) {
        this.imgPlayActive = imgPlayActive;
    }

    //Constructor for fake data
    public Music(String titre, String posterUrl, String artiste, String duration, String imgPlayActive) {
        this.titre = titre;
        this.posterUrl = posterUrl;
        this.artiste = artiste;
        this.duration = duration;
        this.imgPlayActive = imgPlayActive;
    }

    //Constructor for json data
    public Music(JSONObject objectJson){
        try{
            this.titre = objectJson.getString("title");
            this.artiste = objectJson.getString("artist");
            this.posterUrl = objectJson.getString("poster_path");
            this.duration = objectJson.getString("duration");
            this.imgPlayActive = objectJson.getString("music_path");
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    //ArrayList for json data
    public static ArrayList<Music> fromJson(JSONArray jsonObjects) {
        ArrayList<Music> music = new ArrayList<>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                music.add(new Music(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return music;
    }

    //ArrayList for fake data
    public static ArrayList<Music> getFakeMusic(){
        ArrayList<Music> music = new ArrayList<>();
        music.add(new Music("Happy Fifty compa", "", "Zenglen", "3:05", ""));
        music.add(new Music("Happy Fifty compa", "", "Zenglen", "3:05", ""));
        music.add(new Music("Happy Fifty compa", "", "Zenglen", "3:05", ""));
        music.add(new Music("Happy Fifty compa", "", "Zenglen", "3:05", ""));
        music.add(new Music("Happy Fifty compa", "", "Zenglen", "3:05", ""));

        return music;
    }
}

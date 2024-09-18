package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SpotData {
    public static class Record {
        public long id;
        public String beach;
        public  int difficulty_level;
        public String country;
        public  String photos;
    }

    public static class Fields {
        @SerializedName("beach")
        public String beach;
        @SerializedName("Difficulty level")
        public int difficulty_level;
        @SerializedName("country")
        public String country;
        @SerializedName("photos")
        public String photos;
    }

    public static class Response {
        public List<Record> records;
        public String offset;
    }
}




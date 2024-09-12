package com.example.myapplication;

public class spot {
    private long id;
    private String beach;
    private int difficulty_level;
    private String country;
    private String photos;

        // Getter et Setter pour id
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        // Getter et Setter pour beach
        public String getBeach() {
            return beach;
        }

        public void setBeach(String beach) {
            this.beach = beach;
        }

        // Getter et Setter pour difficulty_level
        public int getDifficulty_level() {
            return difficulty_level;
        }

        public void setDifficulty_level(int difficulty_level) {
            this.difficulty_level = difficulty_level;
        }

        // Getter et Setter pour country
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        // Getter et Setter pour photos
        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", beach='" + beach + '\'' +
                ", difficulty_level=" + difficulty_level +
                ", country='" + country + '\'' +
                ", photos='" + photos + '\'' +
                '}';
    }
    }




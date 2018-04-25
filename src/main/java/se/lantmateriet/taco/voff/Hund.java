package se.lantmateriet.taco.voff;

import com.fasterxml.jackson.annotation.JsonValue;

public final class Hund implements Comparable<Hund> {

    @Override public int compareTo(Hund other) {
        int compare = this.ras.getNamn().compareTo(other.ras.getNamn());

        if(compare == 0) {
            compare = this.namn.compareTo(other.namn);
        }

        return compare;
    }

    public enum Ras {
        TIBETANSK_TERRIER("Tibetansk terrier"),
        DOGO_CANARIO("Dogo canario"),
        ROTWEILER("Rotweiler"),
        COLLIE("Collie"),
        UNKNOWN("Okänd");

        @JsonValue
        private String namn;

        private Ras(String namn) {
            this.namn = namn;
        }

        public String getNamn() {
            return namn;
        }
    }

    public final int id;
    public final Ras ras;
    public final String namn;

    public Hund(int id, Ras ras, String namn) {
        this.id = id;
        this.ras = ras;
        this.namn = namn;
    }
}

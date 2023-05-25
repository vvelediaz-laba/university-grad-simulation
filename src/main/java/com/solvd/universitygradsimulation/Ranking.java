package com.solvd.universitygradsimulation;

public class Ranking {
    private String rankingName;
    private Integer rank;
    private Integer year;

    public Ranking(){

    }

    public Ranking(String rankingName, int rank, int year) {
        this.rankingName = rankingName;
        this.rank = rank;
        this.year = year;
    }

    public String getRankingName() {
        return rankingName;
    }

    public void setRankingName(String rankingName) {
        this.rankingName = rankingName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}


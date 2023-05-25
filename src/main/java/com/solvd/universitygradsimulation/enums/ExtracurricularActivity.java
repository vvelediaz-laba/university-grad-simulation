package com.solvd.universitygradsimulation.enums;

import com.solvd.universitygradsimulation.Location;

public enum ExtracurricularActivity {
    DEBATE_CLUB("Debate Club"),
    MUSIC_ENSEMBLE("Music Ensemble", "Auditorium"),
    SPORTS_TEAM("Sports Team", "Field"),
    COMMUNITY_SERVICE_GROUP("Community Service Group"),
    DRAMA_CLUB("Drama Club", "Theater"),
    STUDENT_NEWSPAPER("Student Newspaper", "Media Center"),
    LANGUAGE_CLUB("Language Club", "Language Lab"),
    CODING_CLUB("Coding Club", "Computer Lab"),
    ART_CLUB("Art Club", "Art Studio"),
    DANCE_TEAM("Dance Team", "Dance Studio"),
    NO_ACTIVITY("No Activity", "N/A");

    private final String activityName;
    private final Location meetingLocation;

    ExtracurricularActivity(String activityName, Location meetingLocation) {
        this.activityName = activityName;
        this.meetingLocation = meetingLocation;
    }

    ExtracurricularActivity(String activityName, String meetingLocation) {
        this.activityName = activityName;
        this.meetingLocation = new Location(meetingLocation);
    }

    ExtracurricularActivity(String activityName) {
        this.activityName = activityName;
        this.meetingLocation = new Location();
    }

    public String getActivityName() {
        return activityName;
    }

    public Location getMeetingLocation() {
        return meetingLocation;
    }
}


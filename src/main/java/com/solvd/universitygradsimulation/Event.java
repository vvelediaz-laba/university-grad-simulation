package com.solvd.universitygradsimulation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Event {
    private static final Logger logger = LogManager.getLogger(Event.class.getName());

    private String name;
    private String eventDescription;

    public Event(){

    }

    public Event(String name, String eventDescription) {
        this.name = name;
        this.eventDescription = eventDescription;
    }

    public void startEvent(){
        logger.info(name + " has started!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for(int i = 0; i < name.length(); i++){
            hash = hash*31 + name.charAt(i);
        }
        for(int i = 0; i < eventDescription.length(); i++){
            hash = hash*31 + eventDescription.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Event event = (Event) obj;
        return this.name.equals(event.name) && this.eventDescription.equals(event.eventDescription);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Description: " + eventDescription;
    }
}

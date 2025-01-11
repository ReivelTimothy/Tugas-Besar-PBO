package Models.Enumeration;

public enum EventCat {
    MUSIC, 
    SPORT, 
    EDUCATION, 
    OTHERS;

    public static String getEnum(EventCat eventCat){
        return String.valueOf(eventCat);
    }
    public static EventCat toEnum(String eventCat){
        if (EventCat.MUSIC.name().equalsIgnoreCase(eventCat)) {
            return EventCat.MUSIC;
        } else if (EventCat.EDUCATION.name().equalsIgnoreCase(eventCat)){
            return EventCat.EDUCATION;
        } else {
            return EventCat.SPORT;
        }
    }
}

package Models.Enumaration;

public enum EventCat {
    MUSIC, 
    SPORT, 
    EDUCATION, 
    OTHERS;

    public static String getEnum(EventCat eventCat){
        return String.valueOf(eventCat);
    }
}

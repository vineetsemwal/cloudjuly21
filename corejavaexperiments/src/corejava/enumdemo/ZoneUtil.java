package corejava.enumdemo;

public class ZoneUtil {

    public ZoneType toZone(String zoneText){
       ZoneType[]zones =ZoneType.values();
       for (ZoneType zone:zones){
           String text=zone.name();
           if(text.equalsIgnoreCase(zoneText)){
               return zone;
           }
       }
       throw new InvalidZoneException(zoneText+" zone is invalid");
    }

}

package corejava.enumdemo;

public class ZoneMain {

    public static void main(String[] args){
        ZoneUtil zoneUtil=new ZoneUtil();
        String text="narth";
        ZoneType zone = zoneUtil.toZone(text);
        System.out.println("zone found="+zone.name());
    }
}

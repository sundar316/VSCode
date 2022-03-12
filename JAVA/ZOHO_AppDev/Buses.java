package ZOHO_AppDev;

import java.util.ArrayList;
import java.util.List;

public class Buses {

    String bus;
    String type;
    int seats;
    int avail[][];

    Buses (String bus, String type, int seats) {
        this.bus = bus;
        this.seats = seats;
        this.type = type;
        if (this.bus.equals("Sleeper"))
            this.avail = new int[6][2];
        else
            this.avail = new int[4][3];
    }

    static List<Buses> buses = new ArrayList<>();

    static {
        buses.add(new Buses("Sleeper", "AC", 12));
        buses.add(new Buses("Sleeper", "NON-AC", 12));
        buses.add(new Buses("Seater", "AC", 12));
        buses.add(new Buses("Seater", "NON-AC", 12));
    }

    public static void list () {
        int j = 1;
        for (Buses i : buses) {
            System.out.println(j++ +"-"+ i.bus +"-"+ i.type +"-"+ i.seats);
        }
    }
}

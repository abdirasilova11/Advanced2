package Java;

import java.io.IOException;

public class Driver {
    private int id;
    private String name;
    private String bus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }
    public static void print(Driver[] drivers) throws IOException {
        System.out.println();
        System.out.println("# | Driver     |  Bus");
        System.out.println("———+————————————+————————————+");
        for (int i = 0; i < drivers.length; i++) {
            System.out.printf(i+"%-3s|",drivers[i].getId());
            System.out.printf("%-12s|",drivers[i].getName());
            System.out.printf("%-13s|",drivers[i].getBus());
            System.out.println();
        }

    }
}

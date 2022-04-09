package Java;

public class Car {
    private int id ;
    private String autoName;
    private String driver;
    private State state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoName() {
        return autoName;
    }

    public void setAutoName(String autoName) {
        this.autoName = autoName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
public  static void print(Car [] cars){
    System.out.println("----------------CARS----------------");
    System.out.println("#  |    Bus        |  Driver  |  State ");
    System.out.println("———+———————————————+——————————+————————");
    for (int i = 0; i < cars.length; i++) {
        System.out.printf("%-3s|", cars[i].getId());
        System.out.printf("%-15s|", cars[i].getAutoName());
        System.out.printf("%-10s|", cars[i].getDriver());
        System.out.printf("%-7s|", cars[i].getState());
        System.out.println();
    }
}
    public static void injection() {
        System.out.println("Айдоочуну алмаштыруу учун 1ди басыныз");
        System.out.println("Автону жургузуу учун 2ни басыныз");
        System.out.println("Ремонтту баштоо учун 3ту басыныз ");
    }

    public static void getInfo(Car car) {
        System.out.println("---------------CARS-INFO----------------");
        System.out.printf("N" + "%12s", ":" + car.getId() + "\n");
        System.out.printf("Bus" + "%23s", ":" + car.getAutoName() + "\n");
        System.out.printf("Driver" + "%6s", ":" + car.getDriver() + "\n");
        System.out.printf("Bus State" + "%7s", ":" + car.getState() + "\n");
    }
    public static void action(String action, Car car, Driver[] drivers)  {
        switch (action) {
            case "1":
                if (car.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.changeDriver(car,drivers);
                    } catch (Exception e) {
                        System.out.println("У грузовика нету водителя");
                    }
                } else if (car.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.changeDriver(car,drivers);
                    } catch (Exception e) {
                        System.out.println("Грузовик в пути, невозможно сменить водителя");
                    }
                } else {
                    State repair = State.REPAIR;
                    try {
                        repair.changeDriver(car,drivers);;
                    } catch (Exception e) {
                        System.out.println("Нельзя сменить водителя");
                    }
                }
        break;
            case "2" :
                if (car.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.startDriving(car);
                    } catch (Exception e) {
                        System.out.println("Грузовикa нету водителя");
                    }
                } else if (car.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.startDriving(car);
                    } catch (Exception e) {
                    }
                } else {
                    State repair = State.REPAIR;
                    try {
                        repair.startDriving(car);
                    } catch (Exception e) {
                        System.out.println();
                    }
                }
                break;
            case "3" :
                if (car.getState() == State.BASE) {
                    State state = State.BASE;
                    try {
                        state.startRepair(car);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (car.getState() == State.ROUTE) {
                    State route = State.ROUTE;
                    try {
                        route.startRepair(car);
                    } catch (Exception e) {
                        System.out.println();
                    }
                } else {
                    try {
                        State repair = State.REPAIR;
                        repair.startRepair(car);
                    } catch (Exception e) {
                        System.out.println("uje v remonte");
                    }
                }
                break;
            default:
                System.out.println();

        }
    }
}

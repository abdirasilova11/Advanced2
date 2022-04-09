package Java;

import java.util.Random;

public enum State {

    BASE("base") {
        @Override
        public void changeDriver(Car car, Driver[] driver) {
            int count = 0;
            for (int i = 0; i < driver.length; i++) {
                if (driver[i].getBus() != null) {
                    count++;
                }
            }
            car.setDriver(driver[count].getName());
            driver[count].setBus(car.getAutoName());
        }

        @Override
        public void startDriving(Car car) throws Exception {
            if (car.getDriver().equals("")) {
                throw new Exception();
            } else {
                car.setState(State.ROUTE);
                System.out.println("успешно вышли на маршрут");
            }
        }

        @Override
        public void startRepair(Car car) {
            car.setState(State.REPAIR);
            System.out.println("repair");
        }
    },
    ROUTE("route") {
        @Override
        public void changeDriver(Car car, Driver[] driver) throws Exception {
            throw new Exception("Жолдо баратып айдоочуну алмаштырган мумкун эмес");
        }

        @Override
        public void startDriving(Car car) throws Exception {
            throw new Exception();
        }

        @Override
        public void startRepair(Car car) throws Exception {
            car.setState(State.REPAIR);
            System.out.println("repair");
        }
    },
    REPAIR("repair") {
        @Override
        public void changeDriver(Car car, Driver[] driver) throws Exception {
            throw new Exception();
        }
        @Override
        public void startDriving(Car car) {
            Random random = new Random();
            int randomNum = random.nextInt(2);
            if(randomNum==0){
                car.setState(State.BASE);
                System.out.println();
            }else {
                car.setState(State.ROUTE);
                System.out.println();
            }
        }

        @Override
        public void startRepair(Car car) throws Exception {
            throw new Exception();
        }
    };


    private String state;
    State(String state) {
        this.state = state;
    }

        public abstract void changeDriver (Car car, Driver[]driver) throws Exception;
        public abstract void startDriving (Car car) throws Exception;
        public abstract void startRepair (Car car) throws Exception;
    }


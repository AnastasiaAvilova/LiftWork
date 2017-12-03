package Avilova.Lift;

public class ActionDown {

    private Lift lift;

    ActionDown( Lift lift){
        this.lift = lift;
    }


    public void run(int number) {
        int location = lift.getLocation();

        if (location == number)
            //зайдут
            for (int i = 0; i < lift.passengerList.size(); i++) {
                if ((lift.passengerList.get(i).getFloorOfDeparture() - lift.passengerList.get(i).getFloorOfDestination() > 0) &&
                        (lift.passengerList.get(i).getFloorOfDeparture() == lift.getLocation()) && (!lift.passengerList.get(i).getIsInLift()))
                    if (lift.passengerList.get(i).isSuit() && (lift.getVol() - lift.colOfPassangeInLift() >= 1))
                        lift.passengerList.get(i).setIsInLift(true);
                    else
                        lift.passengerList.get(i).setIsLater(true);

                number = find();
            }


        if ((location != lift.getPossibleInitialFloor()) && (location > number)) {

            lift.setLocation(--location);

            if (lift.getLocation() == number) {

                //выйдут
                while (anyoneElse(number)) {
                    for (int i = 0; i < lift.passengerList.size(); i++)
                        if ((lift.passengerList.get(i).getIsInLift()) &&
                                (lift.passengerList.get(i).getFloorOfDestination() == lift.getLocation()))
                            lift.passengerList.remove(lift.passengerList.get(i));
                }

                //зайдут
                for (int i = 0; i < lift.passengerList.size(); i++)
                    if ((lift.passengerList.get(i).getFloorOfDeparture() - lift.passengerList.get(i).getFloorOfDestination() > 0) &&
                            (lift.passengerList.get(i).getFloorOfDeparture() == lift.getLocation()) && (!lift.passengerList.get(i).getIsInLift())) {

                        if (lift.passengerList.get(i).isSuit() && (lift.getVol() - lift.colOfPassangeInLift() >= 1))
                            lift.passengerList.get(i).setIsInLift(true);
                        else
                            lift.passengerList.get(i).setIsLater(true);
                    }
            }
        } else if (location < number) {
            ++location;
            lift.setLocation(location);
        }
    }

    //найти минимальный этаж куда ехать
    public int find(){

        int min = lift.getPossibleInitialFloor();
        for (int i = 0; i < lift.passengerList.size(); i++) {
            if (((!lift.passengerList.get(i).getIsInLift()) && (lift.passengerList.get(i).getFloorOfDeparture() - lift.passengerList.get(i).getFloorOfDestination() > 0)
                    && (lift.getVol() - lift.colOfPassangeInLift() >= 1)) && (!lift.passengerList.get(i).getIsLater())
                    && (min < lift.passengerList.get(i).getFloorOfDeparture()))
                min = lift.passengerList.get(i).getFloorOfDeparture();
            if (lift.passengerList.get(i).getIsInLift() && (min < lift.passengerList.get(i).getFloorOfDestination()))
                min = lift.passengerList.get(i).getFloorOfDestination();
        }
        return min;
    }


    public boolean anyoneElse(int number){
        for (int i = 0; i < lift.passengerList.size(); i++)
            if ((lift.passengerList.get(i).getIsInLift()) &&
                    (lift.passengerList.get(i).getFloorOfDestination() == lift.getLocation()))
                return  true;
        return  false;
    }
}

package Avilova.Lift;

public class ControllerOfLift {

    private Lift lift;
    private ActionDown actiondown;
    private  ActionUp actionup;

    ControllerOfLift (Lift lift){
        this.lift = lift;
        actiondown = new ActionDown(lift);
        actionup = new ActionUp(lift);
    }

    public void run() {

        if (isChange()) {
            lift.setRout(!lift.getRout());
            for (Passenger passenger : lift.passengerList)
                if (passenger.getIsLater())
                    passenger.setIsLater(false);
        }
            //едет вверх
        if ( lift.getRout())
            actionup.run(actionup.find());

        //едет вниз
        else
            actiondown.run(actiondown.find());

    }

    public boolean isChange(){
        if (lift.colOfPassangeInLift() != 0)
            return false;
        else
          if (lift.getRout()){
              for (Passenger passenger : lift.passengerList)
                  if ((passenger.getFloorOfDeparture() - passenger.getFloorOfDestination() < 0)
                      && (!passenger.getIsLater()))
                      return false;
          } else {
              for (Passenger passenger : lift.passengerList)
                  if ((passenger.getFloorOfDeparture() - passenger.getFloorOfDestination() > 0)
                          && (!passenger.getIsLater()))
                      return false;
          }

        return true;
    }

}

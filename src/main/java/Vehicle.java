public class Vehicle {

    public Vehicle(int InitialAltitude) {
        // TODO: initialize the altitude AND previous altitude to initialAltitude
        Altitude = InitialAltitude;
        PrevAltitude = InitialAltitude;
//        PrevAltitude = Altitude;
    }

    int Gravity = 100;
    /* The rate in which the spaceship descents in free fall (in ten seconds) */

    // Various end-of-game messages and status result codes.
    String dead = "\nCRASH!!\n\tThere were no survivors.\n\n";
    public static final int DEAD = -3;
    String crashed = "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
    public static final int CRASHED = -2;
    String emptyfuel = "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
    public static final int EMPTYFUEL = -1;
    String success = "\nYou made it! Good job!\n\n";
    public static final int SUCCESS = 0;
    public static final int FLYING = 1;

    // this is initial vehicle setup
    int Altitude= 8000;
    int PrevAltitude= 8000;

    int Velocity= 1000;
    int Fuel = 12000;
    int Burn = 0;
    int Status = FLYING;


    public Vehicle() {}

    public String checkFinalStatus() {
        String s = "";
        if (this.Altitude <= 0) {
            if (this.Velocity > 10) {
                s = dead;
                this.Status = DEAD;
            }
            if (this.Velocity < 10 && this.Velocity > 3) {
                s = crashed;
                this.Status = CRASHED;
            }
            if (this.Velocity < 3) {
                s = success;
                this.Status = SUCCESS;
            }
        } else {
            if (this.Altitude > 0) {
                s = emptyfuel;
                this.Status = EMPTYFUEL;
            } }
        return s;
    }

    public int computeDeltaV() {
        // TODO: return velocity + gravity - burn amount
        return Velocity + Gravity - Burn; //caro: changed. IS IT BURN for burn amount?
    }

    public void adjustForBurn(int burnAmount) {
        // TODO: set burn to burnamount requested
        // TODO: save previousAltitude with current Altitude
        // TODO set new velocity to result of computeDeltaV function.
        // TODO subtract speed from Altitude
        // TODO subtract burn amount fuel used from tank
        //Caro changed. unsure about directions
        Burn = burnAmount; //burn amount requested?
        PrevAltitude = Altitude;
        Velocity = computeDeltaV();
        Altitude -= Velocity; //is velocity speed?
        Fuel -= Burn;
    }

    public boolean stillFlying() {
        // TODO return true if altitude is positive
        if (Altitude > 0) {
            return true;
        }
        return false;
    }
    public boolean outOfFuel() {
        // TODO return true if fuel is less than or equal to zero
        if (Fuel <= 0) {
            return true;
        }
        return false;
    }

    public DescentEvent getStatus(int tick) { //it's burnInterval in simulation
        // TODO create a return a new DescentEvent object
        // TODO filled in with the state of the vehicle.

        checkFinalStatus(); //caro: added line
        return new DescentEvent(tick, Velocity, Fuel, Altitude, Status); //is status flying?
    }

}

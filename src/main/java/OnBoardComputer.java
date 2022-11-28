public class OnBoardComputer implements BurnStream {

//    @Override
//    public int getNextBurn(DescentEvent status) {
//        int burn = 0;
//
//        System.out.println(burn); /*hack!*/
//        return burn;
//    }
@Override
public int getNextBurn(DescentEvent status) {
    int burn = 0;
    if (status.getAltitude() > 1) {// altitude needs to be greater than 1 to land the rocket
        burn = (status.getVelocity() * status.getVelocity()) / (2 * status.getAltitude()) + 100; //
    } else {
        burn = 100; //adjusts final speed to be constant when altitude is 1
    }
    System.out.println(burn); /*hack!*/
    return burn;
}

}

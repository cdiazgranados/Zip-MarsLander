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
    status.getVelocity();
    if(status.getAltitude() > 14000) {
        burn = 0;
    }
    System.out.println(burn); /*hack!*/
    return burn;
}

}

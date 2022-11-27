public class BurnDataStream implements BurnStream {
    // TODO these are the series of burns made each 10 secs by the lander.
    // TODO change them to see if you can get the lander to make a soft landing.
    // TODO burns are between 0 and 200. This burn array usually crashes.

//    int burnArray[] = {100, 100, 200, 200, 100, 100, 0, 0, 200, 100, 100, 0, 0, 0, 0};
    int burnArray[] = {200, 200, 200, 200, 200, 200, 200, 200, 200, //Caro: Smooth landing at 5000
            100, 100, 100, 100,
            150, 125, 120, 100, 100, 100, 103,
            100, 100, 100, 100};
    int burnIdx = -1;

    public BurnDataStream() { }
    public BurnDataStream(int[] burns) {
        this.burnArray = burns;
    }
    @Override
    public int getNextBurn(DescentEvent status) {
        if (burnIdx < burnArray.length) {
            burnIdx++;
            System.out.println(burnArray[burnIdx]); /*hack!*/
            return burnArray[burnIdx];
        }
        return 0;
    }
}

package INFO6205;

public class PrintConsole {
    public static void print()
    {
        System.out.println("days: "+DemoHelper.frequencySimulator/100+" Total Infected "+CanvasHelper.numberOfInfected +" Active Cases "+CanvasHelper.numberOfActiveCases +" Immune people "+(CanvasHelper.ImmuneCases-CanvasHelper.numberOfFatality)+" Total Fatality " +CanvasHelper.numberOfFatality);

    }
}

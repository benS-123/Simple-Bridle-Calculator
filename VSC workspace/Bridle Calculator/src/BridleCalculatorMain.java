public class BridleCalculatorMain {
    public static void main (String [] args){
        double tension1, tension2;
        
        BridleCalculator obj1 = new BridleCalculator(14.0, 10, 17.94, 1000.0);        
        obj1.calcTension();
        tension1 = obj1.getTension1(); 
        tension2 = obj1.getTension2();
        System.out.println("Tension 1 = " + tension1 + "\n" +"Tension 2 = " + tension2);
        // T1 = 6199.174148995683 T2 = 8192.411674790148
    }
}
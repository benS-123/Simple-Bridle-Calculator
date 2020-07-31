public class BridleCalculator {

    private double tension1, tension2;                  // Tension along cables 1 and 2  
    private double angle1, angle2;                      // Angles between cable and weight
    private double mass;                                // Mass of weight
    private double length1, length2, length3;           // Length between beams and legnth of cables
    private double height;                              // height from ceiling to weight
    private static final double ACCELERATION_DUE_TO_GRAVITY = 9.80665;

    public BridleCalculator() {
        this(0, 0, 0, 0);
    }

    public BridleCalculator(double length1, double length2, double length3, double mass){
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
        this.mass = mass;
    }

    public void calcTension(){
        double semiPerimiter = (length1 + length2 + length3) / 2.0;
        double area = Math.sqrt(semiPerimiter * (semiPerimiter - length1) * (semiPerimiter - length2) * (semiPerimiter - length3));
        height = area * 2.0 / length3;
        angle1 = Math.asin(height / length2);
        angle2 = Math.asin(height / length1);
        tension1 = ((mass * ACCELERATION_DUE_TO_GRAVITY) / (Math.sin(angle2) + Math.cos(angle2) * Math.tan(angle1)));
        tension2 = tension1 * (Math.cos(angle2) / Math.cos(angle1));
    }

    public double getTension1() {
        return tension1;
    }

    public double getTension2() {
        return tension2;
    }

    /**
     * Returns angle 1 in degrees
     * @return
     */
    public double getAngle1() {
        return (Math.toDegrees(angle1));
    }

    public double getAngle2() {
        return angle2;
    }

        /*
    public static void main (String [] args){
        double tension1, tension2;
        
        BridleCalculator obj1 = new BridleCalculator(14.0, 10, 17.94, 1000.0);        
        obj1.calcTension();
        tension1 = obj1.getTension1(); 
        tension2 = obj1.getTension2();
        System.out.println("Tension 1 = " + tension1 + "\n" +"Tension 2 = " + tension2);
        // T1 = 6199.174148995683 T2 = 8192.411674790148
    }  
    */      

}
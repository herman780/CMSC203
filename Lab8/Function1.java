import java.text.DecimalFormat;

public class Function1 extends Function {
	
	public String answerString(double cost, double radius, double height, double z) {
		
		DecimalFormat optimizeValue = new DecimalFormat ("#,###,###.##");
		
		return "Minimum cost is $" + optimizeValue.format(cost) + " with height = " + optimizeValue.format(height) + "cm and radius = " +optimizeValue.format(radius)
		+ "cm";
		
	}
	
	@Override
	public double fnValue(double x) {
		
		double theOptimizedValStart = 0.0;
		
		if(x <= theOptimizedValStart) {
			
			return Double.MAX_VALUE;
		}
		
		else {
			
			return (0.8 * Math.PI * Math.pow(x,2)) + (800/x);
		}
	}
	
	@Override
	public double getXVal(double x) {
		
		return x;
	}
	
	@Override
	public double getYVal(double x) {
		
		return (2000)/(Math.PI * Math.pow(x,2));
	}
	
	public double getZVal(double x) {
		
		return -1.0;
	}
	
	@Override
	public String toString() {
		
		String theCostToBeMinimized = "Minimize the cost of a can that will hold 2 liters of liquid";
		
		return theCostToBeMinimized;
		
	}
	

}

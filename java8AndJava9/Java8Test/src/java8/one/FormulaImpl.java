package java8.one;

public class FormulaImpl {


	
	public static void main(String[] args) {
		Formula formula=new Formula() {
			
			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return sqrt(a);  //接口的默认方法
			}
		};
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
}

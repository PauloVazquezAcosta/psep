package examePSEP;

import java.util.Scanner;

public class ExercicioExameRunnable implements Runnable{ //1
	public static int a, x, y, b, c, d, e, f;
	public int operacion;
	
	public ExercicioExameRunnable(int operacion){ //2
		this.operacion = operacion;
		} //2
		
	public static void main (String[] args){ //3
	
	Scanner teclado = new Scanner(System.in);
	
	System.out.print("Introduza o valor de x: ");
	x = teclado.nextInt();
	System.out.print("Introduza o valor de y: ");
	y = teclado.nextInt();
	
	ExercicioExameRunnable o1 = new ExercicioExameRunnable(1);
	ExercicioExameRunnable o2 = new ExercicioExameRunnable(2);
	ExercicioExameRunnable o3 = new ExercicioExameRunnable(3);
	
	Thread f1 = new Thread(o1);
	Thread f2 = new Thread(o2);
	Thread f3 = new Thread(o3);
	
	f1.start();
	f2.start();
	f3.start();
	
	try{
		f1.join();
		f2.join();
		f3.join();
	}catch(InterruptedException e){}
	
	ExercicioExameRunnable o4 = new ExercicioExameRunnable(4);
	ExercicioExameRunnable o5 = new ExercicioExameRunnable(5);
	
	Thread f4 = new Thread(o4);
	Thread f5 = new Thread(o5);
	
	f4.start();
	f5.start();
	
	try{
		f4.join();
		f5.join();
	}catch(InterruptedException e){}
	
	f = d - e;
	System.out.println("O valor de f é: " + f);
	
	} //3
	
	@Override
	public void run(){ //4
		switch(operacion){ // 5
			case 1:
				a = x + y;
				System.out.println("O valor de a é: " + a);
				break;
			case 2:
				b = x - y;
				System.out.println("O valor de b é: " + b);
				break;
			case 3:
				c = x * y;
				System.out.println("O valor de c é: " + c);
				break;
			case 4:
				d = a + b + c;
				System.out.println("O valor de d é: " + d);
				break;
			case 5:
				e = a * b * c;
				System.out.println("O valor de e é: " + e);
		} // 5
	} // 4
} // 1
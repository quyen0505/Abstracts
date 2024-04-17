package advance.dev;


	import java.util.Scanner;

	// Abstract class Shape
	abstract class Shape {
	    abstract double chuVi();
	    abstract double dienTich();
		protected abstract void print(Shape[] shapes);
	}

	// Interface IShape
	interface IShape {
	    void input(Shape[] shapes);
	    void print(Shape[] shapes);
	}

	// Class Triangle (Tam giác)
	class Triangle extends Shape implements IShape {
	    double a, b, c;

	    Triangle(double a, double b, double c) {
	        this.a = a;
	        this.b = b;
	        this.c = c;
	    }

	    @Override
	    double chuVi() {
	        return a + b + c;
	    }

	    @Override
	    double dienTich() {
	        double p = chuVi() / 2;
	        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	    }

	    @Override
	    public void input(Shape[] shapes) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Nhập độ dài các cạnh của tam giác (a, b, c):");
	        double a = scanner.nextDouble();
	        double b = scanner.nextDouble();
	        double c = scanner.nextDouble();
	        shapes[0] = new Triangle(a, b, c);
	    }

	    @Override
	    public void print(Shape[] shapes) {
	        System.out.println("Tam giác:");
	        System.out.println("Cạnh a: " + a);
	        System.out.println("Cạnh b: " + b);
	        System.out.println("Cạnh c: " + c);
	        System.out.println("Chu vi:" + chuVi());
	        System.out.println("Diện Tích " + dienTich());
	    }
	}

	// Class Circle (Hình tròn)
	class Circle extends Shape implements IShape {
	    double radius;

	    Circle(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    double chuVi() {
	        return 2 * Math.PI * radius;
	    }

	    @Override
	    double dienTich() {
	        return Math.PI * radius * radius;
	    }

	    @Override
	    public void input(Shape[] shapes) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Nhập bán kính hình tròn:");
	        double radius = scanner.nextDouble();
	        shapes[0] = new Circle(radius);
	    }

	    @Override
	    public void print(Shape[] shapes) {
	        System.out.println("Vòng tròn"+ "");
	        System.out.println("Bán kính"+ " " + radius);
	        System.out.println("Chu vi: " + chuVi());
	        System.out.println("Diện tích: " + dienTich());
	    }
	}

	// Class Rectangle (Hình chữ nhật)
	class Rectangle extends Shape implements IShape {
	    double width, height;

	    Rectangle(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }

	    @Override
	    double chuVi() {
	        return 2 * (width + height);
	    }

	    @Override
	    double dienTich() {
	        return width * height;
	    }

	    @Override
	    public void input(Shape[] shapes) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Nhập chiều rộng và chiều cao của hình chữ nhật:");
	        double width = scanner.nextDouble();
	        double height = scanner.nextDouble();
	        shapes[0] = new Rectangle(width, height);
	    }

	    @Override
	    public void print(Shape[] shapes) {
	        System.out.println("Hình chữ nhật :");
	        System.out.println("Chiều rộng: " + width);
	        System.out.println("CHiều Cao: " + height);
	        System.out.println("Chu vi: " + chuVi());
	        System.out.println("Diện tích: " + dienTich());
	    }
	}

	// Class MainApp
	public class MainApp {
	    public static void main(String[] args) {
	        Shape[] shapes = new Shape[10];
	        MainApp app = new MainApp();
	        app.input(shapes);
	        app.print(shapes);
	    }

	    public void input(Shape[] shapes) {
	        Scanner scanner = new Scanner(System.in);
	        for (int i = 0; i < shapes.length; i++) {
	            System.out.println("Nhập loại hình dạng (1. Tam giác, 2. Hình tròn, 3. Hình chữ nhật):");
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    shapes[i] = new Triangle(3, 4, 5); // For simplicity, hardcoded values for triangle
	                    break;
	                case 2:
	                    System.out.println("Nhập bán kính hình tròn:");
	                    double radius = scanner.nextDouble();
	                    shapes[i] = new Circle(radius);
	                    break;
	                case 3:
	                    System.out.println("Nhập chiều rộng và chiều cao của hình chữ nhật:");
	                    double width = scanner.nextDouble();
	                    double height = scanner.nextDouble();
	                    shapes[i] = new Rectangle(width, height);
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại :");
	                    i--; // Repeat loop for invalid choice
	                    break;
	            }
	        }
	    }

	    public void print(Shape[] shapes) {
	        System.out.println("Shapes:");
	        for (Shape shape : shapes) {
	            if (shape != null) {
	                shape.print(shapes);
	            }
	        }
	    }

}

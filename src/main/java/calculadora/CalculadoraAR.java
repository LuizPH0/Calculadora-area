 package calculadora;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Poligono {
    String categoria;
    double lado;

    public Poligono(String categoria, double lado) {
        this.categoria = categoria;
        this.lado = lado;
    }

    public double calcularArea() {
        if (categoria.equals("Triângulo")) {
            return (lado * lado * Math.sqrt(3)) / 4;
        } else if (categoria.equals("Quadrado")) {
            return lado * lado;
        }
        return 0;
    }
}

public class CalculadoraAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Poligono> poligonos = new ArrayList<>();
        
        //aperte 0 e pressione enter para finalizar a operação e mostrar o resultado.
        while (true) {
            System.out.print("Informe o número de lados (3 para triângulo, 4 para quadrado, 0 para finalizar): ");
            int numLados = scanner.nextInt();
            if (numLados == 0) {
                break;
            }

            String categoria = numLados == 3 ? "Triângulo" : numLados == 4 ? "Quadrado" : "Desconhecido";
            if (!categoria.equals("Desconhecido")) {
                System.out.print("Informe o tamanho do lado (em cm): ");
                double lado = scanner.nextDouble();
                poligonos.add(new Poligono(categoria, lado));
            } else {
                System.out.println("Número de lados não suportado. Por favor repita a ação.");
            }
        }

        System.out.println("Áreas dos polígonos:");
        double areaTotal = 0;
        for (Poligono poligono : poligonos) {
            double area = poligono.calcularArea();
            System.out.println(poligono.categoria + " de lado " + poligono.lado + " cm e área " + String.format("%.2f", area) + " cm²");
            areaTotal += area;
        }

        System.out.println("Área total " + String.format("%.2f", areaTotal) + " cm²");
    }
}


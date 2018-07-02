package java8.demo;

public class DemoLambda {


    static class Addition implements Operation {

        @Override
        public double calcul(double nb1, double nb2) {
            return nb1 + nb2;
        }
    }

    interface Operation {
        double calcul(double nb1, double nb2);
        default double calcul2(double nb1, double nb2) {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        double nb1 = 10;
        double nb2 = 20;
        Addition addition = new Addition();

        Operation soustractionV0 = new Operation() {
            @Override
            public double calcul(double nb1, double nb2) {
                return nb1 - nb2;
            }
        };

        Operation soustractionV1 = (double a, double b) -> {
                return a - b;
        };

        Operation soustractionV2 = (a, b) -> {
            return a - b;
        };

        Operation soustractionV3 = (a, b) -> a - b;

        afficher(nb1, nb2, soustractionV3);

        // V4
        afficher(nb1, nb2, (a, b) -> a - b);
    }

    private static void afficher(double nb1, double nb2, Operation operation) {
        double resultat = operation.calcul(nb1, nb2);
        System.out.println(resultat);
    }


}

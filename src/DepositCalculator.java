import java.util.Scanner;

public class DepositCalculator  {

    double calculateComplexPercent(double amount, double rate, int period) {
        double pay = amount * Math.pow((1 + rate / 12), 12 * period);
        return doRounding(pay,2);
    }

    double calculateSimplePercent(double amount, double rate, int period) {
        return doRounding(amount+amount * rate * period,2);
    }

    double doRounding(double value, int places) {
        double ScaLe= Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateDeposit() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double result = 0;
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
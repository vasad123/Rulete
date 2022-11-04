import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    public static int credit = 2000;

    public static void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dnes si tady budem dělat točky točky:");
        System.out.println("Základ rulety tvoří otáčivé zařízení, které se skládá ze dvou soustředných kol." +
                " Větší z nich je nehybné, menší se otáčí a je rozděleno na 37 pro hru potřebujete hrací předpis hry najdete si na netu "
        );
        System.out.println("pokud chcete začít hru napište 1 pokud ne 0:");
        int y = sc.nextInt();
        if (y == 0) {
            System.out.println("konec hry");
        } else if (y > 1) {
            while (y != 0 || y != 1) {
                System.out.println("nezadal jste správné číslo zkuste znova");
                y = sc.nextInt();
            }

        }


    }

    public static int bet() {


        System.out.println("zadejte častku kterou chcete vsadit");
        int bet = sc.nextInt();

        while (bet > credit) {
            System.out.println("Nemáte dostatek peněz");
            bet = sc.nextInt();
        }

        return bet;

    }

    public static int number() {
        int max = 38;
        int min = 0;
        int z = min + (int) (Math.random() * (max - min));

        return z;
    }

    public static void intro() {
        System.out.println("zadejte číslo pro druh sázky: 1 pro sázku přes barvy (výhra 1x sázky na červenou a černou, )");
        System.out.println("zadejte číslo pro druh sázky: 2 pro sázku jestli je číslo liché čí sudé (výhra 1x sázky)");
        System.out.println("zadejte číslo pro druh sázky: 3 pro sázku malé(1-18) čí velké(19-38) (výhra 2x sázky)");
        System.out.println("zadejte číslo pro druh sázky: 4 pro sázku sázka na jedno číslo (výhra 36x sázky)");
        System.out.println("zadejte číslo pro druh sázky: 5 pro sázku dělitelnost čísel 3, 3 se zbytkem 2, 3 se zbytkem 1 (výhra 2x sázky)  ");
        System.out.println("zadejte číslo pro druh sázky: 6 pro sázku čísla jestli je v rozmezí 1-12,13-24,25-36(výhra 2x sázky)");
    }

    public static void kindOfQuess() {
        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt();
        int money = bet();
        int num = number();
        boolean checkNumber = false;

        //select(a)

        switch (a) {
            case 1:
                System.out.println("pro červenou vložte 1, černou 2 ");
                int colors = sc.nextInt();


                System.out.println("vaše číslo je " + num);
                int[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
                int[] black = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 35};

                if (colors == 1) {
                    for (int i = 0; i < red.length; i++) {
                        if (red[i] == num) {
                            checkNumber = true;

                        }
                    }
                    if (checkNumber) {
                        credit = credit + money;
                        System.out.println("Gratulujeme vyhrál jste  " + money + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (colors == 2) {


                    for (int i = 0; i < black.length; i++) {
                        if (black[i] == num) {
                            checkNumber = true;
                        }

                    }
                    if (checkNumber) {
                        credit = credit + money;
                        System.out.println("Gratulujeme vyhrál jste  " + money + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;

            case 2:
                System.out.println("sudá 1 , lichá 2 ");
                int oddOrEven = sc.nextInt();
                System.out.println("vaše číslo je " + num);


                if (oddOrEven == 1) {

                    if (num % 2 == 0) {
                        checkNumber = true;

                    }

                    if (checkNumber) {
                        credit = credit + money;
                        System.out.println("Gratulujeme vyhrál jste  " + money + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (oddOrEven == 2) {


                    if (oddOrEven % 2 == 1) {
                        checkNumber = true;
                    }


                    if (checkNumber) {
                        credit = credit + money;
                        System.out.println("Gratulujeme vyhrál jste  " + money + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;
            case 3:
                System.out.println("pro číslo od 1-18 1, a pro 19-36 2");
                int bigOrSmall = sc.nextInt();
                System.out.println("vaše číslo je " + num);


                if (bigOrSmall == 1) {

                    if (num > 1 && num < 18) {
                        checkNumber = true;

                    }

                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (bigOrSmall == 2) {


                    if (num > 19 && num < 38) {
                        checkNumber = true;
                    }


                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;
            case 4:
                System.out.println("zadejte číslo od 0-38");
                int number = sc.nextInt();
                System.out.println("vaše číslo je " + num);


                if (number > 1 && number <= 38) {

                    if (number == num) {
                        checkNumber = true;

                    }

                    if (checkNumber) {
                        credit = credit + 36 * money;
                        System.out.println("Gratulujeme vyhrál jste  " + money*36 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;
            case 5:
                System.out.println("pro ano 1 pro ne 2");
                int divideByThree = sc.nextInt();
                System.out.println("vaše číslo je " + num);
                if (divideByThree == 1) {

                    if (num % 3 == 0) {
                        checkNumber = true;

                    }

                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (divideByThree == 2) {
                    System.out.println("bye bye");
                    return;

                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;
            case 6:
                System.out.println("pro rozmezí 1-12 (1),13-24 (2),25-36 (3)");
                int threeTwelves = sc.nextInt();
                System.out.println("vaše číslo je " + num);


                if (threeTwelves == 1) {

                    if (num > 1 && num < 12) {
                        checkNumber = true;

                    }

                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (threeTwelves == 2) {


                    if (num > 13 && num <= 24) {
                        checkNumber = true;
                    }


                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else if (threeTwelves == 3) {


                    if (num > 25 && num <= 36) {
                        checkNumber = true;
                    }


                    if (checkNumber) {
                        credit = credit + (2 * money);
                        System.out.println("Gratulujeme vyhrál jste  " + money*2 + " na učte máte " + credit);
                    } else {
                        credit = credit - money;
                        System.out.println("prohrál jste máte " + credit);
                    }
                } else {
                    System.out.println("nezadal jste správné číslo");
                    return;
                }


                break;

            default:
                System.out.println("nezadal jste správné čísla");
                a = sc.nextInt();


                break;
        }


    }

    public static void main(String[] args) {
        start();
      while(credit!=0) {


            intro();
            kindOfQuess();
          System.out.println("máte "+credit);
        }


    }
}

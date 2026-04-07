class Hillstations {
    void famousfood() {
        System.out.println("Hillstations have local traditional food.");
    }
    void famousfor() {
        System.out.println("Hillstations are famous for scenic beauty.");
    }
}
class Manali extends Hillstations {
    void famousfood() {
        System.out.println("Manali is famous for Siddu and Trout fish.");
    }
    void famousfor() {
        System.out.println("Manali is famous for snow and adventure sports.");
    }
}
class Ooty extends Hillstations {
    void famousfood() {
        System.out.println("Ooty is famous for chocolates and tea.");
    }
    void famousfor() {
        System.out.println("Ooty is famous for tea gardens.");
    }
}
class Darjeeling extends Hillstations {
    void famousfood() {
        System.out.println("Darjeeling is famous for momos and tea.");
    }
    void famousfor() {
        System.out.println("Darjeeling is famous for Kanchenjunga view.");
    }
}

public class Main {
    public static void main(String[] args) {
        Hillstations h;
        h = new Manali();
        h.famousfood();
        h.famousfor();
        System.out.println();
        h = new Ooty();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Darjeeling();
        h.famousfood();
        h.famousfor();
    }
}

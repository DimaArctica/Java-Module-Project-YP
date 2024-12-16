public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nПривет! Добро пожаловать в приложение 24часа ЛеМан! \n");
        Race myRace = new Race();
        myRace.addCars();
        myRace.calculateRaceLeader(myRace.carArrayList);
        myRace.printLeaders();
        System.out.println("\nСпасибо что были с нами! До новых встреч!");
    }
}

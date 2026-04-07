public class AmongUsGame {
    public static void main(String[] args) {

        Crew brian, cindy, david;
        Impostor jacky;

        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Impostor("Jacky");

        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();

        jacky.kill(cindy);

        cindy.callMeeting();
        david.callMeeting();

        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);

    }

    public static void check(ICrew crew) {
        if (AmongUsGame.isImpostor(crew))
            System.out.println(crew.getName() + " is the impostor!");
        else System.out.println(crew.getName() + " is not the impostor.");
    }

    public static boolean isImpostor(ICrew crew) {
        return (crew instanceof Impostor);
    }
}

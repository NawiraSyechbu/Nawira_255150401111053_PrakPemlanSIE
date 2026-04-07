public class Crew implements ICrew {

    private String name;
    private boolean isAlive = true;

    public Crew(String name) {
        this.name = name;
    }

    @Override
    public void doWork() {
        if (isAlive) {
            System.out.println("Crew " + this.name + " is doing work.");
        } else {
            System.out.println("Crew " + this.name + " is dead and cannot work.");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick(ICrew crew){
        System.out.println(crew +" has been kicked out of the spaceship!");
    }

    public void callMeeting() {
        if (isAlive) {
            System.out.print(this.name + " found a corpse ");
            System.out.print("and calls a meeting. ");
            System.out.println("Let's find the impostor!");
        } else {
            System.out.println(this.name + " is dead and cannot call a meeting.");
        }
    }

    public void die() {
        this.isAlive = false;
    }
}

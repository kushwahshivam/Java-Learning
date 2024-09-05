public class ContructorOverloading {
    private String name;
    private int id;

    // no-args constructor
    public ContructorOverloading() {
            this.name = "Default Name";
        }

    // one parameter constructor
    public ContructorOverloading(String n) {
            this.name = n;
        }

    // two parameter constructor
    public ContructorOverloading(String n, int i) {
            this.name = n;
            this.id = i;
        }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Name=" + name;
    }

    public static void main(String[] args) {
        ContructorOverloading d = new ContructorOverloading();
        System.out.println(d);

        d = new ContructorOverloading("Java");
        System.out.println(d);

        d = new ContructorOverloading("Hardik", 25);
        System.out.println(d);

    }
}

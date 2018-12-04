public class Main {
    public static void main(String[] args) {
        int num=0;
        Yablonya antonovka = new Yablonya();
        num = antonovka.number(num);
        antonovka.age(12);
        antonovka.fruiting(210);

        Vishnya holmovaya = new Vishnya();
        num = holmovaya.number(num);
        holmovaya.age(8);
        holmovaya.fruiting(389);

        Grusha dushes = new Grusha();
        num = dushes.number(num);
        dushes.age(16);
        dushes.fruiting(112);
    }
}
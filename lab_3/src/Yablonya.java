public class Yablonya extends SadovoeDerevo {
    public Yablonya(){}

    int number(int num){
        num++;
        System.out.println("Дерево - " + num);
        return num;
    }

    void age(int a){
        System.out.println("Возраст яблони - " + a);
    }

    void fruiting(int f){
        System.out.println("Плодоношение яблони - " + f);
    }

}

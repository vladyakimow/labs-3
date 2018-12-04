public class Grusha extends SadovoeDerevo  {
    public Grusha(){}

    int number(int num){
        num++;
        System.out.println("Дерево - " + num);
        return num;
    }

    void age(int a){
        System.out.println("Возраст груши - " + a);
    }

    void fruiting(int f){
        System.out.println("Плодоношение груши - " + f);
    }

}

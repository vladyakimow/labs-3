public class Vishnya extends SadovoeDerevo  {
    public Vishnya(){}

    int number(int num){
        num++;
        System.out.println("Дерево - " + num);
        return num;
    }

    void age(int a){
        System.out.println("Возраст вишни - " + a);
    }

    void fruiting(int f){
        System.out.println("Плодоношение вишни - " + f);
    }

}

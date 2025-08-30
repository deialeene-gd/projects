public class Pokemon {
    String name;
    int level;
    

    Pokemon(){
        level = 1;
    }

    Pokemon(String name, int level){
        this.name = name;
        this.level = level;
    }

    void attack(){
        System.out.print(name + " attack!");
    }
}
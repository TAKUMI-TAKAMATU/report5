package jp.ac.uryukyu.ie.e175744;

public class Enemy extends LivingThing {

    String name = super.getNames();
    int hitPoint =super.getHitPoint();
    int attack =super.getAttack();
    boolean dead =super.getDead();

    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    @Override
    public  void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            super.setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }


}

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
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        int critical = (int) (Math.random() * 9 + 1);
        if (isDead() == false) {
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", name, opponent.getName());
            } else if (critical < 4) {
                damage += damage;
                System.out.printf("%sの攻撃！痛恨の一撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            } else {
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
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

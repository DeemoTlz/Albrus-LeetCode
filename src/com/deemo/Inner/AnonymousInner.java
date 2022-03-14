package com.deemo.Inner;

public class AnonymousInner {
    String gameClass = "三男一狗";

    public void print(final String gameMethodParam, final GTA gtaMethodParam) {
        final String gameMethod = "三男一狗";
        final GTA gtaMethod = new GTA();
        String games = "三男一狗";

        Super superMan = new Super() {
            @Override
            public void game(String games, GTA gta) {
                System.out.println("外部类 调用方法的形参：" + gameMethodParam);
                System.out.println("外部类 成员变量：" + AnonymousInner.this.gameClass);
                gtaMethodParam.play();
                gtaMethodParam.setName("给他爱5");

                System.out.println("==========================");

                System.out.println("外部类 方法成员变量：" + gameMethod);
                System.out.println("外部类 方法成员变量：" + gtaMethod);

                System.out.println("==========================");

                System.out.println("匿名内部类 方法参数：" + games);
                // 修改形参，对实参没有影响
                games = "给他爱5";
                // 将形参指向新对象时，会中断对实参的引用
                // gta = new GTA();
                // 通过引用地址修改，会同步修改
                gta.setName("GTA 5");

                System.out.println("==========================");

            }

            @Override
            public void save() {

            }

            @Override
            public void shopping() {

            }

            @Override
            public void work() {

            }

            @Override
            public void walk() {

            }
        };
        superMan.game(games, gtaMethod);
        int aa = superMan.a;
    }

    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner();

        GTA gta = new GTA();
        anonymousInner.print("三男一狗", gta);
        gta.play();
    }
}

class GTA {
    private String name = "三男一狗";

    public void play() {
        System.out.println("Play " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Animal {
    void walk();
}

interface Person extends Animal {
    void work();
}

interface Man extends Person {
    void game(String games, GTA gta);
}

interface Woman extends Person {
    void shopping();
}

interface Super extends Man, Woman {
    public final int a = 1;
    void save();
}

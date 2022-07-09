package com.cleo.ocp819;

public  class Test extends SecondTestExtended{




    public void log(String message){
        count++;
        System.out.println(message + " count="+count);
    }

    public static void main(String[] args) {

       SecondTestExtended test = new Test();
       SecondTestExtended test1 = new TestExtended();
       test1.log("Hi there cutie");
        System.out.println(test.getClass());
        test.log("Hi");
        test.log("Hi1","Hi2");
    }


}

class TestExtended extends SecondTestExtended{

    @Override
    public void log(String message) {
        count++;
        System.out.println("Overridden times " + message + " count=" + count);
    }
}

class SecondTestExtended {
    public static int count = 0;

    public void log(String message){
        System.out.println("Count with message=" + count + "\n" + message);
    }



    public final void log(String message1, String message2){
        count++;
        System.out.println("Final message in last overridden class " + message1 + " I am not feeling well?" + message2 + " count="+count);
    }
}
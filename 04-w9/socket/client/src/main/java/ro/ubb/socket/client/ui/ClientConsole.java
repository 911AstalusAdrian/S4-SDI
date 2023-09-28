package ro.ubb.socket.client.ui;

import ro.ubb.socket.common.HelloService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ClientConsole {
    private HelloService helloService;

    public ClientConsole(HelloService helloService) {
        this.helloService = helloService;
    }

    public void runConsole() {
        //todo: implement a menu or cmd based ui

        String name = "Ana";
        Future<String> resultFuture = helloService.sayHello(name); //non-blocking

        /*
        .....
         */

        try {
            String result = resultFuture.get(); //blocking :(((
            System.out.println("***************");
            System.out.println(result);
            System.out.println("***************");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        resultFuture = helloService.sayGoodbye(name); //non-blocking

        /*
        .....
         */

        try {
            String result = resultFuture.get(); //blocking :(((
            System.out.println("***************");
            System.out.println(result);
            System.out.println("***************");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}

package Validator;

import py4j.GatewayServer;

public class App {
    public static void main(String[] args) {
        System.out.println("PY4J gateway server is being started");
        GatewayServer gatewayServer = new GatewayServer(new SyntaxValidator(), 25335);
        gatewayServer.start();
        System.out.println("PY4J gateway server was started");
    }
}
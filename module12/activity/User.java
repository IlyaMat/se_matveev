package sef.module12.activity;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class User {

    private String name;
    private BufferedReader reader;
    private PrintWriter writer;
    private Scanner scanner = new Scanner(System.in);
    private Socket clientSocket;



    public static void main(String[] args) throws Exception{
        User us = new User();
        us.go();
    }

    public User(String name, InputStream stream) {
        //this.reader = new InputStreamReader(stream);
        reader = new BufferedReader(new InputStreamReader(stream));
        this.name = name;
    }


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private void setNetworking(){
        try{
            clientSocket = new Socket("localhost",9930 );
            InputStreamReader streamReader = new InputStreamReader(clientSocket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(clientSocket.getOutputStream());
            System.out.println("networking established");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void go() throws Exception {
        setNetworking();
        Thread readerThread = new Thread(new User.InReader());
        readerThread.start();

        while (true) {
           printMessages();
        }
    }
    public void printMessages(){
        System.out.println("\033[34;1mМожете писать в любое время: \033[39;49m");
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("exit")) {
            try {
                reader.close();
                writer.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }
        }
        writer.println(s);
        writer.flush();
    }


   /* public void printMessages(){
        System.out.println("Можете писать в любое время: ");
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("exit")) {
            try {
                reader.close();
                writer.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.exit(0);
            }
        }
        writer.println(s);
        writer.flush();
    }*/

    public class InReader implements Runnable{
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null){
                        //сообщение клиенту
                    System.out.println( message);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

}

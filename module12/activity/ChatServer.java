package sef.module12.activity;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ChatServer {
    ServerSocket server=null;
    Socket client = null;
    PrintWriter out=null;
    boolean endless=true;
    Scanner scanner = new Scanner(System.in);
    private ArrayList clientOutput;



    public class ClientHandler implements Runnable{
        Socket clientSocket;
        BufferedReader reader;
        PrintWriter writer;
        private User user;

        public ClientHandler(Socket client, User user) {
            try{
                clientSocket = client;
                this.user = user;
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream());
            }catch (IOException e){
                e.printStackTrace();
            }
        }//считываем
        @Override
        public void run() {
            try {
                String mes;
                while ((mes = reader.readLine()) != null) {
                    if(mes.equalsIgnoreCase("exit")){
                        break;
                    }
                    //и выводим на сервер
                    System.out.println("for server from user*** : "+user.getName() +": "+ mes);
                    //рассылаем всем клиентам
                    sendToAllClients(mes, user);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void sendToAllClients(String mes, User user) {
        Iterator iterator = clientOutput.iterator();
        while(iterator.hasNext()){
            try{
                PrintWriter writer = (PrintWriter) iterator.next();
                writer.println("for client from user*** " + user.getName() +": "+mes);
                writer.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void go() {
        clientOutput = new ArrayList();
        try {
            server = new ServerSocket(9930);

            System.out.println("ServerSocket created at ");
            System.out.println("Waiting for connection");
            int i = 0;
            while (endless) {
                client = server.accept();
                User user = new User("user_" + i++);

                Thread thread = new Thread(new ClientHandler(client,user));
                thread.start();

                out = new PrintWriter(client.getOutputStream(), true);
                clientOutput.add(out);
                out.println("You have reached server " + client.getInetAddress() + " Have a nice day!");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();

                if (client != null)
                    client.close();

                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ChatServer().go();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluísio
 */
public class ChatServidor {

    private ArrayList<PrintWriter> escritores = new ArrayList<>();

    public ChatServidor() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                new Thread(new EscutaCliente(socket)).start();
                PrintWriter p = new PrintWriter(socket.getOutputStream());
                escritores.add(p);
            }
        } catch (IOException e) {
        }
    }

    private void encaminharParaTodos(String texto) {
        for (PrintWriter w : escritores) {
            try {
                w.println(texto);
                w.flush();
            } catch (Exception e) {

            }
        }
    }

    private class EscutaCliente implements Runnable {

        Scanner leitor;

        public EscutaCliente(Socket socket) {
            try {
                leitor = new Scanner(socket.getInputStream());
            } catch (Exception e) {

            }
        }

        @Override
        public void run() {
            try {
                String texto;
                while ((texto = leitor.nextLine()) != null) {
                    System.out.println("->" + texto);
                    encaminharParaTodos(texto);
                }
            } catch (Exception x) {
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new ChatServidor();

    }

}

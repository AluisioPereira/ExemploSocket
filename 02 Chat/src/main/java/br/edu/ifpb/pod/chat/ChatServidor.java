/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Aluísio
 */
public class ChatServidor {

    public ChatServidor() {
        ServerSocket server;
        Scanner leitor;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket s = server.accept();
                leitor = new Scanner(s.getInputStream());
                System.out.println(leitor.nextLine());
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServidor();

    }

}

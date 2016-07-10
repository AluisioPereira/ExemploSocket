/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.paradigmaclienteservidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aluísio
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket socket = server.accept();
            try (PrintWriter w = new PrintWriter(socket.getOutputStream())) {
                w.printf("Aprender java é show de bola!");
            }
        }

    }
}

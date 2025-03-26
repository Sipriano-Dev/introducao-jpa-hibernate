package com.sipriano.aulajpa;

import com.sipriano.aulajpa.dominio.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "Carlos da Silva", "Carlos@gmail.com");
        Pessoa p2 = new Pessoa(1, "Joaquim Silva", "Joaquim@gmail.com");
        Pessoa p3 = new Pessoa(1, "Ana Maria SAntos", "Maria@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
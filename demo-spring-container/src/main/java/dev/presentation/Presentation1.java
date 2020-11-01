package dev.presentation;

import dev.metier.IMetier;

import java.util.Scanner;

public class Presentation1 {

    private IMetier metier;

    private Scanner scanner;

    public Presentation1(IMetier metier, Scanner scanner) {
        this.metier = metier;
        this.scanner = scanner;
    }

    public void print() {
        System.out.println("Bonjour ");
        System.out.println("Saisie : ");
        String saisie = scanner.next();
        System.out.println("P - " + metier.get() + " " + saisie);
    }
}

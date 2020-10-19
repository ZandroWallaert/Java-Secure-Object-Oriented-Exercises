package be.howest.ti.design.patterns.factory.grass;

import be.howest.ti.design.patterns.general.grass.ILawnMower;

import java.util.Scanner;

public class CreateLawnMower {

    public static void main(String[] args) {
        LawnMowerFactory lawnMowerFactory =  LawnMowerFactory.factory(new Scanner(System.in).nextLine());

        ILawnMower lawnMower = lawnMowerFactory.create();

        lawnMower.mowTheGrass();
        System.out.println(lawnMower.getClass().getCanonicalName());
    }

}

package com.audient._1603;

public class FirstSolution {

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));


    }


    static class ParkingSystem {

        private int big;
        private int medium;
        private int small;


        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (this.big < 1) {
                    return false;
                } else {
                    this.big -= 1;
                    return true;
                }
            } else if (carType == 2) {
                if (this.medium < 1) {
                    return false;
                } else {
                    this.medium -= 1;
                    return true;
                }
            } else if (carType == 3) {
                if (this.small < 1) {
                    return false;
                } else {
                    this.small -= 1;
                    return true;
                }
            } else {
                return false;
            }
        }



    }


}

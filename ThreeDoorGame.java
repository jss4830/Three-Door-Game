/*
 * Name: Jesse Goldman
 * Date: 2/14/2022
 * Course Number: CSC-212-D01
 * Course Name: Java 2
 * Problem Number: Monty Hall
 * Email: Jgoldman2001@student.stcc.edu
 * Short Description of the Problem : Three Door Game Class
 */

public class ThreeDoorGame {

    private int prizeDoor;
    private int contestantDoor;
    private int hostDoor;

    private int remainingClosedDoor;

    public static final int DOOR1 = 1;
    public static final int DOOR2 = 2;
    public static final int DOOR3 = 3;

    public ThreeDoorGame(int contestantDoor, int switchDecision) {

    }

    public void placePrize() {
        this.prizeDoor = generateRandomDoor();
    }

    public void pickContestantDoor(int contestantDoor) {
        if (contestantDoor < 1 || contestantDoor > 3) {
            this.contestantDoor = generateRandomDoor();
        }
        else this.contestantDoor = contestantDoor;
    }

    public void montyRevealZonk() {
        switch (prizeDoor) {
            case DOOR1 -> {
                if (contestantDoor == DOOR2) {
                    hostDoor = DOOR3;
                    remainingClosedDoor = DOOR1;
                } else if (contestantDoor == DOOR3) {
                    hostDoor = DOOR2;
                    remainingClosedDoor = DOOR1;
                } else {
                    hostDoor = pickBetweenTwoDoors(DOOR2, DOOR3);
                    if (hostDoor == DOOR2)
                        remainingClosedDoor = DOOR3;
                    else remainingClosedDoor = DOOR2;
                }
            }
            case DOOR2 -> {
                if (contestantDoor == DOOR1){
                    hostDoor = DOOR3;
                    remainingClosedDoor = DOOR2;
                }
                else if (contestantDoor == DOOR3){
                    hostDoor = DOOR1;
                    remainingClosedDoor = DOOR2;
                }
                else{
                    hostDoor = pickBetweenTwoDoors(DOOR1, DOOR3);
                    if(hostDoor == DOOR1)
                        remainingClosedDoor = DOOR3;
                    else remainingClosedDoor = DOOR1;
                }
            }
            case DOOR3 -> {
                if (contestantDoor == DOOR1){
                    hostDoor = DOOR2;
                    remainingClosedDoor = DOOR3;
                }
                else if (contestantDoor == DOOR2){
                    hostDoor = DOOR1;
                    remainingClosedDoor = DOOR3;
                }
                else {
                    hostDoor = pickBetweenTwoDoors(DOOR2, DOOR1);
                    if (hostDoor == DOOR1)
                        remainingClosedDoor = DOOR2;
                    else remainingClosedDoor = DOOR1;
                }
            }
        }
    }

    public void switchDoor() {
        contestantDoor = remainingClosedDoor;
    }

    public int pickBetweenTwoDoors(int d1, int d2) {
        if (Math.random() > 0.5)
            return d1;
        return d2;
    }

    public int generateRandomDoor() {
        return (int) (3 * Math.random() + 1);
    }

    public int getPrizeDoor() {
        return prizeDoor;
    }

    public int getContestantDoor() {
        return contestantDoor;
    }

    public int getHostDoor() {
        return hostDoor;
    }

}

package org.firstinspires.ftc.teamcode;

public class RobotProcesses extends Auto{
    private RobotMove robotMove;
    private RobotArm robotArm;

    public RobotProcesses(RobotMove robotMove, RobotArm robotArm) {
        this.robotMove = robotMove;
        this.robotArm = robotArm;
    }

    public void moveRobotTime(double x, double y, double seconds) {

        long totalTime = (long) (1000 * seconds);
        long startTime = System.currentTimeMillis();
        boolean finished = false;

        while (!finished) {
            robotMove.robotCentricMovement(x, y, 0, 0);
            finished = (System.currentTimeMillis() - startTime >= totalTime);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // Handle the interruption (e.g., log it or throw a new exception)
                robotMove.robotCentricMovement(0, 0, 0, 0);
            }
        }
    }

    public void turnToOrientation(double targetAngle, double duration) {
        long totalTime = (long) (1000 * duration);
        long startTime = System.currentTimeMillis();
        boolean finished = false;

        robotMove.autoCorrectOrientation.firstAngle = (float)robotMove.angleToRange(targetAngle);

        while (!finished) {
            // auto correct orientation to 90 degrees left facing board
            robotMove.robotCentricMovement(0, 0, 0, 0);
            finished = (System.currentTimeMillis() - startTime >= totalTime);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // Handle the interruption (e.g., log it or throw a new exception)
            }
        }
    }

    public void setArmDown() {
        robotArm.motorArmLeft.setTargetPosition(-162);
        robotArm.motorArmRight.setTargetPosition(-90);

    }

    public void setArmBoard() {
        robotArm.motorArmLeft.setTargetPosition(-85);
        robotArm.motorArmRight.setTargetPosition(-13);
    }

    public void pickUpPixel() {
        // make sure arm is in down position first
        setArmDown();
    }

}

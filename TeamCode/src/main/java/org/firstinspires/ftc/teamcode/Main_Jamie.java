/*import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.ControllerInputHandler;
import org.firstinspires.ftc.teamcode.MotorRun;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Main", group = "TeleOp")
public class Main extends OpMode {

    private ControllerInputHandler controllerInput;
    private DcMotor coreHexMotor;
    private MotorRun coreHexMotorClass;
    private DcMotor hdHexMotor;
    private MotorRun hdHexMotorClass;


    @Override
    public void init() {
        /*controllerInput = new ControllerInputHandler(gamepad1);
        coreHexMotorClass = new MotorRun(coreHexMotor, 0, "forward"); // power, direction
        coreHexMotor = hardwareMap.get(DcMotor.class, "coreHexMotor");
        coreHexMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        hdHexMotorClass = new MotorRun(hdHexMotor, 0, "forward");
        hdHexMotor = hardwareMap.get(DcMotor.class, "left");
        hdHexMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        hdHexMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    @Override
    public void loop() {
        boolean isButtonAPressed = controllerInput.isButtonPressed('a');
        boolean isButtonBPressed = controllerInput.isButtonPressed('b');
        boolean isButtonXPressed = controllerInput.isButtonPressed('x');
        boolean isButtonYPressed = controllerInput.isButtonPressed('y');

        //coreHexMotor.setPower(isButtonAPressed ? 0.5 : 0);
        hdHexMotor.setPower(isButtonBPressed ? 0.5 : 0);

        telemetry.addData("Button A Pressed ", false); // a pressed
        telemetry.addData("Button B Pressed ", false); // b pressed
        telemetry.update();
    }
}
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Main_Jamie", group = "TeleOp")
public class Main_Jamie extends OpMode {
    private ControllerInputHandler controllerInput;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor hdHexMotor;

    double speed = 1.0;


    @Override
    public void init() {
        controllerInput = new ControllerInputHandler(gamepad1);
        /*
        coreHexMotorClass = new MotorRun(coreHexMotor, 0, "forward"); // power, direction
        coreHexMotor = hardwareMap.get(DcMotor.class, "coreHexMotor");
        coreHexMotor.setDirection(DcMotorSimple.Direction.FORWARD);*/

        leftMotor = hardwareMap.get(DcMotor.class, "left");
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor = hardwareMap.get(DcMotor.class, "right");
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
        boolean isButtonAPressed = controllerInput.isButtonPressed('a');
        boolean isButtonBPressed = controllerInput.isButtonPressed('b');
        boolean isButtonXPressed = controllerInput.isButtonPressed('x');
        boolean isButtonYPressed = controllerInput.isButtonPressed('y');
        float leftStickX = controllerInput.getLeftStickX();
        float leftStickY = controllerInput.getLeftStickY();

        //boolean leftBumper = controllerInput.leftBumper();
        //boolean rightBumper = controllerInput.rightBumper();
        if(isButtonAPressed){
            if(speed == 1) speed = 0.5;
            else speed = 1;
        }


        //coreHexMotor.setPower(isButtonAPressed ? 0.5 : 0);
        //
        if(leftStickY > 0) {
            if(leftStickX > 0){
                rightMotor.setPower(speed * -leftStickX);
                leftMotor.setPower(speed);
            }
            else if(leftStickX < 0){
                rightMotor.setPower(speed);
                leftMotor.setPower(speed * -leftStickX);
            }
            else{
                rightMotor.setPower(speed);
                leftMotor.setPower(speed);
            }
        }
        else if(leftStickY < 0) {
            if(leftStickX > 0){
                rightMotor.setPower(-speed * -leftStickX);
                leftMotor.setPower(-speed);
            }
            else if(leftStickX < 0){
                rightMotor.setPower(-speed);
                leftMotor.setPower(-speed * -leftStickX);
            }
            else{
                rightMotor.setPower(-speed);
                leftMotor.setPower(-speed);
            }
        }
        else{
            rightMotor.setPower(0);
            leftMotor.setPower(0);
        }
        telemetry.addData("Left stick has X value:\t", leftStickX);
        telemetry.addData("Left stick has Y value:\t", leftStickY);
        telemetry.addData("Button A Pressed ", false); // a pressed
        telemetry.addData("Button B Pressed ", false); // b pressed
        telemetry.update();
    }
}
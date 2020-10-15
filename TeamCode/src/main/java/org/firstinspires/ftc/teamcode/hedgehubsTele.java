package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name ="hedgehubs holonomic test", group ="LinearOpmode")
public class hedgehubsTele extends LinearOpMode {
private ElapsedTime runtime = new ElapsedTime();
private DcMotor leftFdrive = null;
private DcMotor leftBdrive = null;
private DcMotor rightFdrive = null;
private DcMotor rightBdrive = null;
    @Override
    public void runOpMode(){

        leftFdrive = hardwareMap.get(DcMotor.class, "leftFdrive");
        leftBdrive = hardwareMap.get(DcMotor.class, "leftBdrive");
        rightFdrive = hardwareMap.get(DcMotor.class, "rightFdrive");
        rightBdrive = hardwareMap.get(DcMotor.class, "rightBdrive");

        leftFdrive.setDirection(DcMotor.Direction.FORWARD);
        leftBdrive.setDirection(DcMotor.Direction.FORWARD);
        rightFdrive.setDirection(DcMotor.Direction.REVERSE);
        rightBdrive.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
        runtime.reset();

        while(opModeIsActive()){
            double leftPower;
            double rightPower;


            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive-turn, -1.0, 1.0);


            leftFdrive.setPower(leftPower);
            leftBdrive.setPower(leftPower);
            rightFdrive.setPower(rightPower);
            rightBdrive.setPower(rightPower);

            if(gamepad1.left_bumper){
                scuttleLeft();
                // aisjhauiodghasyduioadgha
            }

            if(gamepad1.right_bumper){
                scuttleRight();
            }
        }

    }
    public void scuttleRight(){
        leftFdrive.setPower(0.8);
        leftBdrive.setPower(-0.8);
        rightFdrive.setPower(-0.8);
        rightBdrive.setPower(0.8);
    }
    public void scuttleLeft(){
        leftFdrive.setPower(-0.8);
        leftBdrive.setPower(0.8);
        rightFdrive.setPower(0.8);
        rightBdrive.setPower(-0.8);
    }
}

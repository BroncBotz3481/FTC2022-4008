package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="Duck_Park_Blue", group="4008")

public class Duck_Park_Blue extends LinearOpMode {
    Team4008HMNew robot = new Team4008HMNew();
    ElapsedTime Time = new ElapsedTime();
    double multy = 0.3;
    // variable for wheel diameter
    // variable for ticks/rev
    // variable for timeout
    // TELEMETRY EXAMPLE: telemetry.addData("Say", "TeleOp Starting");
    //        telemetry.update();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();
        double distance = 3.5;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        robot.DuckRight.setPower(-0.5);
        sleep(3500);
        robot.DuckRight.setPower(0);
        sleep(750);

        distance = 3.5;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        distance = 21;
        multy = 1;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(1000);
        robot.DriveRightFront.setPower(-0.5);
        robot.DriveLeftFront.setPower(-0.5);
        robot.DriveRightBack.setPower(-0.5);
        robot.DriveLeftBack.setPower(-0.5);
        sleep(100);

        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        sleep(750);

        //variable for target distance
        // set motor mode to RESET_ENCODERS
        //  EXAMPLE: robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // set mode to RUN USING ENCODER
        //  EXAMPLE: robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Calculate ticks needed
        // reset & start timer
        // set power to motors
        //robot.DriveLeftBack.setPower(0.5); // Runs until set to a different power
        //robot.DriveRightBack.setPower(0.5);
        // while loop: while encodervalue < target && time < timeout
        // telemetry current encoder value
        // stop robot
        // sleep for at least 500
        // reset encoder
    }
}
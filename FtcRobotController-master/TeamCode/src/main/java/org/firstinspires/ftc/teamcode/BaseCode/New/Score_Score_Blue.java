package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="!Score_Score_Blue", group="4008")

public class Score_Score_Blue extends LinearOpMode {
    Team4008HMNew robot = new Team4008HMNew();
    ElapsedTime Time = new ElapsedTime();
    double multy = 0.4;

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();

        //Strafe out from wall
        double distance = 40;
        multy = 0.5;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 2500 && robot.DriveRightFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        //Scoring Level 3
        robot.Intake.setPower(-0.15);
        sleep(1000);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Intake.setPower(-0.3);
        tick = 1300;
        while (opModeIsActive() && Time.milliseconds() < 8000 && robot.Intake.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
            telemetry.update();
        }
        robot.Intake.setPower(-0.02);
        robot.IntakeWheel.setPower(0.5);
        sleep(1000);
        robot.IntakeWheel.setPower(0);
        robot.Intake.setPower(0);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(500);

        //Turning Around
        distance = 15;
        multy = 0.3;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
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

        //Strafing to wall
        distance = 36;
        multy = 1;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Intake Down
        robot.Intake.setPower(0.2);
        sleep(1000);
        robot.Intake.setPower(0);
        sleep(500);

       /* //Drive Straight
        distance = 35;
        multy = 0.8;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        robot.IntakeWheel.setPower(-0.7);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.IntakeWheel.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        robot.IntakeWheel.setPower(-1);
        sleep(2000);
        robot.IntakeWheel.setPower(0);
        if (robot.Touch.isPressed()){
            telemetry.addData("Touch", robot.Touch.isPressed());
            telemetry.update();}*/
        //drive back
        /*distance = 10;
        multy = 0.8;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.IntakeWheel.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        //Strafe to wall
        distance = 10;
        multy = 1;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(multy);
        while (opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //drive back
        distance = 25;
        multy = 0.8;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.IntakeWheel.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        //Strafing from wall
        distance = 45;
        multy = 0.5;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Turning Around
        distance = 40;
        multy = 0.3;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
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

        //Scoring Level 3
        robot.Intake.setPower(-0.15);
        sleep(1000);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Intake.setPower(-0.3);
        tick = 1300;
        while (opModeIsActive() && Time.milliseconds() < 8000 && robot.Intake.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
            telemetry.update();
        }
        robot.Intake.setPower(-0.02);
        robot.IntakeWheel.setPower(0.5);
        sleep(1000);
        robot.IntakeWheel.setPower(0);
        robot.Intake.setPower(0);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(500);

        //Strafing to park
        distance = 20;
        multy = 0.8;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Drive Straight
        distance = 24;
        multy = 1;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.IntakeWheel.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);*/


    }
}
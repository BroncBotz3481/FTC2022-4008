package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto_6976_Red", group="6976")

public class Auto_6976_Red_Old extends LinearOpMode {
    hardware6976 robot = new hardware6976();

    double multy = 0.95;

    @Override
    public void runOpMode() {
        robot.assign(hardwareMap);

        waitForStart();
        robot.DriveLeft.setPower(0.5);
        robot.DriveRight.setPower(0.5);
        sleep(700);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.DriveLeft.setPower(0.5);
        robot.DriveRight.setPower(-0.5);
        sleep(600);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.Duck.setPower(1);
        sleep(4000);
        robot.Duck.setPower(0);

        robot.DriveLeft.setPower(-0.7);
        robot.DriveRight.setPower(-0.7);
        sleep(300);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.DriveRight.setPower(-0.85);
        robot.DriveLeft.setPower(0.85);
        sleep(600);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.DriveLeft.setPower(-0.7);
        robot.DriveRight.setPower(-0.7);
        sleep(825);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
    }
}


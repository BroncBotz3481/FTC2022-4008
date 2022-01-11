package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto_6976_Blue", group="6976")

public class Auto_6976_Blue_Old extends LinearOpMode {
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

        robot.Duck.setPower(-1);
        sleep(4000);
        robot.Duck.setPower(0);

        robot.DriveLeft.setPower(0.8);
        robot.DriveRight.setPower(-0.8);
        sleep(400);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.DriveLeft.setPower(-0.5);
        robot.DriveRight.setPower(-0.4);
        sleep(1500);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.DriveLeft.setPower(0.5);
        robot.DriveRight.setPower(0.5);
        sleep(800);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
    }
}


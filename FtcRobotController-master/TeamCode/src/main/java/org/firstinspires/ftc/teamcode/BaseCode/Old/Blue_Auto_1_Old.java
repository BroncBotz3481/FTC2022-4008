package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Blue_Auto_1", group="4008")

public class Blue_Auto_1_Old extends LinearOpMode {
    HardwareMap4008 robot = new HardwareMap4008();

    double multy = 0.95;

    @Override
    public void runOpMode() {
        robot.assign(hardwareMap);

        waitForStart();
        robot.DriveLeft.setPower(-0.5);
        robot.DriveLeftFront.setPower(-0.5);
        robot.DriveRight.setPower(-0.5);
        robot.DriveRightFront.setPower(-0.5);
        sleep(700);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DuckRight.setPower(-1);
        sleep(3500);
        robot.DuckRight.setPower(0);

        robot.DriveLeft.setPower(0.5);
        robot.DriveLeftFront.setPower(0.5);
        robot.DriveRight.setPower(0.5);
        robot.DriveRightFront.setPower(0.5);
        sleep(600);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(-0.25);
        robot.DriveLeftFront.setPower(-0.25);
        robot.DriveRight.setPower(0.25);
        robot.DriveRightFront.setPower(0.25);
        sleep(750);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(0.35);
        robot.DriveLeftFront.setPower(0.35);
        robot.DriveRight.setPower(0.75);
        robot.DriveRightFront.setPower(0.75);
        sleep(600);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(0.75);
        robot.DriveLeftFront.setPower(0.75);
        robot.DriveRight.setPower(0.75);
        robot.DriveRightFront.setPower(0.75);
        sleep(2000);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(1);
        robot.DriveLeftFront.setPower(1);
        robot.DriveRight.setPower(1);
        robot.DriveRightFront.setPower(1);
        sleep(2500);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
    }
}
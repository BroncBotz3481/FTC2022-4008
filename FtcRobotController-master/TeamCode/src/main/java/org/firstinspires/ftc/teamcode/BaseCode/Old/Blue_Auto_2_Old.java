package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Blue_Auto_2", group="4008")

public class Blue_Auto_2_Old extends LinearOpMode {
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

        robot.DriveLeft.setPower(0.8);
        robot.DriveLeftFront.setPower(0.8);
        robot.DriveRight.setPower(-0.8);
        robot.DriveRightFront.setPower(-0.8);
        sleep(400);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(-0.5);
        robot.DriveLeftFront.setPower(-0.5);
        robot.DriveRight.setPower(-0.4);
        robot.DriveRightFront.setPower(-0.4);
        sleep(1500);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.IntakeWheel.setPower(-1);
        sleep(1000);
        robot.IntakeWheel.setPower(0);

        robot.DriveLeft.setPower(-0.5);
        robot.DriveLeftFront.setPower(-0.5);
        robot.DriveRight.setPower(-0.5);
        robot.DriveRightFront.setPower(-0.5);
        sleep(100);
        robot.DriveLeft.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);

        robot.DriveLeft.setPower(0.5);
        robot.DriveLeftFront.setPower(0.5);
        robot.DriveRight.setPower(0.5);
        robot.DriveRightFront.setPower(0.5);
        sleep(100);
        robot.DriveLeft.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
    }
}
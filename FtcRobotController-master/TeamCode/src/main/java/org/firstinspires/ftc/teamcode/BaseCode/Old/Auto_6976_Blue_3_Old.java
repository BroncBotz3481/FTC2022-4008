package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Auto_6976_Blue_3_Old", group="6976")

public class Auto_6976_Blue_3_Old extends LinearOpMode {
    hardware6976 robot = new hardware6976();

    double multy = 0.95;

    @Override
    public void runOpMode() {
        robot.assign(hardwareMap);

        waitForStart();
        robot.DriveLeft.setPower(-0.7);
        robot.DriveRight.setPower(-0.7);
        sleep(2000);

        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
    }
}

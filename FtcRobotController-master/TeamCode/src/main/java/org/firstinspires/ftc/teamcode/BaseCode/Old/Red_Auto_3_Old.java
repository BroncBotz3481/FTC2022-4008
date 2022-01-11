package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="RedAuto3", group="6976")

public class Red_Auto_3_Old extends LinearOpMode{
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

        robot.DriveLeft.setPower(0.5);
        robot.DriveLeftFront.setPower(0.5);
        robot.DriveRight.setPower(-0.5);
        robot.DriveRightFront.setPower(-0.5);
        sleep(900);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);

        robot.DriveLeft.setPower(-1);
        robot.DriveLeftFront.setPower(-1);
        robot.DriveRight.setPower(-1);
        robot.DriveRightFront.setPower(-1);
        sleep(2000);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
    }
}

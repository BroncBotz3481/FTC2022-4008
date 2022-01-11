package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="driveSpin_TIME", group="6976")
public class AutoDuck extends LinearOpMode
{
    hardware6976 robot           = new hardware6976();

    double multy = 0.95;

    @Override
    public void runOpMode()
    {
        robot.assign(hardwareMap);

        waitForStart();
        robot.DriveLeft.setPower(-0.5);
        robot.DriveRight.setPower(-0.5);
        sleep(1000);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);

        robot.Duck.setPower(-1);
        sleep(1000);
        robot.Duck.setPower(0);
    }
}

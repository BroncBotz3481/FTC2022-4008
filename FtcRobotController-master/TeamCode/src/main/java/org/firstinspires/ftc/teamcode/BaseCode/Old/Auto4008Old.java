package org.firstinspires.ftc.teamcode.BaseCode.Old;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="driveStraight_!TIME!", group="4008")
@Disabled
public class Auto4008Old extends LinearOpMode
{
    HardwareMap4008 robot           = new HardwareMap4008();

    double multy = 0.95;

    @Override
    public void runOpMode()
    {
        robot.assign(hardwareMap);

        waitForStart();
        robot.DriveLeft.setPower(1);
        robot.DriveRight.setPower(1);
        sleep(5000);
        robot.DriveLeft.setPower(1);
        robot.DriveRight.setPower(1);
    }
}

package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp6976", group="6976")

public class teleop6976 extends LinearOpMode
{
    hardware6976 HardwareMap = new hardware6976();

    @Override
    public void runOpMode()
    {
        HardwareMap.assign(hardwareMap);

        waitForStart();
        double powerConstant = 1.0;
        double duckSpinnerA = 0;


        while(opModeIsActive())
        {
            HardwareMap.DriveLeft.setPower(gamepad1.left_stick_y * powerConstant);
            HardwareMap.DriveRight.setPower(gamepad1.right_stick_y * powerConstant);

            HardwareMap.Intake.setPower(gamepad2.right_stick_y*0.45);
            HardwareMap.Elevator.setPower(gamepad2.right_trigger - gamepad2.left_trigger);
            HardwareMap.Duck.setPower(gamepad2.left_stick_x);
        }
    }
}

package org.firstinspires.ftc.teamcode.BaseCode.New;


import android.renderscript.ScriptGroup;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.RoboVision;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialInput;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialMotor;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.PIDF;

@TeleOp(name="Team_6976_TeleOp_New", group="6976")

public class Team_6976_TeleOp_New extends LinearOpMode
{
    Team_6976_HM_New robot   = new Team_6976_HM_New();


    @Override
    public void runOpMode()
    {
        robot.Map(hardwareMap);
        telemetry.addData("Say", "TeleOp Starting");
        telemetry.update();

        waitForStart();

        robot.period.reset();

        while (opModeIsActive())
        {
            robot.DriveLeft.setPower(gamepad1.left_stick_y);
            robot.DriveRight.setPower((gamepad1.right_stick_y));
            robot.Intake.setPower(-gamepad2.left_stick_y);

            if(gamepad2.a){
                robot.IntakeWheel.setPower(.75);
            }
            else if(gamepad2.y) {
                robot.IntakeWheel.setPower(-.75);
            }
            else {
                robot.IntakeWheel.setPower(0);
            }

            if (gamepad2.x)  {
                robot.DuckLeft.setPower(-.65);
            }
            else {
                robot.DuckLeft.setPower(0);
            }
            if (gamepad2.b) {
                robot.DuckRight.setPower(.65);
            }
            else {
                robot.DuckRight.setPower(0);
            }
        }
    }
}

package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="Scoring_Level1", group="4008")

public class Scoring_Level1 extends LinearOpMode{
    Team4008HMNew robot = new Team4008HMNew();
    ElapsedTime Time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();

        //Scoring Level 1
        robot.Intake.setPower(0.05);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Intake.setPower(0.3);
        double tick = 400;
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
            telemetry.update();
        }
        robot.Intake.setPower(0.05);
        robot.IntakeWheel.setPower(0.5);
        sleep(1000);
        robot.IntakeWheel.setPower(0);
        robot.Intake.setPower(0);
        robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(500);
    }
}
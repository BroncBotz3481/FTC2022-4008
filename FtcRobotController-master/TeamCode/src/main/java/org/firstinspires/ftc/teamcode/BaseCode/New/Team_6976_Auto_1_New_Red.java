package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="Team_6976_Auto_1_New_Red", group="6976")

public class Team_6976_Auto_1_New_Red extends LinearOpMode {
    Team_6976_HM_New robot = new Team_6976_HM_New();
    ElapsedTime Time = new ElapsedTime();
    double multy = 0.3;
    // variable for wheel diameter
    // variable for ticks/rev
    // variable for timeout
    // TELEMETRY EXAMPLE: telemetry.addData("Say", "TeleOp Starting");
    //        telemetry.update();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();
        double distance = 3.5;
        robot.DriveLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRight.setPower(0.2);
        robot.DriveLeft.setPower(0.2);
        while (opModeIsActive() && Time.milliseconds() < 500 && robot.DriveLeft.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeft.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRight.setPower(0);
        robot.DriveLeft.setPower(0);
        robot.DriveLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(750);

        robot.DuckLeft.setPower(-0.4);
        sleep(5000);
        robot.DuckLeft.setPower(0);
        sleep(750);

        distance = 3.5;

        multy = 1;
        robot.DriveLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRight.setPower(0.8);
        robot.DriveLeft.setPower(-0.8);
        while (opModeIsActive() && Time.milliseconds() < 300 && robot.DriveLeft.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveLeft.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRight.setPower(0);
        robot.DriveLeft.setPower(0);
        robot.DriveLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        distance = 10;

        sleep(1000);
        robot.DriveRight.setPower(0.5);
        robot.DriveLeft.setPower(0.5);
        sleep(850);
        robot.DriveRight.setPower(0);
        robot.DriveLeft.setPower(0);
        sleep(2000);
    }
}
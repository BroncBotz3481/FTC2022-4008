package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="Warehouse_Auto_6976", group="6976")

public class Warehouse_Auto_6976 extends LinearOpMode{
    Team_6976_HM_New robot = new Team_6976_HM_New();
    ElapsedTime Time = new ElapsedTime();
    double multy = -0.30;
    // variable for wheel diameter
    // variable for ticks/rev
    // variable for timeout
    // TELEMETRY EXAMPLE: telemetry.addData("Say", "TeleOp Starting");
    //        telemetry.update();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();
        int distance = 36;
        robot.DriveRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRight.setPower(multy);
        robot.DriveLeft.setPower(multy);
        robot.DriveRight.setPower(multy);
        robot.DriveLeft.setPower(multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveRight.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRight.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRight.setPower(0);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setPower(0);
        robot.DriveLeft.setPower(0);
        robot.DriveRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // variable for target distance
        // set motor mode to RESET_ENCODERS
        //  EXAMPLE: robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // set mode to RUN USING ENCODER
        //  EXAMPLE: robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Calculate ticks needed
        // reset & start timer
        // set power to motors
        //robot.DriveLeftBack.setPower(0.5); // Runs until set to a different power
        //robot.DriveRightBack.setPower(0.5);
        // while loop: while encodervalue < target && time < timeout
        // telemetry current encoder value
        // stop robot
        // sleep for at least 500
        // reset encoder
    }
}

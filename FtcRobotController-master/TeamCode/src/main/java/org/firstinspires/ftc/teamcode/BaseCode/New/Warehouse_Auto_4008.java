package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
//import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;

@Autonomous(name="Warehouse_Auto_4008", group="4008")

public class Warehouse_Auto_4008 extends LinearOpMode {
    Team4008HMNew robot = new Team4008HMNew();
    ElapsedTime Time = new ElapsedTime();
    double multy = -0.3;
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
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveRightFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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

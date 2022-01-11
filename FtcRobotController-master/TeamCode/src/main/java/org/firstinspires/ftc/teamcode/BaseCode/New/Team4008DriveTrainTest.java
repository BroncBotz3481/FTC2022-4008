package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BaseCode.New.Team4008HMNew;
//import org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables;

@TeleOp(name="Team4008DriveTrainTest", group="4008")
public class Team4008DriveTrainTest extends LinearOpMode
{
    Team4008DriveTrainTestHM robot  = new Team4008DriveTrainTestHM();

    @Override
    public void runOpMode()
    {
        robot.Map(hardwareMap);

        double pow = .5;
        waitForStart();

        while (opModeIsActive())
        {
            robot.DriveLeftFront.setPower(gamepad1.left_stick_y);
            robot.DriveLeftBack.setPower(gamepad1.left_stick_y);
            robot.DriveRightFront.setPower(gamepad1.right_stick_y);
            robot.DriveRightBack.setPower(gamepad1.right_stick_y);
//            if(gamepad1.x){
//                robot.DriveLeftFront.setPower(gamepad1.right_bumper ? pow * -1 : pow);
//            }
//            else{
//                robot.DriveLeftFront.setPower(0);
//            }
//
//            if(gamepad1.y){
//                robot.DriveRightFront.setPower(gamepad1.right_bumper ? pow * -1 : pow);
//            }
//            else{
//                robot.DriveRightFront.setPower(0);
//            }
//
//            if(gamepad1.a){
//                robot.DriveLeftBack.setPower(gamepad1.right_bumper ? pow * -1 : pow);
//            }
//            else{
//                robot.DriveLeftBack.setPower(0);
//            }
//
//            if(gamepad1.b){
//                robot.DriveRightBack.setPower(gamepad1.right_bumper ? pow * -1 : pow);
//            }
//            else{
//                robot.DriveRightBack.setPower(0);
//            }
        }
    }
}
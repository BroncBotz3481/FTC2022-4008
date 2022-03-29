package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="!CV_Test", group="4008")
public class AutoVisionCV extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ZoneChooser chooser = new ZoneChooser(hardwareMap, telemetry);
        waitForStart();
        Target target = chooser.getTarget();
        chooser.stop();
//        switch(target) {
//            case A:
              /*  telemetry.addData("Target Status", "A");
                //Scoring Level 1
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                double tick = 400;
                while(opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
                    telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
                    telemetry.update();
                }
                robot.Intake.setPower(-0.02);
                robot.IntakeWheel.setPower(0.5);
                sleep(1000);
                robot.IntakeWheel.setPower(0);
                robot.Intake.setPower(0);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                sleep(500);
                break;

            case B:
                telemetry.addData("Target Status", "B");
                //Scoring Level 2
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                double tick = 750;
                while(opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
                    telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
                    telemetry.update();
                }
                robot.Intake.setPower(-0.02);
                robot.IntakeWheel.setPower(0.5);
                sleep(1000);
                robot.IntakeWheel.setPower(0);
                robot.Intake.setPower(0);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                sleep(500);
                break;
            case C:
                telemetry.addData("Target Status","C");
                //Scoring Level 3
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.RESET_ENCODERS);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                double tick = 1300;
                while(opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
                    telemetry.addData("Encoder Val", robot.Intake.getCurrentPosition());
                    telemetry.update();
                }
                robot.Intake.setPower(-0.02);
                robot.IntakeWheel.setPower(0.5);
                sleep(1000);
                robot.IntakeWheel.setPower(0);
                robot.Intake.setPower(0);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                sleep(500);
                break;*/
//        }
        telemetry.update();
    }
}

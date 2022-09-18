package org.firstinspires.ftc.teamcode.BaseCode.New;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.Old.HardwareMap4008;
import org.firstinspires.ftc.teamcode.CapperDetector;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name="!StrafeScoreBLUE_DuckPark2_Vision", group="4008")

public class StrafeScoreBLUE_DuckPark2_Vision extends LinearOpMode{
        Team4008HMNew robot = new Team4008HMNew();
        OpenCvCamera phoneCam;
        ElapsedTime Time = new ElapsedTime();
        double multy = 0.4;

        @Override
        public void runOpMode() throws InterruptedException {
            robot.Map(hardwareMap);
//        int cameraMonitorViewId = hardwareMap.appContext
//                .getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        phoneCam = OpenCvCameraFactory.getInstance()
//                .createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
            int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            phoneCam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
            CapperDetector capperDetector = new CapperDetector(telemetry);
            phoneCam.setPipeline(capperDetector);
            phoneCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
            {
                @Override
                public void onOpened()
                {
                    /*
                     * Tell the camera to start streaming images to us! Note that you must make sure
                     * the resolution you specify is supported by the camera. If it is not, an exception
                     * will be thrown.
                     *
                     * Also, we specify the rotation that the camera is used in. This is so that the image
                     * from the camera sensor can be rotated such that it is always displayed with the image upright.
                     * For a front facing camera, rotation is defined assuming the user is looking at the screen.
                     * For a rear facing camera or a webcam, rotation is defined assuming the camera is facing
                     * away from the user.
                     */
                    phoneCam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
                }

                @Override
                public void onError(int errorCode)
                {
                    /*
                     * This will be called if the camera could not be opened
                     */
                }
            });

        waitForStart();
        robot.Map(hardwareMap);
        CapperDetector.Location detectedLocation = capperDetector.getLocation();
        sleep(6000);

        //Strafe out from wall
        double distance = 10;
        multy = 0.5;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() < tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Forward to Aliance Hub
        distance = 15;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        // Turning
        distance = 20;
        multy = 0.3;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        //Slow Forward to Hub
        distance = 10;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        switch (detectedLocation) { //depending on location, appropriate auto will run
            case LEFT:
                // score low
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                tick = 400;
                while (opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
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
            case CENTER:
                // score mid
                //Scoring Level 2
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                tick = 750;
                while (opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
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
            case RIGHT:
                // score high
                //Scoring Level 3
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.RESET_ENCODERS);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                tick = 1300;
                while (opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
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
            case NOT_FOUND:
                // score high
                robot.Intake.setPower(-0.15);
                sleep(1000);
                robot.Intake.setMode(DcMotor.RunMode.RESET_ENCODERS);
                robot.Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                robot.Intake.setPower(-0.3);
                tick = 1300;
                while (opModeIsActive() && Time.milliseconds() < 4000 && robot.Intake.getCurrentPosition() > -tick) {
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
        }


        //Turning Right
        distance = 20;
        multy = 0.3;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        //Intake Down
        robot.Intake.setPower(0.2);
        sleep(500);
        robot.Intake.setPower(0);
        sleep(500);

        //Drive Straight
        distance = 45;
        multy = 0.5;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        //Strafe Left to Duck Spinner
        distance = 6;
        multy = -0.6;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Forwards Right Side To Align
        distance = 5;
        multy = 0.6;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7) / (4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        while (opModeIsActive() && Time.milliseconds() < 4000 && robot.DriveRightFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        //Strafe Left to Duck Spinner SLOW
        distance = 8;
        multy = -0.1;
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(-multy);
        robot.DriveLeftFront.setPower(multy);
        robot.DriveRightBack.setPower(multy);
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sleep(100);

        //Duck Spinner
        robot.DuckRight.setPower(-0.5);
        sleep(3500);
        robot.DuckRight.setPower(0);
        sleep(750);

        //Strafe Right to park
        distance = 23;
        multy = -0.5;
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tick = (distance * 537.7)/(4 * Math.PI);
        Time.reset();
        robot.DriveRightFront.setPower(multy);
        robot.DriveLeftFront.setPower(-multy);
        robot.DriveRightBack.setPower(-multy);
        robot.DriveLeftBack.setPower(multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() > -tick) {
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition());
            telemetry.update();
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(100);
        robot.DriveRightFront.setPower(-0.5);
        robot.DriveLeftFront.setPower(-0.5);
        robot.DriveRightBack.setPower(-0.5);
        robot.DriveLeftBack.setPower(-0.5);
        sleep(300);

        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        sleep(100);
    }
}
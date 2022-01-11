package org.firstinspires.ftc.teamcode.BaseCode;

//We can use this for strafing in Auto
//The distance for encoders forward and back should act the same for strafing

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.BaseFunctions.*;

public class MecanumDrive {

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftRear;
    private DcMotor rightRear;
    private SpecialMotor TrackingMotorLF;
    private SpecialMotor TrackingMotorLR;
    private SpecialMotor TrackingMotorRR;
    private SpecialMotor TrackingMotorRF;

    /*Constructor*/
    //MAKE IT
    public MecanumDrive(DcMotor FLeft, DcMotor FRight, DcMotor BLeft, DcMotor BRight){
        leftFront = FLeft;
        rightFront = FRight;
        leftRear = BLeft;
        rightRear =  BRight;

        TrackingMotorLR = new SpecialMotor(leftRear);
        TrackingMotorRR = new SpecialMotor(rightRear);
        TrackingMotorRF = new SpecialMotor(rightFront);
        TrackingMotorLF = new SpecialMotor(leftFront);
    }

    //USE IT
    public void NonDynamicControl(float forwardAndBack, float LeftAndRight, float Turn) { //Only goes in x OR y directions, cannot go diagnal
        if (Math.abs(forwardAndBack) >= Math.abs(LeftAndRight))
        {
            Drive(-forwardAndBack, 0, Turn);
        }
        else if(Math.abs(forwardAndBack) < Math.abs(LeftAndRight)) {
            Drive(0, LeftAndRight, Turn);
        }
        else {
            Drive(0, 0, Turn);
        }
    }

    //FIND AND FIX IT
    public void NonDynamicControl(float right, float Left) { //Tank Drive
        leftFront.setPower(Left);
        rightFront.setPower(right);
        leftRear.setPower(Left);
        rightRear.setPower(right);
    }


    //FIND AND USE IT
    public void Drive(float forwardAndBack, float LeftAndRight, float Turn){ //can be used in teleop for full x-y control
        double r = Math.hypot(Turn, forwardAndBack);
        double robotAngle = Math.atan2(forwardAndBack, Turn) - Math.PI / 4;
        double rightX = LeftAndRight;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        leftFront.setPower(v1);
        rightFront.setPower(v2);
        leftRear.setPower(v3);
        rightRear.setPower(v4);
    }

    //RUN IT
    public void DriveAuto(double forwardAndBack, double LeftAndRight, double Turn, double Distance){ //goes to exact values

        forwardAndBack *= -1;
        LeftAndRight *= -1;
        Turn *= -1;


        double r = Math.hypot(LeftAndRight, forwardAndBack);
        double robotAngle = Math.atan2(forwardAndBack, LeftAndRight) - Math.PI / 4;
        double rightX = Turn;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        TrackingMotorRR.Activate();
        TrackingMotorLR.Activate();
        TrackingMotorRF.Activate();
        TrackingMotorLF.Activate();

        if(Distance == 0){
            int x = 0;
            while(x < 1000){
                x++;
            }
        }
        else {
            while (!(TrackingMotorRR.IsComplete() && TrackingMotorLR.IsComplete() && TrackingMotorRF.IsComplete() && TrackingMotorLF.IsComplete())) {
                TrackingMotorRR.RunAndReset(GetSign(v4) * Distance, v4);
                TrackingMotorLR.RunAndReset(GetSign(v3) * Distance, v3);
                TrackingMotorRF.RunAndReset(GetSign(v2) * Distance, v2);
                TrackingMotorLF.RunAndReset(GetSign(v1) * Distance, v1);
            }
        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

    }

    //IN IT
    public void DriveAuto(double forwardAndBack, double LeftAndRight, double Turn, double Distance, int Tolerance){ //Uses the tolerance in special Motor

        forwardAndBack *= -1;
        LeftAndRight *= -1;
        Turn *= -1;


        double r = Math.hypot(LeftAndRight, forwardAndBack);
        double robotAngle = Math.atan2(forwardAndBack, LeftAndRight) - Math.PI / 4;
        double rightX = Turn;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        TrackingMotorRR.Activate();
        TrackingMotorLR.Activate();
        TrackingMotorRF.Activate();
        TrackingMotorLF.Activate();

        if(Distance == 0){
            int x = 0;
            while(x < 1000){
                x++;
            }
        }
        else {
            while (!(TrackingMotorRR.IsComplete() && TrackingMotorLR.IsComplete() && TrackingMotorRF.IsComplete() && TrackingMotorLF.IsComplete())) {
                TrackingMotorRR.RunAndReset(GetSign(v4) * Distance, v4, Tolerance);
                TrackingMotorLR.RunAndReset(GetSign(v3) * Distance, v3, Tolerance);
                TrackingMotorRF.RunAndReset(GetSign(v2) * Distance, v2, Tolerance);
                TrackingMotorLF.RunAndReset(GetSign(v1) * Distance, v1, Tolerance);
            }
        }
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

    }

}
//TECHNOLOGIC
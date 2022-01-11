package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BaseCode.SpecialInput;

import static java.lang.Thread.sleep;

public class HardwareMap4008
{
    public DcMotor DriveLeft;
    public DcMotor DriveRight;
    public DcMotor DriveLeftFront;
    public DcMotor DriveRightFront;
    public DcMotor DuckLeft;
    public DcMotor DuckRight;
    public DcMotor Intake;
    public DcMotor IntakeWheel;
    public SpecialInput ButtonA;
    public SpecialInput ButtonB;

    HardwareMap hwMap = null;

    public HardwareMap4008() {}

    public void assign (HardwareMap Map)
    {
        ButtonA = new SpecialInput();
        ButtonB = new SpecialInput();

        hwMap = Map;
        DriveLeft = hwMap.get(DcMotor.class, "DriveLeft");
        DriveRight = hwMap.get(DcMotor.class, "DriveRight");
        DriveLeftFront = hwMap.get(DcMotor.class, "DriveLeftFront");
        DriveRightFront = hwMap.get(DcMotor.class, "DriveRightFront");
        DuckLeft = hwMap.get(DcMotor.class, "DuckLeft");
        DuckRight = hwMap.get(DcMotor.class, "DuckRight");
        Intake = hwMap.get(DcMotor.class, "Intake");
        IntakeWheel = hwMap.get(DcMotor.class, "IntakeWheel");

        DriveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveLeftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        DuckLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        DriveRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        DuckRight.setDirection(DcMotorSimple.Direction.REVERSE);
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);

        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
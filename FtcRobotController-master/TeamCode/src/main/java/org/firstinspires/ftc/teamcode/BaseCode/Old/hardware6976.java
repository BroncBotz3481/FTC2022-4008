package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialInput;

import static java.lang.Thread.sleep;

public class hardware6976
{
    public DcMotor DriveLeft;
    public DcMotor DriveRight;
    public DcMotor Duck;
    public DcMotor Intake;
    public DcMotor Elevator;

    HardwareMap hwMap = null;

    MecanumDrive DriveTrain;

    public hardware6976() {}

    public void assign (HardwareMap Map)
    {

        hwMap = Map;
        DriveLeft = hwMap.get(DcMotor.class, "DriveLeft");
        DriveRight = hwMap.get(DcMotor.class, "DriveRight");
        Duck = hwMap.get(DcMotor.class, "DuckLeft");
        Intake = hwMap.get(DcMotor.class, "Intake");
        Elevator = hwMap.get(DcMotor.class, "IntakeWheel");

        DriveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        DriveRight.setDirection(DcMotorSimple.Direction.REVERSE);
        Elevator.setDirection(DcMotorSimple.Direction.REVERSE);
        Intake.setDirection(DcMotorSimple.Direction.REVERSE);

        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
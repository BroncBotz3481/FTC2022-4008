package org.firstinspires.ftc.teamcode.BaseCode.New;

import android.graphics.Path;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.BaseCode.MecanumDrive;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialInput;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialMotor;

import static java.lang.Thread.sleep;

public class Team_6976_HM_New {

    public DcMotor DriveLeft = null;
    public DcMotor DriveRight = null;

    public DcMotor Intake = null;
    public DcMotor IntakeWheel = null;
    public DcMotor DuckLeft = null;
    public DcMotor DuckRight = null;

    HardwareMap hwMap   = null;
    public ElapsedTime period = new ElapsedTime();

    public Team_6976_HM_New()  {}

    public void Map(HardwareMap newhwMap)
    {
        hwMap = newhwMap;
        DriveLeft = hwMap.get(DcMotor.class, "DriveLeft");
        DriveRight = hwMap.get(DcMotor.class, "DriveRight");

        DriveLeft.setDirection(DcMotor.Direction.REVERSE);
        DriveLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DriveRight.setDirection(DcMotor.Direction.FORWARD);
        DriveRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Intake = hwMap.get(DcMotor.class, "Intake");
        IntakeWheel = hwMap.get(DcMotor.class, "IntakeWheel");
        //IntakeWheel.setDirection(DcMotor.Direction.REVERSE);

        DuckLeft = hwMap.get(DcMotor.class,"DuckLeft");
        DuckRight = hwMap.get(DcMotor.class, "DuckRight");

    }
}

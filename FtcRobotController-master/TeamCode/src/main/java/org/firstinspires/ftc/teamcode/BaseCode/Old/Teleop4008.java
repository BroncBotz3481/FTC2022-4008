package org.firstinspires.ftc.teamcode.BaseCode.Old;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp4008", group="4008")

public class Teleop4008 extends LinearOpMode
{
    HardwareMap4008 HardwareMap = new HardwareMap4008();

    @Override
    public void runOpMode()
    {
        HardwareMap.assign(hardwareMap);
//        HardwareMap.IntakeLeft.setPosition(0.15);
//        HardwareMap.IntakeRight.setPosition(0.85);
        waitForStart();
        double powerConstant = 1.0;
        double duckSpinnerA = 0;
        double duckSpinnerB = 0;


        while(opModeIsActive())
        {

           // HardwareMap.DriveLeft.setPower(gamepad1.left_stick_y * powerConstant);
           // HardwareMap.DriveRight.setPower(gamepad1.right_stick_y * powerConstant);
           // HardwareMap.DriveLeftFront.setPower(gamepad1.left_stick_y * powerConstant);
           // HardwareMap.DriveRightFront.setPower(gamepad1.right_stick_y * powerConstant);

            HardwareMap.ButtonA.changeButton(gamepad2.a);
            if(HardwareMap.ButtonA.GetButtonBurstDown())
            {
                if (duckSpinnerA == 0)
                    duckSpinnerA = 1;
                else
                    duckSpinnerA = 0;
            }

            HardwareMap.ButtonB.changeButton(gamepad2.b);
            if(HardwareMap.ButtonB.GetButtonBurstDown())
            {
                if (duckSpinnerB == 0)
                    duckSpinnerB = 1;
                else
                    duckSpinnerB = 0;
            }


//            HardwareMap.IntakeLeft.setPosition((gamepad2.y ? 1 : 0.25));
//          HardwareMap.IntakeRight.setPosition((gamepad2.y ? 0 : 0.75));

            HardwareMap.Intake.setPower(gamepad2.right_stick_y*0.45);
            HardwareMap.IntakeWheel.setPower(gamepad2.right_trigger - gamepad2.left_trigger);
            HardwareMap.DuckLeft.setPower(duckSpinnerA);
            HardwareMap.DuckRight.setPower(duckSpinnerB);
        }
    }
}

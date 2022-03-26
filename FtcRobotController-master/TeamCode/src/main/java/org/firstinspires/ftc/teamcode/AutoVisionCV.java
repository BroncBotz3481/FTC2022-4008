package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="!CV_Test", group="4008")
public class AutoVisionCV extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ZoneChooser chooser = new ZoneChooser(hardwareMap, telemetry);
        waitForStart();
        Target target = chooser.getTarget();
        chooser.stop();
        switch(target) {
            case A:
                telemetry.addData("Target Status", "A");
                break;
            case B:
                telemetry.addData("Target Status", "B");
                break;
            case C:
                telemetry.addData("Target Status","C");
                break;
        }
        telemetry.update();
    }
}

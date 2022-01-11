package org.firstinspires.ftc.teamcode.BaseCode;

//Do not touch code peasants!
//Do not touch code peasants!

//Wheel is in inches

import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.BaseFunctions.*;


public class SpecialMotor {

    private DcMotor M;
    private DcMotor N = null;
    private double CountsPerInch = 0;
    private double CountPerRev = 1035; //Is found by spinning the wheel exactly one rotation
    private double DefaltSpeed = 0.9;
    private boolean IsRunning = false;
    private boolean IsActive;

    /*Constructors*/
    //MAKE IT
    public SpecialMotor(DcMotor motor){
        M = motor;
        CountsPerInch = Calculate(4);
        IsRunning = false;
        IsActive = false;
    }
    //CHANGE IT
    public SpecialMotor(DcMotor motor, double wheelDiameter){
        M = motor;
        CountsPerInch = Calculate(wheelDiameter);
        IsRunning = false;
        IsActive = false;
    }

    //TWEAK AND USE IT
    public SpecialMotor(DcMotor left, DcMotor right, double wheelDiameter){
        M = left;
        N = right;

        CountsPerInch = Calculate(wheelDiameter);
    }

    //ASK IT
    public boolean IsComplete(){ //used in telop to prevent changing target position
        return !IsActive;
    }

    //GET IT
    private double Calculate(double WheelDiameter){ //Gets the value for ticks

        M.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //12.5in = 1000 ticks

        return (CountPerRev) / (WheelDiameter * 3.1415);
    }

    public double GetCountPerInch(){
        return CountsPerInch;
    }

    //USE IT
    public void Activate(){ //Starts the motor(s) to run to position
        IsActive = true;
    }

    public DcMotor GetMotor()
    {
        return M;
    }
    public DcMotor GetSecondMotor(){
        return N;
    }

    /*two motor encoder drive*/

    //RUN IT
    private void StartDouble(double Left, double Right, double Speed){ //Creates target position for two motors
        M.setTargetPosition((int) (Left * CountsPerInch));
        N.setTargetPosition((int) (Right * CountsPerInch));

        M.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        N.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        M.setPower(Math.abs(Speed));
        N.setPower(Math.abs(Speed));
    }

    public void DoubleRunAndResetForAutoONLY(double LeftInches, double RightInches, double speed){ //Runs motor for Auto

        StartDouble(LeftInches, RightInches, speed);

        while (M.isBusy()){}

        M.setPower(0);
        N.setPower(0);
        M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        N.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        N.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    /*Tolerance With Encoders Code*/

    //USE IT
    public void DoubleRunAndReset(double LeftInches, double RightInches, double speed, int tolerance) { //Runs motor for teleOp and can stop faster
        if(IsActive) {
            if (!IsRunning) {
                StartDouble(LeftInches, RightInches, speed);

                IsRunning = true;
            } else {
                if ((!M.isBusy() || (InRange(M.getCurrentPosition(), M.getTargetPosition(), tolerance))) && (!N.isBusy() || (InRange(N.getCurrentPosition(), N.getTargetPosition(), tolerance)))) {
                    M.setPower(0);
                    N.setPower(0);
                    M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    N.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    N.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    public void DoubleRunTo(double LeftInches, double RightInches, double speed, int tolerance){ //Runs motor for teleOp and can stop faster
        if(IsActive) {
            if (!IsRunning) {
                StartDouble(LeftInches, RightInches, speed);

                IsRunning = true;
            } else {
                if ((!M.isBusy() || (InRange(M.getCurrentPosition(), M.getTargetPosition(), tolerance))) && (!N.isBusy() || (InRange(N.getCurrentPosition(), N.getTargetPosition(), tolerance)))) {
                    M.setPower(0);
                    N.setPower(0);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    N.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    private void StartSingle(double dis, double speed){ //Creates target position
        M.setTargetPosition((int)(dis * CountsPerInch));

        M.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        M.setPower(Math.abs(speed));
    }

    /*One motor encoder drive*/
    public void RunAndResetForAutoONLY(double distanceInches, double speed){    //Runs motors for auto

        StartSingle(distanceInches, speed);

        while (M.isBusy()){}

        M.setPower(0);
        M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RunAndResetForAutoONLY(double distanceInches, double speed, int tolerance){    //Runs motors for auto

        StartSingle(distanceInches, speed);

        while (!((!M.isBusy() || (InRange(M.getCurrentPosition(), M.getTargetPosition(), tolerance))) && (!N.isBusy() || (InRange(N.getCurrentPosition(), N.getTargetPosition(), tolerance))))){}

        M.setPower(0);
        M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RunAndReset(double distanceInches, double speed) { //Runs motor for teleOp
        if (IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches, speed);
                IsRunning = true;
            } else {
                if (!M.isBusy()) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    public void RunAndReset(double distanceInches){ //Runs motor for teleOp
        if(IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches, DefaltSpeed);
                IsRunning = true;
            } else {
                if (!M.isBusy()) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    public void RunTo(double distanceInches, double speed){ //Runs motor for teleOp
        if(IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches, speed);
                IsRunning = true;
            } else {
                if (!M.isBusy()) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }


    public void RunTo(int distanceInches){ //Runs motor for teleOp
        if(IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches, DefaltSpeed);
                IsRunning = true;
            } else {
                if (!M.isBusy()) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    /*Tolerance With Encoders Code*/

    //NEAR IT
    public void RunAndReset(double distanceInches, double speed, int tolerance) { //Runs motor for teleOp and can stop faster
        if (IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches,speed);
                IsRunning = true;
            } else {
                if (!M.isBusy() || (InRange(M.getCurrentPosition(), M.getTargetPosition(), tolerance))) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

    public void RunTo(double distanceInches, double speed, int tolerance){ //Runs motor for teleOp and can stop faster
        if(IsActive) {
            if (!IsRunning) {
                StartSingle(distanceInches,speed);
                IsRunning = true;
            } else {
                if (!M.isBusy() || (InRange(M.getCurrentPosition(), M.getTargetPosition(), tolerance))) {
                    M.setPower(0);
                    M.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    IsRunning = false;
                    IsActive = false;
                }
            }
        }
    }

}
//TECHNOLOGIC
package org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables;

import static org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.BaseFunctions.*;

public class PIDF {

    /*Experimental Use only if necessary*/

    private double P = 0;//Proportional
    private double I = 0;//Integral
    private double D = 0;//Deferential
    private double F = 0;//Factorial
    //If you need help, search it up or ask other programmers
    private double PrevE = 0;
    private double totalE = 0;
    private int GoalP;
    private boolean Limit = false;

    private boolean Completed = false;

    /*Constructors*/
    public PIDF(){//MAKE IT
        P = 0.002;
        I = 0;
        D = 0;
        F = 0;
        Reset();
    }

    public PIDF(double P, double I, double D, double F){//FIX IT
        this.P = P;
        this.I = I;
        this.D = D;
        this.F = F;
        Reset();
    }

    public void Reset(){ //Resets object to be used again if needed for some thing else //BREAK IT
        PrevE = 0;
        totalE = 0;
        Completed = false;
    }

    public double Calculate(int Pos){
        return Calculate(Pos, GoalP, 0.1, 10);
    }//CHANGE IT

    public double Calculate(int Pos, int GoalPoint){
        return Calculate(Pos, GoalPoint, 0.1, 10);
    }//TWEAK IT

    //GET IT
    public double Calculate(int Pos,int GoalPoint, double ChangeInTime, int Tolerance){ //Gives value based on how far the Pos is from GoalPoint over time
        if(!InRange(Pos, GoalPoint, Tolerance)){
            Completed = false;
            double Error = GoalPoint - Pos;
            totalE += Error * ChangeInTime;
            double Result = ((P * Error) + (I * totalE)  + (D * ((Error - PrevE) / ChangeInTime)) + (F * GoalPoint));
            if(Limit) {
                if (Result > 1) {
                    Result = 1;
                } else if (Result < -1) {
                    Result = -1;
                }
            }
            PrevE = Error;
            return Result;
        }
        else{
            Completed = true;
            return 0;
        }

    }

    //SET IT
    public void setGoal(int GoalPoint){GoalP = GoalPoint;} //Sets the goal to go to (might be used for breaking)

    public boolean IsCompleted(){return Completed;}
}
//TECHNOLOGIC
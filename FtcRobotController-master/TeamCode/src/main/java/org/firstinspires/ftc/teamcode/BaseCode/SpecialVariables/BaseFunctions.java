package org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables;

public class BaseFunctions {
    //GIVE IT
    public static int GetSign(double var){ //returns if positive or negative
        if(var > 0){
            return 1;
        }
        else if(var < 0){
            return -1;
        }
        return 1;
    }

    //IN IT
    public static boolean InRange(int pos, int toPos, int tolerance){ //Deals with tolerancce for encoders
        if(Math.abs(pos - toPos) <= tolerance){
            return true;
        }
        return false;
    }
}

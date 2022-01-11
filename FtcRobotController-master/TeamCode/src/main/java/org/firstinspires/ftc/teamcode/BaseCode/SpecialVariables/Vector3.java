package org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables;

public class Vector3 {

    //Stores 3 values

    public int x;
    public int y;
    public int z;

    //MAKE IT
    public Vector3(){
        Zero();
    }

    //TWEAK IT
    public Vector3(double X, double Y, double Z){
        Set((int)X, (int)Y, (int)Z);
    }

    //SET IT
    public void Zero(){
        Set(0, 0, 0);
    }

    //USE IT
    public void Set(float X, float Y, float Z){Set((int)X, (int)Y, (int)Z);}

    //USE IT
    public void Set(int X, int Y, int Z){
        this.x = X;
        this.y = Y;
        this.z = Z;
    }
}
//TECHNOLOGIC
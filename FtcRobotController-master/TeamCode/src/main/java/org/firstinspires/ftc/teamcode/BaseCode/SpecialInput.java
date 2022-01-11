package org.firstinspires.ftc.teamcode.BaseCode;

//Do not touch code peasants!
//Do not touch code peasants!
public class SpecialInput {

    private boolean pressed = false;
    private boolean prev  = false;
    private boolean Relased = false;
    private boolean prevR  = false;
    private boolean on = true;
    private boolean button;

    /*Constructors*/
    //MAKE IT
    public SpecialInput(){}

    //FIX IT
    public SpecialInput(boolean Button){
        changeButton(Button);
    }

    //RENAME IT
    public void changeButton(boolean Button){
        button = Button;
    }

    //GET IT
    public boolean GetButtonDown(){ //changes when button is PRESSED
        if(button){
            if(pressed){

                prev = !prev;

                pressed = false;
            }
        }
        else{
            pressed = true;
        }

        if(prev){
            return false;
        }
        else {
            return true;
        }
    }

    //USE IT
    public boolean GetButtonUp(){ //changes when button is RELEASED
        if(button){
            Relased = true;
        }
        else{
            if(Relased){

                prevR = !prevR;

                Relased = false;
            }
        }

        if(prevR){
            return false;
        }
        else {
            return true;
        }
    }

    //GO AND FIX IT
    public boolean GetButtonDown(boolean buttonP){ //changes when button is PRESSED
        if(buttonP){
            if(pressed){

                prev = !prev;

                pressed = false;
            }
        }
        else{
            pressed = true;
        }

        if(prev){
            return false;
        }
        else {
            return true;
        }
    }

    //CHANGE IT
    public boolean GetButtonUp(boolean buttonP){ //changes when button is RELEASED
        if(buttonP){
            Relased = true;
        }
        else{
            if(Relased){

                prevR = !prevR;

                Relased = false;
            }
        }

        if(prevR){
            return false;
        }
        else {
            return true;
        }
    }


    //UNDO IT
    public boolean GetButtonBurstDown(){ //switches states for one loop then goes back when button is PRESSED (can be used to cycle values in an array (set points))
        if(button){
            if(on){
                on = false;
                return true;
            }
            else{
                return false;
            }
        }
        else {
            on = true;
            return false;
        }
    }

    //REDO IT
    public boolean GetButtonBurstUp(){ //switches states for one loop then goes back when button is RELEASED (can be used to cycle values in an array (set points))
        if(button){
            on = true;
            return false;
        }
        else {
            if(on){
                on = false;
                return true;
            }
            else {
                return false;
            }
        }
    }

    //TWEAK IT
    public boolean GetButtonBurstDown(boolean buttonP){ //switches states for one loop then goes back when button is PRESSED (can be used to cycle values in an array (set points))
        if(buttonP){
            if(on){
                on = false;
                return true;
            }
            else{
                return false;
            }
        }
        else {
            on = true;
            return false;
        }
    }

    //MAKE IT
    public boolean GetButtonBurstUp(boolean buttonP){ //switches states for one loop then goes back when button is RELEASED (can be used to cycle values in an array (set points))
        if(buttonP){
            on = true;
            return false;
        }
        else {
            if(on){
                on = false;
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void Setpoint(double[] setpoints, int point, SpecialMotor Motor, double runSpeed){
        Motor.RunTo(setpoints[point], runSpeed);
    }

    public int PointChange(double[] setpoints, int point, boolean Up, boolean down, SpecialMotor Motor){
        int p = point;
        if(GetButtonDown(Up) && Motor.IsComplete()){
            point++;
        }
        else if(GetButtonDown(down) && Motor.IsComplete()){
            point--;
        }
        if(point < 0){
            point = 0;
        }
        else if(point > setpoints.length - 1) {
            point = setpoints.length - 1;
        }
        if(p != point){
            Motor.Activate();
        }
        return point;
    }

}
//TECHNOLOGIC
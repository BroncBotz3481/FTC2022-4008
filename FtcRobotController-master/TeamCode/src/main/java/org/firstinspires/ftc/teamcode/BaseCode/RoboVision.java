package org.firstinspires.ftc.teamcode.BaseCode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.Vector3;
//import org.firstinspires.ftc.teamcode.HardwareMap4602;

import java.util.List;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

public class RoboVision{

    private String KeyCode = "AQa8i9//////AAABmVwvh15UF0TqvX7i3E4zs8p4ffzQDzpN7b3fKQK623+VJqGlGYnJqeJHazeJzgJoTFBKLLAPgfIlugmO/5OPdn0ahCSyAkUHsR2XpvN7Fhb/ToIGFjuUrt4quJbmchiY1Or6xt50UKpDYXlsSyqMYje9wDyZGY0oYX1xjJihND+ynhmdqOJW2g17MZWj3HJwX50MrtpUbevP9QG3DY5pvpjA4fOiuOoxI4Dm8jOE1N/QeMqtfCRX0kRjMp/vMX+2+XDk+zaTOhQSrLkfh+ExJN9UJOh3CrIdiFkumBiGQ/MWXtJIWg8aqgZQJWcWWaW2mw2xQM7bO09Z0TnTLEOxomtaCO5CFfneHORex+KVumpR";
    private OpenGLMatrix lastLocation = null;
    private VuforiaLocalizer vuforia;
    private VuforiaTrackables Trackables;
    private VuforiaTrackable Template;
    public Vector3 transform = new Vector3(); //Position
    public Vector3 rotation = new Vector3();  //Rotation
    private Boolean present = false;
    private String AssetFileName = "StonesAndChips";
    private List<Recognition> updatedRecognitionsOut;


    private static final String TFOD_MODEL_ASSET = "UltimateGoal.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Quad";
    private static final String LABEL_SECOND_ELEMENT = "Single";


    private TFObjectDetector tfod;

    //Uses sample code but put into an object and uses two Vector3 objects to store position and rotation

    //MAKE IT
    public RoboVision()
    {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = KeyCode;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        Trackables = this.vuforia.loadTrackablesFromAsset(AssetFileName);
        Template = Trackables.get(0);
        Trackables.activate();
    }

    //TWEAK IT
    public RoboVision(HardwareMap Map, boolean ShowVuforiaOutput, boolean ShowTensorflowOutput)
    {
        VuforiaLocalizer.Parameters parameters;
        if(ShowVuforiaOutput)
        {
            int cameraMonitorViewId = Map.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", Map.appContext.getPackageName());
            parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        }
        else
        {
            parameters = new VuforiaLocalizer.Parameters();
        }
        parameters.vuforiaLicenseKey = KeyCode;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        Trackables = this.vuforia.loadTrackablesFromAsset(AssetFileName);
        Template = Trackables.get(0);
        Trackables.activate();
        initTfod(Map, ShowTensorflowOutput);

        if (tfod != null)
        {
            tfod.activate();
            tfod.setZoom(1, 16.0/9.0);
        }
    }

    //USE IT
    public RoboVision(String AssetName){
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = KeyCode;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
        Trackables = this.vuforia.loadTrackablesFromAsset(AssetName);
        Template = Trackables.get(0);
        Trackables.activate();
    }

    //RUN IT
    public void look(){
        OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)Template.getListener()).getPose();

        if (pose != null) {
            present = true;
            VectorF trans = pose.getTranslation();
            Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

            transform.Set(trans.get(0), trans.get(1), trans.get(2));
            rotation.Set(rot.firstAngle, rot.secondAngle, rot.thirdAngle);
        }
        else{
            present = false;
            transform.Zero();
            rotation.Zero();
        }

        if (tfod != null) {
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null)
            {
                updatedRecognitionsOut = updatedRecognitions;
            }
        }
    }

    public List<Recognition> GetObjects()
    {
        return updatedRecognitionsOut;
    }

    //FIND IT
    public boolean IsPresent(){
        return present;
    }

    public void TurnOFF()
    {
        if (tfod != null)
        {
            tfod.shutdown();
        }
    }

    public Vector3 GetCenter(Recognition Object)
    {
        float X = Object.getLeft() + (Object.getWidth() / 2);
        float Y = Object.getTop() + (Object.getHeight() / 2);
        return new Vector3(X, Y, 0);
    }

    private void initTfod(HardwareMap Map, boolean ShowOut)
    {
        TFObjectDetector.Parameters tfodParameters;
        if(ShowOut)
        {
            int tfodMonitorViewId = Map.appContext.getResources().getIdentifier(
                    "tfodMonitorViewId", "id", Map.appContext.getPackageName());
            tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        }
        else
        {
            tfodParameters = new TFObjectDetector.Parameters();
        }

        tfodParameters.minResultConfidence = 0.8f;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}
//TECHNOLOGIC
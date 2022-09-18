package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class CapperDetector extends OpenCvPipeline { //the class that decects color and determine position
    Telemetry telemetry;  //class that sends print statements to phone
    Mat mat = new Mat();  //mat = multidimensional array, 2D array, each point is pixel in camera each hold color val
    public enum Location { //enum = variables to represent predefined constants; static final variables
        LEFT,
        CENTER,
        RIGHT,
        NOT_FOUND
    }
    private Location location = Location.NOT_FOUND; //setting location (type) to notfound (enum) by default
    static final Rect LEFT_ROI = new Rect( //roi = bounding box region of interest; fov restriction
        new Point(30, 100), //x & y top left
        new Point(103, 180) // x & y bottom right (0,0 is top left of cam like quadrant 4)
    );
    static final Rect CENTER_ROI = new Rect( //setting more rois
        new Point(123, 100),
        new Point(196, 180)
    );
    static final Rect RIGHT_ROI = new Rect(
            new Point(216, 100),
            new Point(289, 180)
    );
    public CapperDetector(Telemetry t) { telemetry = t; } //constructor- runs when u make instance of classlol (setting up telemntry)

    @Override
    public Mat processFrame(Mat input) {  //mat input represents one frame of the input video output mat result of processing
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV); //opencv library , input is rgb converts it to hsv hue sat. value
        Scalar lowHSV = new Scalar(75.0 / 2, 100, 100); //set range of hsv, if in range = true, it is the color!!!
        Scalar highHSV = new Scalar(100.0 / 2, 255, 255);//h is / 2 bc 75 is 360, 37.5 for 180 diff scale for diff library

        Core.inRange(mat, lowHSV, highHSV, mat); //take mat input, if in range, if in range set white, not set black; creating mask, return mat

        Mat left = mat.submat(LEFT_ROI); //create submat of output
        Mat center = mat.submat(CENTER_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;  //get avg value (all elements/ divide by pixel area/255(normalizing num))
        double centerValue = Core.sumElems(center).val[0] / LEFT_ROI.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / LEFT_ROI.area() / 255;

        left.release(); //get rid of mats for memory reasons good code practiceyay
        center.release();
        right.release();

        telemetry.addData("Left Raw Value", (int) Core.sumElems(left).val[0]); //add raw data to phone as a percent
        telemetry.addData("Center Raw Value", (int) Core.sumElems(center).val[0]);
        telemetry.addData("Right Raw Value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Left Percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Center Percentage", Math.round(centerValue * 100) + "%");
        telemetry.addData("Right Percentage", Math.round(rightValue * 100) + "%");

        Mat outMat = new Mat();
        Imgproc.cvtColor(mat, outMat, Imgproc.COLOR_GRAY2RGB);
        Scalar colorCapper = new Scalar(0, 255, 0);
        Scalar colorEmpty = new Scalar(255, 0, 0);

        if(leftValue > centerValue && leftValue > rightValue) { //compare all values to determine which one has most the cone should have way more than other positions
            location = Location.LEFT;
            telemetry.addData("Capper Location", "Left");
            Imgproc.rectangle(input, LEFT_ROI, colorCapper);
            Imgproc.rectangle(input, CENTER_ROI, colorEmpty);
            Imgproc.rectangle(input, RIGHT_ROI, colorEmpty);
        }
        else if(centerValue > leftValue && centerValue > rightValue) {
            location = Location.CENTER;
            telemetry.addData("Capper Location", "Center");
            Imgproc.rectangle(input, LEFT_ROI, colorEmpty);
            Imgproc.rectangle(input, CENTER_ROI, colorCapper);
            Imgproc.rectangle(input, RIGHT_ROI, colorEmpty);
        }
        else if(rightValue > leftValue && rightValue > centerValue) {
            location = Location.RIGHT;
            telemetry.addData("Capper Location", "Right");
            Imgproc.rectangle(input, LEFT_ROI, colorEmpty);
            Imgproc.rectangle(input, CENTER_ROI, colorEmpty);
            Imgproc.rectangle(input, RIGHT_ROI, colorCapper);
        }
        else {
            location = Location.NOT_FOUND; //if not found set to left automatically
            telemetry.addData("Capper Location", "Not Found");
            Imgproc.rectangle(input, LEFT_ROI, colorEmpty);
            Imgproc.rectangle(input, CENTER_ROI, colorEmpty);
            Imgproc.rectangle(input, RIGHT_ROI, colorEmpty); //draw rectangles on image, the rectangle is green for the color, the rest is red on the phone
        }
        telemetry.update();
        return input;
    }

    public Location getLocation() {
        return location;
    } //returns the location detected of the cone
}

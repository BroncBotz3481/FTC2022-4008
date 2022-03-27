package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class CapperDetector extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();
    public enum Location {
        LEFT,
        CENTER,
        RIGHT,
        NOT_FOUND
    }
    private Location location = Location.NOT_FOUND;
    static final Rect LEFT_ROI = new Rect(
        new Point(60, 30),
        new Point(180, 103)
    );
    static final Rect CENTER_ROI = new Rect(
        new Point(60, 123),
        new Point(180, 196)
    );
    static final Rect RIGHT_ROI = new Rect(
            new Point(60, 216),
            new Point(180, 289)
    );
    public CapperDetector(Telemetry t) { telemetry = t; }

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(75.0 / 2, 100, 100);
        Scalar highHSV = new Scalar(100.0 / 2, 255, 255);

        Core.inRange(mat, lowHSV, highHSV, mat);

        Mat left = mat.submat(LEFT_ROI);
        Mat center = mat.submat(CENTER_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
        double centerValue = Core.sumElems(center).val[0] / LEFT_ROI.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / LEFT_ROI.area() / 255;

        left.release();
        center.release();
        right.release();

        telemetry.addData("Left Raw Value", (int) Core.sumElems(left).val[0]);
        telemetry.addData("Center Raw Value", (int) Core.sumElems(center).val[0]);
        telemetry.addData("Right Raw Value", (int) Core.sumElems(right).val[0]);
        telemetry.addData("Left Percentage", Math.round(leftValue * 100) + "%");
        telemetry.addData("Center Percentage", Math.round(centerValue * 100) + "%");
        telemetry.addData("Right Percentage", Math.round(rightValue * 100) + "%");

        Mat outMat = new Mat();
        Imgproc.cvtColor(mat, outMat, Imgproc.COLOR_GRAY2RGB);
        Scalar colorCapper = new Scalar(0, 255, 0);
        Scalar colorEmpty = new Scalar(255, 0, 0);

        if(leftValue > centerValue && leftValue > rightValue) {
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
            location = Location.NOT_FOUND;
            telemetry.addData("Capper Location", "Not Found");
            Imgproc.rectangle(input, LEFT_ROI, colorEmpty);
            Imgproc.rectangle(input, CENTER_ROI, colorEmpty);
            Imgproc.rectangle(input, RIGHT_ROI, colorEmpty);
        }
        telemetry.update();
        return input;
    }

    public Location getLocation() {
        return location;
    }
}

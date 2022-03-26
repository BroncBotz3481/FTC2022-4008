package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.BaseCode.New.Team4008HMNew;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraBase;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera2;
import org.openftc.easyopencv.OpenCvPipeline;

public class ZoneChooser extends OpenCvPipeline {
    private OpenCvCamera cam;
    private Mat mat = new Mat();
    private Rect upperROI = new Rect(new Point(240, 120), new Point(304, 145));
    private Rect lowerROI = new Rect(new Point(240, 145), new Point(304, 170));
    private Mat upperMat;
    private Mat lowerMat;
    private Target target;
    private Telemetry telemetry;

    public ZoneChooser(HardwareMap hwMap, Telemetry t){
        telemetry = t;
        int camMonViewId = hwMap.appContext.getResources().getIdentifier(
            "cameraMonitorViewId",
            "id",
            hwMap.appContext.getPackageName()
        );
        cam = OpenCvCameraFactory.getInstance().createInternalCamera2(OpenCvInternalCamera2.CameraDirection.BACK);
//        cam = OpenCvCameraFactory.getInstance().createWebcam(
//                hwMap.get(WebcamName.class, "Webcam"),
//                camMonViewId
//        );
        cam.setPipeline(this);
        cam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                cam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }
            @Override
            public void onError(int errorCode)
            {
                telemetry.addData("CAMERA ERROR", errorCode);
                telemetry.update();
            }
        });
    }
    //target
    @Override
    public Mat processFrame(Mat input) {
        telemetry.addData("TEST","TEST");
        //--THRESHOLD--
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGBA2RGB);
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowerBound = new Scalar(75.0 / 2, 100, 100);
        Scalar upperBound = new Scalar(100.0 / 2, 255, 255);
        Core.inRange(mat, lowerBound, upperBound, mat);
        //82, 81, 92 HSV
        //--DIVIDE--
        upperMat = mat.submat(upperROI);
        lowerMat = mat.submat(lowerROI);
        //--AVERAGE--
        double upperValue = (Core.mean(upperMat).val[2] / 255);
        double lowerValue = (Core.mean(upperMat).val[2] / 255);
        upperMat.release();
        lowerMat.release();
        mat.release();
        //--COMPARE--
        final double THRESHOLD = 10;
        if (upperValue > THRESHOLD) {
            target = Target.C;
        } else if (lowerValue > THRESHOLD) {
            target = Target.B;
        } else {
            target = Target.A;
        }
        return null;
    }

    public Target getTarget() {
        return target;
    }

    public void stop() {
        cam.closeCameraDeviceAsync(() -> {});
    }
}





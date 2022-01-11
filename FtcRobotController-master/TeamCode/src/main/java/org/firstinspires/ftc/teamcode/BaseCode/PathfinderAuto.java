package org.firstinspires.ftc.teamcode.BaseCode;

import org.firstinspires.ftc.teamcode.BaseCode.SpecialVariables.Vector3;

import java.util.ArrayList;
import java.util.List;

public class PathfinderAuto {
    public float[] Distances;
    public float[] Angles;
    private float DistFor90 = 100;
    private float AngleDistance = (DistFor90) / 90; //Change number
    private boolean Subtract = true;

    public PathfinderAuto(Vector3[] Waypoints) {
        List<Float> Ag = new ArrayList<Float>();
        Ag.add(0.0f);
        List<Float> D = new ArrayList<Float>();
        D.add(0.0f);

        for (int i = 1; i < Waypoints.length; i++) {
            float Dis = (float) Math.sqrt(Math.pow(Waypoints[i].x - Waypoints[i - 1].x, 2) + Math.pow(Waypoints[i].y - Waypoints[i - 1].y, 2));

            {
                boolean IsNegativeX = Waypoints[i - 1].x > Waypoints[i].x;
                float XDIS = (Waypoints[i].x - Waypoints[i - 1].x);
                float YDIS = (Waypoints[i].y - Waypoints[i - 1].y);

                float A = (float) (Math.toDegrees(Math.atan2(YDIS, XDIS)));

                Ag.add(A);
                D.add(Dis);
            }
        }
        for (int i = 0; i < Ag.size(); i++) {
            Angles[i] = Ag.get(i);
        }
        for (int i = 0; i < D.size(); i++) {
            Distances[i] = D.get(i);
        }
        if (Subtract) {
            {
                for (int i = Angles.length - 1; i > 1; i--) {
                    Angles[i] -= Angles[i - 1];

                    if (Math.abs(Angles[i]) == 180) {
                        Angles[i] = 0;
                        Distances[i] *= -1;
                        if (i != Angles.length - 1) {
                            Angles[i + 1] += 180;
                        }
                    }

                    if (Angles[i] < -200)
                        Angles[i] = Math.max(Angles[i], Angles[i] + 360);
                    else if (Angles[i] > 200)
                        Angles[i] = Math.min(Angles[i], Angles[i] - 360);
                }
            }
        }
        for (int i = 0; i < Angles.length; i++){
            Angles[i] *= AngleDistance;
        }
    }
}

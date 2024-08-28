package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class Motor extends opmode{
    DcMotor motor1;

    @Override
    public void init(){
    motor1 = hardwareMap.dcMotor.get("motorOne");
    }

    @Override
    public void loop(){
        motor1.setPower(gamepad1.right_stick_y);
    }

}


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class Tank extends OpMode {

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    @Override
    public void init(){

        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");

    }

    @Override
    public void loop(){

        leftFront.setPower((gamepad1.left_stick_y * -1));
        leftBack.setPower((gamepad1.left_stick_y * -1));
        rightFront.setPower(gamepad1.right_stick_y);
        rightBack.setPower((gamepad1.right_stick_y * -1));
    }

}